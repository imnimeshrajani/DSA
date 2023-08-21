import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Value : ");
//        System.out.println(recursion.factorial(scanner.nextInt()));
        int a = scanner.nextInt();
        for (int i = 0; i <= a; i++) {
            System.out.println(recursion.fibonacci(i));
        }
    }
    int factorial(int n){
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

    int fibonacci(int n){
        if (n==0 || n==1) return n;
        return fibonacci(n-1)+ fibonacci(n-2);
    }
}
