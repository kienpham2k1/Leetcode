import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC_217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
            else if (nums[i] < nums[i - 1]) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] == nums[i]) return true;
                }
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
        return false;
    }

    public boolean containsDuplicateWithSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    public boolean containsDuplicateWithSHashSet(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) return true;
            seen.add(nums[i]);
        }
        return false;
    }

    public boolean containsDuplicateWithSHashMap(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(num) && seen.get(num) >= 1)
                return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}
