package org.example.dataprocessor.output;

import java.io.File;
import java.io.FileWriter;

public class TextFile implements outputType {
    public void output(double result) throws Exception {
        File file = new File("target/result.txt");
        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Result = " + result);
        }

    }
}
