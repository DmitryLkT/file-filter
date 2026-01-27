package org.lukdt.cli;

import org.lukdt.model.StatsType;

public class Validator {
    public static void validatePathArg(String arg) {
        if(arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException("Путь не должен быть пустым");
        }

        if(arg.startsWith("-")) {
            throw new IllegalArgumentException("После '-o' должен быть путь, а не флаг");
        }
    }

    public static void validatePrefixArg(String arg) {
        if(arg == null) {
            throw new IllegalArgumentException("Префикс не может быть null");
        }

        if(arg.startsWith("-")) {
            throw new IllegalArgumentException("Префикс не может быть флагом");
        }
    }

    public static void validateStatsTypeArg(StatsType statsType, String arg) {
        if(statsType == StatsType.FULL && arg.equals("-s")) {
            throw new IllegalArgumentException("Нельзя использовать одновременно -s и -f");
        }

        if(statsType == StatsType.SHORT && arg.equals("-f")) {
            throw new IllegalArgumentException("Нельзя использовать одновременно -s и -f");
        }
    }

    public static void validateUnknownFlags(String arg) {
        if(arg.startsWith("-")) {
            throw new IllegalArgumentException("Не извествый флаг");
        }
    }
}
