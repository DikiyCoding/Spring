package root;

import org.springframework.stereotype.Component;

@Component
public class CourseManager {

    private double usd, eur, gbr, cny;

    public CourseManager() {
        usd = 65.43;
        eur = 74.16;
        gbr = 85.44;
        cny = 9.74;
    }

    double getCourse(String codeISOto) {
        switch (codeISOto) {
            case "USD":
                return usd;
            case "EUR":
                return eur;
            case "GBP":
                return gbr;
            case "CNY":
                return cny;
        }
        return 1;
    }
}
