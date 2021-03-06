import com.sun.source.tree.BinaryTree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingCharacter {
    public static void main(String[] args) {
        char result = firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof");
        System.out.println(result);
    }

    public static char firstNotRepeatingCharacter(String s) {
        LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<>(); //Use linked hash map to just preserve the order the push
        char[] characters = s.toCharArray();

        for (char character : characters) {
            int repeatFor = 0;
            if (hashmap.containsKey(character)) {
                repeatFor = hashmap.get(character);
                repeatFor++;
            }
            hashmap.put(character, repeatFor);
        }

        for (Map.Entry<Character, Integer> pair : hashmap.entrySet()) {
            if (pair.getValue() == 0) {
                return pair.getKey();
            }
        }
        return '_';
    }
}
