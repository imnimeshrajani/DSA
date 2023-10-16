import java.util.Arrays;

public class SortAlgorithms {
    public static void main(String[] args) {
        int[] arr = Utils.intArrayFromUser();

//        BubbleSort(arr);
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void BubbleSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

    public static void SelectionSort(int[] arr){
        int n = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < n; j++) {
                
            }
        }
    }
}
