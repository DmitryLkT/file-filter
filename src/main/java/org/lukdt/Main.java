package org.lukdt;

import org.lukdt.cli.Arguments;
import org.lukdt.processor.Processor;

public class Main {
    public static void main(String[] args) {

            Arguments arguments = Arguments.parse(args);
            Processor processor = new Processor(arguments);
            processor.run();

    }
}
