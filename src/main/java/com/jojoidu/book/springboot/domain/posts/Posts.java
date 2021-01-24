package com.jojoidu.book.springboot.domain.posts;

import com.jojoidu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 이 클래스는 setter메소드가 없다는 점이 특이점
// Entitiy클래스에는 절대로 Setter메소드를 만들지 않습니다. 대신 목적으로 만들어야 하면 해당하는 메소드를 만듦..
// 어노테이션 순서는 주요 어노테이션을 클래스에 가깝게 두는 것이 좋다. 여기서는 Entity가 가장 중요하게 여겨지는 것임..
@Getter // 롬복 -  클래스 내 모든 필드의 Getter메소드를 자동 생성
@NoArgsConstructor // 롬복 - 기본 생성자 자동추가... public Posts {} 와 같은 효과
@Entity // JPA의 어노테이션 - 테이블과 링크될 클래스임을 나타냄.... 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 pk필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성 규칙을 나타냅니다.. (auto_increment 위해 IDNNTITY 추가)
    private Long id; // 웬만하면 Entity의 PK는 Long타입의 Auto.incremen를 추천함.. => mysql에서 bigInt

    @Column(length = 500, nullable = false) // @Column 테이블의 칼럼을 나타내며 굳이 선언하지 않아도됩니다. 사용하는 이유는 기본값 이외에 추가값이 필요하기 때문..
    private String title; // Varchar의 경우 기본값이 255 인데 늘리고 싶어서 length = 500을 추가했습니다.

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성...
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }



}

// 기본적인 구조는 생성자를 통해 값을 채운 후 DB에 삽입...
// 값 변경이 필요한 경우 해당 이벤트에 맞는 public메소드를 호출하여 변경하는 것을 전제로함..
// 생성자 대신 @Builder를 통해 제공되는 빌더 클래스 사용...
