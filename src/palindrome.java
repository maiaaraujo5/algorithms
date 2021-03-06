import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class palindrome {
    public static void main(String[] args) {

    }

    public static boolean canConstruct(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0 || s.length() < k) {
            return false;
        }
        Map<Character, Integer> freqs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }
        if (k <= freqs.size()) {
            int oddFreq = 0;
            for (int freq : freqs.values()) {
                if (freq % 2 != 0) {
                    oddFreq++;
                }
            }
            return oddFreq <= k;
        }
        Iterator<Character> iter = freqs.keySet().iterator();
        for (int i = 0; i < k; i++) {
            if (!iter.hasNext()) {
                iter = freqs.keySet().iterator();
            }
            char c = iter.next();
            if (freqs.get(c) > 0) {
                freqs.put(c, freqs.get(c) - 1);
            }
        }
        int evenFreqs = 0;
        for (int freq : freqs.values()) {
            if (freq % 2 == 0) {
                evenFreqs++;
            }
        }
        return evenFreqs <= k;
    }
}
