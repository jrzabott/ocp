import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class WrapperCheck {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(6);
        nums.add(7);

        int sum = 0;
        for (Integer n: nums) {
            sum += n;
        }


        System.out.println("Daniel Junior");

        System.out.println("Sum = " + sum);
        System.out.println("Avg = " + sum/nums.size());
    }
}
