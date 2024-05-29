package com.zemo.base;

import java.util.List;

/**
 * @ClassName: MinHeap
 * @author: zeming.chen
 * @email: zeming.chen@dmall.com
 * @Date 12/19/2022
 * @Description
 */
public class MinHeap {

    private List<Integer> arr;
    /**
     * 构建最小堆，从最后一个节点的父节点开始调整（也可以对数组中某段连续数据即下标从firstIndex -> endIndex进行建堆）
     * @param firstIndex 起始下标
     * @param enIndex    结束下标
     */
    public void buildMinHeap(int firstIndex,int enIndex) {
        for (int i = enIndex/2; i >= firstIndex; i--) {
            adjustDown(i,enIndex);
        }
    }
    /**
     * 调整当前子树，越小的数据往上移动，注意调整的该节点还有子节点的情况，所以需要递归调整。
     * @param parentIndex  父节点的下标
     */
    private void adjustDown(int parentIndex,int endIndex) {
        int left = 2 * parentIndex + 1;
        int right = 2 * parentIndex + 2;
        //最小值的下标
        int minIndex = parentIndex;
        if (left < endIndex && arr.get(left) < arr.get(minIndex)) {
            minIndex = left;
        }
        if (right < endIndex && arr.get(right) < arr.get(minIndex)) {
            minIndex = right;
        }
        if(minIndex == parentIndex){
            return;
        }
        //交换元素
        swap(parentIndex,minIndex);
        //递归调整
        adjustDown(minIndex,endIndex);
    }
    private void swap(int parentIndex,int minIndex){
        int temp = arr.get(parentIndex);
        arr.set(parentIndex,arr.get(minIndex));
        arr.set(minIndex,temp);

    }
    /**
     * 先建成最小堆，再将堆顶元素和堆尾元素交换，除了当前堆的堆尾元素，对剩下的元素再次进行建堆
     */
    public void heapSort(){
        for(int i = 0;i<arr.size();i++){
            buildMinHeap(0,arr.size()-1-i);
            swap(0,arr.size()-1-i);
        }
    }
    public int deleteMinHeap(){
        //取出最小元素，并将最后一个元素置顶
        int minItem = arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        //移除末尾元素
        if(arr.size() > 1){
            arr.remove(arr.size() - 1);
        }
        //向下调整堆(该实现见上面)
        adjustDown(0,arr.size()-1);
        return minItem;
    }
    /**
     * @param item 要插入的元素
     */
    public void insertToMinHeap(int item){
        arr.add(item);
        //根节点
        if(arr.size() == 1){
            return;
        }
        adjustUp(arr.size()-1);

    }

    /**
     * 向上调整
     * @param childIndex 要往上调整的子节点的下标
     */
    private void adjustUp(int childIndex){
        int parentIndex = (childIndex - 1)/2;
        int parentItem = arr.get(parentIndex);
        int childItem = arr.get(childIndex);

        if(parentItem > childItem){
            swap(parentIndex,childIndex);
            adjustUp(parentIndex);
        }
    }
    public  void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            //
            swap((index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

  /*  public void heapInsert(List<Integer> arr,int value){
        if (arr == null || arr.length == 0) {
            arr
        }
        int lastIndex = arr.length;
    }*/

    public static void main(String[] args) {

    }
}
