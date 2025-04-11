package com.univrouen.socialmedia.Service.Post;

import com.univrouen.socialmedia.Dto.Poll.PollDto;
import com.univrouen.socialmedia.Dto.Poll.PollOptionDto;
import com.univrouen.socialmedia.Dto.Post.CreatePostRequestDto;
import com.univrouen.socialmedia.Dto.Post.CreatePostResponseDto;
import com.univrouen.socialmedia.Entity.Poll;
import com.univrouen.socialmedia.Entity.PollOption;
import com.univrouen.socialmedia.Entity.Post;
import com.univrouen.socialmedia.Entity.User;
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

    public StdPostService(PostRepository postRepository,
                          UserRepository userRepository,
                          CommentRepository commentRepository,
                          PollRepository pollRepository,
                          PollOptionRepository pollOptionRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.pollRepository = pollRepository;
        this.pollOptionRepository = pollOptionRepository;
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

            }

            responseDto.setInfo("Le poste a été crée avec succès!");
            return responseDto;
        }else{
            responseDto.setAlert("L'utilisateur n'existe pas!");
            return responseDto;
        }
    }
}
