public class FareEstimator {
    public static void main(String[] args) {
        double[] costPerMinute = new double[]{1, 2, 3, 4, 5};
        double[] costPerMiles = new double[]{2, 3, 3, 5, 6};
        double[] result = fareEstimator(30, 30, costPerMinute, costPerMiles);
        printArray(result);
    }

    public static double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
        double[] result = new double[cost_per_mile.length];

        for (int i = 0; i < cost_per_mile.length; i++) {
            result[i] = ((cost_per_minute[i] * ride_time) + (cost_per_mile[i] * ride_distance));
        }

        return result;
    }

    public static void printArray(double[] result) {
        for (double v : result) {
            System.out.println(v);
        }
    }
}
