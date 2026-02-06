package org.lukdt.statistics;

import org.lukdt.model.StatsType;

import java.math.BigInteger;

public class IntegerStatistics implements Statistics {
    private long count = 0;

    private BigInteger min = null;
    private BigInteger max = null;
    private BigInteger sum = BigInteger.ZERO;

    private double getAvg() {
        return count == 0 ? 0 : sum.doubleValue() / count;
    }

    @Override
    public void acceptValue(String value) {
        BigInteger num = new BigInteger(value);

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

        System.out.printf("Integers:\n Count: %d\n", count);

        if(type == StatsType.SHORT || count == 0) return;

        System.out.printf(
                " Min: %s\n" +
                " Max: %s\n" +
                " Sum: %s\n" +
                " Avg: %.2f\n",
                min, max, sum, getAvg());
    }
}
