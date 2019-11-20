package cn.zkj.lk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class SearchMatrix {
    public static void main(String[] args) throws ParseException {
        int i=1;
        while (true){
            i++;
            if (i==5){
                break;
            }
        }
        System.out.println(i);

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse("2019-12-11");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();

        System.out.println(date.getTime());
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[1].length;
        //设置目标值范围下标的m n
        int nmin = 0;
        int mmin = 0;
        //设置目标值范围上界的 m n
        int nmax = n;
        int mmax = m;
        //与target比较的游标
        int t=matrix[n/2][m/2];
        //比较次数
        int c=1;
        while (t!=target){
            c++;
            if (target>t){
                nmin+= n>>(c);
                mmin+= m>>(c);
                t=matrix[nmin][mmin];
            }
            if (target<t){
                nmax-= n>>(c);
                mmax-= m>>(c);
                t=matrix[nmax][nmax];
            }

            if (t==target){
                return true;
            }
            if (Math.abs(nmax-nmin)<=1&&Math.abs(mmax-mmin)<=1){
                return false;
            }
        }
        return true;
    }

}
