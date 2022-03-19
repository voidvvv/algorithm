package cn.zkj.lk.sctruction;

/**
 * @Classname Bank
 * @Description
 * @Date 2022/3/18 13:16
 * @Created by zkj
 */
public class Bank {
    private long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1<1 || account1>balance.length || account2<1 ||account2>balance.length){
            return false;
        }
        if (this.balance[account1-1]>=money){
            this.balance[account1-1]-=money;
            this.balance[account2-1]+=money;
            return true;
        }else {
            return false;
        }
    }

    public boolean deposit(int account, long money) {
        if (account<1 || account>balance.length){
            return false;
        }
        this.balance[account-1]+=money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account<1 || account>balance.length){
            return false;
        }
        if (this.balance[account-1]>=money){
            this.balance[account-1]-=money;
            return true;
        }else {
            return false;
        }
    }
}
