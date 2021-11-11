package cn.zkj.lk.sctruction;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhaoKaiJie
 * @Description:1357. 每隔 n 个顾客打折
 *
超市里正在举行打折活动，每隔 n 个顾客会得到 discount 的折扣。

超市里有一些商品，第 i 种商品为 products[i] 且每件单品的价格为 prices[i] 。

结账系统会统计顾客的数目，每隔 n 个顾客结账时，该顾客的账单都会打折，折扣为 discount （也就是如果原本账单为 x ，那么实际金额会变成 x - (discount * x) / 100 ），然后系统会重新开始计数。

顾客会购买一些商品， product[i] 是顾客购买的第 i 种商品， amount[i] 是对应的购买该种商品的数目。

请你实现 Cashier 类：

Cashier(int n, int discount, int[] products, int[] prices) 初始化实例对象，参数分别为打折频率 n ，折扣大小 discount ，超市里的商品列表 products 和它们的价格 prices 。
double getBill(int[] product, int[] amount) 返回账单的实际金额（如果有打折，请返回打折后的结果）。返回结果与标准答案误差在 10^-5 以内都视为正确结果。
 *
 * @Date: 2021/6/19
 * @version: 01
 */
class Cashier {
    private Map<Integer,Integer> productPriceMapping;
    private int count;
    private int nowCount;
    private int discount;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.count = n;
        this.discount =discount;
        productPriceMapping = new HashMap<>();
        for (int x=0;x<prices.length;x++){
            productPriceMapping.put(products[x],prices[x]);
        }
        nowCount = 0;
    }

    public double getBill(int[] product, int[] amount) {
        int totalFee=0;
        for (int x=0;x<product.length;x++){
            Integer integer = productPriceMapping.get(product[x]);
            totalFee+= (integer*amount[x]);
        }
        if (++nowCount==1||(nowCount%(count+1)!=1)){
            return totalFee;
        }else {
            return getCountBill(totalFee);
        }
    }

    private double getCountBill(int bill){
        return (bill*((double)(100-discount)/100));
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
