import java.util.Scanner;

public class DailyTask {
    public static void main(String[] args){
        DailyTask dailyTask = new DailyTask();
        Scanner scanner = new Scanner(System.in);
        int[] array = Utils.intArrayFromUser();
        System.out.println("Enter your target: ");
        System.out.println(dailyTask.search(array, scanner.nextInt()));
    }
    public boolean search(int[] nums, int target) {
        int mid = (nums.length-1)/2, start = 0, end = nums.length-1;
        if (target>nums[mid] && target > nums[nums.length-1] && target< nums[mid-1]) end = mid;
        if (nums[mid]> nums[mid-1]) mid--;
        while (start<end){
            mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }


}
