package com.jojoidu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 테스트를 진행할 때 Junit에 내장된 실행자 이외에 다른 실행자를 실행시킵니다.
// 즉, 스프링부트 테스트와 Junit 사이의 연결자..
@RunWith(SpringRunner.class)
// Web(Spring MVC)에 집중할 수 있는 어노테이션
// 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음.
// @Service, @Component, @Repository 등은 사용 불가...
// 여기서는 컨트롤러만 사용하기 때문에..
@WebMvcTest
public class HelloControllerTest {
    // 스프링이 관리하는 빈을 주입 받습니다!
    @Autowired
    // 웹 API를 테스트할 때 사용.
    // 스프링 MVC 테스트의 시작점 이 클래스를 통해 API 테스트를 할 수 있음.
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 합니다.
        // 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있음.
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                // param - API 테스트할 때 사용될 요청 파라미터를 설정
                // 단 값은 String만 허용됩니다.
                // 그래서 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 가능합니다.
                // joinPath - JSON 응답값을 필드별로 검증할 수 있는 메소드입니다.
                // $를 기준으로 필드명을 명시합니다.
                // 여기서는 name과 amount를 검증하니 $.name, $.amount로 거증합니다.
                get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount))
                )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));
    }
}