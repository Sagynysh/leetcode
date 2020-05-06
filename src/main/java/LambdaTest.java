import java.lang.reflect.Array;
import java.util.Arrays;

public class LambdaTest {
    public static void main(String[] args) {
        String [] planets = new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        Arrays.sort(planets,(first,sedond)-> first.length()-sedond.length());
        System.out.println(Arrays.toString(planets));
    }
}
