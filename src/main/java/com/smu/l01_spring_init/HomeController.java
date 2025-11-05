package com.smu.l01_spring_init;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//스프링은 상속을 아주 아주 아주 싫어합니다 ! ! !
//코드가 복잡하고, 관계가 복잡하다고 생각해서 그럼 ㅇㅇ
//그래서 대부분이 자동 상속을 한다고?! 어노테이션 상속으로 대체함.
/// 어노테이션 상속이란?
/// java→class 컴파일시에 동작함. (1.오류, 2.자동완성)

@Controller //이 친구가 자동으로 servlet을.. 뭐라구? //동적리소스 타입
//└─ html(view)를 자동으로 렌더링 후 응답함.
//@RestController //json, text, img,.. 응답하는 타입을 다양하게 할 수 있음.
public class HomeController {

    //함수마다 주소 만들 수 잇슴
    //┌─ Get으로 들어온 요청을 주소로 쓰겟다!
    @GetMapping("/") // "/" ⇒ 요청이 오면 해당 함수를 실행하겠다!
    public String index(Model model) { //동적리소스
        model.addAttribute("msg","스프링아 안녕"); //타임리프가 index.html을 렌더링 할 때 사용하는 객체
        //└─ == req.setAttribute("msg","");

        return "index"; //== req.getRequestDispatcher("/WEB-INF/views/index.html").forward(req.resp)
        //└─ 해당하는 타임리프 .. 모라고???
    }


    /*@GetMapping("/reqTest.do")
    public String reqTest(String id) { //받는 타입 쓰면 끝남 //== request.getParameter("id")
        System.out.println("파라미터로 받은 아이디: "+id);
        return "redirect:/"; //다시 home으로 갈게~
        //== resp.sendRedirect("/")
    }*/
    // 위랑 아래랑 같음. 파라미터 변수 처리가 다른 것뿐
    @GetMapping("/reqTest.do")
    public String reqTest(@RequestParam(name = "id") String userId) { //받는 타입 쓰면 끝남 //== request.getParameter("id")
        System.out.println("파라미터로 받은 아이디: "+userId);
        return "redirect:/"; //다시 home으로 갈게~
        //== resp.sendRedirect("/")
    }

    /*// ?a=10&n=20.1 ⇒ Integer.parseInt(req.getParameter("a"))
    @GetMapping("/parseTest.do")
    public String parseTest(
            int a,
            double b){
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        return "redirect:/";
    }*/

    // ?a=10&n=20.1&c=true
    @GetMapping("/parseTest.do")
    public String parseTest(
            int a,
            double b,
            Integer c){ //랩퍼클래스: 파라미터를 강제하지 않음. 파라미터 없어도 오류x
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        System.out.println("c:"+c);
        return "redirect:/";
    }
}
