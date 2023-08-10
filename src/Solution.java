import java.util.*;

class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
//        int[] array = Utils.intArrayFromUser();
//        int[] array2 = Utils.intArrayFromUser();
//        System.out.println("Enter a Target");
//        int target = scanner.nextInt();
//        main.printArray(solution.twoSum(array, target));
//        System.out.println(solution.removeDuplicates(array));
//        System.out.println("ans:" + solution.searchInsert(array,target));
//        main.printArray(solution.plusOne(array));
//        System.out.println("Enter a Sorted array length");
//        int m = scanner.nextInt();
//        Utils.printArray(solution.merge(array, m, array2, array2.length));

//        solution.maxProfit(array);
//        solution.singleNumber(array);
//        solution.majorityElement(array);\
//        System.out.println(solution.containsDuplicate(array));
//        System.out.println(solution.summaryRanges(array));
//        System.out.println(solution.missingNumber(array));
//        solution.moveZeroes(array);
        /*NumArray numArray = new NumArray(array);
        System.out.println("Enter Range:");
        System.out.println(numArray.sumRange(scanner.nextInt(), scanner.nextInt()));*/

//        Utils.printArray(solution.intersect(array,array2));
        /*System.out.println("Enter Romen Number:");
        System.out.println(solution.romanToInt(scanner.next()));*/

        System.out.println("Enter Value: ");
        System.out.println(solution.mySqrt(scanner.nextInt()));
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
        System.out.println(nums[n / 2]);
    }

    public boolean containsDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] == nums[j]) {
                return true;
            } else if (nums[i] != nums[j] && i != j - 1) {
                j--;
            }
            if (i < nums.length - 1) {
                i++;
                j = nums.length - 1;
            }
        }

        return false;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] - nums[i] != 1) {
                if (index != i) {
                    list.add(nums[index] + "->" + nums[i]);
                } else list.add("" + nums[index]);
                index = i + 1;
            }
        }
        if (index == nums.length - 1) {
            list.add("" + nums[index]);
        } else {
            {
                list.add(nums[index] + "->" + nums[nums.length - 1]);
            }
        }
        return list;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length, sum = n * (n + 1) / 2;
        for (int i : nums) sum -= i;
        return sum;
    }

    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int start = 0, end = 1;
        /*while(end<nums.length){
            if(nums[start]==0 && nums[end]!=0){
                nums[start] = nums[start]+ nums[end];
                nums[end] = nums[start] - nums[end];
                nums[start] = nums[start] - nums [end];
                start++;
                end++;
            }else if(nums[start]==0 && nums[end]==0){
                end++;
            }else{
                start++;
                end++;
            }
        }*/

        for (int i = 1; i < nums.length; i++) {
            if (nums[start] == 0 && nums[i] != 0) {
                nums[start] = nums[start] + nums[i];
                nums[i] = nums[start] - nums[i];
                nums[start] = nums[start] - nums[i];
                start++;
            } else if (nums[start] == 0 && nums[end] == 0) {
            } else {
                start++;
            }
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while( i < n1 && j < n2)
        {
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else
            {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0, j = str.length()-1;
        while (i<j) if (str.charAt(i++) != str.charAt(j--)) return false;
        return true;
    }

    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        for (int i = 0; i < s.length(); i++) {
            int currValue = map.get(s.charAt(i));
            if (i < s.length()-1 && currValue < map.get(s.charAt(i+1))) ans -= currValue;
            else ans += currValue;
        }
        return ans;
    }
    public int mySqrt(int x) {
        int start = 1, end = x, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if ((long) mid * mid > (long) x) end = mid - 1;
            else if (mid * mid == x) return mid;
            else start = mid + 1;
        }
        return Math.round(end);
    }
}