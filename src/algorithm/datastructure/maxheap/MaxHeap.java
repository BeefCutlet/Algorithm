package algorithm.datastructure.maxheap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    private static final List<Integer> tree = new ArrayList<>();

    public void push(int data) {
        tree.add(data);
        int currentIndex = tree.size() - 1;
        while (true) {
            int parentIndex = (currentIndex + 1) / 2 - 1;
            if (parentIndex < 0) {
                break;
            } else if (tree.get(currentIndex) <= tree.get(parentIndex)) {
                break;
            } else {
                int current = tree.get(currentIndex);
                int parent = tree.get(parentIndex);
                tree.remove(parentIndex);
                tree.add(parentIndex, current);
                tree.remove(currentIndex);
                tree.add(currentIndex, parent);
                currentIndex = parentIndex;
            }
        }
    }

    public void pop() {
        int currentIndex = tree.size() - 1;
        if (currentIndex < 0) {
            return;
        }

        int current = tree.get(currentIndex);
        tree.remove(currentIndex);
        tree.remove(0);
        tree.add(0, current);
        currentIndex = 0;

        while (true) {
            current = tree.get(currentIndex);
            int leftIndex = (currentIndex + 1) * 2 - 1;
            int rightIndex = (currentIndex + 1) * 2;

            if (leftIndex > tree.size() - 1 && rightIndex > tree.size() - 1) {
                break;
            }

            int left = tree.get(leftIndex);
            int right = rightIndex > tree.size() - 1 ? Integer.MIN_VALUE : tree.get(rightIndex);

            if (current >= left && current >= right) {
                break;
            }

            int max = current;
            int changeIndex = currentIndex;
            if (current < left) {
                max = left;
                changeIndex = leftIndex;
            }

            if (current < right && left < right) {
                max = right;
                changeIndex = rightIndex;
            }

            tree.remove(currentIndex);
            tree.add(currentIndex, max);
            tree.remove(changeIndex);
            tree.add(changeIndex, current);

            currentIndex = changeIndex;
        }
    }

    public List<Integer> getTree() {
        return tree;
    }
}
