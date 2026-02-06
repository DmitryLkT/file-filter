package org.lukdt.statistics;

import org.lukdt.model.StatsType;

public class StringStatistics implements Statistics {
    private long count = 0;

    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;

    @Override
    public void acceptValue(String value) {
        if(value == null || value.isEmpty()) return;

        long len = value.length();

        count++;

        min = Math.min(min, len);
        max = Math.max(max, len);
    }

    @Override
    public void print(StatsType type) {
        if(type == StatsType.NONE) return;

        System.out.printf("Strings:\n Count: %d\n", count);

        if(type == StatsType.SHORT || count == 0) return;

        System.out.printf(
                " Min length: %d\n" +
                " Max length: %d\n",
                min, max);
    }
}
