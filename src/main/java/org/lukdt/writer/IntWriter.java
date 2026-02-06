package org.lukdt.writer;

import org.lukdt.cli.Arguments;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class IntWriter {
    private final FileWriter writer;

    public IntWriter(Arguments arguments) throws IOException {
        Path file = arguments.getOutputPath().resolve(
                arguments.getPrefix() + "integers.txt"
        );

        this.writer = new FileWriter(file.toFile(), arguments.isAppend());
    }

    public boolean write(String line) {
        try {
            writer.write(line + System.lineSeparator()); // Перенос строки
            return true;
        } catch(IOException e) {
            System.err.println("Ошибка записи целого числа: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            writer.close();
        } catch(IOException e) {
            System.err.println("Ошибка закрытия файла: " + e.getMessage());
        }
    }
}
