package cn.zkj.algorithm;

public class Boy {
    int id;
    Boy next;

    public Boy(int x){
        this.id=x;
    }



    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id ;
    }
}
