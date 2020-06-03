package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListSamples {
    public static void main(String[] args) {
        List<String> params = new ArrayList<String>();
        params.add("a");
        params.add("b");
        params.add("c");
        params.add("D");

        System.out.println(params.stream().collect(Collectors.joining(",","(",")")));
//        System.out.println(params.stream().map(val->val.toUpperCase()).collect(Collectors.toList()));

        System.out.println();


    }
}
