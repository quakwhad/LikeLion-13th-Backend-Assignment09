package com.likelion.likelionSwagger.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
// @OpenAPIDefinition(info = @Info(title = "Swagger Test App", description = "description", version = "7.7")) // info객체를 생성하는게 더 많은 정보 + 가독성.
public class SwaggerConfiguration {

    @Bean
    public OpenAPI swaggerConfig(){

        Info info = new Info()
                .title("Swagger Test App")
                .description("description : 스프링 스웨거 설명을 위한 앱 입니다.")
                .version("7.7")
                .contact(new Contact()
                        .name("담당자 이름 : 박종범")
                        .email("담당자이메일@gmail.com"));

        //외부 문서 링크
        ExternalDocumentation externalDocs = new ExternalDocumentation()
                .description("외부 문서 링크 : 누르면 이동")
                .url("https://www.naver.com");

        // 서버 정보
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Development Server");

        Server prodServer = new Server();
        prodServer.setUrl("https://Production Server.com");
        prodServer.setDescription("Production Server");

        //Components는 Swagger api에서 공통으로 재사용되는 구성요소들을 담는 객체
        //Components → 인증 방식을 정의 (JWT, Basic 등)
        Components components = new Components()
                .addSecuritySchemes("Authorization",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"));

        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocs)
                .servers(List.of(devServer, prodServer))
                .components(components)
                .addSecurityItem(new SecurityRequirement().addList("Authorization"));

    }

    //그룹 생성
    @Bean
    public GroupedOpenApi group1(){
        return GroupedOpenApi.builder()
                .group("멤버")
                .pathsToMatch("/member/**")
                .build();
    }

    @Bean
    public GroupedOpenApi group2(){
        return GroupedOpenApi.builder()
                .group("포스트")
                .pathsToMatch("/post/**")
                .build();
    }

}