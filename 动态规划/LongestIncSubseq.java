// 动态规划求最长递增子序列

public class LongestIncSubseq {
	public static int LIS(int[] L) {
		int max = 0;
		int n = L.length;
		int[] f = new int[n];// 用于存放f(i)值；
		f[0] = 1;// 以第a1为末元素的最长递增子序列长度为1；
		for (int i = 1; i < n; i++)// 循环n-1次
		{
			f[i] = 1;// f[i]的最小值为1；
			for (int j = 0; j < i; j++)// 循环i 次
			{
				if (L[j] < L[i] && f[j] + 1 > f[i])
					f[i] = f[j] + 1;// 更新f[i]的值。
			}
		}
		for (int i = 0; i < n; i++) {
			if (f[i] > max)
				max = f[i];
		}
		return max;
	}
	public static int LIS2(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int[] b = new int[A.length];
        b[0] = 1;
        int result = 1;
        for(int i=1; i<A.length; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(A[j] < A[i] && b[j] > max)
                    max = b[j];
            }
            b[i] = max + 1;
            result = Math.max(result, b[i]);
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(LIS(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 30 }));
	}
}
