package practise.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

    public static void main(String[] args) {

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] kElements = new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        int k = 2;
        int[] topK = topKFrequentElements.findTopK(kElements, k);
        for (int i : topK)
            System.out.println(i);
    }

    private int[] findTopK(int[] kElements, int k) {
        int[] output = new int[k];
        //calculate the frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : kElements)
            map.put(i, map.getOrDefault(i, 0) + 1);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        int i = 0;
        for (Integer key : map.keySet()) {
            queue.add(key);
            if (queue.size() > map.size() - k) {
                output[i++] = queue.poll();
            }
        }
        return output;
    }
}
