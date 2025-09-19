package com.likelion.likelionSwagger.member.api.dto;

import com.likelion.likelionSwagger.common.template.ApiResTemplate;
import com.likelion.likelionSwagger.member.api.dto.request.MemberJoinReqDto;
import com.likelion.likelionSwagger.member.api.dto.request.MemberLoginReqDto;
import com.likelion.likelionSwagger.member.api.dto.response.MemberInfoResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member2")
@Tag(name = "멤버 API", description = "멤버 관리하는 api ")
public interface MemberControllerSwagger {

    @PostMapping("/join")
    @Operation(summary = "멤버 회원가입", description = "멤버 회원가입 설명란입니다.")
    ApiResTemplate<String> join(@RequestBody @Valid MemberJoinReqDto memberJoinReqDto);

    @PostMapping("/login")
    @Operation(summary = "멤버 로그인", description = "멤버 로그인 설명란입니다.")
    ApiResTemplate<MemberInfoResDto> login(@RequestBody @Valid MemberLoginReqDto memberLoginReqDto);


}