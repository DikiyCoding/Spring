package root;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public Main main() {
        return new Main();
    }

    @Bean
    public CourseManager course() {
        return new CourseManager(main());
    }

    @Bean
    public ConvertManager convert() {
        return new ConvertManager(main(), course(), "RUB");
    }
}
