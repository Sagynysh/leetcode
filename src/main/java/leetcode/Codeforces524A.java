package leetcode;

import java.util.Scanner;

public class Codeforces524A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int red = 2;
        int green = 5;
        int blue = 8;

        int redC = (red*n)%k==0?(red*n)/k:(red*n)/k+1;
        int greenC = (green*n)%k==0?(green*n)/k:(green*n)/k+1;
        int blueC = (blue*n)%k==0?(blue*n)/k:(blue*n)/k+1;
        System.out.println(redC+greenC+blueC);

    }
}
