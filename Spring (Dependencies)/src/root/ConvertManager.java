package root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertManager implements Convertable {

    @Autowired
    private CourseManager course;
    private String codeISOfrom;

    public ConvertManager() {
        codeISOfrom = "RUB";
    }

    @Override
    public void convert(double value, String codeISOto) {
        System.out.println("Текущий курс " + codeISOto + " относительно " + codeISOfrom + ": " + course.getCourse(codeISOto));
        System.out.println(value + " " + codeISOfrom + " = " + value / course.getCourse(codeISOto) + " " + codeISOto);
    }
}
