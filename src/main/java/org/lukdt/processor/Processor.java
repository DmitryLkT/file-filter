package org.lukdt.processor;

import org.lukdt.classifierType.DataClassifier;
import org.lukdt.cli.Arguments;
import org.lukdt.model.DataType;
import org.lukdt.statistics.FloatStatistics;
import org.lukdt.statistics.IntegerStatistics;
import org.lukdt.statistics.StringStatistics;
import org.lukdt.writer.FloatWriter;
import org.lukdt.writer.IntWriter;
import org.lukdt.writer.StringWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Processor {
    private Arguments args;

    public Processor(Arguments args) {
        this.args = args;
    }

    public void run() {
        IntegerStatistics integerStatistics = new IntegerStatistics();
        FloatStatistics floatStatistics = new FloatStatistics();
        StringStatistics stringStatistics = new StringStatistics();

        IntWriter intWriter = null;
        FloatWriter floatWriter = null;
        StringWriter stringWriter = null;

        try {
            for(Path file : args.getInputFiles()) {
                try(BufferedReader br = new BufferedReader(new FileReader(file.toFile()))) {
                    String line;
                    while((line = br.readLine()) != null) {
                        DataType type = DataClassifier.classify(line);

                        if(type != null) {
                            switch(type) {
                                case INTEGER:
                                    if(intWriter == null) {
                                        intWriter = new IntWriter(args);
                                    }

                                    if(intWriter.write(line)) {
                                        integerStatistics.acceptValue(line);
                                    }
                                    break;
                                case FLOAT:
                                    if(floatWriter == null) {
                                        floatWriter = new FloatWriter(args);
                                    }

                                    if(floatWriter.write(line)) {
                                        floatStatistics.acceptValue(line);
                                    }
                                    break;
                                case STRING:
                                    if(stringWriter == null) {
                                        stringWriter = new StringWriter(args);
                                    }

                                    if(stringWriter.write(line)) {
                                        stringStatistics.acceptValue(line);
                                    }
                                    break;
                            }
                        }
                    }
                } catch(IOException e) {
                    System.err.println("Ошибка чтения файла: " + e.getMessage());
                }
            }
        } finally {
            integerStatistics.print(args.getStatsType());
            floatStatistics.print(args.getStatsType());
            stringStatistics.print(args.getStatsType());

            if(intWriter != null) intWriter.close();
            if(floatWriter != null) floatWriter.close();
            if(stringWriter != null) stringWriter.close();
        }

    }
}
