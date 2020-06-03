package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SetSample {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");

        set2.add("B");
        set2.add("C");
        set2.add("A");
        set2.add("A");

        System.out.println(set1.equals(set2));
    }
}
