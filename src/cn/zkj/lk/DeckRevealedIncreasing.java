package cn.zkj.lk;

/*
950.
牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。

最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。

现在，重复执行以下步骤，直到显示所有卡牌为止：

从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
返回能以递增顺序显示卡牌的牌组顺序。

答案中的第一张牌被认为处于牌堆顶部。

 

示例：

输入：[17,13,11,2,3,5,7]
输出：[2,13,3,11,5,17,7]
解释：
我们得到的牌组顺序为 [17,13,11,2,3,5,7]（这个顺序不重要），然后将其重新排序。
重新排序后，牌组以 [2,13,3,11,5,17,7] 开始，其中 2 位于牌组的顶部。
我们显示 2，然后将 13 移到底部。牌组现在是 [3,11,5,17,7,13]。
我们显示 3，并将 11 移到底部。牌组现在是 [5,17,7,13,11]。
我们显示 5，然后将 17 移到底部。牌组现在是 [7,13,11,17]。
我们显示 7，并将 13 移到底部。牌组现在是 [11,17,13]。
我们显示 11，然后将 17 移到底部。牌组现在是 [13,17]。
我们展示 13，然后将 17 移到底部。牌组现在是 [17]。
我们显示 17。
由于所有卡片都是按递增顺序排列显示的，所以答案是正确的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reveal-cards-in-increasing-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Stack;

public class DeckRevealedIncreasing {
    class NodeList {
        int val;
        NodeList next;
        NodeList pre;

        NodeList(int a) {
            val = a;
        }
    }

    public static void main(String[] args) {
        DeckRevealedIncreasing d= new DeckRevealedIncreasing();
        int[] arr={17,13,11,2,3,5,7};
        int[] ints = d.deckRevealedIncreasing(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        shellSort(deck);
        int[] result = new int[deck.length];
        NodeList nodeList = new NodeList(0);
        nodeList.next = nodeList;
        nodeList.pre=nodeList;
        NodeList temp = nodeList;

        for (int x = 1; x < deck.length; x++) {
            NodeList teemp = new NodeList(x);
//            System.out.println(x);
            teemp.next = nodeList;
            teemp.pre=temp;
            nodeList.pre=teemp;
            temp.next = teemp;
            temp = temp.next;
        }
       /* System.out.println("检查链表");
        temp = nodeList;
        for (int x=0;x<14;x++){
            System.out.println(temp.val);
            temp=temp.next;
        }
        System.out.println("结束");*/
        temp = nodeList;
        int num = 0;
        int nn=0;
        while (temp.next != temp) {
            //System.out.println(temp.val);
            if (num%2==0){
                //System.out.println(temp.val);
//                System.out.println(nn);
                result[temp.val]=deck[nn];
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
                nn++;
            }
            num++;
            /*System.out.println(temp.pre.val);
            System.out.println(temp.val);
            System.out.println(temp.pre.pre.val);
            System.out.println("======");*/
            temp=temp.next;
        }
        result[temp.val]=deck[nn];
        return result;

    }

    public void shellSort(int[] deck) {
        int n = deck.length / 2;

        while (n > 0) {
            for (int x = n; x < n * 2; x++) {
                for (int y = x; y < deck.length; y += n) {
                    int val = deck[y];
                    int index = y - n;

                    while (index >= 0 && deck[index] > val) {
                        deck[index + n] = deck[index];
                        index -= n;
                    }
                    deck[index + n] = val;

                }
            }
            n /= 2;
        }
    }
}
