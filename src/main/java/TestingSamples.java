import java.util.ArrayList;
import java.util.List;

public class TestingSamples {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("1");
        test.add("1");
        test.add("2");
        System.out.println(test.size());

        test.remove("1");
        System.out.println(test.size());

    }
}
