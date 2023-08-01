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

    // 2D ARRAY
    public static int[][] get2dArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Raw & Column Size: ");
        int raw = scanner.nextInt();
        int column = scanner.nextInt();

        int[][] array = new int[raw][column];
        System.out.println("Enter Your Values: ");
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }

    public static void print2dArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

}
