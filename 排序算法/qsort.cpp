// 快排C++实现

template <class Type>
void QuickSort(Type a[], int p, int r)
{
    if (p < r)
    {
        int q = Partition(a, p, r);
        QuickSort(a, p, q - 1);
        QuickSort(a, q + 1, r);
    }
}

template <class Type>
int Partition(Type a[], int p, int r)
{
    int i = p, j = r + 1;
    Type x = a[p];
    while (true)
    {
        while (a[++i] < x && i < r);
        while (a[--j] > x);
        if (i >= j)
            break;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    a[p] = a[j];
    a[j] = x;
    return j;
}