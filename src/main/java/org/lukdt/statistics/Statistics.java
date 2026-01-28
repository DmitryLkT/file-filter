package org.lukdt.statistics;

import org.lukdt.model.StatsType;

public interface Statistics {

    void acceptValue(long value);

    void print(StatsType type);
}
