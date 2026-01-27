package org.lukdt.cli;

import org.lukdt.model.StatsType;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Arguments {
    private Path outputPath;
    private String prefix;
    private boolean append;
    private StatsType statsType;
    private List<Path> inputFiles;

    private Arguments(Path outputPath, String prefix, boolean append, StatsType statsType, List<Path> inputFiles) {
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.append = append;
        this.statsType = statsType;
        this.inputFiles = inputFiles;
    }

    public static Arguments parse(String[] args) {
        Path outputPath = Paths.get(".");
        String prefix = "";
        boolean append = false;
        StatsType statsType = StatsType.NONE;
        List<Path> inputFiles = new ArrayList<>();

        int i = 0;

        while(i < args.length) {
            String arg = args[i];

            switch(arg) {
                case "-o":
                    Validator.validatePathArg(args[i + 1]);
                    outputPath = Paths.get(args[i + 1]);
                    i += 2;
                    break;
                case "-p":
                    Validator.validatePrefixArg(args[i + 1]);
                    prefix = args[i + 1];
                    i += 2;
                    break;
                case "-a":
                    append = true;
                    i++;
                    break;
                case "-s":
                    Validator.validateStatsTypeArg(statsType, arg);
                    statsType = StatsType.SHORT;
                    i++;
                    break;
                case "-f":
                    Validator.validateStatsTypeArg(statsType, arg);
                    statsType = StatsType.FULL;
                    i++;
                    break;
                default:
                    Validator.validateUnknownFlags(arg);
                    inputFiles.add(Paths.get(arg));
                    i++;
            }
        }

        return new Arguments(outputPath, prefix, append, statsType, inputFiles);
    }
}
