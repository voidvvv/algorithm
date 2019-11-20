package cn.zkj.lk;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int closest=sum(0,1,2,nums);
        int subtract=Math.abs(target-closest);
        for (int x=0;x<nums.length;x++){
            for (int y =x+1;y<nums.length;y++){
                for (int z=y+1;z<nums.length;z++){
                    if(subtract>Math.abs(target-sum(x,y,z,nums))){
                        closest=sum(x,y,z,nums);
                        subtract=target-sum(x,y,z,nums);
                    }
                    if (subtract==0){
                        return sum(x,y,z,nums);
                    }
                }
            }
        }


        return closest;
    }

    public int sum(int a,int b,int c,int [] s){

        return s[a]+s[b]+s[c];
    }
}
