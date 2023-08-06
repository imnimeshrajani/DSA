import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
//        main.arrayExample();
//        System.out.println("Search Element = " + main.searchElement());
//        main.intArrayFromUser();
//        System.out.println("Repeat Element " + main.repeatValueArray() + " Position");
//        int uniqueValue = main.findUniqueValue();
//        if (uniqueValue!=-1){
//            System.out.println("Unique Value is: "+uniqueValue);
//        }
//        System.out.println(main.findDifferenceValue());

        // Reverse Array
//        int[] array = main.rotateArrayFromGivenValue();
//        main.printArray(array);

//        int[] array = main.negativePositiveNumberArray();
//        main.printArray(array);

//        System.out.println("First Matrix Value: ");
//        int[][] firstArray = Utils.get2dArray();
//        main.reverseMatrixColumn(firstArray);
//        main.arraySorting(Utils.intArrayFromUser());

        // 2D Array
        /*System.out.println("Second Matrix Value: ");
        int[][] secArray = Utils.get2dArray();
        main.matrixSum(
                firstArray, firstArray.length, firstArray[firstArray.length - 1].length,
                secArray, secArray.length, secArray[secArray.length - 1].length
        );
        main.matrixMultiplication(
                firstArray, firstArray.length, firstArray[firstArray.length - 1].length,
                secArray, secArray.length, secArray[secArray.length - 1].length
        );*/
//        main.rotationMatrixAntiClockWise(firstArray);
//        System.out.println("Enter pascal raw size: ");
//        main.pascal(scanner.nextInt());

        System.out.println("Enter Raw & Column Size: ");
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        int[][] array = new int[row][column];
        System.out.println("Enter Your Values: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter r1 c1 & r2 c2: ");
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
//        main.spiralMatrixPrint(array, row, column);
//        main.spiralMatrixCreate(row, row);
        main.getSumWithPrefixSumMatrix(array, c1, c2, r1, r2);
    }

    void arraySorting(int[] nums) {
        int i = 0, j = i + 1;
        while (j < nums.length) {
            if (nums[i] > nums[j]) {
                nums[i] = nums[i] + nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
            }
            j++;
            if (j == nums.length) {
                i++;
                j = i + 1;
            }
        }
        Utils.printArray(nums);
    }

    void arrayExample() {
        int total = 0, index = 0, max = 0;
        int[] arr = {1, 5, 3, 5, 34, 5, 6};
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("total = " + total);
        System.out.println("Maximum = " + max);
    }

    int searchElement() {
        int[] array = {1, 5, 8, 3, 12, 5};
        int x = 5;
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                return i;
            }
        }
        return -1;
    }


    int repeatValueArray() {
        int[] arrayInt = {1, 4, 6, 8, 2, 5, 8, 9, 4, 5, 2, 4};
        int checkElement = 5, repeated = 0;
        for (int i = arrayInt.length - 1; i > 0; i--) {
            if (checkElement == arrayInt[i]) {
                return i;
            }
        }
        return repeated;
    }

    int findUniqueValue() {
        int[] array = Utils.intArrayFromUser();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[i] = -1;
                    array[j] = -1;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                return array[i];
            }
        }
        return -1;
    }

    String findDifferenceValue() {
        int[] array = Utils.intArrayFromUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter difference Number: ");
        int diff = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] - array[i] == diff) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    int[] rotateArrayFromGivenValue() {
        int[] array = Utils.intArrayFromUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Position For Swap: ");
        int position = scanner.nextInt();
        position = position % array.length;
        reverse(array, 0, array.length - position - 1);
        reverse(array, position, array.length - 1);
        reverse(array, 0, array.length - 1);
        return array;
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
    }

    int[] negativePositiveNumberArray() {
//        int[] array = intArrayFromUser();
        int[] array = {1, 2, 3, -4, -1, 4};
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i % 2 == 0 && array[j] < 0) {
                    newArray[i] = array[j];
                    break;
                } else if (i % 2 != 0 && array[j] > 0) {
                    newArray[i] = array[j];
                    break;
                }
            }
        }
        return newArray;
    }

    // 2D ARRAY EXAMPLES & PRACTICE
    void matrixSum(int[][] firstArray, int r1, int c1, int[][] secArray, int r2, int c2) {
        if (r1 != r2 || c1 != c2) {
            System.out.println("Wrong Input - Addition Not Possible");
            return;
        }
        int[][] sumArray = new int[r1][c1];
        for (int i = 0; i < sumArray.length; i++) {
            for (int j = 0; j < sumArray[i].length; j++) {
                sumArray[i][j] = firstArray[i][j] + secArray[i][j];
            }
        }
        Utils.print2dArray(sumArray);
    }

    void matrixMultiplication(int[][] firstArray, int r1, int c1, int[][] secArray, int r2, int c2) {
        if (r2 != c1) {
            System.out.println("Wrong Input - Multiplication not possible");
            return;
        }
        int[][] multiArray = new int[r1][c2];
        for (int raw = 0; raw < r1; raw++) {
            for (int column = 0; column < c2; column++) {
                for (int i = 0; i < c1; i++) {
                    multiArray[raw][column] += (firstArray[raw][i] * secArray[i][column]);
                }
            }
        }
        Utils.print2dArray(multiArray);
    }

    void reverseMatrixColumn(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int arrayLastPosition = array[i].length - 1;
            for (int j = 0; j < arrayLastPosition; j++) {
                array[i][j] = array[i][j] + array[i][arrayLastPosition];
                array[i][arrayLastPosition] = array[i][j] - array[i][arrayLastPosition];
                array[i][j] = array[i][j] - array[i][arrayLastPosition];
                arrayLastPosition--;
            }
        }
        Utils.print2dArray(array);
    }

    void transposeMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array[i].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        Utils.print2dArray(array);
    }

    void rotationMatrixClockWise(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array[i].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
            int arrayLastPosition = array[i].length - 1;
            for (int j = 0; j < arrayLastPosition; j++) {
                array[i][j] = array[i][j] + array[i][arrayLastPosition];
                array[i][arrayLastPosition] = array[i][j] - array[i][arrayLastPosition];
                array[i][j] = array[i][j] - array[i][arrayLastPosition];
                arrayLastPosition--;
            }
        }
        Utils.print2dArray(array);
    }

    void rotationMatrixAntiClockWise(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int arrayLastPosition = array[i].length - 1;
            for (int j = 0; j < arrayLastPosition; j++) {
                array[i][j] = array[i][j] + array[i][arrayLastPosition];
                array[i][arrayLastPosition] = array[i][j] - array[i][arrayLastPosition];
                array[i][j] = array[i][j] - array[i][arrayLastPosition];
                arrayLastPosition--;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array[i].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
        Utils.print2dArray(array);
    }

    void pascal(int raw) {
        int[][] pascalArray = new int[raw][];
        for (int i = 0; i < raw; i++) {
            pascalArray[i] = new int[i + 1];
            pascalArray[i][0] = pascalArray[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascalArray[i][j] = pascalArray[i - 1][j] + pascalArray[i - 1][j - 1];
            }
        }
        Utils.print2dArray(pascalArray);
    }

    void spiralMatrixPrint(int[][] matrix, int r, int c) {
        int leftCol = 0;
        int rightCol = r - 1;
        int topRow = 0;
        int bottomRow = c - 1;

        while (topRow <= bottomRow) {
            // top row
            for (int i = leftCol; i <= rightCol && topRow <= bottomRow; i++) {
                System.out.print(matrix[topRow][i] + " ");
            }
            topRow++;

            // right colum
            for (int i = topRow; i <= bottomRow && topRow <= bottomRow; i++) {
                System.out.print(matrix[i][rightCol] + " ");
            }
            rightCol--;

            // bottom row
            for (int i = rightCol; i >= leftCol && topRow <= bottomRow; i--) {
                System.out.print(matrix[bottomRow][i] + " ");
            }
            bottomRow--;
            // left column
            for (int i = bottomRow; i >= topRow && topRow <= bottomRow; i--) {
                System.out.print(matrix[i][leftCol] + " ");
            }
            leftCol++;
        }
    }

    void spiralMatrixCreate(int r, int c) {
        int leftCol = 0;
        int rightCol = r - 1;
        int topRow = 0;
        int bottomRow = c - 1;
        int value = 1;
        int[][] matrix = new int[r][c];

        while (value < r * c) {
            // top row
            for (int i = leftCol; i <= rightCol && value < r * c; i++) {
                matrix[topRow][i] = value++;
            }
            topRow++;

            // right colum
            for (int i = topRow; i <= bottomRow && value < r * c; i++) {
                matrix[i][rightCol] = value++;
            }
            rightCol--;

            // bottom row
            for (int i = rightCol; i >= leftCol && value < r * c; i--) {
                matrix[bottomRow][i] = value++;
            }
            bottomRow--;
            // left column
            for (int i = bottomRow; i >= topRow && value < r * c; i--) {
                matrix[i][leftCol] = value++;
            }
            leftCol++;
        }
        Utils.print2dArray(matrix);
    }

    void getSumWithPrefixSumMatrix(int[][] matrix, int leftCol, int rightCol, int topRow, int bottomRow) {
        getPrefixedMatrixRow(matrix);
        int sum = 0;
        if (leftCol > 0 && topRow > 0) {
            sum = matrix[bottomRow][rightCol] - matrix[bottomRow][leftCol - 1] - matrix[topRow - 1][rightCol] + matrix[topRow-1][leftCol-1];
        } else if (leftCol > 0) {
            sum = matrix[bottomRow][rightCol] - matrix[bottomRow][leftCol - 1];
        } else if (topRow > 0) {
            sum = matrix[bottomRow][rightCol] - matrix[topRow - 1][rightCol];
        } else {
            sum = matrix[bottomRow][rightCol];
        }
        /*
        for (int i = topRow; i <= bottomRow; i++) {
            if (leftCol > 0) {
                sum += matrix[i][rightCol] - matrix[i][leftCol - 1];
            } else {
                sum += matrix[i][rightCol];
            }
        }*/
        System.out.println(sum);
    }

    void getPrefixedMatrixRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
            }
        }
        getPrefixedFinalMatrix(matrix);
    }

    void getPrefixedFinalMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
            }
        }
    }
}
