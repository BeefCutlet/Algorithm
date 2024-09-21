package algorithm.graphalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 8, 9, 0, 0, 0, 0},
                {0, 0, 0, 10, 0, 0, 0},
                {0, -15, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, -7, 0},
                {0, 0, 12, 0, 0, 0, 5},
                {0, 0, 0, 0, 4, 0, 0,}
        };

        //현재 최소 가중치
        int[] min = new int[graph.length];
        Arrays.fill(min, 100000);
        //시작 인덱스
        int start = 0;
        min[start] = 0;
        //현재 선택된 노드
        List<Integer> onNode = new ArrayList<>();
        onNode.add(start);
        //현재 선택된 노드와 인접한 노드 ==> 다음으로 체크할 노드
        List<Integer> newOnNode = new ArrayList<>();

        for (int i = 1; i < graph.length; i++) {
            for (int node : onNode) {
                for (int j = 0; j < graph[node].length; j++) {
                    if (graph[node][j] != 0) {
                        int newNodeData = min[node] + graph[node][j];
                        min[j] = Math.min(newNodeData, min[j]);
                        newOnNode.add(j);
                    }
                }
            }
            //다음으로 체크할 노드 선택
            onNode = newOnNode;
            newOnNode = new ArrayList<>();
        }

        for (int minCount : min) {
            System.out.println(minCount);
        }
    }
}
