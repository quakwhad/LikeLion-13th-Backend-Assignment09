package com.likelion.likelionSwagger.post.api.dto.request;


import jakarta.validation.constraints.NotBlank;

public record PostSaveRequestDto(
        @NotBlank(message = "제목은 필수로 입력해야 합니다.")
//        @Schema(description = "게시물 제목", example = "제목입니다")
        String title,

        @NotBlank(message = "내용은 필수로 입력해야 합니다.")
//        @Schema(description = "게시물 내용", example = "내용입니다.")
        String content
) {
}
