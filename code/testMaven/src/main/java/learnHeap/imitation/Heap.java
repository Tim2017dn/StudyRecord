package learnHeap.imitation;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class Heap {

    public static void sort(Comparable[] pq){
        int n = pq.length;


        // 生成 大根堆
        for(int k = n/2;k>=1;k--){
            sink(pq,k,n);
        }

        //通过交换
        //使得每次最大的在底部

        int k= n;
        while( k>1) {
            swap(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    public static void sort2(Comparable[] pq){
        int n=pq.length;
        for(int i=n;i>1;i--){
            swim(pq,i);
        }
    }

    private static void sink(Comparable[] pq, int k,int n){

        // int t= 2*k;
        while(2*k<=n){
            int j = 2*k;
            if(j < n && less(pq,j,j+1)){
                j++;
            }
            if(!less(pq,k,j)){
                break;
            }
            swap(pq,k,j);
            k=j;
          //  t=2*k;

        }

    }

    private static void swim(Comparable[] pq,int k){
        while(k>1 && less(pq,k,k/2)){
            swap(pq,k/2,k);
            k=k/2;
        }
    }

    private static void swap(Object[] pq,int i,int j) {
        Object temp = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = temp;
    }

    private static boolean less(Comparable[] pq,int i,int j){
        return pq[i-1].compareTo(pq[j-1])<=0?true:false;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void main(String[] args) {
//        Integer [] arr ={4,3,2,1,0} ;
        Integer[] arr = {53,5,23,15,25,97,435,32,11};

        Heap.sort(arr);
       // Heap.sort2(arr);

        show(arr);
    }
}
