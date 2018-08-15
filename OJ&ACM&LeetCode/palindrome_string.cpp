/*
# 题目三：回文字符串序列
时间限制:2000ms

单点时限:1000ms

内存限制:256MB

## 描述
>给定字符串，求它的回文子序列个数。回文子序列反转字符顺序后仍然与原序列相同。例如字符串aba中，回文子序列为"a", "a", "aa", "b", "aba"，共5个。内容相同位置不同的子序列算不同的子序列。

## 输入
>第一行一个整数T，表示数据组数。之后是T组数据，每组数据为一行字符串。

## 输出
>对于每组数据输出一行，格式为"Case #X: Y"，X代表数据编号（从1开始），Y为答案。答案对100007取模。

## 数据范围
>1 ≤ T ≤ 30

## 小数据
>字符串长度 ≤ 25

## 大数据
>字符串长度 ≤ 1000

## 样例输入
```
5

aba

abcbaddabcba

12111112351121

ccccccc

fdadfa
```

## 样例输出
```
Case #1: 5

Case #2: 277

Case #3: 1333

Case #4: 127

Case #5: 17
*/
#include <iostream>
#include <cstdio>
#include <cstring>
#include <cmath>
#include <string>
#include <iomanip>
#include <algorithm>
#include <queue>
#define MOD 100007
using namespace std;
int dp[1005][1005];
char str[1005];
int main()
{
    int T,cnt=0,t;
    cin>>T;
    t=T;
    getchar();
    int tmp[T];
    while(T--)
    {
        gets(str);
        int n=strlen(str);
        int i,j;
        for(i=0;i<n;i++)
            dp[i][i]=1;
        for(i=1;i<n;i++)
        {
            for(j=i-1;j>=0;j--)
            {
                dp[j][i]=(dp[j+1][i]+dp[j][i-1]-dp[j+1][i-1]+MOD)%MOD;
                if(str[i]==str[j])
                    dp[j][i]=(dp[j][i]+dp[j+1][i-1]+1+MOD)%MOD;
            }
        }
        tmp[cnt++]=dp[0][n-1];
    }
    for(int i=1;i<=t;i++)
    {
     printf("Case #%d: %d\n",i,tmp[i-1]);
    }
    return 0;
}