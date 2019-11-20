package cn.zkj.lk;

/*
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class MaxProfit {



    public int maxProfit(int[] prices) {
//        先设一个最小值，为int上限，再设一个初始利润，为0
        int minprice = Integer.MAX_VALUE;
        int profit = 0;
//        遍历数组，每当遍历到一个数就将其跟最小值比较，取其中较小者
        for (int x=0;x<prices.length;x++){
            minprice = Math.min(prices[x],minprice);
//        然后让其跟目前的最小值相减，跟利润比，取最大者。这样到最后即可得到理想值
            profit = Math.max(profit,prices[x]-minprice);
        }
        return profit;
    }
}
