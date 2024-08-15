import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_347_Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int num : nums) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue()
        );
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            topKElements.add(entry);
            if (topKElements.size() > k) topKElements.poll();
        }
        int[] topNumbers = new int[k];
        for (int i = 0; i < topKElements.size(); i++) {
            topNumbers[i] = topKElements.poll().getKey();
        }
        return topNumbers;
    }
}
