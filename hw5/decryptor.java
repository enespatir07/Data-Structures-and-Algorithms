import java.util.Map;
import java.util.Iterator;

public class decryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text = "";
	private String cipher_text;

	public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		this.map = _map;
		this.key = _key;
		this.cipher_text = text;
		this.plain_text = text;
		decrypt();
	}

	/*
	 * Decrypt the cipher text
	 * 
	 */
	public void decrypt() {
		// do not edit this method
		generate_keystream();
		generate_plain_text();
	}

	/*
	 * Generate the keystream by repeating the key
	 * 
	 */
	private void generate_keystream() {
		StringBuilder temp = new StringBuilder();
		while (temp.length() < plain_text.length()) {
			temp.append(key);
		}
		keystream = temp.substring(0, plain_text.length());
	}

	/*
	 * Generate the plain text by using the keystream
	 * 
	 */
	private void generate_plain_text() {
		plain_text = "";
		for (int i = 0; i < cipher_text.length(); i++) { // iterate through the cipher text
			Map<Character, Character> row = map.get(keystream.charAt(i));// get the row of the map corresponding to the
																			// key character
			if (row != null) {// if the key character is found in the map
				Iterator<Character> row_it = row.keySet().iterator();// iterate through the row
				while (row_it.hasNext()) {
					Character keyEntry = row_it.next();
					if (row.get(keyEntry).equals(cipher_text.charAt(i))) {// if the value of the row is equal to the
																			// cipher text character
						plain_text += keyEntry;
						break;
					}
				}
			} else {
				System.out.println("Error: Key character '" + keystream.charAt(i) + "' not found in map.");
			}
		}
	}

	/*
	 * Get the keystream
	 * 
	 */
	public String get_keystream() {
		return keystream;
	}

	/*
	 * Get the plain text
	 */
	public String get_plain_text() {
		return plain_text;
	}
}
