package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class DvdController {
    
    @GetMapping("/dvds")
    public String dvdListPage(Model model) {
        Dvd dvd1 = Dvd.builder()
                .title("테스트1")
                .producer("테스트 제작사1")
                .publisher("테스트 발행사1")
                .build();
        Dvd dvd2 = Dvd.builder()
                .title("테스트2")
                .producer("테스트 제작사2")
                .publisher("테스트 발행사2")
                .build();
        Dvd dvd3 = Dvd.builder()
                .title("테스트3")
                .producer("테스트 제작사3")
                .publisher("테스트 발행사3")
                .build();
        model.addAttribute(dvd1); // 객체를 넣은 경우
        model.addAttribute("names", List.of("김준일", "김준이", "김준삼")); // 리스트를 넣은 경우
        model.addAttribute("dvdList", List.of(dvd1, dvd2, dvd3)); // 리스트를 넣은 경우
        model.addAttribute("title", "테스트 제목"); // literal을 넣은 경우
        
        return "views/dvd_list"; // 뷰네임 리턴
    }
    
    // 위의 코드와 동일한 코드
//    public ModelAndView dvdListPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("views/dvd_list");
//        return mav;
//    }

    @ResponseBody  // 데이터 응답 (안붙이면 view 응답)??? 무슨 소리일까
    @GetMapping("/dvds/body")
    public String getViewName() {

        return "views/dvd_list";
    }

    @ResponseBody // 안 붙이면 500에러가 뜬다 // responbody를 붙이고 객체를 리턴하면 json으로 변환해서 반환한다
    @GetMapping("/dvd")
    public Object getDvd() { // Dvd 자료형으로 반환을 하던, Object로 하던 리턴이 된다.
        Dvd dvd1 = Dvd.builder().title("테스트1").producer("테스트 제작사1").publisher("테스트 발행사1").build();
        Dvd dvd2 = Dvd.builder().title("테스트2").producer("테스트 제작사2").publisher("테스트 발행사2").build();
        Dvd dvd3 = Dvd.builder().title("테스트3").producer("테스트 제작사3").publisher("테스트 발행사3").build();

        return List.of(dvd1, dvd2, dvd3);
    }
}
