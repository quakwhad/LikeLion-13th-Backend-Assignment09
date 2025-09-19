package com.likelion.likelionSwagger.member.api;

import com.likelion.likelionSwagger.common.error.SuccessCode;
import com.likelion.likelionSwagger.common.template.ApiResTemplate;
import com.likelion.likelionSwagger.member.api.dto.MemberControllerSwagger;
import com.likelion.likelionSwagger.member.api.dto.request.MemberJoinReqDto;
import com.likelion.likelionSwagger.member.api.dto.request.MemberLoginReqDto;
import com.likelion.likelionSwagger.member.api.dto.response.MemberInfoResDto;
import com.likelion.likelionSwagger.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class MemberController2 implements MemberControllerSwagger {

    private final MemberService memberService;

    @Override
    public ApiResTemplate<String> join(MemberJoinReqDto memberJoinReqDto) {
        memberService.join(memberJoinReqDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.MEMBER_JOIN_SUCCESS);
    }

    @Override
    public ApiResTemplate<MemberInfoResDto> login(MemberLoginReqDto memberLoginReqDto) {
        MemberInfoResDto memberInfoResDto = memberService.login(memberLoginReqDto);
        return ApiResTemplate.successResponse(SuccessCode.MEMBER_LOGIN_SUCCESS, memberInfoResDto);
    }

}