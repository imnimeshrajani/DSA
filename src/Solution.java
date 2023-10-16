import java.util.*;

class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
//        int[] array = Utils.intArrayFromUser();
//        System.out.println("Enter Your Target");
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        solution.intersection(nums1,nums2);
    }

    // TODO: WRITE ALL LEET CODE SOLUTIONS HERE
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return true;
            else map.put(num, 1);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) return true;
            else map.put(nums[i], i);
        }
        return false;
    }

    public static double myPow(double x, int n) {
        if (x == 1 || x == -1) return x;
        if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) return 0.000000;
        if (n < 0) {
            if (n == -1) return 1;
            return 1 / x * myPow(x, n + 1);

        } else if (n == 0) return 1;
        return x * myPow(x, n - 1);
    }

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

    public int majorityElement(int[] nums) {
        /*int ans = 1, max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else {
                map.put(nums[i], map.get(nums[i])+1);
                if (map.get(nums[i])>max) {
                    max = map.get(nums[i]);
                    ans = nums[i];
                }
            }
        }
        return ans;*/
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] - nums[i] != 1) {
                if (index != i) {
                    list.add(nums[index] + "->" + nums[i]);
                } else list.add(String.valueOf(nums[index]));
                index = i + 1;
            }
        }
        if (index == nums.length - 1) {
            list.add(String.valueOf(nums[index]));
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
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0, j = str.length() - 1;
        while (i < j) if (str.charAt(i++) != str.charAt(j--)) return false;
        return true;
    }

    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            int currValue = map.get(s.charAt(i));
            if (i < s.length() - 1 && currValue < map.get(s.charAt(i + 1))) ans -= currValue;
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

    public boolean canBeIncreasing(int[] nums) {
        int j = 0, a = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[j] < nums[i]) {
                if (nums[i] < nums[i + 1]) {
                    j = i;
                } else {
                    if (a > 0) {
                        a--;
                        i++;
                    } else return false;
                }
            } else {
                if (a > 0) a--;
                else return false;
            }
        }
        return true;
    }

    // 1346
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && map.containsValue(arr[i] / 2)) || map.containsValue(arr[i] * 2)) {
                return true;
            } else {
                map.put(i, arr[i]);
            }
        }
        return false;
    }

    public int longestSubarray(int[] nums) {
        int i = 0, j = 0, k = -1, big = Integer.MIN_VALUE, sum = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0) {
                i++;
                j++;
                sum = 0;
            } else if (nums[j] == 0) {
                if (k < 0) k = j++;
                else {
                    i = k + 1;
                    j = i;
                    k = -1;
                    if (sum > big) {
                        big = sum;
                        sum = 0;
                    }
                }
            } else sum += nums[j++];
        }
        if (Math.max(sum, big) == nums.length) return nums.length - 1;
        return Math.max(sum, big);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0, ans = 0, prod = 1;
        while (r < nums.length) {
            prod *= nums[r];
            while (prod > k && l <= r) {
                prod /= nums[l];
                l++;
            }
            ans += (r - l + 1);
            r++;
        }
        return ans;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) i++;
        }
        return i;
    }

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 < 0) count++;
                    if (i + 1 == grid.length) count++;
                    if (i - 1 >= 0 && grid[i - 1][j] == 0) count++;
                    if (i + 1 < grid.length && grid[i + 1][j] == 0) count++;

                    if (j - 1 < 0) count++;
                    if (j + 1 == grid[i].length) count++;
                    if (j - 1 >= 0 && grid[i][j - 1] == 0) count++;
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 0) count++;
                }
            }
        }
        return count;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int big = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            if (big < sum) big = sum;
            if (num == 0) sum = 0;
        }
        return big;
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0, big = Integer.MIN_VALUE;
        StringBuilder str = new StringBuilder(String.valueOf(s.charAt(0)));
        while (i < s.length()) {
            if (!str.toString().contains(String.valueOf(s.charAt(i)))) {
                str.append(s.charAt(i));
                i++;
            } else str.deleteCharAt(0);
            if (big < str.length()) big = str.length();
        }
        return big;
    }

    public int search(int[] nums, int target) {
        int pivot = pivot(nums);
        if (nums[nums.length - 1] < target) return partSearch(nums, 0, pivot, target);
        else return partSearch(nums, pivot, nums.length - 1, target);
    }

    int pivot(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[nums.length - 1]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    int partSearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) return left;
            if (nums[mid] == target) return mid;
            if (nums[right] == target) return right;
            else if (nums[left] < target) left = mid + 1;
            else if (nums[right] > target) right = mid - 1;
        }
        return -1;
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i < timeSeries.length - 1 && timeSeries[i + 1] < timeSeries[i] + duration)
                sum -= (timeSeries[i] + duration) - timeSeries[i + 1];
            sum += duration;
        }
        return sum;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i<nums1.length){
            if (nums1[i] == nums2[j]){
                for (int k = j; k < nums2.length-1; k++) {
                    if (nums2[k]<nums2[k+1]) {
                        nums1[i] = nums2[k];
                        break;
                    } else {
                        nums1[i] = -1;
                    }
                }
                if (j < nums2.length-1) j++;
            } else if (j < nums2.length-1) j++;
            else{
                i++;
                j = i;
            }
        }
        return nums1;
    }

    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int val = 0;
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) if (binary.charAt(j) == '1') val++;
            arr[i] = val;
        }
        return arr;
    }

    public int addDigits(int num) {
        if (num == 0) return 0;
        return (num % 9 == 0) ? 9 : (num % 9);
    }

    public String[] findWords(String[] words) {
        String[] ans = new String[words.length];
        int k =0;
        String top = "qwertyuiop", mid = "asdfghjkl", last = "zxcvbnm";
        for (int i = 0; i < words.length; i++) {
            String searchRow = last;
            if (top.contains(""+words[i].toLowerCase().charAt(0)))searchRow = top;
            else if (mid.contains(""+words[i].toLowerCase().charAt(0))) searchRow = mid;
            System.out.println(words[i].toLowerCase().charAt(0));
            int j = 0;
            while ( j < words[i].length()) {
                if (searchRow.contains(""+words[i].charAt(j))){
                    j++;
                    if (j == words[i].length()) {
                        ans[k] = words[i];
                        k++;
                    }
                } else break;
            }
        }
        return ans;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> set1 = new ArrayList<>(), set2 = new ArrayList<>();
        for (int i : nums1) set1.add(i);
        for (int i : nums2) if (set1.contains(i))set2.add(i);
        int ans[] = new int[set2.size()], index = 0;
        for (Integer integer : set2) ans[index++] = integer;
        return ans;
    }

}