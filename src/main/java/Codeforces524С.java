import java.util.Scanner;

public class Codeforces524С {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int q = in.nextInt();
//        for(int i=0;i<q;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int arr[][] = new int[m][n];
            int white = (m*n%2==0)?m*n/2:(m*n)/2+1;

            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            for(int j=x1-1;j<x2;j++){
                for(int k=y1-1;k<y2;k++){
                    arr[j][k] = 1;
                }
            }

            int newx1 = in.nextInt();
            int newy1 = in.nextInt();
            int newx2 = in.nextInt();
            int newy2 = in.nextInt();

        System.out.println("White "+white);
            int newN = (x2-x1)+1;
            int newM = (y2-y1)+1;
            int newWhite = newN*newM;
            for(int j=newx1-1;j<newx2;j++){
                for(int k=newy1-1;k<newy2;k++){
                    if(arr[j][k] == 1){
                        newWhite--;
                        System.out.println("cross");
                    }
//                    newWhite = (arr[j][k] == 1)?newWhite--:newWhite;
                }
            }

//            newWhite = (newN*newM%2==0) ? newN*newM/2 : newN*newM/2+1;
//            newWhite = ((x1+y1)%2==0) ? newWhite : newM*newN-newWhite;
        System.out.println("New White "+newWhite);

            newN = (x2-x1)+1;
            newM = (y2-y1)+1;
            int newBlack = (newN*newM%2==0) ? newN*newM/2 : newN*newM/2+1;
            newBlack = ((x1+y1)%2==0) ? newM*newN-newBlack : newBlack ;
        System.out.println("New Black "+newBlack);

            white = (newWhite>=newBlack) ? white+(newWhite-newBlack) : white - (newBlack - newWhite);

            System.out.print(white+" "+(m*n-white));

//        }
    }
}
