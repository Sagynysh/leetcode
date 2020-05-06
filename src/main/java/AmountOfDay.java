import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AmountOfDay {
    public static void main(String[] args) {
        int[]arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        Map<String,Integer> map = new HashMap<>();
        boolean[] b = new boolean[1000];
        for(int k:arr){
            System.out.println(map.get(k+"")+" "+k);
            if(map.get(k+"")!=null){
                map.put(k+"",map.get(k+"")+1);
            }else{
                map.put(k+"",1);
            }
        }
        for(String k:map.keySet()){
            System.out.println(k+"  "+map.get(k));
        }

        for(String k:map.keySet()){
            if(b[map.get(k).intValue()]){
                System.out.println("False");
            }else{
                b[map.get(k).intValue()] = true;
            }
        }
        System.out.println("True");
    }
}
