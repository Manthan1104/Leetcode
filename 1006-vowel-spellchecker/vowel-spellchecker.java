import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatch = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelError = new HashMap<>();

        for (String word : wordlist) {
            exactMatch.add(word);

            String wordLower = word.toLowerCase();
            if (!caseInsensitive.containsKey(wordLower)) {
                caseInsensitive.put(wordLower, word);
            }

            String wordVowelMasked = maskVowels(wordLower);
            if (!vowelError.containsKey(wordVowelMasked)) {
                vowelError.put(wordVowelMasked, word);
            }
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactMatch.contains(query)) {
                result[i] = query;
            } else {
                String queryLower = query.toLowerCase();
                String queryVowelMasked = maskVowels(queryLower);

                if (caseInsensitive.containsKey(queryLower)) {
                    result[i] = caseInsensitive.get(queryLower);
                } else if (vowelError.containsKey(queryVowelMasked)) {
                    result[i] = vowelError.get(queryVowelMasked);
                } else {
                    result[i] = "";
                }
            }
        }

        return result;
    }

    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (isVowel(ch)) {
                sb.append('*');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}

/*

private boolean isVowel(char c) {
    Character ch = Character.toLowerCase(c);  // ensure lowercase
    return ch.equals('a') || ch.equals('e') || ch.equals('i') || ch.equals('o') || ch.equals('u');
}

private boolean isVowel(char c) {
    c = Character.toLowerCase(c);  // in case it's uppercase
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

*/