package service;

import java.util.*;
import java.util.regex.Pattern;

public class TextService {

    private String[] wordInText(String text) {
        Pattern word = Pattern.compile("[^a-zA-Z]");
        return word.split(text);
    }

    public Map<String, Long> countWords(String text) {
        String[] wordsInText = wordInText(text);
        Map<String, Long> countWordsInText = new HashMap<>();
        Long count;
        Long first = (long) 1;
        for (String word : wordsInText) {
            String wordLower = word.toLowerCase();
            if (countWordsInText.containsKey(wordLower)) {
                count = countWordsInText.get(wordLower);
                countWordsInText.put(wordLower, count + 1);
            } else {
                countWordsInText.put(wordLower, first);

            }
        }
        return countWordsInText;
    }

    public Set<String> uniqueWords(String text) {
        String[] wordsInText = wordInText(text);
        Set<String> uniqueWords = new HashSet<>();
        for (String word : wordsInText) {
            uniqueWords.add(word.toLowerCase());
        }
        return uniqueWords;
    }

    public Set<String> sortWordsAlphabet(String text) {
        String[] words = wordInText(text);
        return new TreeSet<>(Arrays.asList(words));
    }

    public Set<String> sortWordsByLength(String text, Comparator<String> comparator) {
        String[] words = wordInText(text);
        Arrays.sort(words, comparator);
        return new LinkedHashSet<>(Arrays.asList(words));
    }
}
