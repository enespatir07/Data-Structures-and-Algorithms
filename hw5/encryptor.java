import java.util.Map;

public class encryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text;
	private String cipher_text = "";

	public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		this.map = _map;
		this.key = _key;
		this.plain_text = text;
		encrypt();
	}

	public void encrypt() {
		// do not edit this method
		generate_keystream();
		generate_cipher_text();
	}

	/*
	 * Generate the keystream by repeating the key
	 */
	private void generate_keystream() {
		String temp = "";
		while (temp.length() < plain_text.length()) {
			temp += key;
		}
		keystream = temp.substring(0, plain_text.length());
	}

	/*
	 * Generate the cipher text by using the keystream
	 * 
	 */
	private void generate_cipher_text() {
		cipher_text = "";
		for (int i = 0; i < plain_text.length(); i++) {
			cipher_text += map.get(plain_text.charAt(i)).get(keystream.charAt(i));
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
	 * Get the cipher text
	 */
	public String get_cipher_text() {
		return cipher_text;
	}
}
