package com.example.relation.domain.comment;

import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.repository.PostRepository;
import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.domain.comment.dto.CommentResponseDto;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentResponseDto createComment(Long postId, CommentRequestDto requestDto) {

        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException());

        Comment comment = requestDto.toEntity(post);
        return CommentResponseDto.from(commentRepository.save(comment));
    }

    @Transactional
    public CommentResponseDto updateComment(Long postId, Long commentId, CommentRequestDto requestDto) {
        
//       영속되기 시작함 => dirty checking됨
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException());

        comment.update(requestDto);

        return CommentResponseDto.from(comment);
    }
}
