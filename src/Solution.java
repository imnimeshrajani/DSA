import java.util.Arrays;
import java.util.Scanner;

class Solution {


    public static void main(String args[]) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int[] array = Utils.intArrayFromUser();
//        System.out.println("Enter a Target");
//        int target = scanner.nextInt();
//        main.printArray(solution.twoSum(array, target));
//        System.out.println(solution.removeDuplicates(array));
//        System.out.println("ans:" + solution.searchInsert(array,target));
//        main.printArray(solution.plusOne(array));
//        System.out.println("Enter a Sorted array length");
//        int m = scanner.nextInt();
//        int[] nums2 = Utils.intArrayFromUser();
//        Utils.printArray(solution.merge(array, m, nums2, nums2.length));

//        solution.maxProfit(array);
//        solution.singleNumber(array);
        solution.majorityElement(array);
    }

    // TODO: WRITE ALL LEET CODE SOLUTIONS HERE
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        Main main = new Main();
        Utils.printArray(nums);
        return j;
    }

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j += 1;
            }
        }
        Main main = new Main();
        Utils.printArray(nums);
        return j;
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
        return nums1;
    }

    public void maxProfit(int[] prices) {
        int i = 0, j = 1, profit = 0;
        while (j < prices.length) {
            if (prices[j] - prices[i] > profit) {
                profit = prices[j] - prices[i];
            } else if (prices[j] - prices[i] < 0) {
                i = j;
            }
            j++;
        }
        System.out.println(profit);
    }

    public void singleNumber(int[] nums) {
        int result = 0, i = 0;
        while (i < nums.length) {
            result = result ^ nums[i++];
        }
        System.out.println(result);
    }

    public void majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        System.out.println(nums[n/2]);
    }
}