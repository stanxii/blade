#include <cstdio>
#include <algorithm>
#include <cmath>
using namespace std;
struct Node
{
    double x, y;
} arr[10010];
bool cmp(const Node &a, const Node &b)
{
    return a.x < b.x;
}
int main()
{
    int t;
    scanf("%d", &t);
    while (t--)
    {
        int n, w, h;
        double x, r;
        scanf("%d%d%d", &n, &w, &h);
        h = h / 2;
        for (int i = 1; i <= n; i++)
        {
            scanf("%lf%lf", &x, &r);
            double temp;
            if (r < h)
                temp = 0;
            else
                temp = sqrt(r * r - h * h);
            arr[i].x = x - temp;
            arr[i].y = x + temp;
        }
        sort(arr + 1, arr + n + 1, cmp);
        int sum = 0;
        double index = 0.0, curr = 0.0;
        for (int i = 1; i <= n; i++)
        {
            if (arr[i].x <= index)
            {
                curr = arr[i].y;
                while (arr[i].x <= index)
                {

                    curr = max(curr, arr[i].y);
                    i++;
                    if (i > n)
                        break;
                }
                i--;
                index = curr;
                sum++;
            }
            if (index >= w)
                break;
        }
        if (index >= w)
            printf("%d\n", sum);
        else
            printf("0\n");
    }
}