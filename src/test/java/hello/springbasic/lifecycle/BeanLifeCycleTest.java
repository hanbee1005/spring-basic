package hello.springbasic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {
        // AnnotationConfigApplicationContext ac 또는
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LiftCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();  // 기본 ApplicationContext 는 제공 x
    }

    @Configuration
    static class LiftCycleConfig {
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
