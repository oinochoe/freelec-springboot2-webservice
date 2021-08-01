package com.jojoidu.book.springboot.web;

import com.jojoidu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // ResponseBody를 각 메서드마다 설정하던 것을 한번에 사용할 수 있게 해줌.. 와웅 굳.. 이제 아네..
public class HelloController {
    @GetMapping("/hello") // Get의 요청을 받을 수 있는 API를 만들어줌...(매핑을 함으로 인해서 API의 탄생);
    // 예전에는 @RequestMapping(method = RequestMethod.GET)으로 받던 것이... 이렇게 간단하게!!!
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        // @RequestParam - 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션..
        // 여기에서는 외부에서 name (@RequsetParam("name"))이란 이름으로 넘긴 파라미터 메소드를 파라미터 name(String name)에 저장하게 됩니다.
        return new HelloResponseDto(name, amount);
    }
}
// WAS를 실행하지 않고 테스트코드로 먼저 검증하시오.
// 자동화 테스트