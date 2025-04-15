package com.univrouen.socialmedia.Controller;

import com.univrouen.socialmedia.Dto.AlertAndInfoDto;
import com.univrouen.socialmedia.Dto.Poll.PollDto;
import com.univrouen.socialmedia.Dto.Post.*;
import com.univrouen.socialmedia.Entity.*;
import com.univrouen.socialmedia.Repository.*;
import com.univrouen.socialmedia.Service.Post.PostService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PollRepository pollRepository;
    private final PollOptionRepository pollOptionRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;
    private PostService postService;

    public PostController(PostRepository postRepository,
                          UserRepository userRepository,
                          CommentRepository commentRepository,
                          PostService postService, PollRepository pollRepository, PollOptionRepository pollOptionRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.pollRepository = pollRepository;
        this.pollOptionRepository = pollOptionRepository;
    }

    @PostMapping("/create")
    public CreatePostResponseDto createPost(@Valid @RequestBody CreatePostRequestDto requestDto){
        CreatePostResponseDto responseDto = postService.createPost(requestDto);
        return responseDto;
    }

    @PostMapping("/comment")
    public AlertAndInfoDto commentPost(@Valid @RequestBody CommentPostRequestDto requestDto){
        AlertAndInfoDto responseDto = new AlertAndInfoDto();
        Optional<User> user = userRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
        if(user.isPresent()){
            Optional<Post> post = postRepository.findById(requestDto.getPost_id());
            if(post.isPresent()){
                Comment comment = new Comment();
                comment.setContent(requestDto.getContent());
                comment.setUser(user.get());
                comment.setPost(post.get());
                commentRepository.save(comment);
                responseDto.setInfo("Le commentaire a bien été posté!");
                return responseDto;
            }else{
                responseDto.setAlert("Le poste n'existe pas!");
                return responseDto;
            }


        }else{
            responseDto.setAlert("L'utilisateur n'existe pas!");
            return responseDto;
        }
    }

    @PostMapping("/votepoll")
    public AlertAndInfoDto votePoll(@Valid @RequestBody VotePollRequestDto requestDto){
        AlertAndInfoDto responseDto = new AlertAndInfoDto();
        Optional<Post> post = postRepository.findById(requestDto.getPost_id());
        if(post.isPresent()){
            Poll poll = post.get().getPoll();
            for(PollOption pollOption : poll.getPollOptions()){
                if(pollOption.getId() == requestDto.getPost_id()){
                    pollOption.setCount(pollOption.getCount() + 1);
                    pollOptionRepository.save(pollOption);
                    responseDto.setInfo("Le vote a bien été pris en compte !");
                    return responseDto;
                }
            }
            responseDto.setAlert("L'option n'a pas été trouvé dans le poste");
            return responseDto;
        }else{
            responseDto.setAlert("Le poste n'existe pas!");
            return responseDto;
        }
    }

    @GetMapping
    public FetchPostResponseDto getPosts(){
        List<Post> posts = postRepository.findAll();
        FetchPostResponseDto responseDto = new FetchPostResponseDto();
        responseDto.setPosts(posts);
        responseDto.setInfo("La récupération s'est bien effectuée !");
        return responseDto;
    }
}
