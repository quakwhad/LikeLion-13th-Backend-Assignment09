package com.likelion.likelionSwagger.post.application;

import com.likelion.likelionSwagger.common.error.ErrorCode;
import com.likelion.likelionSwagger.common.exception.BusinessException;
import com.likelion.likelionSwagger.member.domain.Member;
import com.likelion.likelionSwagger.member.domain.repository.MemberRepository;
import com.likelion.likelionSwagger.post.api.dto.request.PostSaveRequestDto;

import com.likelion.likelionSwagger.post.domain.Post;
import com.likelion.likelionSwagger.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    // 게시물 저장
    @Transactional
    public void postSave(PostSaveRequestDto postSaveRequestDto, Principal principal) {
        Long memberId = Long.parseLong(principal.getName());

        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND_EXCEPTION
                        , ErrorCode.MEMBER_NOT_FOUND_EXCEPTION.getMessage()));

        Post post = Post.builder()
                .title(postSaveRequestDto.title())
                .content(postSaveRequestDto.content())
                .member(member)
                .build();

        postRepository.save(post);
    }
}