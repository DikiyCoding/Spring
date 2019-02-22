package root;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {

    private static double value;
    private static String course;
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println("Данная программа переводит рубли в доллары/евро/фунт стерлингов/юань по курсу от 21.02.2019.");
        System.out.print("Введите \"USD\", \"EUR\", \"GBP\", \"CNY\" в зависимости от того, в какую валюту хотите конвертировать рубли (например: USD): ");
        setCourse();
        System.out.println();
        System.out.print("Введите сумму в рублях, необходимую для перевода в " + course + " (например: 52,71): ");
        setValue();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Convertable convertable = ac.getBean(ConvertManager.class);
        convertable.convert();
    }

    private static void setValue() {
        value = sc.nextDouble();
    }

    double getValue() {
        return value;
    }

    private static void setCourse() {
        course = sc.next();
    }

    String getCourse() {
        return course;
    }
}
