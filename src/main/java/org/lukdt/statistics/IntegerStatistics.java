package org.lukdt.statistics;

import org.lukdt.model.StatsType;

public class IntegerStatistics implements Statistics {
    private long count = 0;

    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;
    private long sum = 0;

    private double getAvg() {
        return count == 0 ? 0 : (double) sum / count;
    }

    @Override
    public void acceptValue(long value) {
        count++;

        if(value < min) min = value;
        if(value > max) max = value;

        sum += value;
    }

    @Override
    public void print(StatsType type) {
        if(type == StatsType.NONE) return;

        System.out.printf("Integers:\n Count: %d\n", count);

        if(type == StatsType.SHORT) return;

        System.out.printf(
                " Min: %d\n" +
                " Max: %d\n" +
                " Sum: %d\n" +
                " Avg: %.2f\n",
                min, max, sum, getAvg()git);
    }
}
