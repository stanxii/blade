class TopK {
	public static void main(String[] args) {
		int[] a = {3,4,6,8,32,38,9,22,88,62,10};
		System.out.println(getTopK(a, 4));
	}
    public static int getTopK(int[] a, int k) {
		k = a.length+1-k;
        int i = 0, j = a.length - 1, index = 0;
        while (index != k - 1) {
            if (index > k - 1) {
                j = index - 1;
            } else {
                i = index + 1;
            }
            index = partition(a, i, j);
        }
        return a[index];
    }

    public static int partition(int[] a, int i, int j) {
        int b = i;
        int e = j + 1;
        int x = a[i];
        while (true) {
            while (b < j && a[++b] < x)
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