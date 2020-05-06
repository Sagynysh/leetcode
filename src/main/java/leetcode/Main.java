package leetcode;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!)");
//        System.out.println(Math.pow(2,31));
//        System.out.println(longestCommonPrefix(new String[]{}));
//        System.out.println(isValid(")"));
//        System.out.println(removeElement(new int[]{03,2,2,3},3));
//        System.out.println(strStr("hello", "ol"));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
//        System.out.println(firstBadVersion(2126753390));
//        System.out.println(1/2);
//        System.out.println(countAndSay(20));
//        System.out.println(lengthOfLastWord("Wß World "));
//        System.out.println(Arrays.toString(plusOne(new int[] {8,9,9,9})));
//        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
//                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
//        System.out.println(mySqrt(9));
//        System.out.println(climbStairs(6));
//        System.out.println(getRow(4));
//        System.out.println(numJewelsInStones("bce","eea"));
//        System.out.println(toLowerCase("LOVELY"));
//        System.out.println(buddyStrings("ab","ba"));
//        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1,2,5,6})));
//        System.out.println(hammingDistance(1,                4));
//        System.out.println(flipAndInvertImage(new int [] [] {{1,1,0},{1,0,1},{0,0,0}}));
//        moveZeroes(new int [] {0,0,0,0,1});
//        System.out.println(majorityElement(new int [] {6,6,6,7,7}));
//        System.out.println(maximumProduct(new int []{-4,-3,-2,-1,60}));

//        System.out.println(singleNumber(new int []{4,1,2,1,2}));
//        System.out.println(reverseVowels("aA"));
//        System.out.println((int)'a' +" "+(int)'z' +" "+ (int)'A'+" "+(int)'Z');
//        System.out.println((int) '0' +" "+(int)'9');
//        System.out.println(isPalindrome("0pP0"));
//        rotate(new int[]{1,2,3,4,5},3);
//        System.out.println(reverseStr("abcdefg",2));
//        System.out.println(reverseWords("Let's take LeetCode contest"));
//        System.out.println(countPrimes(499979));
//        System.out.println(smallestRangeI(new int[]{1,3,6},3));
//        System.out.println(Arrays.toString(shortestToChar("aaba",'b')));
//        System.out.println(isToeplitzMatrix(new int[][]{{41,45},{81,41},{73,81},{47,73},{76,47},{79,76}}));
//
//        System.out.println(binaryGap(55));
//        System.out.println(arrayPairSum(new int[]{1,4,3,2}));
//        System.out.println(selfDividingNumbers(1,22));
//        System.out.println(peakIndexInMountainArray(new int[]{0,1,2,0}));
//        System.out.println(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6}));
//        System.out.println(fib(6));
//        System.out.println(findShortestSubArray(new int[]{1, 2}));
//        System.out.println(search(new int[]{-1,0,3,5,9,12},9));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length==0 || strs==null)
            return result;
        for(int j=0;j<strs[0].length();j++){
            String ch=strs[0].substring(j,j+1);
            for(int i=1;i<strs.length;i++){
                if(j>=strs[i].length() || !strs[i].substring(j,j+1).equals(ch)){
                    return result;
                }
            }
            result+=ch;
        }
        return result;
    }

    public static boolean isValid(String s) {
        Stack<String> stackPrnts = new Stack<String>();
        Map<String,String> prntsPair = new HashMap<String, String>();
        prntsPair.put("{","}");
        prntsPair.put("(",")");
        prntsPair.put("[","]");
        for (int i=0;i<s.length();i++){
            if(s.substring(i,i+1).equals("(") || s.substring(i,i+1).equals("[") || s.substring(i,i+1).equals("{")){
                stackPrnts.push(s.substring(i,i+1));
            }else{
                if(stackPrnts.size()!=0 && prntsPair.get(stackPrnts.peek()).equals(s.substring(i,i+1))){
                    stackPrnts.pop();
                }else {
                    return false;
                }
            }
        }
        if(stackPrnts.size()!=0){
            return false;
        }else{
            return true;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length==0 || nums==null)
            return 0;
        int k = nums[0];
        int lengthCounter = 1;

        for(int i=1;i<nums.length;i++){
            if(k!=nums[i]){
                nums[lengthCounter]=nums[i];
                lengthCounter++;
                k=nums[i];
            }
        }
        return lengthCounter;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n=nums.length;
        while(i<n){
             if(nums[i]==val){
                 nums[i]=nums[n-1];
                 n--;

             }else{
                 i++;
             }
        }
        return i;
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()==0)return 0;
        if(haystack.length()<needle.length())
            return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            System.out.println(haystack.substring(i,i+needle.length()));
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                return i;
            }
            if(nums[i]==target){
                return i;
            }
        }
        return nums.length;

    }

    public static int firstBadVersion(int n) {
        int flag = 0;
        if(n==1)return 1;
        int k=n/2;
        while(k>=1){
            System.out.println(k +" "+flag);
            if(isBadVersion(k)){
                if(flag+1==k){
                    return k;
                }
                k=k/2;
            }else{
                if(k+1==n){
                    return n;
                }
                flag=k;
                k=(k+n)/2;
            }
            System.out.println(k +" "+flag);
        }
        return n;
    }

    public static boolean isBadVersion(int n) {
        if(n>=1702766719)
            return true;
        else
            return false;

    }

    public static String countAndSay(int n) {
        String text = "1";
        if(n==1)return text;
        for(int i=1;i<n;i++){
            char ch = text.charAt(text.length()-1);
            int counter=0;
            String result = "";
            for(int j=text.length()-1;j>=0;j--){
//                System.out.println(text.charAt(j)+"  "+ch +"-->");
                if(text.charAt(j)==ch){
                    counter++;
                }else {
                    result=counter+""+ch+result;
                    counter=1;
                    ch=text.charAt(j);
                }
//                System.out.println(counter+"--"+ch+"---"+result);
            }
            if(counter!=0)
                result=counter+""+ch+result;
//            System.out.println("Result "+result);
            text=result;
        }

        return text;

    }

    public static int lengthOfLastWord(String s) {
        int counter = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                counter++;
            }else if(counter!=0){
                return counter;
            }
        }

        return counter;


    }

    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
                if(i==0){
                    int[] newDigit = new int[digits.length+1];
                    newDigit[0]=1;
                    System.arraycopy(digits,0,newDigit,1,digits.length);
                    return newDigit;
                }
            }else{
                digits[i]++;
                return digits;
            }
        }
        return digits;

    }

    public static String addBinary(String a, String b) {
        java.math.BigInteger res = new java.math.BigInteger(a,2).add(new java.math.BigInteger(b,2));
        return  res.toString(2);
    }

    public static int mySqrt(int x) {
        return (int)Math.sqrt(x);

    }

    public static int climbStairs(int n) {
        int res = 0;
        for(int i=(n+1)/2;i<=n;i++){
            int two = n-i;
            int one = n-two*2;
//            System.out.println(two+"*2+"+one+"=="+n);
            java.math.BigInteger tempRes = new java.math.BigInteger("1");
            java.math.BigInteger tempDown = new java.math.BigInteger("1");
            if(two>one){
                for(int j=1;j<=i;j++){
                    if(j<=one){
                        tempDown=tempDown.multiply(new java.math.BigInteger(j+""));
                    }
                    if(j>two){
                        tempRes=tempRes.multiply(new java.math.BigInteger(j+""));
                    }

                }
            }else{
                for(int j=1;j<=i;j++){
                    if(j<=one){
                        tempDown=tempDown.multiply(new java.math.BigInteger(j+""));
                    }
                    if(j>two){
                        tempRes=tempRes.multiply(new java.math.BigInteger(j+""));
                    }

                }
            }
//            System.out.println(i + " --  tempRes = " +tempRes + " /tempDown = "+tempDown+ " == "+tempRes/tempDown);
            res+=tempRes.divide(tempDown).intValue();

        }
        return res;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> column = new ArrayList<List<Integer>>();
        if(numRows==0){
            return column;
        }
        column.add(new ArrayList<Integer>());
        column.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> rowPrev = column.get(i-1);
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(rowPrev.get(j-1)+rowPrev.get(j));
            }
            row.add(1);
            column.add(row);
        }
        return column;

    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(0,1);
        if(rowIndex==0){
            return row;
        }
        for(int i=1;i<=rowIndex;i++){
            List<Integer> rowPrev = new ArrayList<Integer>(row);
            System.out.println(rowPrev.toString());
            for(int j=1;j<i;j++){
                System.out.println(rowPrev.get(j-1)+" -- "+rowPrev.get(j)+" == "+rowPrev.toString()+" - "+row.toString());
                row.set(j,rowPrev.get(j-1)+rowPrev.get(j));
            }
            row.add(1);
        }
        return row;
    }

//    public static int singleNumber(int[] nums) {
//
//
//    }
    public static int numJewelsInStones(String J, String S) {
        int c = 0;
        for(int i=0;i<S.length();i++){
            for(int j=0;j<J.length();j++){
                if(S.charAt(i)==J.charAt(j)){
                    c++;
                    continue;
                }

            }
        }
        return c;

    }

    public static String toLowerCase(String str) {
        String res = "";
        for(int i=0;i<str.length();i++){
            if((int)str.charAt(i)>64 && (int)str.charAt(i)<91){
                res+=(char)(((int)str.charAt(i))+32);

            }else{
                res+=str.charAt(i)+"";
            }
        }
        return res;

    }

    public static boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(B.length()-i-1))
                return false;
        }
        return true;
    }
    public static int[] sortArrayByParity(int[] A) {
        int k=A.length-1;
        int m=0;
        while(k>m){
            if(A[k]%2==0){
                if(A[m]%2!=0){
                    A[k]=A[k]+A[m];
                    A[m] = A[k]-A[m];
                    A[k]=A[k]-A[m];
                    k--;
                }else{
                    m++;
                }
            }else{
                k--;
            }
        }
        return A;
    }

    public static int hammingDistance(int x, int y) {
        StringBuffer a = new StringBuffer(Integer.toString(x,2));
        StringBuffer b = new StringBuffer(Integer.toString(y,2));
        System.out.println(a+"--"+b);
        if(a.length()>b.length()){
            int count = a.length()-b.length();
            for(int i=0;i<count;i++){
                b.insert(0,0);
            }
        }else if(a.length()<b.length()){
            int count = b.length()-a.length();
            for(int i=0;i<count;i++){
                a.insert(0,0);
            }
        }
        System.out.println(a+"--"+b);
        int c=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                c++;
            }
        }
        return c;
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            int [] curr = new int[A.length];
            for(int j=0;j<A.length;j++){
                if(A[i][j]==0){
                    curr[A.length-j-1] = 1;
                }else{
                    curr[A.length-j-1] = 0;
                }
            }
            A[i]=curr;
        }
        return A;

    }

    public static void moveZeroes(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
        }
        for(int i=k;i<nums.length;i++){
            nums[i]=0;
        }

    }

    public static int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int curr = (nums.length+1)/2;
        Arrays.sort(nums);
        int k=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                k++;
            }else {
                k++;
                if(k>=curr){
                    return nums[i];
                }
                k=0;
            }
        }
        return nums[nums.length-2];

    }

    public static int maximumProduct(int[] nums) {
        if(nums.length==3){
            return  nums[0]*nums[1]*nums[2];
        }
        Arrays.sort(nums);
        if(nums[0]<0 && nums[1]<0 && nums[nums.length-1]>0){
            return (nums[0]*nums[1]*nums[nums.length-1]>nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1])?nums[0]*nums[1]*nums[nums.length-1]:nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1] ;
        }
        if(nums[nums.length-1]<0){
            return nums[0]*nums[1]*nums[2];
        }
        return nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1];
    }

    public static String reverseString(String s) {
        StringBuffer buf =new StringBuffer(s);
        return buf.reverse().toString();

    }
    public static int findComplement(int num) {
        StringBuffer res = new StringBuffer(Integer.toString(num,2));
        for(int i=0;i<res.length();i++){
            if(res.charAt(i)=='0'){
                res.setCharAt(i,'1');
            }else{
                res.setCharAt(i,'0');
            }
        }
        return Integer.parseInt(res.toString(),2);

    }

    public static TreeNode searchBST(TreeNode root, int val) {
        while(true){
            if(root.val==val)return root;
            else if(root.val<val){
                if(root.right==null)return null;
                root = root.right;
            }else{
                if(root.left==null)return null;
                root = root.left;
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> numArray = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(numArray.containsKey(nums[i])){
                if(target==nums[i]*2){
//                        System.out.println(numArray.get(nums[i])+ " " + i);
                    return new int[]{numArray.get(nums[i]),i};
                }
            }else{
                numArray.put(nums[i],i);
            }

            if(numArray.containsKey(target-nums[i]) && numArray.get(target-nums[i])!=numArray.get(nums[i])){
//                    System.out.println(numArray.get(target-nums[i])+ " " + numArray.get(nums[i]));
                return new int[]{numArray.get(target-nums[i]),numArray.get(nums[i])};
            }

        }
        return null;
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> couple = new HashSet<Integer>();
        couple.add(nums[0]);
        for (int i=1;i<nums.length;i++){
            if(couple.contains(nums[i])){
                couple.remove(nums[i]);
            }else{
                couple.add(nums[i]);
            }
        }
        Iterator it = couple.iterator();
        return (Integer) it.next();

    }

    public static String reverseVowels(String s) {
        Set<String> vowel = new HashSet<String>();
        vowel.add("a");
        vowel.add("e");
        vowel.add("i");
        vowel.add("o");
        vowel.add("u");
        vowel.add("A");
        vowel.add("E");
        vowel.add("I");
        vowel.add("O");
        vowel.add("U");
        StringBuffer reverse = new StringBuffer("");
        StringBuffer result = new StringBuffer(s);
        for(int i=0;i<result.length();i++){
            if(vowel.contains(result.charAt(i)+"")){
                reverse.append(result.charAt(i));
            }
        }
        reverse.reverse();
        System.out.println(reverse);
        for(int i=0;i<result.length();i++){
            if(vowel.contains(result.charAt(i)+"")){
                result.setCharAt(i,reverse.charAt(0));
                reverse.delete(0,1);
            }
        }
        return result.toString();
    }

    public static boolean isPalindrome(String s) {
        StringBuffer res = new StringBuffer("");
        for(int i=0;i<s.length();i++){
            if(((int)s.charAt(i)>64 && (int)s.charAt(i)<91) || ((int)s.charAt(i)>96 && (int)s.charAt(i)<123) || ((int)s.charAt(i)>47 && (int)s.charAt(i)<58)){
                res.append(s.charAt(i));
            }
        }
        System.out.println(res);
        System.out.println(res.reverse());
        if(res.toString().toLowerCase().equals(res.reverse().toString().toLowerCase())){
            return true;
        }else{
            return false;
        }
    }

    public static void rotate(int[] nums, int k) {
//        for(int i=0;i<k;i++){
            int prev = 0; int next = nums[0];
            for(int j=0;j<nums.length;j++){
                prev = next;
                next = nums[(j+k)%nums.length];
                nums[(j+k)%nums.length] = prev;
            }
            System.out.println(Arrays.toString(nums));
//        }

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<Integer>();
        for (int i=0;i<nums.length;i++){
            if(!res.contains(nums[i])){
                res.add(nums[i]);
            }
            else{
                return true;
            }
        }
        return false;

    }

    public static String reverseStr(String s, int k) {
        StringBuffer cur = new StringBuffer(s);
        StringBuffer res = new StringBuffer("");
        for(int i=0;i<s.length()/k;i++){
            if(i%2==0){
                res.append(new StringBuffer(cur.substring(i*k,i*k+k)).reverse());
            }else{
                res.append(cur.substring(i*k,i*k+k));
            }
        }
        if(s.length()-s.length()/k>0){
            if((s.length()/k)%2==0){
                res.append(new StringBuffer(cur.substring(s.length()-s.length()%k)).reverse());
            }else{
                res.append(new StringBuffer(cur.substring(s.length()-s.length()%k)));
            }
        }
        return res.toString();

    }


    public static String reverseWords(String s) {
        StringBuffer res = new StringBuffer("");
        String [] words = s.split(" ");
        for(int i=0;i<words.length;i++){
            if(i!=words.length-1){
                res.append(new StringBuffer(words[i]).reverse()).append(" ");
            }else{
                res.append(new StringBuffer(words[i]).reverse());
            }
        }

        return res.toString();
    }

    public static  boolean isIsomorphic(String s, String t) {
        StringBuffer res = new StringBuffer("");
        return false;
    }

    public static int countPrimes(int n) {
        boolean [] isPrime = new boolean[n];
        if(n<=1){
            return 0;
        }
        for(int i=2;i<n;i++){
            isPrime[i]=true;
        }
        for(int i=2;i*i<=n;i++){
            if(!isPrime[i]) continue;
            for(int j=i*i;j<n;j+=i){
                isPrime[j]=false;
            }
        }
        int counter = 0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                counter++;
            }
        }
        return counter;

    }

    public static int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int diff = (A[A.length-1]-A[0])-2*K;
        if(diff>0){
            return diff;

        }else{
            return 0;
        }

    }

    public static int[][] transpose(int[][] A) {
        int [][] B = new int[A[0].length][A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                B[j][i] = A[i][j];
            }
        }
        return B;

    }

    public static ListNode middleNode(ListNode head) {
        ListNode curr = head;
        int counter = 1;
        while(curr.next!=null){
            curr = curr.next;
            counter++;
        }
        curr = head;
        if(counter%2==0){
            for(int i=0;i<counter/2+1;i++){
                curr = curr.next;
            }
            return curr;

        }else{
            for(int i=0;i<counter/2;i++){
                curr = curr.next;
            }
            return curr;
        }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static int numSpecialEquivGroups(String[] A) {
        HashMap<String, Integer> pair = new HashMap<String,Integer>();
        for(int i=0;i<A.length;i++){
            if(pair.containsKey(A[i])){
                pair.put(A[i],pair.get(A[i]));
            }else{
                pair.put(A[i],1);
            }
        }
        return 0;
    }
    public static int maxDepth(Node root) {
        int counter = 1;
        if(root==null) return 0;
        return insideNode(root,counter);
    }

    private static int insideNode(Node root, int k){
        k++;
        int c = 0;
        for(int i=0;i<root.children.size();i++){
            int cc = insideNode(root.children.get(i),k);
            System.out.println("Depth C "+c+ "  k "+k);
            if(c<cc){
                c=cc;
            }
        }
        if(k<c){
            k=c;
        }
        return k;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(leafSimilar(root1).equals(leafSimilar(root2))){
            return true;
        }else{
            return false;
        }


    }

    private static StringBuffer leafSimilar(TreeNode root){
        StringBuffer res = new StringBuffer("");
        if(root.left!=null){
            res.append(leafSimilar(root.left));
        }
        if(root.right!=null){
            res.append(leafSimilar(root.right));
        }
        if(root.right==null && root.left==null){
            res.append(root.val);
        }
        return res;
    }

    public static int[] shortestToChar(String S, char C) {
        StringBuffer res = new StringBuffer(S);
        int[] resArr = new int[res.length()];
        int r = res.indexOf(C+"");
        int l = 0-r;
        for(int i=0;i<res.length();i++){
            if(r<=i){
                l=r;
                r=res.indexOf(C+"",i);
                if(r<0){
                    r=Integer.MAX_VALUE;
                }
            }
            System.out.println("L "+l+ " R "+r);
            System.out.println((r-i)+"   " +(i-l));

            if((r-i)>=(i-l)){
                resArr[i] = i-l;
            }else{
                resArr[i] = r-i;
            }
        }
        return resArr;
    }

    public static List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(root.val);
        int i=0;
        while(true){
            Node curr = root;
            if(curr.children!=null && i<curr.children.size()){
                res.add(curr.children.get(i).val);

            }



        }

    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length==1 || matrix[0].length==1){
            return true;
        }
        for(int i=0;i<matrix[0].length;i++){
            int c = -1;
            int cc = -1;
            for(int j=0;j<matrix.length;j++){
//                System.out.print(" "+(j+i));
                if((j+i)>=matrix[0].length){
                    if((j+i)%matrix[0].length==0){
                        cc=-1;
                    }
                    if(cc!=-1){
                        if(cc!=matrix[j][(j+i)%matrix[0].length]){
                            return false;
                        }
                    }else{
                        cc = matrix[j][(j+i)%matrix[0].length];
                    }
                }else{
                    if(c!=-1){
                        if(c!=matrix[j][j+i]){
                            return false;
                        }
                    }else{
                        c = matrix[j][j+i];

                    }
                }
                System.out.print(c+">>" +cc+" ");
            }
            System.out.println();
        }
        return true;
    }

    public static String[] findWords(String[] words) {
        StringBuffer firstRow = new StringBuffer("qwertyuiop");
        StringBuffer secondRow = new StringBuffer("asdfghjkl");
        StringBuffer thrirdRow = new StringBuffer("zxcvbnm");
        for(int i=0;i<words.length;i++){
            StringBuffer res = new StringBuffer(words[i]);

        }
        return new String[]{""};

    }


    public static int binaryGap(int N) {
        int last = -1; int res = 0;
        for(int i=0;i<32;i++){
            System.out.println("I : "+i+" N : "+N);
            System.out.println(N>>i);
            if(((N>>i)&1) > 0){
                if (last >= 0)
                    res = Math.max(res, i - last);
                last = i;
            }
        }
        return res;

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i<nums.length;i+=2){
            res+=Math.min(nums[i],nums[i+1]);
        }
        return res;

    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            if(selfDivide(i)){
                res.add(i);
            }
        }
        return res;

    }
    public static boolean selfDivide(int num){
        int curr=num;
        int i=curr%10;
        while(curr>=1){
            if(i==0)return false;
            if(num%i!=0){
                return false;
            }
            curr=curr/10;
            i=curr%10;
        }
        return true;
    }

    public static int peakIndexInMountainArray(int[] A) {
        int curr=0;
        for(int i=1;i<A.length;i++){
            if(A[i]>A[curr])
                curr=i;
        }
        return curr;
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] res = new int[arr1.length];
        int c=0;
        Arrays.sort(arr1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<arr2.length;i++){
            arrayList.add(arr2[i]);
            for(int j=0;j<arr1.length;j++){
                if(arr2[i] == arr1[j]){
                    res[c] = arr2[i];
                    c++;
                }
            }
        }

        for(int j=0;j<arr1.length;j++){
            if(!arrayList.contains(arr1[j])){
                res[c] = arr1[j];
                c++;
            }
        }
        
        for(int j=0;j<arr1.length;j++){
            System.out.print(res[j]+" ");
        }
        return res;
    }
    public static int fib(int N) {
        if(N ==0){
            return 0;
        }else if(N ==1){
            return 1;
        }
        int[] fibArray = new int[N+1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for(int i=2;i<=N;i++){
            fibArray[i] = fibArray[i-1]+fibArray[i-2];
        }
        return fibArray[N];
    }
    public static int numRookCaptures(char[][] board) {
        int rx = 0;
        int ry = 0;
        int res = 0;
        for(int j=0;j<board.length;j++){
            for(int i=0;i<board.length;i++){
                if(board[j][i] == 'R'){
                    rx = j;
                    ry = i;
                    break;
                }
            }
        }
        int tmpRx = rx;
        int tmpRy = ry;
        while(tmpRx>=0){
            if(board[tmpRx][ry] == 'p'){
                tmpRx = rx;
                break;
            }else if(board[tmpRx][ry] == 'B'){
                res++;
                tmpRx = rx;

                break;
            }
            tmpRx--;
        }
        while(tmpRx<8){
            if(board[tmpRx][ry] == 'p'){
                break;
            }else if(board[tmpRx][ry] == 'B'){
                res++;
                break;
            }
            tmpRx++;
        }

        while(tmpRy>=0){
            if(board[rx][tmpRy] == 'p'){
                tmpRy = ry;
                break;
            }else if(board[rx][tmpRy] == 'B'){
                res++;
                tmpRy = ry;
                break;
            }
            tmpRy--;
        }
        while(tmpRy<8){
            if(board[rx][tmpRy] == 'p'){
                break;
            }else if(board[rx][tmpRy] == 'B'){
                res++;
                break;
            }
            tmpRy++;
        }
        return res;
    }

    public static int findShortestSubArray(int[] nums) {
        if(nums.length == 1) return 1;
        HashMap<Integer, int[]> numMap = new HashMap<>();
        int res = 1;
        for(int i=0;i<nums.length;i++){
            if(numMap.get(nums[i])!=null){
                numMap.get(nums[i])[0]++;
                numMap.get(nums[i])[2]=i;
                if(numMap.get(nums[i])[0]>res){
                    res = numMap.get(nums[i])[0];
                }
            }else{
                numMap.put(nums[i],new int[]{1,i,i});
            }
            System.out.println(nums[i]+" - "+numMap.get(nums[i])[1]+" - "+numMap.get(nums[i])[2]);
        }
        int c = 500001;
        for(int i:numMap.keySet()){
            if(numMap.get(i)[0] == res){
                if(numMap.get(i)[2] - numMap.get(i)[1] < c){
                    System.out.println(i+" "+numMap.get(i)[1]+" "+numMap.get(i)[2]);
                    c = numMap.get(i)[2] - numMap.get(i)[1];
                }
            }
        }
        return c+1;

    }

    public static int maxDepth(TreeNode root) {
        int res = 1;
        HashMap<TreeNode,TreeNode> treeNodes = new HashMap();
        treeNodes.put(root,root);
        TreeNode tmpNode = root;
        int i=1;
        while(true){

            if(treeNodes.containsKey(tmpNode.left) && tmpNode.right==null) {
                if (treeNodes.get(tmpNode).equals(tmpNode)) {
                    return res;
                } else {
                    i--;
                    tmpNode = treeNodes.get(tmpNode);
                }
            }else if(treeNodes.containsKey(tmpNode.right) && tmpNode.left==null) {
                if (treeNodes.get(tmpNode).equals(tmpNode)) {
                    return res;
                } else {
                    i--;
                    tmpNode = treeNodes.get(tmpNode);
                }
            }else if(treeNodes.containsKey(tmpNode.left) && treeNodes.containsKey(tmpNode.right)){
                if (treeNodes.get(tmpNode).equals(tmpNode)) {
                    return res;
                } else {
                    i--;
                    tmpNode = treeNodes.get(tmpNode);
                }
            }

            if(tmpNode.left!=null && !treeNodes.containsKey(tmpNode.left)){
                treeNodes.put(tmpNode.left,tmpNode);
                tmpNode = tmpNode.left;
                i++;
            }else if(tmpNode.right!=null && !treeNodes.containsKey(tmpNode.right)){
                treeNodes.put(tmpNode.right,tmpNode);
                tmpNode = tmpNode.right;
                i++;
            }else if(tmpNode.left == null && tmpNode.right == null){
                if(i>res){
                    res = i;
                }
                i--;
                if (treeNodes.get(tmpNode).equals(tmpNode)) {
                    return res;
                }
                tmpNode = treeNodes.get(tmpNode);
            }
        }
    }

    public static int maxDepthRecursion(TreeNode root) {
        if(root==null) return 0;
        int left = maxDepthRecursion(root.left);
        int right = maxDepthRecursion(root.right);
        return Math.max(left,right)+1;
    }

    public static int tribonacci(int n) {
        if(n==0)return 0;
        if(n<3) return 1;
        int [] tribArray = new int[n+1];
        tribArray[0] = 0;
        tribArray[1] = 1;
        tribArray[2] = 1;
        for(int i=3;i<=n;i++){
            tribArray[i] = tribArray[i-3]+tribArray[i-2]+tribArray[i-1];
        }
        return tribArray[n];
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        HashMap<Integer,Long[]> level = new HashMap<>();
        fillLevels(level,0,root);
        for(int i:level.keySet()){
            result.add(level.get(i)[0]/Double.parseDouble(level.get(i)[1]+""));
        }
        return result;
    }
    public static void fillLevels(HashMap<Integer,Long[]> map, int i, TreeNode root){
        if(root == null) return;
        if(!map.containsKey(i)){
            map.put(i,new Long[]{Long.valueOf(root.val),1L});
        }else {
            map.get(i)[0]+=root.val;
            map.get(i)[1]+=1;
        }
        i++;
        fillLevels(map,i,root.left);
        fillLevels(map,i,root.right);
        i--;
    }

    public static boolean isMonotonic(int[] A) {
        if(A.length == 1) return true;
        int c = 0;
        for(int i=0;i<A.length-1;i++){
            if(A[i]-A[i+1]>0 && c == 0){
                c = -1;
            }else if(A[i]-A[i+1]<0 && c == 0){
                c = 1;
            }
            if(c<0 && A[i]-A[i+1]<0){
                return false;
            }else if(c>0 && A[i]-A[i+1]>0){
                return false;
            }
        }
        return true;

    }

    public static int maxAncestorDiff(TreeNode root) {

        return 0;
    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int [] result = new int[queries.length];
        int c = 0;
        for(int k:A){
            if(k%2==0){
                c+=k;
            }
        }

        for(int i=0;i<queries.length;i++){
            if(A[queries[i][1]]%2==0){
                if(queries[i][0]%2==0){
                    c+=queries[i][0];
                }else{
                    c-=A[queries[i][1]];
                }
            }else{
                if(queries[i][0]%2!=0){
                    c+=(queries[i][0]+A[queries[i][1]]);
                }
            }
            A[queries[i][1]] +=queries[i][0];
            result[i] = c;
        }
        return result;
    }

    public static int minDiffInBST(TreeNode root) {
        int c = 100;
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        parents.put(root,root);
        TreeNode tmp = root;
        ArrayList<Integer> numberArray = new ArrayList<>();
        numberArray.add(tmp.val);
        while(true){
            if(parents.containsKey(tmp.left) && tmp.right==null) {
                if (parents.get(tmp).equals(tmp)) {
                    break;
                } else {
                    tmp = parents.get(tmp);
                }
            }else if(parents.containsKey(tmp.right) && tmp.left==null) {
                if (parents.get(tmp).equals(tmp)) {
                    break;
                } else {
                    tmp = parents.get(tmp);
                }
            }else if(parents.containsKey(tmp.left) && parents.containsKey(tmp.right)){
                if (parents.get(tmp).equals(tmp)) {
                    break;
                } else {
                    tmp = parents.get(tmp);
                }
            }

            if(tmp.left!=null && !parents.containsKey(tmp.left)){
                parents.put(tmp.left,tmp);
                tmp = tmp.left;
                numberArray.add(tmp.val);
            }else if(tmp.right!=null && !parents.containsKey(tmp.right)){
                parents.put(tmp.right,tmp);
                tmp = tmp.right;
                numberArray.add(tmp.val);
            }else if(tmp.left == null && tmp.right == null){
                if (parents.get(tmp).equals(tmp)) {
                    break;
                }
                tmp = parents.get(tmp);
            }
        }
        for (int i=0;i<numberArray.size();i++){
            for(int j=0;j<numberArray.size();j++){
                if(i!=j && Math.abs(numberArray.get(i)-numberArray.get(j))<c){
                    c = Math.abs(numberArray.get(i)-numberArray.get(j));
                }
            }
        }
        return c;
    }

    public static int search(int[] nums, int target) {
        int medium = nums.length/2;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            System.out.println(l+" "+medium+" "+r);
            if( nums[medium]==target){
                return medium;
            }else if(nums[medium]>target){
                r = medium-1;
            }else{
                l = medium+1;
            }
            medium = (l+r)/2;
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        int inc = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            TreeNode node = recKthSmallest(root,inc);
            inc = node.val;
            node.val = Integer.MAX_VALUE;
        }
        return inc;

    }
    public TreeNode recKthSmallest(TreeNode root, int min){
        if(root == null) return null;
        TreeNode l = recKthSmallest(root.left,min);
        l = (l == null) ? root : (root.val>l.val) ? l : root;
        TreeNode r = recKthSmallest(root.right,min);
        r = (r == null) ? root : (root.val>r.val) ? r : root;
        System.out.println(l.val+" "+r.val);
        if(r.val>l.val){
            return l;
        }else{
            return r;
        }
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int charLetter[] = new int[26];
        for(int i=0;i<magazine.length();i++)
        {
            charLetter[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(charLetter[ransomNote.charAt(i)-'a']==0){
                return false;
            }
            charLetter[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int [] top = new int[grid[0].length];
        int [] left = new int[grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                left[i] = Math.max(grid[i][j],left[i]);
            }
        }

        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                top[i] = Math.max(grid[j][i],top[i]);
            }
        }
        int counter = 0;
        int [][] newGrid = new int[grid.length][grid[0].length];

        for(int i=0;i<left.length;i++){
            for(int j=0;j<top.length;j++){
                newGrid[i][j] = Math.min(left[i],top[j]);
                counter+= newGrid[i][j] - grid[i][j];
            }
        }
        return counter;

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val<val){
            TreeNode tmp = insertIntoBST(root.right,val);
            if(tmp == null){
                root.right = new TreeNode(val);
            }
            return root;

        }else{
            TreeNode tmp = insertIntoBST(root.left,val);
            if(tmp == null){
                root.left = new TreeNode(val);
            }
            return root;
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            boolean thisNumber = false;
            for(int j=0;j<nums2.length;j++){
                if(thisNumber && nums2[j]>nums1[i] && res[i] == 0){
                    res[i] = nums2[j];
                }
                if(nums2[j] == nums1[i]){
                    thisNumber = true;
                }
            }
            if(res[i]==0)
                res[i] = -1;
        }
        return res;
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int minDistanceRight = 0;
        int minDistanceLeft = 0;
        int st = start;
        int dest = destination;
        if(start>destination){
            st = dest;
            dest = st;
        }
        for(int i = st;i<dest;i++){
            minDistanceRight+=distance[i];
        }
        int i = dest;
        while(i!=st){
            minDistanceLeft+=distance[i];
            i=(i+=1)%distance.length;
        }
        return (minDistanceLeft<minDistanceRight) ? minDistanceLeft : minDistanceRight;

    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> tmp = new Stack<>();
        tmp.push(head);
        while (head.next!=null){
            head = head.next;
            tmp.push(head);
        }
        System.out.println(tmp);
        ListNode res = tmp.pop();
        System.out.println(res.val);
        ListNode tmpNode = res;
        while(!tmp.isEmpty()){
            System.out.println(tmpNode.val);
            tmpNode.next = tmp.pop();
            tmpNode = tmpNode.next;
        }
        return res;
    }

    public int twoCitySchedCost(int[][] costs) {
        int result = 0;
        int[] maxNumbers = new int[costs.length];
        for(int i =0;i<costs.length;i++){
            maxNumbers[i] = Math.max(costs[i][0],costs[i][1]);
        }
        Arrays.sort(maxNumbers);
        int a = 0;
        int b = 0;
        boolean [] entered = new boolean[maxNumbers.length];
        for(int j =0;j<maxNumbers.length/2;j++){
            for(int i = 0; i<costs.length;i++){
                if(maxNumbers[maxNumbers.length-1-j] == costs[i][0]){
                    result+=costs[i][1];
                    b++;
                    entered[i] = true;
                    break;
                }else if(maxNumbers[maxNumbers.length-1-j] == costs[i][1]){
                    result+=costs[i][0];
                    a++;
                    entered[i] = true;
                    break;
                }
            }
        }

        for(int i =0;i<costs.length;i++){

            if(!entered[i]){
                if(Math.min(costs[i][0],costs[i][1]) == costs[i][0]){
                    if(a<maxNumbers.length/2){
                        a++;
                        result+=costs[i][0];
                    }else{
                        result+=costs[i][1];
                        b++;
                    }

                }else{
                    if(b<maxNumbers.length/2){
                        b++;
                        result+=costs[i][1];
                    }else{
                        result+=costs[i][0];
                        a++;
                    }

                }
            }

        }
        return result;

    }

    public void deleteNode(ListNode node) {
        if(node.next == null){
            return;
        }
        node.val = node.next.val;
        if(node.next.next == null){
            node.next = null;
        }else{
            deleteNode(node.next);
        }
    }
    public boolean canWinNim(int n) {
        if(n%4 ==0){
            return false;
        }else{
            return true;
        }
    }


    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }

}

