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
        // 第一个猜测值
        double guess = number / 2;
        int count = 0;
        if (number < 0) {
            return Double.NaN;
        }
        // 当两个猜测的差值大于精度即return
        while (Math.abs(guess - (number / guess)) > accuracy) {
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
        double last_middle = 0.00;
        int count = 0;
        if (number < 0) {
            return Double.NaN;
        }
        while (Math.abs(middle - last_middle) > accuracy) {
            if (middle * middle > number) {
                higher = middle;
            } else {
                lower = middle;
            }
            last_middle = middle;
            middle = (lower + higher) / 2;
            count++;
            System.out.printf("Dichotomy try count = %d, guess = %f\n", count, last_middle);
        }
        System.out.printf("Dichotomy final result = %f\n", last_middle);
        return last_middle;
    }
}