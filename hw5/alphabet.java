import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class alphabet {
    private Set<Character> english_alphabet = new LinkedHashSet<Character>();
    private Map<Character, Map<Character, Character>> map = new HashMap<Character, Map<Character, Character>>();

    public alphabet() {
        // do not edit this method
        fill_english_alphabet();
        fill_map();
    }

    private void fill_english_alphabet() {
        // do not edit this method
        for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
            english_alphabet.add(c);
        }
    }

    /*
     * Fill the map with the Vigenere cipher table
     */
    private void fill_map() {
        Iterator<Character> alp_it = english_alphabet.iterator();
        Character[] alph_arr = new Character[english_alphabet.size()];
        int counter = 0;

        while (alp_it.hasNext()) {// fill the array with the alphabet using the iterator
            alph_arr[counter] = alp_it.next();
            counter++;
        }

        for (int i = 0; i < alph_arr.length; i++) {// iterate through the alphabet array
            Map<Character, Character> row_map = new HashMap<>();
            for (int j = 0; j < alph_arr.length; j++) {
                row_map.put(alph_arr[j], alph_arr[(j + i) % alph_arr.length]);
            }
            map.put(alph_arr[i], row_map);
        }
    }

    public void print_map() {
        // do not edit this method
        System.out.println("*** Viegenere Cipher ***\n\n");
        System.out.println("    " + english_alphabet);
        System.out.print("    ------------------------------------------------------------------------------");
        for (Character k : map.keySet()) {
            System.out.print("\n" + k + " | ");
            System.out.print(map.get(k).values());
        }
        System.out.println("\n");

    }

    /*
     * Get the map
     */
    public Map<Character, Map<Character, Character>> get_map() {
        return map;
    }
}
