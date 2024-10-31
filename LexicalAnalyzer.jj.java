import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {
    private static final String[] WORDS = {
        // Add your 400 words here
    };

    private static final Pattern WORD_PATTERN = Pattern.compile("\\b(" + String.join("|", WORDS) + ")\\b");
    private static final Map<String, String> TOKEN_MAP = new HashMap<>();

    static {
        for (int i = 0; i < WORDS.length; i++) {
            TOKEN_MAP.put(WORDS[i], "WORD_" + (i + 1));
        }
    }

    public static void main(String[] args) {
        String input = "This is a sample input text with some words.";
        analyze(input);
    }

    public static void analyze(String input) {
        Matcher matcher = WORD_PATTERN.matcher(input);
        while (matcher.find()) {
            String word = matcher.group();
            String token = TOKEN_MAP.get(word);
            System.out.println("Word: " + word + ", Token: " + token);
        }
    }
}