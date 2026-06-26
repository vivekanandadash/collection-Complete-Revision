package failFastAndFailSafe;

import java.util.ArrayList;
import java.util.List;

public class FailFastDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(24);
        nums.add(74);
        nums.add(64);
        nums.add(54);
        for (Integer num : nums){
            System.out.println(num);
//                THIS IS THE ConcurrentModificationException  we can not add object in the collection while traversing
//            if (num == 54){
//                nums.add(105);
//            }
        }
    }
}
