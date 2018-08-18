import java.lang.Math;

class NewtonSqrt {
    /**
     * 牛顿迭代法求平方根
     * 
     * @param number   求值的数
     * @param accuracy 精度
     * @return Double
     */
    public static double newtonSqrt(double number, double accuracy) {
        if (number < 0) {
            return Double.NaN;
        }
        // 取二分之一作为第一个猜测值
        double guess = number / 2;
        int count = 0;
        // 当估算值的平方与实际求根的数之差值小于精度即return
        while (Math.abs(guess * guess - number) < accuracy) {
            // 迭代公式推导而成
            guess = (guess + (number / guess)) / 2;
            count++;
            System.out.printf("try count = %d, guess = %f\n", count, guess);
        }
        System.out.printf("final result = %f\n", guess);
        return guess;
    }

    // 二分法求根
    public static double DichotomySqrt(double number, double accuracy) {
        double higher = number;
        double lower = 0.0;
        double middle = (lower + higher) / 2;
        int count = 0;
        if (number < 0) {
            return Double.NaN;
        }
        while (Math.abs(middle * middle - number) < accuracy) {
            if (middle * middle > number) {
                higher = middle;
            } else {
                lower = middle;
            }
            middle = (lower + higher) / 2;
            count++;
            System.out.printf("Dichotomy try count = %d, guess = %f\n", count, middle);
        }
        System.out.printf("Dichotomy final result = %f\n", middle);
        return middle;
    }
}