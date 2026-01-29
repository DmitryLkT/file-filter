package org.lukdt.classifierType;

import org.lukdt.model.DataType;

public class DataClassifier {

    public DataType classify(String value) {
        if(value == null) return DataType.STRING;

        value = value.trim();

        if(value.isEmpty()) return DataType.STRING;

        if(value.matches("[-+]?\\d+")) return DataType.INTEGER;

        if(value.matches("[-+]?\\d+\\.\\d+")) return DataType.FLOAT;

        return DataType.STRING;
    }
}
