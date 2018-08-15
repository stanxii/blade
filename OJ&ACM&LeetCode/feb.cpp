/*
# 题目一：2月29
时间限制:2000ms

单点时限:1000ms

内存限制:256MB

## 描述

>给定两个日期，计算这两个日期之间有多少个2月29日（包括起始日期）。
只有闰年有2月29日，满足以下一个条件的年份为闰年：
1. 年份能被4整除但不能被100整除
2. 年份能被400整除



## 输入
>第一行为一个整数T，表示数据组数。

>之后每组数据包含两行。每一行格式为"month day, year"，表示一个日期。month为{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November" , "December"}中的一个字符串。day与year为两个数字。

>数据保证给定的日期合法且第一个日期早于或等于第二个日期。



## 输出
>对于每组数据输出一行，形如"Case #X: Y"。X为数据组数，从1开始，Y为答案。

## 数据范围
>1 ≤ T ≤ 550

### 小数据：
>2000 ≤ year ≤ 3000

### 大数据：
>2000 ≤ year ≤ 2×109
### 样例输入
```
4

January 12, 2012

March 19, 2012

August 12, 2899

August 12, 2901

August 12, 2000

August 12, 2005

February 29, 2004

February 29, 2012
```

### 样例输出
```
Case #1: 1

Case #2: 0

Case #3: 1

Case #4: 3
*/
#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <algorithm>
#include <iosfwd>
#include <queue>
#include <sstream>
#include <stack>
#include <cstring>
#include <climits>
using namespace std;
#define LL long long
char month[12][20]={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November" , "December"};
map<string,int> mp;
int main(){
    int t,d,y,ans,m;
    char ms[20];
    for(int i=0;i<12;i++){
        mp[month[i]]=i+1;
    }
    scanf("%d",&t);
    for(int ks=1;ks<=t;ks++){
        scanf("%s %d, %d",ms,&d,&y);
        m=mp[ms];
        ans=y/4;ans-=y/100;
        ans+=y/400;
        if((y%4==0&&y%100!=0)||(y%400==0)){
            if(m<2)ans--;
            if(m==2&&d<=29)ans--;
        }
        ans=-ans;
        scanf("%s %d, %d",ms,&d,&y);
        m=mp[ms];
        ans+=y/4;ans-=y/100;
        ans+=y/400;
        if((y%4==0&&y%100!=0)||(y%400==0)){
            if(m<2)ans--;
            if(m==2&&d<29)ans--;
        }
        printf("Case #%d: %d\n",ks,ans);
    }
    return 0;
}