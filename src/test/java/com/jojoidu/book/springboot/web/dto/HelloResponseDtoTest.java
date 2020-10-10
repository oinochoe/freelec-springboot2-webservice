package com.jojoidu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // assertj라는 테스트 검증 라이브러리의 메서드
        assertThat(dto.getAmount()).isEqualTo(amount); // 검증하고 싶은 대상을 메소드 인자로 받습니다. 메소드 체이닝 지원됨

        // junit과 비교하여 assertj의 장점
        // CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않습니다. junit은 .is()를 위한 라이브러리도 따로 임포트해야함
        // 자동완성이 좀 더 확실하게 지원됨.
    }
}
