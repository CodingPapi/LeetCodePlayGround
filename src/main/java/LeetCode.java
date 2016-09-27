import java.util.HashMap;

/**
 * Created by lijia8 on 2016/9/27.
 */
public class LeetCode {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempA = new ListNode(0);
        ListNode tempB = tempA;
        while (l1 != null && l2 != null) {
            tempA.val = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null && l2 != null) {
                tempA.next = new ListNode(0);
            }
            tempA = tempA.next;
        }


        tempA = tempB;
        boolean increase = false;
        while (tempA != null) {
            tempA.val = increase ? tempA.val + 1 : tempA.val;
            increase = tempA.val >= 10;
            tempA.val = increase ? tempA.val - 10 : tempA.val;
            tempA = tempA.next;
        }

        return tempB;

    }
}
