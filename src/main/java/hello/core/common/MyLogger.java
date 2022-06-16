package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
// proxyMode : 가짜 proxy class를 만들어두고, request와 상관없이 가짜 proxy class를 다른 빈에 미리 주입해둔다.
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // value가 없어도 됨
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid +"]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString(); // 전 세계에 하나인 unique id
        System.out.println("[" + uuid +"] request scope bean create: "+ this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid +"] request scope bean close: "+ this);
    }
}
