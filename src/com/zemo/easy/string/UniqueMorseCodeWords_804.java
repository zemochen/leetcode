package com.zemo.easy.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: UniqueMorseCodeWords_804
 * @author: superzemo
 * @email: zemochen@gmail.com
 * @Date 2018/7/24 10:21 PM
 * @Description International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
 *              as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 *              For convenience, the full table for the 26 letters of the English alphabet is given below:
 *              [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
 *              "...","-","..-","...-",".--","-..-","-.--","--.."]
 *              Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
 *              For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
 *              We'll call such a concatenation, the transformation of a word.
 *              Return the number of different transformations among all words we have.
 *  Example:
 *          Input: words = ["gin", "zen", "gig", "msg"]
 *          Output: 2
 * Explanation:
 *          The transformation of each word is:
 *          "gin" -> "--...-."
 *          "zen" -> "--...-."
 *          "gig" -> "--...--."
 *          "msg" -> "--...--."
 *
 * There are 2 different transformations, "--...-." and "--...--.".
 */
public class UniqueMorseCodeWords_804 {

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseTable = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> morseSet = new HashSet<String>();
        for (String word : words) {
            StringBuilder morse = new StringBuilder();
            for (char c : word.toLowerCase().toCharArray()) {
                morse.append(morseTable[c - 'a']);
            }
            morseSet.add(morse.toString());
        }
        return morseSet.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
