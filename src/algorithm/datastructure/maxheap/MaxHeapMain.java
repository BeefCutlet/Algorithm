package algorithm.datastructure.maxheap;

import java.util.Arrays;

public class MaxHeapMain {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.push(20);
        maxHeap.push(10);
        maxHeap.push(50);
        maxHeap.push(40);
        maxHeap.push(60);
        maxHeap.push(30);

        maxHeap.pop();

        for (Integer heap : maxHeap.getTree()) {
            System.out.println(heap);
        }
    }
}
