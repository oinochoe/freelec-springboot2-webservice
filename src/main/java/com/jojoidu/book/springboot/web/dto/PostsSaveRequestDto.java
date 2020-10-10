package com.jojoidu.book.springboot.web.dto;

import com.jojoidu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성했습니다.
// Entity 클래스를 절대로 Request, Response 클래스로 사용해서는 안됩니다.
// Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스임...
// 수많은 서비스 클래스나 비즈니스 로직들이 Entity 기준으로 동작함...
// 꼭 Entity 클래스와 Controller에서 쓸 Dto는 구분해서 사용합니다.
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
