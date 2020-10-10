package com.jojoidu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이클래스는 항상 프로젝트 최상단에 위치..
@SpringBootApplication // Bean 읽기와 생성을 모두 자동으로 설정됩니다.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


// 내장 WAS란 ?
// 별도로 외부에 Was를 두지 않고(tomcat 등), 애플리케이션을 실행할 때 내부에서 Was를 실행하는 것..

// 참고로 서비느는 비즈니스 로직을 처리하는게 아니라... 트랜잭션, 도메인간 순서의 보장만 해줍니다.