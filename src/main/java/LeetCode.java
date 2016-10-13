import java.util.HashMap;

/**
 * Created by lijia8 on 2016/9/27.
 */
public class LeetCode {
    /**
     * No.1
     */
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

    /**
     * No.2
     */
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
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                tempA.val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                tempA.val = l1.val;
                l1 = l1.next;
            } else {
                tempA.val = l2.val;
                l2 = l2.next;
            }
            if (l1 != null || l2 != null) {
                tempA.next = new ListNode(0);
                tempA = tempA.next;
            }
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

    /**
     * No.416
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int centerValue = sum / 2;

        int[] temp = mergeSort(nums, 0, nums.length - 1);
        if (temp[nums.length - 1] > centerValue) {
            return false;
        } else if (temp[nums.length - 1] == centerValue) {
            return true;
        } else {
            if (oddNums % 2 != 0) {
                return false;
            } else {
                return canSplit(new int[]{centerValue, temp.length}, temp);
            }
        }

    }

    public boolean canSplit(int[] maxNum, int[] sortedNums) {
        if (maxNum[1] <= 0) {
            return false;
        }
        int maxTemp[] = searchForMax(maxNum, sortedNums);
        if (maxTemp[1] < 0 || maxNum[0] < 0) {
            return false;
        } else if (maxTemp[0] == maxNum[0]) {
            return true;
        } else {
            maxTemp[0] = maxNum[0] - maxTemp[0];
            boolean yesICan = canSplit(maxTemp, sortedNums);
            while (!yesICan && maxNum[1] > 0) {
                maxNum[1] -= 1;
                maxTemp = searchForMax(maxNum, sortedNums);
                maxTemp[0] = maxNum[0] - maxTemp[0];
                yesICan = canSplit(maxTemp, sortedNums);
            }
            return yesICan;
        }
    }

    public int[] searchForMax(int[] maxNum, int[] sortedNums) {
        int length = maxNum[1];
        for (int i = maxNum[1] - 1; i >= 0; i--) {
            if (sortedNums[i] <= maxNum[0]) {
                return new int[]{sortedNums[i], i};
            }
        }
        return new int[]{maxNum[0], -1};
    }

    int oddNums = 0;

    public boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public int[] quickSort(int[] nums, int start, int end) {
        if (start >= end || end < 0) {
            return nums;
        }
        int tempValue = nums[start];
        int tempSwapIndex = start;
        int tempLeftIndex = start;
        int tempRightIndex = end;
        while (tempLeftIndex < tempRightIndex) {
            while (tempLeftIndex < tempRightIndex && nums[tempRightIndex] >= tempValue) {
                tempRightIndex--;
            }
            if (tempLeftIndex < tempRightIndex) {
                nums[tempSwapIndex] = nums[tempRightIndex];
                tempSwapIndex = tempRightIndex;
            }

            while (tempLeftIndex < tempRightIndex && nums[tempLeftIndex] <= tempValue) {
                tempLeftIndex++;
            }
            if (tempLeftIndex < tempRightIndex) {
                nums[tempSwapIndex] = nums[tempLeftIndex];
                tempSwapIndex = tempLeftIndex;
            }
        }
        nums[tempSwapIndex] = tempValue;
        quickSort(nums, start, tempSwapIndex - 1);
        quickSort(nums, tempSwapIndex + 1, end);

        return nums;

    }

    public int[] mergeSort(int[] nums, int start, int end) {
        int length = end - start + 1;
        int center = start + length / 2 - 1;
        int[] tempLeft;
        int[] tempRight;
        int[] temp = new int[length];
        if (length <= 1) {
            temp[0] = nums[end];
            if (isOdd(temp[0])) {
                oddNums++;
            }
            return temp;
        } else {
            tempLeft = mergeSort(nums, start, center);
            tempRight = mergeSort(nums, center + 1, end);
        }

        int i = 0;
        int j = 0;
        int index = 0;
        while (index < length) {
            if (i < tempLeft.length && j < tempRight.length) {
                if (tempLeft[i] < tempRight[j]) {
                    temp[index] = tempLeft[i];
                    i++;
                } else {
                    temp[index] = tempRight[j];
                    j++;
                }
            } else if (i < tempLeft.length) {
                temp[index] = tempLeft[i];
                i++;
            } else if (j < tempRight.length) {
                temp[index] = tempRight[j];
                j++;
            }
            index++;
        }
        return temp;
    }

}
