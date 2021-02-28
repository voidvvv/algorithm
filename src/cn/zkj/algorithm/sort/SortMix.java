package cn.zkj.algorithm.sort;

public class SortMix {
    //所有高级排序

    //希尔排序
    public void shellSort( int[]arr){
        int n=arr.length/2;

        while (n>0){
            for (int x=n;x<n*2;x++){
                for (int y=x;y<arr.length;y+=n){
                    int val=arr[y];
                    int indedx=y-n;
                    while (indedx>=0&&arr[indedx]>val){
                        arr[indedx+n]=arr[indedx];
                        indedx-=n;
                    }
                    arr[indedx+n]=val;
                }
            }
            n/=2;
        }
    }

    //将数组分成两部分，其中一部分比另一部分都要小
    public void quickSort(int[] arr,int left,int right){
        int le= left;
        int r =right;

        int pivot=arr[(left+right)/2];
        int temp;
        while (le<r){
            while (arr[le]<pivot){
                le++;
            }
            while (arr[r]>pivot){
                r--;
            }
            if (le>=r){
                break;
            }
            temp=arr[le];
            arr[le]=arr[r];
            arr[r]=temp;
            if (arr[le]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                le++;
            }
        }
        if (le==r){
            le++;
            r--;
        }
        if (le<right){
            quickSort(arr,le,right);
        }
        if (r>left){
            quickSort(arr,left,r);
        }
    }

    //归并排序
    public void merge(int[] arr,int left,int right,int mid,int[] temp){
        int i=left;
        int j= mid+1;

        int t=0;
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]) {
                temp[t]=arr[i];
                i++;
                t++;
            }else {
                temp[t]=arr[j];
                j++;
                t++;
            }
        }
        while (i<=mid){
            temp[t]=arr[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }

        t=0;
        int leftIndex=left;
        while (leftIndex<=right){
            arr[leftIndex] = arr[t];
            leftIndex++;
            t++;
        }


    }

    public void divid(int[]arr,int left,int right,int[] temp){
        if (left<right){
            int mid = (left+right)/2;


            divid(arr,left,mid,temp);
            divid(arr,mid+1,right,temp);

            merge(arr,left,right,mid,temp);
        }
    }

    //基数排序
    public void RadixSort(int[]arr){
        int[][] bucket=new int[10][arr.length];
        int[] mark=new int[10];

        int max=arr[0];
        for (int i:arr){
            if (i>max){
                max=i;
            }
        }
        int n=0;
        while (max>0){
            max/=10;
            n++;
        }
        int count=0;
        for (int x=0;x<n;x++){
            for (int y=0;y<arr.length;y++){
                int cur=arr[y];
                for (int z=0;z<x;z++){
                    cur=cur/10;
                }
                cur=cur%10;
                bucket[cur][mark[cur]]=arr[y];

                mark[cur]++;
            }
            int index=0;
            for (int m=0;m<10;m++){
                for (int p=0;p<mark[m];p++){
                    arr[index]=bucket[m][p];
                    index++;
                }
            }
        }
    }
}
