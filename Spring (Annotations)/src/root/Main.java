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
        System.out.print("Введите сумму в рублях, необходимую для перевода в " + course + " (например: 52,71): ");
        setValue();
        getResult(handleInput(course));
    }

    private static String handleInput(String course) {
        switch (course) {
            case "USD":
                return "usd-converter";
            case "EUR":
                return "eur-converter";
            case "GBP":
                return "gbr-converter";
            case "CNY":
                return "cny-converter";
            default:
                return null;
        }
    }

    private static void getResult(String bean) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Convertable convertable = (Convertable) ac.getBean(bean);
        convertable.convert(value);
    }

    private static void setValue() {
        value = sc.nextDouble();
    }

    private static void setCourse() {
        course = sc.next();
    }
}
