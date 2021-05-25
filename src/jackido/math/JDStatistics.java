package jackido.math;

import java.util.ArrayList;

public class JDStatistics {
    public static double mean(ArrayList<Double> list) {
        double sum = 0.0;
        for (double d : list) {
            sum += d;
        }
        return sum / list.size();
    }

    public static double stdev(ArrayList<Double> list) {
        return Math.sqrt(variance(list));
    }

    public static double variance(ArrayList<Double> list) {
        double sum = 0.0;
        double mean = mean(list);
        for (double d : list) {
            sum += (d - mean) * (d - mean);
        }
        return sum / list.size();
    }

    public static double skewness(ArrayList<Double> list) {
        double sum1 = 0;
        double mean = mean(list);
        for (int i = 0; i < list.size(); i++) {
            sum1 += Math.pow((list.get(i) - mean), 3);
        }
        double sum2 = 0;
        for (int i = 0; i < list.size(); i++) {
            sum2 += Math.pow((list.get(i) - mean), 2);
        }
        return sum1 / Math.pow(sum2, 3/2) * Math.sqrt(list.size());
    }

    public static double kurtosis(ArrayList<Double> list) {
        double sum1 = 0;
        double mean = mean(list);
        for (int i = 0; i < list.size(); i++) {
            sum1 += Math.pow(list.get(i) - mean, 4);
        }
        double sum2 = 0;
        for (int i = 0; i < list.size(); i++) {
            sum2 += Math.pow(list.get(i) - mean, 2);
        }
        return sum1 / Math.pow(sum2, 2) * list.size();
    }

    public static double[] getFourMoments(ArrayList<Double> list) {
        int n = list.size();

        double sum = 0.0;
        for (double d : list) {
            sum += d;
        }
        double mean = sum / n;

        double sum2 = 0.0, sum3 = 0.0, sum4 = 0.0;
        for (double d : list) {
            double diff = d - mean;
            double d2 = diff * diff;
            double d3 = d2 * diff;
            double d4 = d3 * diff;
            sum2 += d2;
            sum3 += d3;
            sum4 += d4;
        }
        double stDev = Math.sqrt(sum2 / n);
        double skew = sum3 / Math.pow(sum2, 3/2) * Math.sqrt(n);
        double kurt = sum4 / Math.pow(sum2, 2) * n;

        return new double[]{mean, stDev, skew, kurt};
    }
}