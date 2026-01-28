package org.lukdt.statistics;

import org.lukdt.model.StatsType;

public class FloatStatistics implements Statistics {
    private long count = 0;

    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;
    private double sum = 0;

    private double getAvg() {
        return count == 0 ? 0 : (double) sum / count;
    }

    @Override
    public void acceptValue(String value) {
        double num = Double.parseDouble(value);

        count++;

        min = Math.min(min, num);
        max = Math.max(max, num);

        sum += num;
    }

    @Override
    public void print(StatsType type) {
        if(type == StatsType.NONE) return;

        System.out.printf("Floats:\n Count: %d\n", count);

        if(type == StatsType.SHORT) return;

        System.out.printf(
                " Min: %.2f\n" +
                " Max: %.2f\n" +
                " Sum: %.2f\n" +
                " Avg: %.2f\n",
                min, max, sum, getAvg());
    }
}
