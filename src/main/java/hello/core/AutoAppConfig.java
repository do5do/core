package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @ComponentScan :  @Component 애노테이션이 붙은 것을 다 찾아서 자동으로 스프링 빈으로 등록 해준다.
@ComponentScan( // excludeFilter : 그 중에 빈 등록 제외 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // @Configuration 애노테이션은 제외
)
public class AutoAppConfig {
    // 수동으로 등록한 빈 이름이 자동으로 등록되는 이름과 같을때 => 수동 빈 등록이 우선권을 가진다. but 최신 스프링부트에서는 오류가 나도록 막아놓음
/*    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
