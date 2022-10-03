package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CharToByte {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/IO/test.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

        outputStreamWriter.write("字符流到字节流输出");
        outputStreamWriter.close();
    }
}
