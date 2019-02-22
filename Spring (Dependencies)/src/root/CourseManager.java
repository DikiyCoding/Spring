package root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseManager {

    private Main main;
    private double usd, eur, gbr, cny;

    @Autowired
    public CourseManager(Main main) {
        this.main = main;
        usd = 65.43;
        eur = 74.16;
        gbr = 85.44;
        cny = 9.74;
    }

    double getCourse() {
        switch (main.getCourse()) {
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
