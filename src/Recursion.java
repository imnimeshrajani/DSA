import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter num Value : ");
        int[] arr = {3,1,30,2,5};
        System.out.println(recursion.maxValue(arr, 0, Integer.MIN_VALUE));
    }

    int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    void multiply(int num, int k) {
        if (k == 0) return;
        multiply(num, k - 1);
        System.out.println(num * k);
    }

    int sumMinus(int num) {
        if (num == 0) return 0;
        if (num % 2 == 0) return sumMinus(num - 1) - num;
        else return sumMinus(num - 1) + num;
    }

    int maxValue(int[] arr, int idx, int max) {
        if (idx == arr.length) return max;
        if (max<arr[idx]) max = arr[idx];
        return maxValue(arr,idx+1,max);
    }
}
