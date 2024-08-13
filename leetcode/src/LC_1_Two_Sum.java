import java.util.HashMap;
import java.util.Map;

public class LC_1_Two_Sum {
    public int[] twoSum_Brute_Force(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public int[] twoSumTwoPass(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i)
                return new int[]{i, numMap.get(complement)};
        }
        return new int[]{};
    }

    public int[] twoSumOnePass(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement))
                return new int[]{i, numMap.get(complement)};
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
