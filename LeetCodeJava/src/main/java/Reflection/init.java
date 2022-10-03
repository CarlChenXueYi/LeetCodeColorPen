package Reflection;

import java.io.*;
import java.util.Properties;

public class init {
    public static Properties getPro() throws IOException {
        Properties pro = new Properties();
        File file = new File("src/main/java/Reflection/fruit.properties");
        if (file.exists()) {
            pro.load(new FileInputStream(file));
        } else {
            pro.setProperty("apple", "Reflect.Apple");
            pro.setProperty("orange", "Reflect.Orange");
            pro.store(new FileOutputStream(file), "FRUIT CLASS");
        }
        return pro;
    }
}
