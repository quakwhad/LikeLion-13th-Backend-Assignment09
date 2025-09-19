package com.likelion.likelionSwagger.member.api;

import com.likelion.likelionSwagger.common.error.SuccessCode;
import com.likelion.likelionSwagger.common.template.ApiResTemplate;
import com.likelion.likelionSwagger.member.api.dto.request.MemberJoinReqDto;
import com.likelion.likelionSwagger.member.api.dto.request.MemberLoginReqDto;
import com.likelion.likelionSwagger.member.api.dto.response.MemberInfoResDto;
import com.likelion.likelionSwagger.member.application.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Tag(name = "멤버 API", description = "멤버 관리하는 api ")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    @Operation(summary = "멤버 회원가입", description = "멤버 회원가입 설명란입니다.")
    public ApiResTemplate<String> join(
            @RequestBody @Valid MemberJoinReqDto memberJoinReqDto
    ) {
        memberService.join(memberJoinReqDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.MEMBER_JOIN_SUCCESS);
    }

    @PostMapping("/login")
    @Operation(summary = "멤버 로그인", description = "멤버 로그인 설명란입니다.")
    public ApiResTemplate<MemberInfoResDto> login(@RequestBody @Valid MemberLoginReqDto memberLoginReqDto) {
        MemberInfoResDto memberInfoResDto = memberService.login(memberLoginReqDto);
        return ApiResTemplate.successResponse(SuccessCode.MEMBER_LOGIN_SUCCESS, memberInfoResDto);
    }

    @PostMapping("/join2")
    @Operation(
            summary = "회원가입",
            description = "이 API는 이메일, 비밀번호, 이름을 받아 회원가입을 진행합니다."
    )
    public ApiResTemplate<String> join2(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = """
                      요청 예시:
                      {
                        "email": "test@example.com",
                        "password": "password1234",
                        "name": "홍길동"
                      }
                      """
            )
            @RequestBody @Valid MemberJoinReqDto memberJoinReqDto
    ) {
        memberService.join(memberJoinReqDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.MEMBER_JOIN_SUCCESS);
    }


}
