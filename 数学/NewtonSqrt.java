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
}