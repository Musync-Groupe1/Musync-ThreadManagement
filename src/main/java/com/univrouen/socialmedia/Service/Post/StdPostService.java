package com.univrouen.socialmedia.Service.Post;

import com.univrouen.socialmedia.Dto.Post.Poll.PollDto;
import com.univrouen.socialmedia.Dto.Post.Poll.PollOptionDto;
import com.univrouen.socialmedia.Dto.Post.CreatePostRequestDto;
import com.univrouen.socialmedia.Dto.Post.CreatePostResponseDto;
import com.univrouen.socialmedia.Dto.Post.Quiz.QuizOptionDto;
import com.univrouen.socialmedia.Dto.Post.Quiz.QuizQuestionDto;
import com.univrouen.socialmedia.Entity.*;
import com.univrouen.socialmedia.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StdPostService implements PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;
    private PollRepository pollRepository;
    private PollOptionRepository pollOptionRepository;
    private QuizRepository quizRepository;
    private QuizQuestionRepository quizQuestionRepository;
    private QuizQuestionOptionRepository quizQuestionOptionRepository;

    public StdPostService(PostRepository postRepository,
                          UserRepository userRepository,
                          CommentRepository commentRepository,
                          PollRepository pollRepository,
                          PollOptionRepository pollOptionRepository,
                          QuizRepository quizRepository,
                          QuizQuestionRepository quizQuestionRepository,
                          QuizQuestionOptionRepository quizQuestionOptionRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.pollRepository = pollRepository;
        this.pollOptionRepository = pollOptionRepository;
        this.quizRepository = quizRepository;
        this.quizQuestionRepository = quizQuestionRepository;
        this.quizQuestionOptionRepository = quizQuestionOptionRepository;
    }


    @Transactional
    public CreatePostResponseDto createPost(CreatePostRequestDto requestDto) {
        CreatePostResponseDto responseDto = new CreatePostResponseDto();
        Post post = new Post();
        post.setContent(requestDto.getContent());
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            post.setUser(user.get());
            if(requestDto.getPoll() != null && requestDto.getQuiz() != null){
                responseDto.setAlert("Il est interdit de créer un quiz et un sondage en même temps!");
                return responseDto;
            }

            if(requestDto.getPoll() != null){
                PollDto pollDto = requestDto.getPoll();

                Poll poll = new Poll();
                poll.setQuestion(pollDto.getQuestion());
                pollRepository.save(poll);

                post.setPoll(poll);
                postRepository.save(post);

                for(PollOptionDto pollOptionDto : pollDto.getPoll_options()){
                    PollOption pollOption = new PollOption();
                    pollOption.setContent(pollOptionDto.getContent());
                    pollOption.setPoll(poll);
                    pollOptionRepository.save(pollOption);
                }
                responseDto.setInfo("Le poste avec un sondage a été crée avec succès!");
                return responseDto;
            }

            if(requestDto.getQuiz() != null){
                List<QuizQuestionDto> quizQuestionDtos = requestDto.getQuiz();

                Quiz quiz = new Quiz();
                quizRepository.save(quiz);
                post.setQuiz(quiz);
                postRepository.save(post);

                List<QuizQuestion> quizQuestions = new ArrayList<>();
                for(QuizQuestionDto quizQuestionDto : quizQuestionDtos){
                    QuizQuestion quizQuestion = new QuizQuestion();
                    quizQuestion.setQuestion(quizQuestionDto.getQuestion());
                    quizQuestion.setQuiz(quiz);
                    quizQuestionRepository.save(quizQuestion);
                    for(QuizOptionDto quizOptionDto : quizQuestionDto.getQuiz_options()){
                        QuizQuestionOption quizQuestionOption = new QuizQuestionOption();
                        quizQuestionOption.setOption(quizOptionDto.getOption());
                        quizQuestionOption.setIs_correct(quizOptionDto.getIs_correct());
                        quizQuestionOption.setQuizQuestion(quizQuestion);
                        quizQuestionOptionRepository.save(quizQuestionOption);
                    }
                }
                responseDto.setInfo("Le poste avec un quiz a été crée avec succès!");
                return responseDto;
            }
            responseDto.setInfo("Le poste a été crée avec succès!");
            return responseDto;
        }else{
            responseDto.setAlert("L'utilisateur n'existe pas!");
            return responseDto;
        }
    }
}
