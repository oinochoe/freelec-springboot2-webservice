package com.jojoidu.book.springboot.service.posts;

import com.jojoidu.book.springboot.domain.posts.PostsRepository;
import com.jojoidu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// autowired가 없지만 autowire와 setter로 빈을 주입받는 것보다 생성자로 주입받는게 낫기 때문에 없다...
@RequiredArgsConstructor // 얘가 바로 생성자!! final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬복 @RequiredArgsContructor가 대신 생성해줌..
// 생성자를 직접 안쓰고 롬복 어노테이션을 사용한 이유는 해당 클래스의 의존성이 변경될 때마다 생성자 코드를 계속 수정하는 번거로움을 해결..
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
