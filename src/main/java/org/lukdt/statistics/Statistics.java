package org.lukdt.statistics;

import org.lukdt.model.StatsType;

public interface Statistics {

    void acceptValue(String value);

    void print(StatsType type);
}
