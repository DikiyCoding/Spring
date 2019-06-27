package root;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "usd-converter")
    public ConvertManager toUSD() {
        return new ConvertManager("USD", 65.43);
    }

    @Bean(name = "eur-converter")
    public ConvertManager toEUR() {
        return new ConvertManager("EUR", 74.16);
    }

    @Bean(name = "gbr-converter")
    public ConvertManager toGBR() {
        return new ConvertManager("GBR", 85.44);
    }

    @Bean(name = "cny-converter")
    public ConvertManager toCNY() {
        return new ConvertManager("CNY", 9.74);
    }
}
