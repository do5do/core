package hello.core.singleton;

public class SingletonService {
    // static 선언으로 하면 해당 클래스에서 이 객체 하나만 생성되어 가지고 있는다. -> static 영역에 하나의 객체 생성
    private static final SingletonService instance = new SingletonService();

    // 객체 인스턴스가 필요할 경우 해당 public 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // private으로 기본 생성자를 선언하여 외부에서 new 생성을 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
