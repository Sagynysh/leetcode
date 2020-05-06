import scala.Int;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class randomSample {
    public static void main(String[] args) {
//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(findComplement(5));


    }

    public static int findComplement(int num) {
        StringBuffer bin = new StringBuffer(Integer.toBinaryString(num));
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i) == '0'){
                bin.replace(i,i+1,"1");
            }else{
                bin.replace(i,i+1,"0");
            }
        }
        return Integer.parseInt(bin.toString(),2);
    }

    public static int removeDuplicates(int[] nums) {
        int res = 0;
        int r = nums.length;
        if(res == r){
            return  res;
        }
        for(int i=1;i<r;i++){
            if(nums[res] != nums[i]){
                res++;
                nums[res] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return res+1;
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (grid[i][j] == '1' && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(grid, i, j, visited);
                    ++count;
                }

        return count;
    }

    void DFS(char M[][], int row, int col, boolean visited[][])
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] { -1, 0, 0, 1 };
        int colNbr[] = new int[] {  0, -1, 1, 0};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 4; k++)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    boolean isSafe(char M[][], int row, int col,
                   boolean visited[][])
    {
        return (row >= 0) && (row < M.length) && (col >= 0) && (col < M[0].length) && (M[row][col] == '1' && !visited[row][col]);
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode res = head;
        ListNode res2 = head.next;
        ListNode sec = res2;
        while(head.next!=null || sec.next!=null){
            if(head.next.next == null){
                head.next = null;
            }else{
                head.next = head.next.next;
                head = head.next;
            }
            System.out.println(sec.val);
            if(sec.next.next == null){
                sec.next = null;
            }else{
                sec.next = sec.next.next;
                sec = sec.next;
            }
        }
        head.next = res2;
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        result.add(Arrays.asList(root.val));
        while (!stack.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int n = stack.size();
            for(int i=0;i<n;i++){
                root = stack.poll();
                if(root.left!=null){
                    stack.add(root.left);
                    tmp.add(root.left.val);
                }
                if(root.right!=null){
                    stack.add(root.right);
                    tmp.add(root.right.val);
                }
            }

            if(tmp.size()!=0){
                result.add(tmp);
            }
        }
        return result;
    }


    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int kthSmallest(int[][] matrix, int k) {
        int [] res = new int[matrix.length*matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                res[matrix.length*i+j] = matrix[i][j];
                System.out.println(matrix.length*i+j+" "+matrix[i][j]);
            }
        }
        Arrays.sort(res);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
        return res[k-1];
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])){
                return nums[i];
            }
            s.add(nums[i]);

        }
        return 0;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }


    }

    public int[] productExceptSelf(int[] nums) {
        int[]res = new int[nums.length];
        res[0] = 1;
        for(int i=1;i<nums.length;i++){
            res[i] = nums[i-1]*res[i-1];
        }
        int R = 1;
        for(int i = nums.length-1;i>0;i--){
            res[i-1] = res[i-1]*nums[i-1]*R;
            R = nums[i-1]*R;
        }
        return res;
    }

    public boolean isHappy(int n) {
        StringBuilder r = new StringBuilder(n);
        while (!r.toString().equals("1")){
            int c = 0;
            for(int i=0;i<r.length();i++){
                c+=Math.pow(Double.parseDouble(r.charAt(i)+""),2);
            }
            r = new StringBuilder(c);
        }

        int k = n/10;
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode l = root;
        int r = root.val;
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        while(l!=null || leftStack.size()!=0 || l.val!=r){
            while(l!=null){
                leftStack.push(l);
                l = l.left;
                if(root == null){
                    return false;
                }
                rightStack.push(root);
                root = root.right;
            }
            if(root !=null){
                return false;
            }
            l = leftStack.pop();
            root = rightStack.pop();
            if(l.val != root.val){
                return false;
            }
            if(l.val == r){
                return true;
            }
            l = l.right;
            root = root.left;
        }
        return true;

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> counter = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            counter.put(nums[i],counter.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->
            counter.get(n1) - counter.get(n2));

        for(int n:counter.keySet()){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }

        }
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }


    public boolean isPalindrome(ListNode head) {
        StringBuilder a = new StringBuilder("");
        StringBuilder b = new StringBuilder("");
        while(head!=null){
            a.append(head.val);
            b.insert(0,head.val);
            head = head.next;
        }
        if(a.toString().equals(b.toString())){
            return true;
        }else{
            return false;
        }


    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int res = 0;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while(root!=null || treeNodeStack.size()!=0){
            while(root!=null){
                treeNodeStack.push(root);
                root = root.left;
            }
            root = treeNodeStack.pop();
            if(root.val>=L && root.val<=R){
                res+=root.val;
            }
            root = root.right;
        }
        return res;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String a = "";
        String b = "";
        while(l1!=null){
            a=l1.val+a;
            l1 = l1.next;
        }
        while(l2!=null){
            b=l2.val+b;
            l2 = l2.next;
        }
        String r = (new BigInteger(a).add(new BigInteger(b))).toString();
        ListNode l = new ListNode(0);
        ListNode res = l;
        for(int i=r.length()-1;i>=0;i--){
            l.val = Integer.parseInt(r.substring(i,i+1));
            if(i != 0){
                l.next = new ListNode(0);
                l = l.next;
            }

        }
        return res;

    }

    public static int getSum(int a, int b) {
        System.out.println(a&b);
        return a;

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return null;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode l = new ListNode(0);
        ListNode res = l;
        while((l1 != null && l2 != null)){
            if(l1.val > l2.val){
                l.next = l2;
                l2 = l2.next;
            }else{
                l.next = l1;
                l1 = l1.next;
            }
            l = l.next;
        }

        if(l1 != null){
            l.next = l1;
        }
        if(l2 !=null){
            l.next = l2;
        }
        return res.next;

    }

    public static boolean isAnagram(String s,String t){
        if(s.length()!=t.length())
            return false;
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for(int i=0;i<26;i++){
            chars1[(int)s.charAt(i)-97]++;
            chars2[(int)t.charAt(i)-97]++;
        }

        for(int i=0;i<s.length();i++){
            if(chars1[i]!=chars2[i])
                return false;
        }
    return true;

    }
    public static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<String,Integer[]> vowel1 = new HashMap<String,Integer[]>();
        for(int i=0;i<s.length();i++){
            if(vowel1.get(s.substring(i,i+1))!=null){
                Integer in = vowel1.get(s.substring(i,i+1))[0];
                vowel1.get(s.substring(i,i+1))[0] = in+1;
                System.out.println("vowel1 "+s.substring(i,i+1) + " "+(in+1));
            }else{
                System.out.println("First appear 1 "+s.substring(i,i+1));
                vowel1.put(s.substring(i,i+1),new Integer[]{1,0});
            }

            if(vowel1.get(t.substring(i,i+1))!=null){
                Integer in = vowel1.get(t.substring(i,i+1))[1];
                vowel1.get(t.substring(i,i+1))[1] = in+1;
                System.out.println("vowel2 "+s.substring(i,i+1) + " "+(in+1));
            }else{
                System.out.println("First appear 2 "+s.substring(i,i+1));
                vowel1.put(t.substring(i,i+1),new Integer[]{0,1});
            }
        }

        for(String k:vowel1.keySet()){
            if(vowel1.get(k)[0]!=vowel1.get(k)[1]){
                System.out.println("FALSE");
                return false;
            }
        }
        System.out.println("TRUE");
        return true;
    }

    public int firstUniqChar(String s) {
        Map<String,Integer> vowel = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(vowel.containsKey(s.substring(i,i+1))){
                vowel.put(s.substring(i,i+1),-1);
            }else{
                vowel.put(s.substring(i,i+1),i);
            }
        }
        for(int i=0;i<s.length();i++){
            if(vowel.get(s.substring(i,i+1)) != -1){
                return vowel.get(s.substring(i,i+1));
            }
        }

        return -1;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(root!=null || stack.size()!=0){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }


    public TreeNode bstToGst(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode result = root;
        int counter = 0;
        while(root!=null || treeNodeStack.size()!=0){
            while(root!=null){
                treeNodeStack.push(root);
                root = root.right;
            }
            root = treeNodeStack.pop();
            counter += root.val;
            root.val = counter;
            root = root.left;
            System.out.println();
        }
        return result;
    }

    public List<Integer> sortArray(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for(int k:nums){
            res.add(k);
        }
        return res;

    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index]<0){
                res.add(nums[index]);
            }
            nums[index] = -nums[index];
        }
        return res;
    }


    public String customSortString(String S, String T) {
        Map<Character,Integer> ltMap = new HashMap<>();
        for(int i=0;i<S.length();i++){
            ltMap.put(S.charAt(i),i);
        }
        StringBuilder result = new StringBuilder("");
        String [] arrOf = new String[S.length()+1];
        Arrays.fill(arrOf,"");
        for(int i=0;i<T.length();i++){
            if(ltMap.get(T.charAt(i))!=null){
                arrOf[ltMap.get(T.charAt(i))]+=T.substring(i,i+1);
            }else{
                arrOf[S.length()]+=T.substring(i,i+1);
            }
        }
        for(String s:arrOf){
            result.append(s);
        }
        return result.toString();
    }


}