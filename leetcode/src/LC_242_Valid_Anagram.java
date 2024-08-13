import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_242_Valid_Anagram {
    public boolean isAnagramSorting(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public boolean isAnagramHashTable(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        for (int val : count.values()) {
            if (val != 0) return false;
        }
        return true;
    }

    public boolean isAnagramHashTableArray(String s, String t) {
        int[] count = new int[26];
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        for (int x : count) {
            if (x != 0)
                return false;
        }
        return true;
    }  public boolean isAnagramHashTable2(String s, String t) {
        if(s.length() != t.length()) return  false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) -'a'] ++;
            count[t.charAt(i) -'a'] --;
        }
        for (int x : count) {
            if (x != 0)
                return false;
        }
        return true;
    }
}
