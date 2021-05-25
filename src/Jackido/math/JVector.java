package Jackido.math;

public class JVector {
    public static double getCosineSimilarity(double[] v1, double[] v2) {
        if (v1 == null || v2 == null || v1.length != v2.length || v1.length == 0) return 0.0;
        double sum1 = 0.0, sum2 = 0.0, sum3 = 0.0;
        int vectorSize = v1.length;
        for (int i = 0; i < vectorSize; i++) {
            sum1 += v1[i] * v2[i];
            sum2 += v1[i] * v1[i];
            sum3 += v2[i] * v2[i];
        }
        return sum1 / (Math.sqrt(sum2) * Math.sqrt(sum3));
    }
}
