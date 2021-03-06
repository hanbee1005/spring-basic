package hello.springbasic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A사용자가 10000원을 주문
        int userAPrice = statefulService1.order("userA", 10000);

        // ThreadB: B사용자가 20000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);

//        // ThreadA: A사용자가 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
        System.out.println("userAPrice = " + userAPrice);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
