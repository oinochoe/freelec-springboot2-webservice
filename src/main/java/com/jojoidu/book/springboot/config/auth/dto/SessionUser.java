package com.jojoidu.book.springboot.config.auth.dto;

import com.jojoidu.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
// 인증된 사용자 정보만 필요합니다. 그래서 3가지만 필드로 설정