/*
# 题目二：基站选址
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
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <map>
#include <iostream>
using namespace std;
int xa[1010],xb[1010],ya[1010],yb[1010];
int n,m,a,b;
long long pax,pay,sax,say;
const long long MM = 0x7fffffffffffffffLL;
int main(){
    int T;
    scanf("%d",&T);
    for(int ks=1;ks<=T;ks++){
        scanf("%d%d%d%d",&n,&m,&a,&b);
        pax=0,sax=0,pay=0,say=0;
        for(int i=0;i<a;i++){
            scanf("%d%d",xa+i,ya+i);
            pax+=xa[i]*xa[i];pay+=ya[i]*ya[i];
            sax+=xa[i];say+=ya[i];
         }
        for(int i=0;i<b;i++){
            scanf("%d%d",xb+i,yb+i);
        }    
        long long ans=    MM;
        for(int ii=0;ii<b;ii++){
            long long tx=MM;
            long long bs=0;    
                for(long long x=sax/a-3;x<sax/a+4;x++){
                long long c = a*x*x + pax - 2*sax*x + abs(x-xb[ii]);
                if(c<tx)tx=c;    
                }
            bs+=tx;
            tx=MM;    
                for(long long y=say/a-3;y<say/a+4;y++){
                long long c = a*y*y + pay - 2*say*y + abs(y-yb[ii]);
                if(c<tx)tx=c;    
                }
            bs+=tx;
            if(ans>bs) ans = bs;
        }
        printf("Case #%d: %lld\n",ks,ans);
    }
    return 0;
}