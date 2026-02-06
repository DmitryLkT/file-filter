package org.lukdt.statistics;

import org.lukdt.model.StatsType;

import java.math.BigDecimal;

public class FloatStatistics implements Statistics {
    private long count = 0;

    private BigDecimal min = null;
    private BigDecimal max = null;
    private BigDecimal sum = BigDecimal.ZERO;

    private double getAvg() {
        return count == 0 ? 0 : sum.doubleValue() / count;
    }

    @Override
    public void acceptValue(String value) {
        BigDecimal num = new BigDecimal(value);

        count++;

        if(min == null || num.compareTo(min) < 0) {
            min = num;
        }

        if(max == null || num.compareTo(max) > 0) {
            max = num;
        }

        sum = sum.add(num);
    }

    @Override
    public void print(StatsType type) {
        if(type == StatsType.NONE) return;

        System.out.printf("Floats:\n Count: %d\n", count);

        if(type == StatsType.SHORT || count == 0) return;

        System.out.printf(
                " Min: %s\n" +
                " Max: %s\n" +
                " Sum: %s\n" +
                " Avg: %.10f\n",
                min, max, sum, getAvg());
    }
}
