import java.util.Arrays;

public class LC_128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                length++;
            } else if (nums[i - 1] == nums[i]) continue;
            else {
                length = 1;
            }
            longest = Math.max(length, longest);
        }
        return longest;
    }
}
