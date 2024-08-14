import java.util.*;

public class LC_49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortWord = new String(chars);
            if (!map.containsKey(sortWord)) {
                map.put(sortWord, new ArrayList<>());
            }
            map.get(sortWord).add(str);

        }
        return new ArrayList<>(map.values());

    }
}
