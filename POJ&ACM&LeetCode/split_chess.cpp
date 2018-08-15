/*
题目：http://blog.taohuawu.club/article/17
*/
#include <stdio.h>  
#include <string.h>  
#include <math.h>  
  
int sum[10][10],board[10][10];  
double ave;  
int dp[10][10][10][10][20];  
int calsum(int x1,int y1,int x2,int y2)  
{  
    int ans=sum[x2-1][y2-1];  
    if(x1>0)ans-=sum[x1-1][y2-1];  
    if(y1>0)ans-=sum[x2-1][y1-1];  
    if(x1>0&&y1>0)ans+=sum[x1-1][y1-1];  
    return ans;  
}  
int min(int a,int b)  
{  
    if(a>b)a=b;  
    return a;  
}  
void dfs(int x1,int y1,int x2,int y2,int num)  
{  
    if(dp[x1][y1][x2][y2][num]!=-1)return;  
    int temp;  
    dp[x1][y1][x2][y2][num]=100000000;  
    if(num==0)  
    {  
        temp=calsum(x1,y1,x2,y2);  
        dp[x1][y1][x2][y2][0]=temp*temp;  
        return ;  
    }  
    for(int i=x1+1; i<x2; i++)  
    {  
        dfs(i,y1,x2,y2,num-1);  
        dfs(x1,y1,i,y2,0);  
        dp[x1][y1][x2][y2][num]=min(dp[i][y1][x2][y2][num-1]+dp[x1][y1][i][y2][0],dp[x1][y1][x2][y2][num]);  
        dfs(i,y1,x2,y2,0);  
        dfs(x1,y1,i,y2,num-1);  
        dp[x1][y1][x2][y2][num]=min(dp[i][y1][x2][y2][0]+dp[x1][y1][i][y2][num-1],dp[x1][y1][x2][y2][num]);  
    }  
    for(int i=y1+1; i<y2; i++)  
    {  
        dfs(x1,i,x2,y2,num-1);  
        dfs(x1,y1,x2,i,0);  
        dp[x1][y1][x2][y2][num]=min(dp[x1][i][x2][y2][num-1]+dp[x1][y1][x2][i][0],dp[x1][y1][x2][y2][num]);  
        dfs(x1,i,x2,y2,0);  
        dfs(x1,y1,x2,i,num-1);  
        dp[x1][y1][x2][y2][num]=min(dp[x1][i][x2][y2][0]+dp[x1][y1][x2][i][num-1],dp[x1][y1][x2][y2][num]);  
    }  
}  
int main()  
{  
    int n;  
    while(scanf("%d",&n)!=EOF)  
    {  
        ave=0;  
        for(int i=0; i<8; i++)  
        {  
            for(int j=0; j<8; j++)  
            {  
                scanf("%d",&board[i][j]);  
                ave+=board[i][j];  
                sum[i][j]=board[i][j];  
                if(i>0)sum[i][j]+=sum[i-1][j];  
                if(j>0)  
                {  
                    sum[i][j]+=sum[i][j-1];  
                    if(i>0)sum[i][j]-=sum[i-1][j-1];  
                }  
            }  
        }  
        ave/=n;  
        memset(dp,-1,sizeof(dp));  
        dfs(0,0,8,8,n-1);  
        double ren=dp[0][0][8][8][n-1];  
        printf("%.3f\n",sqrt((ren/n)-ave*ave));//方差公式可以化简  
    }  
    return 0;  
}