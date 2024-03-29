package com.jojoidu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // 보통 ibatis나 mybatis 등에서 dao로 불리우는 DB Layer접근자입니다.
    // Jpa 에서는 Repository라고 부르며.. 인터페이스로 생성합니다. 단순히 상속하면 기본 적인 CRUD가 자동으로 생성됩니다.
    // @Repositoy를 추가할 필요도 없습니다... Entity 클래스와 기본 Entity Repository는 함께 위치해야합니다.
    // 그래서 보면 Posts와 같은선상에 PostsRepository가 있는 것입니다.
    // Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없습니다.
    // 그래서 Domain 패키지를 만들어 함께 관리하는 것입니다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

/* SpringDataJpa에서 제공하지 않는 메소드는 위처럼 쿼리로 작성해도 됩니다. */