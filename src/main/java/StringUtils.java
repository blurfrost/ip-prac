public class StringUtils {
    
    public static String trim(String s) {
        if (s == null) {
            return null;
        }
        return s.trim();
    }
    
    public static String normalizeWhitespace(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("\\s+", " ").trim();
    }
    
    /**
     * Validates that the input string does not contain pipe characters.
     *
     * @param input the string to validate
     * @throws PipeCharacterException if the input contains a pipe character
     */
    public static void validateNoPipe(String input) {
        if (input != null && input.contains("|")) {
            throw new PipeCharacterException(input);
        }
    }
}
