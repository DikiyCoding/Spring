package root;

import org.springframework.stereotype.Component;

@Component
public class ConvertManager implements Convertable {

    private String from, to;
    private double course;

    public ConvertManager(String to, double course) {
        this.from = "RUB";
        this.course = course;
        this.to = to;
    }

    @Override
    public void convert(double value) {
        System.out.println("Текущий курс " + to + " относительно " + from + ": " + course);
        System.out.println(value + " " + from + " = " + value / course + " " + to);
    }
}
