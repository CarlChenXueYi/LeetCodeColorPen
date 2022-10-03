package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteToChar {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/IO/test.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");

        char[] buf = new char[1024];
        int len = inputStreamReader.read(buf);
        System.out.println(new String(buf, 0, len));
        inputStreamReader.close();
    }
}
