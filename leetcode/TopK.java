// 利用快排算法的partition函数实现O(n)时间复杂度求数组中第k小的数，java实现。

class TopK {
    public static void main(String[] args) {
        int[] a = {2, 1};
        System.out.println(getTopK(a, 1));
    }

    public static int getTopK(int[] a, int k) {
        if (k < 1 || k > a.length) {
            return -1;
        }
        k = a.length - k;
        int i = 0, j = a.length - 1, index = -1;
        while (index != k) {
            index = partition(a, i, j);
            if (index > k) {
                j = index - 1;
            } else {
                i = index + 1;
            }
        }
        return a[index];
    }

    public static int partition(int[] a, int i, int j) {
        int b = i;
        int e = j + 1;
        int x = a[i];
        while (i <= j) {
            while (b < j && a[++b] <= x)
                ;
            while (a[--e] > x)
                ;
            if (b >= e) {
                break;
            }
            int tmp = a[b];
            a[b] = a[e];
            a[e] = tmp;
        }
        a[i] = a[e];
        a[e] = x;
        return e;
    }
}