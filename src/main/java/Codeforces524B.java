import java.util.Scanner;

public class Codeforces524B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int l = 0;
        int k = 0;
        for(int i=0;i<q;i++){
            l = in.nextInt();
            k = in.nextInt();
            if(l==k)
                if(k%2==0){
                    System.out.println(k);
                }else{
                    System.out.println((-1)*k);
                }
            else{
                if((l+k)%2==0){
                    int res = (l+k)/2;
                    res = (k%2==0)?res:res*(-1);
                    System.out.println(res);
                }else{
                    int res = (k-l)/2+1;
                    res = (k%2==0)?res:res*(-1);
                    System.out.println(res);

                }
            }
        }
        System.out.println();

    }
}
