package softAndHardCooperation;

import softAndHardCooperation.Comment;

import java.io.IOException;

public class writingTest {
    public static void recordSum() throws IOException {
        Comment.fileWriterMethod("writer.txt", "summary");

    }

    public static void main(String[] args) throws IOException {
        Comment.fileWriterMethod("writer.txt", "summary");

    }
}
