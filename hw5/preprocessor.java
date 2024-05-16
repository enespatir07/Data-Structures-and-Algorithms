public class preprocessor {
    private String initial_string;
    private String preprocessed_string;

    public preprocessor(String str) {
        this.initial_string = str;
        preprocess();
    }

    public void preprocess() {
        // do not edit this method
        capitalize();
        clean();
    }

    /*
     * Capitalize the string by using ASCII values
     */
    private void capitalize() {
        char[] initial_string_arr = initial_string.toCharArray();
        for (int i = 0; i < initial_string_arr.length; i++) {
            if (Character.isLowerCase(initial_string_arr[i])) {
                initial_string_arr[i] = (char) (initial_string_arr[i] - 32);
            }
        }
        initial_string = new String(initial_string_arr);
        this.preprocessed_string = initial_string;
    }

    /*
     * Remove all non-alphabetic characters from the string
     */
    private void clean() {
        this.preprocessed_string = preprocessed_string.replaceAll("[^A-Z]", "");
    }

    /*
     * Get the preprocessed string
     */

    public String get_preprocessed_string() {
        return preprocessed_string;
    }
}
