package com.zemo.easy.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: RansomNote
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 8/17/16 21:53
 * @Description Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int count = 0;
        char[] mChars = magazine.toCharArray();
        for (char rChar : ransomNote.toCharArray()) {
            for (int i = 0; i < mChars.length; i++) {
                if (rChar == mChars[i]) {
                    mChars[i] = ' ';
                    count++;
                    break;
                }
            }
        }
        return count == ransomNote.length();
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (char c : magazine.toCharArray())
            list.add(c);
        for (char c : ransomNote.toCharArray())
            if (!list.remove((Character) c))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct2("bjaajgea", "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
//        System.out.println(canConstruct("a","aa"));
    }
}
