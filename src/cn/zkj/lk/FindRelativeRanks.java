package cn.zkj.lk;

import java.util.Arrays;

//506. 相对名次
/*
给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。

(注：分数越高的选手，排名越靠前。)

示例 1:

输入: [5, 4, 3, 2, 1]
输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
提示:

N 是一个正整数并且不会超过 10000。
所有运动员的成绩都不相同。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-ranks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRelativeRanks {
    public static void main(String[] args) {
        //[1,0,0,1,0,0,0,1] 826
        FindRelativeRanks f =new FindRelativeRanks();
        int[]a1={1,0,0,1,0,0,0,1};
        f.prisonAfterNDays(a1,826);
    }

    public String[] findRelativeRanks(int[] nums) {
        int [] count = new int[nums.length];
        for (int x=0;x<count.length;x++){
            count[x]=x;
        }

        int n=nums.length/2;
        while (n>0){
            for (int x=n;x<2*n;x++){
                for (int y=x;y<nums.length;y+=n){
                    int val=nums[y];
                    int m=count[y];
                    int index =y-n;

                    while (index>=0&&nums[index]<val){
                        nums[index+n]=nums[index];
                        count[index+n]=count[index];
                        index-=n;
                    }
                    nums[index+n]=val;
                    count[index+n]=m;


                }
            }
            n/=2;
        }
        String[]result=new String[nums.length];
        String s1="Gold Medal";
        String s2="Silver Medal";
        String s3="Bronze Medal";
        for (int x=0;x<count.length;x++){
            if (x==0){
                result[count[x]]=s1;
                continue;
            }
            if (x==1){
                result[count[x]]=s2;
                continue;
            }
            if(x==2){
                result[count[x]]=s3;
                continue;
            }
            result[count[x]]=x+1+"";

        }
        return result;
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N==0){
            return cells;
        }
        int[] pre=new int[cells.length];
        for (int x=0;x<cells.length;x++){
            pre[x]=cells[x];
        }
        cells[0]=0;
        cells[cells.length-1]=0;
        //N=N%14;
        for (int x=0;x<=(N-1)%14;x++){
            for (int y=1;y<cells.length-1;y++){
                if (pre[y-1]==pre[y+1]){
                    cells[y]=1;
                }else {
                    cells[y]=0;
                }
            }
            System.out.println("这是第"+x+"天的结果"+Arrays.toString(cells));

            for (int z=0;z<cells.length;z++){
                pre[z]=cells[z];
            }
        }
        return cells;

    }
}
