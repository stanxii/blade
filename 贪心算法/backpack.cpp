/*
题目：

问题描述：给定n种物品和一个背包。物品i的重量是Wi，其价值为Vi，
背包的容量为C 应如何选择装入背包的物品 使得装入背包中物品的
总价值最大? 这里，在选择物品i装入背包时，可以选择物品i的一部分，
而不一定要全部装入背包，不能重复装载。

现在有三种贪心策略：

1.按照价值最大贪心，是目标函数增长最快的，但是背包容量却可能消耗的太快，使得装入背包的物品个数减少，而且有很大的几率会冗余，从而不能保证目标函数达到最大值。
2.按照重量最大贪心，使得背包增长最慢，很显然，重量和价值没有关系，这也无法保证目标函数达到最大值。
3.按照价值率（价值除以质量），使得单位重量价值增长最快。保证了价值和重量，是最优解。
*/
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

//排序，前者为价值，后者为重量
bool compare(std::pair<int, int> i, std::pair<int, int> j)
{
    return (double)i.first / (double)i.second > (double)j.first / (double)j.second;
}

void GreedyKnapsack(int limit_weight, vector<std::pair<int, int>> goods, vector<double> &result)
{
    if (goods.size() == 0)
    {
        return;
    }
    std::sort(goods.begin(), goods.end(), compare);
    int i = 0;
    for (auto p : goods)
    {
        std::cout << "第" << i << "个物品，价值为" << p.first << "，重量为" << p.second << "，单位重量价值率为" << (double)p.first / p.second << std::endl;
        i++;
    }
    result.assign(goods.size(), 0.0); //初始化
    auto itr = goods.begin();
    i = 0;
    for (; itr != goods.end(), i < result.size(); itr++, i++)
    {
        if ((*itr).second > limit_weight)
            break;     //一定要立马退出，便于后面做部分计算
        result[i] = 1; //mark
        limit_weight -= (*itr).second;
    }

    if (itr != goods.end())
    {
        result[i] = (double)limit_weight / (*itr).second;
    }
}

int main()
{
    vector<double> result;
    vector<std::pair<int, int>> goods = {{25, 18}, {24, 15}, {15, 10}};
    int limit_weight = 20;

    GreedyKnapsack(limit_weight, goods, result);

    cout << "--------结果-------" << endl;
    for (auto itr = result.begin(); itr != result.end(); itr++)
    {
        if ((*itr) > 0.0)
        {
            std::cout << "需要第" << std::abs(std::distance(result.begin(), itr)) << "个物品 : " << *itr << "个" << std::endl;
        }
    }

    return 0;
}