package lab2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.thymeleaf.spring6.view.ThymeleafView;
@Configuration
public class ThymeleafConfig {
    @Bean
    @Scope("prototype")
    public ThymeleafView mainView() {
        return new ThymeleafView("index");
    }
}
