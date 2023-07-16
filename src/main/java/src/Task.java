package src;

import java.util.*;


/**
 Вам потрібно розробити алгоритм програми, яка повинна виконувати наступне:
 - програма приймає на вхід довільний текст і знаходить в кожному слові цього тексту найперший символ, який більше НЕ повторюється в аналізуємому слові
 - далі із отриманого набору символів програма повинна вибрати перший унікальний (тобто той, який більше не зустручається в наборі) і повернути його.

 Наприклад, якщо програма отримує на вхід текст нижче:

 The Tao gave birth to machine language.  Machine language gave birth to the assembler.
 The assembler gave birth to the compiler.  Now there are ten thousand languages.
 Each language has its purpose, however humble.  Each language expresses the Yin and Yang of software.
 Each language has its place within the Tao.
 But do not program in COBOL if you can avoid it.
 -- Geoffrey James, "The Tao of Programming"

 то повинна повернути вона символ "m".
 */
public class Task {

    /**
     * Finds the first unique character in the given text.
     *
     * @param text The text to search for the first unique character.
     * @return An Optional containing the first unique character, or an empty Optional if no unique character is found.
     * @throws IllegalArgumentException if the text is null or empty.
     */
    public static Optional<Character> findFirstUniqueCharacter(String text) {

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text must not be null or empty.");
        }

        // Splitting the text into words
        String[] words = text.split("\s+");

        // List to store the first non-repeated character of each word
        List<Character> characters = new LinkedList<>();

        // Finding the first non-repeated character for each word
        for (String word : words) {
            characters.add(findFirstNonRepeatedCharacter(word));
        }

        // Finding the first unique symbol from the list of characters
        return findFirstUniqueSymbol(characters);
    }

    /**
     * Finds the first non-repeated character in the given word.
     *
     * @param word The word to search for the first non-repeated character.
     * @return The first non-repeated character, or '\0' if no non-repeated character is found.
     */
    private static char findFirstNonRepeatedCharacter(String word) {
        // Map to store character frequencies in the word
        Map<Character, Integer> characterCounts = new LinkedHashMap<>();

        // Counting the frequency of each character in the word
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            characterCounts.put(c, characterCounts.getOrDefault(c, 0) + 1);
        }

        // Finding the first non-repeated character by iterating through the map
        for (Map.Entry<Character, Integer> entry : characterCounts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0'; // No non-repeated character found
    }

    /**
     * Finds the first unique symbol in the given list of symbols.
     *
     * @param symbols The list of symbols to search for the first unique symbol.
     * @return An Optional containing the first unique symbol, or an empty Optional if no unique symbol is found.
     */
    private static Optional<Character> findFirstUniqueSymbol(List<Character> symbols) {
        // Map to store symbol frequencies
        Map<Character, Integer> symbolFrequency = new HashMap<>();

        // Counting the frequency of each symbol in the list
        for (char symbol : symbols) {
            symbolFrequency.put(symbol, symbolFrequency.getOrDefault(symbol, 0) + 1);
        }

        // Finding the first unique symbol by iterating through the list
        for (char symbol : symbols) {
            if (symbolFrequency.get(symbol) == 1) {
                return Optional.of(symbol);
            }
        }

        return Optional.empty(); // No unique symbol found
    }
}
