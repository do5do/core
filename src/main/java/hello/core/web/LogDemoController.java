package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    // MyLogger의 scope는 request가 있을때에만 동작하는데, 그냥 쌩으로 주입을하면 스프링컨테이너가 뜰때 MyLogger를 생성하여 의존성 주입하려고 하니, request가 없다는 에러가 난다.
    // -> 이를 해결하기 위해 스프링 컨테이너가 뜨고, request가 왔을때에 생성하도록 지연(lazy) 시켜줘야한다. (ObjectProvider or Provider 사용 또는!! proxy로 대체)
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass()); // CGLIB 스프링이 조작한 class가 찍힌다.
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");

        logDemoService.logic("testId");
        return "OK";
    }
}
