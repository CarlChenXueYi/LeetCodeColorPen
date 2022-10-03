package Reflection;

import java.io.IOException;
import java.util.Properties;

public class hello {
    public static void main(String[] args) throws IOException {
        Properties properties = init.getPro();
        fruit fruit = Factory.getInstance(properties.getProperty("apple"));
        if (fruit != null) {
            fruit.eat();
        }
    }
}
