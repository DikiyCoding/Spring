package root;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Main main() {
        return new Main();
    }

    @Bean
    public ConvertManager manager() {
        return new ConvertManager(main(), 65.43, "RUB", "USD");
    }
}
