package root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertManager implements Convertable {

    private Main main;
    private CourseManager course;
    private String from;

    @Autowired
    ConvertManager(Main main, CourseManager course, String from) {
        this.main = main;
        this.course = course;
        this.from = from;
    }

    @Override
    public void convert() {
        System.out.println("Текущий курс " + main.getCourse() + " относительно " + from + ": " + course);
        System.out.println(main.getValue() + " " + from + " = " + main.getValue() / course.getCourse() + " " + main.getCourse());
    }
}
