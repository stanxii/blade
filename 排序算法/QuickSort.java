class QuickSort {
    public void quickSort(int[] a, int i, int j) {
        if (i < j) {
            int mid = partition(a, i, j);
            quickSort(a, i, mid - 1);
            quickSort(a, mid + 1, j);
        }
    }
    public void partition(int[] a, int i, int j) {
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
        a[i] = a[b];
        a[b] = x;
    }
}