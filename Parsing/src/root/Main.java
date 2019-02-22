package root;

import org.htmlcleaner.XPatherException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        HtmlParser parser = new HtmlParser();
        try {
            parser.parse();
        } catch (IOException | XPatherException exception) {
            exception.printStackTrace();
        }
    }
}
