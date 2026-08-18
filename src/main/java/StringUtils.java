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
}
