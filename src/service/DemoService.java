package service;

import repository.Text;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class DemoService {
    public void runDemo() {
        TextService textService = new TextService();
        String text = Text.text;

        Map<String, Long> words = textService.countWords(text);
        System.out.println("All words from text:");
        words.forEach((word, aLong) -> System.out.printf("%s - %d%n", word, aLong));
        System.out.println();

        Set<String> uniq = textService.uniqueWords(text);
        System.out.println("Unique words:");
        uniq.forEach(System.out::println);
        System.out.println();

        Set<String> sortedAlphabet = textService.sortWordsAlphabet(text);
        System.out.println("Sorted by alphabetically:");
        sortedAlphabet.forEach(System.out::println);
        System.out.println();

        Comparator<String> stringComparator = new WordLength();
        Set<String> sortedLength = textService.sortWordsByLength(text, stringComparator);
        System.out.println("Sorted by length:");
        sortedLength.forEach(System.out::println);
        System.out.println();
    }
}
