public class BinarySearchPractice {
    public static void main(String[] rgs) {
        BinarySearchPractice searchPractice = new BinarySearchPractice();
        System.out.println(searchPractice.getPivot(Utils.intArrayFromUser()));
    }

    int getPivot(int[] nums) {
        int s = 0, e = nums.length - 1, mid = s + (e - s) / 2;
        while (s < e) {
            if (nums[mid] >= nums[0]) s = mid + 1;
            else e = mid;

            mid = s + (e - s) / 2;
        }
        return s;
    }

    int paintersPartitionProblem(int[] nums, int n, int m) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int start = 0, end = sum, mid = start + (end - start) / 2, ans = -1;
        while (start < end) {
            if (isPossible(nums, n, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return ans;
    }

    boolean isPossible(int[] nums, int n, int m, int mid) {
        int stdCount = 1, pageSum = 0;
        for (int i = 0; i < n; i++) {
            if (pageSum + nums[i] == mid) {
                pageSum += nums[i];
            } else {
                stdCount++;
                if (stdCount > m || nums[i] > mid) return false;
                pageSum = nums[i];
            }
        }
        return false;
    }
}
