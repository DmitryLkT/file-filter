package org.lukdt.statistics;

public class FloatStatistics implements Statistics {
    private long count = 0;

    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;
    private double sum = 0;

    private double getAvg() {
        return count == 0 ? 0 : (double) sum / count;
    }

    @Override
    public void acceptValue()
}
