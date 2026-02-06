package org.lukdt.classifierType;

import org.lukdt.model.DataType;

public class DataClassifier {

    public static DataType classify(String value) {
        if(value == null) return null;

        value = value.trim();
        if(value.isEmpty()) return null;

        try {
            Long.parseLong(value);
            return DataType.INTEGER;
        } catch(NumberFormatException ignored) {}

        try {
            Double.parseDouble(value);
            return DataType.FLOAT;
        } catch(NumberFormatException ignored) {}

        return DataType.STRING;
    }
}
