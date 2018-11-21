package me.kaishun.最基础的算法.数据流的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流的中位数
 */
public class MedianHolder {

    public static void main(String[] args) {
        MedianHolder medianHolder = new MedianHolder();
        int[] arr = {1,2,3,4,5,6,7,8};
        for (int i : arr) {
            medianHolder.addNumber(i);
            System.out.print(medianHolder.getMidian()+",");
        }
    }

    private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new MaxHeapComparator());
    private PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();

    public void addNumber(int num){
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }
        if(this.maxHeap.peek()>num){
            maxHeap.add(num);
        }else {
            if(minHeap.isEmpty()){
                minHeap.add(num);
                return;
            }
            if(minHeap.peek()>num){
                // 大的和小的中间的，默认放在大的里面
                maxHeap.add(num);
            }else {
                minHeap.add(num);
            }
        }
        //两个堆的长度差不能超过1
        if(maxHeap.size()==minHeap.size()+2){
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size()==maxHeap.size()+2){
            maxHeap.add(minHeap.poll());
        }
    }
    public Double getMidian(){
        if(minHeap.size()==maxHeap.size()&&minHeap.size()==0){
            return null; //两个都是空，就return null
        }
        if(minHeap.size()==maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek()*1.0;
        }else {
            return minHeap.peek()*1.0;
        }
    }
    public class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a,Integer b){
            if(b>a){
                return 1;
            }else if(b<a){
                return -1;
            }
            return 0;
        }
    }

}
