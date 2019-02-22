package root;

import org.springframework.stereotype.Component;

@Component
public class ConvertManager implements Convertable {

    private Main main;
    private String from, to;
    private double course;

    public ConvertManager(Main main, double course, String from, String to) {
        this.main = main;
        this.course = course;
        this.from = from;
        this.to = to;
    }

    @Override
    public void convert() {
        System.out.println("Текущий курс " + to + " относительно " + from + ": " + course);
        System.out.println(main.getValue() + " " + from + " = " + main.getValue() / course + " " + to);
    }
}
