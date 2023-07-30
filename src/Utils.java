import java.util.Scanner;

public class Utils {
    public static int[] intArrayFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Array Length");
        int arrayLength = scanner.nextInt();
        System.out.println("Enter Array Value");
        int[] intArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
