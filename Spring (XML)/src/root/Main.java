package root;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    private static double value;
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println("Данная программа переводит рубли в доллары по курсу от 21.02.2019.");
        System.out.print("Введите сумму в рублях, необходимую для перевода в доллары (например: 52,71): ");
        setValue();

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Convertable convertable = (Convertable) ac.getBean("converter");
        convertable.convert();
    }

    private static void setValue() {
        value = sc.nextDouble();
    }

    double getValue() {
        return value;
    }
}
