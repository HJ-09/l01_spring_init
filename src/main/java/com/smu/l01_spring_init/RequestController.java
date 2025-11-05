package com.smu.l01_spring_init;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //컨트롤러가 되었어오
// 선생님! 중간경로를 만들고 싶어요 ↓↓
@RequestMapping("/req") //모든 요청에 req 있으면 다 이리와~~
public class RequestController {

    @GetMapping("/required.do") //?name=경민
    public String required(
           @RequestParam(required = true) String name //파라미터에 name이 업스면 오류(400)!
    ){
        System.out.println("name: "+name);
        return "required";
    }

    //REST API: 파라미터에 url을 포함시킴. 명시적이고 url을 짧게 만들 수 있다는 장점이~
    //예시 ↓↓
    // /req/{no}/book ⇒상세
    // /req/book/list ⇒리스트
    @GetMapping("/{no}/book")
    public String bookDetail(
            //여태 파라미터에 보낼 때 물음표에 보냈는데 이제는 path에 보냄 ㅋ
            //┌─ PathVariable은 삭제불가라고..?
            @PathVariable(name = "no") int bookNo
            //required=true인 것만 적어주면 댐.
    ){
        System.out.println(bookNo);
        return "required"; //페이지 required로 돌아갈게~,~
    }

    @PostMapping("/modelTest.do")
    public String modelTest(
//            int deptno, String dname, String loc
            DeptDto deptDto //⇒ @ModelAttribute임. 생략해도 댐.
    ){
//        System.out.println(deptno+":"+dname+":"+loc);
        System.out.println(deptDto);
        return "required";
    }

}
