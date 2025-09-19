package com.likelion.likelionSwagger.post.domain.repository;


import com.likelion.likelionSwagger.member.domain.Member;
import com.likelion.likelionSwagger.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByMember(Member member);
}
