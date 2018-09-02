/*
众所周知，我们可以通过直角坐标系把平面上的任何一个点P用一个有序数对(x, y)来唯一表示，如果x, y都是整数，我们就把点P称为整点，否则点P称为非整点。我们把平面上所有整点构成的集合记为W。 
定义1 两个整点P1(x1, y1), P2(x2, y2)，若|x1-x2| + |y1-y2| = 1，则称P1, P2相邻，记作P1~P2，否则称P1, P2不相邻。 
定义 2 设点集S是W的一个有限子集，即S = {P1, P2,..., Pn}(n >= 1)，其中Pi(1 <= i <= n)属于W，我们把S称为整点集。 
定义 3 设S是一个整点集，若点R, T属于S，且存在一个有限的点序列Q1, Q2, ?, Qk满足: 
1. Qi属于S（1 <= i <= k）; 
2. Q1 = R, Qk = T; 
3. Qi~Qi + 1(1 <= i <= k-1)，即Qi与Qi + 1相邻; 
4. 对于任何1 <= i < j <= k有Qi ≠ Qj; 
我们则称点R与点T在整点集S上连通，把点序列Q1, Q2,..., Qk称为整点集S中连接点R与点T的一条道路。 
定义4 若整点集V满足：对于V中的任何两个整点，V中有且仅有一条连接这两点的道路，则V称为单整点集。 
定义5 对于平面上的每一个整点，我们可以赋予它一个整数，作为该点的权，于是我们把一个整点集中所有点的权的总和称为该整点集的权和。 
我们希望对于给定的一个单整点集V，求出一个V的最优连通子集B，满足： 
1. B是V的子集 
2. 对于B中的任何两个整点，在B中连通； 
3. B是满足条件(1)和(2)的所有整点集中权和最大的。 

# Input

>第1行是一个整数N（2 <= N <= 1000），表示单整点集V中点的个数； 
以下N行中，第i行(1 <= i <= N)有三个整数，Xi, Yi, Ci依次表示第i个点的横坐标，纵坐标和权。同一行相邻两数之间用一个空格分隔。-10^6 <= Xi, Yi <= 10^6；-100 <= Ci <= 100。 

# Output

>仅一个整数，表示所求最优连通集的权和。

# Sample Input

5 0 0 -2 0 1 1 1 0 1 0 -1 1 -1 0 1


# Sample Output
2
*/
#include<iostream>
#include<stdio.h>
#include<vector>
#include<math.h>
using namespace std;
const int MAXN=1005;
int n;
bool used[MAXN];
int f[MAXN];
struct Node
{
    int x,y,v;
}tt[MAXN];
vector<int>child[MAXN];
bool near(int p,int q)//判断两个整点是否相邻
{
    if(fabs((double)tt[p].x-tt[q].x)+fabs((double)tt[p].y-tt[q].y)==1)return true;
    return false;
}        
void dfs(int p)
{
    used[p]=true;
    for(int i=1;i<=n;i++)
    {
        if(!used[i]&&near(p,i))
        {
            child[p].push_back(i);
            dfs(i);
        }    
    }        
}   
void recur(int p)
{
    if(child[p].size()==0)
    {
        f[p]=tt[p].v;
        return;
    }    
    for(int i=0;i<child[p].size();i++)
        recur(child[p][i]);
    f[p]=tt[p].v;
    for(int i=0;i<child[p].size();i++)
      if(f[child[p][i]]>0)f[p]+=f[child[p][i]];
} 
int main()
{
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
        scanf("%d%d%d",&tt[i].x,&tt[i].y,&tt[i].v);
    for(int i=1;i<=n;i++)  child[i].clear();
    memset(used,false,sizeof(used));
    dfs(1);
    recur(1);
    int ans=0;
    //for(int i=1;i<=n;i++)
      //if(f[i]>ans)ans=f[i];
    printf("%d\n",f[1]);
    system("pause");
    return 0;
}