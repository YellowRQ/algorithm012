package structrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName:ArrayList
 * Package:structrue
 * Description:
 *
 * @author:YellowRQ
 * @data:2020/7/11 16:45
 */
public class ArrayList {

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        Arrays.sort(nums);
        List<Integer> integers = Arrays.asList(nums[1], nums[3], nums[5]);
        System.out.println(integers.toString());
    }

}
