import java.sql.Array;
import java.util.*;

public class GeeksForGeeks {
    public static void main(String[] args) {
        GeeksForGeeks geeksForGeeks = new GeeksForGeeks();
        Scanner scanner = new Scanner(System.in);
//        int[] array = Utils.intArrayFromUser();
//        int[] array2 = Utils.intArrayFromUser();
//        System.out.println("Enter Your Target: ");
//        int[] l = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        int[] l = {6,1,2,8,3,4,7,10,5};
        int N = 10, K = 12;
        System.out.println(geeksForGeeks.missingNumber(l, N));

    }

    public static int doUnion(int[] a, int n, int[] b, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i])) map.put(a[i], map.getOrDefault(a[i], 1) + 1);
            else map.put(a[i], 1);
        }

        for (int i = 0; i < m; i++) {
            if (!map.containsKey(b[i])) map.put(b[i], 1);
        }
        return map.size();
    }

    public static boolean check(long[] A, long[] B, int N) {
        Map<Long, Long> map = new HashMap<>();
        for (long l : A) {
            if (map.containsKey(l)) map.put(l, map.get(l) + 1);
            else map.put(l, 1L);
        }
        for (long l : B) {
            if (map.containsKey(l)) map.put(l, map.get(l) - 1);
            else return false;
        }
        for (var i : map.values()) if (i > 0) return false;
        return true;
    }

    public static boolean isPowerofTwo(long n) {
        double a = n;
        if (a == 2) return true;
        while (a >= 2) {
            a = a / 2;
            if (a == 2.00) return true;
        }
        return false;
    }

    static int search(int arr[], int N, int X) {
        for (int i = 0; i < N; i++) if (arr[i] == X) return i;
        return -1;
    }

    static Pair getMinMax(long[] a, long n) {
        long small = Long.MAX_VALUE, big = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < small) small = a[i];
            if (a[i] > big) big = a[i];
        }
        return new Pair(small, big);
    }

    static int isPrime(int N) {
        if (N == 1) return 0;
        for (int i = 2; i * i <= N; i++) if (N % i == 0) return 0;
        return 1;
    }

    public static long[] printFibb(int n) {
        long[] array = new long[n];
        array[0] = 1;
        for (int i = 1; i < n; i++) {
            if (i - 2 < 0) array[i] = array[i - 1];
            else array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

    static int searchInSorted(int[] arr, int N, int K) {
        int start = 0, end = N - 1;
        if (K > arr[N - 1]) return -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == K) return 1;
            else if (K > arr[mid]) start = mid + 1;
            else if (K < arr[mid]) end = mid - 1;
        }
        return -1;
    }

    static void binSort(int[] A, int N) {
        int i = 0, j = N - 1;
        while (i < j) {
            if (A[i] == 0) i++;
            else if (A[j] == 1) j--;
            else if (A[i] > A[j]) {
                A[i] = A[i] + A[j];
                A[j] = A[i] - A[j];
                A[i] = A[i] - A[j];
                i++;
                j--;

            }
        }
        System.out.println(Arrays.toString(A));
    }

    public static Long product(Long[] arr, Long mod, int n) {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= arr[i];
        }
        return ans / mod;
    }

    public static int chocolates(int n, int[] arr) {
        int i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] < arr[j]) j--;
            else i++;
        }
        if (arr[i] < arr[j]) return arr[j];
        else return arr[i];
    }

    public static int multiply(int[] arr, int n) {
        int i = 0, j = n - 1, left = 0, right = 0;
        while (i < j) {
            left += arr[i];
            right += arr[j];
            if (i + 1 != j) i++;
            j--;
        }
        if (n % 2 != 0) right += arr[(n - 1) / 2];
        return left * right;
    }

    static boolean checkElements(int[] arr, int n, int A, int B) {
        // not Done
        int range = A;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= A && arr[i] <= B) {
                range++;
                if (range == B) return true;
            }
        }
        return range < B;
    }

    public static long findMultiplication(int[] arr, int[] brr, int n, int m) {
        int maxA = Integer.MIN_VALUE, minB = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i > maxA) maxA = i;
        }
        for (int i : brr) {
            if (i < minB) minB = i;
        }
        return (long) maxA * minB;
    }

    public static int findClosest(int[] arr, int n, int target) {
        int big = Integer.MAX_VALUE, small = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i == target) return target;
            if (i > small && target > i) small = i;
            if (i < big && target < i) big = i;
        }
        if (target - small < big - target && small > 0) return small;
        return big;
    }

    public static int findMax(Height[] arr, int n) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sumInches = (arr[i].feet * 12) + arr[i].inches;
            ans = Math.max(sumInches, ans);
        }
        return ans;
    }

    int binarySearch(int arr[], int n, int k) {
        int start = 0, end = arr.length - 1, mid = start + (end - start) / 2;
        while (start < end) {
            if (arr[start] == k) return start;
            if (arr[end] == k) return end;
            if (arr[mid] == k) return mid;
            else if (arr[mid] < k) start = mid + 1;
            else if (arr[mid] > k) end = mid;
            mid = start + (end - start) / 2;
        }
        return -1;
    }

    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int a = Math.min(k - 1, n - 1), s = 0, m = 1;
        while (s <= n - 1) {
            if (s < a) {
                arr.set(s, arr.get(s) + arr.get(a));
                arr.set(a, arr.get(s) - arr.get(a));
                arr.set(s, arr.get(s) - arr.get(a));
                a--;
                s++;
            } else {
                s = (k * m);
                m++;
                a = Math.min((k * m) - 1, n - 1);
            }
        }
    }

    public void rotate(int[] arr, int n) {
        int i = 0, j = n - 1;
        while (i < j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
        }
    }

    public int largest(int[] arr, int n) {
        int big = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) if (arr[i] > big) big = arr[i];
        return big;
    }

    long Maximize(int[] arr, int n) {
        long ans = 0;
        long limit = 1000000007L;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            ans += ((long) arr[i] * i);
        }
        return ans % limit;
    }

    void immediateSmaller(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (i + 1 == arr.length || arr[i + 1] >= arr[i]) arr[i] = -1;
            else arr[i] = arr[i + 1];
        }
        System.out.println(Arrays.toString(arr));
    }

    public int firstElementKTime(int[] a, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i])) map.put(a[i], map.get(a[i]) + 1);
            else map.put(a[i], 1);
            if (map.get(a[i]) == k) return a[i];
        }
        return -1;
    }

    public void zigZag(int[] a, int n) {
        int i = 0, j = 1;
        while (i < n - 1 && j < n) {
            if (i % 2 == 0) {
                if (a[i] > a[j]) {
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            } else {
                if (a[i] < a[j]) {
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            }
            i++;
            j++;
        }
        System.out.println(Arrays.toString(a));
    }

    void leftRotate(int[] arr, int n, int d) {
        d = d % n;
        rotate(arr, 0, d - 1);
        rotate(arr, d, n - 1);
        rotate(arr, 0, n - 1);
    }

    void rotate(int[] arr, int i, int j) {
        while (i < j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
    }

    int thirdLargest(int[] a, int n) {
        int first = -1, sec = -1, third = -1;
        for (int j : a) {
            if (j > first) {
                third = sec;
                sec = first;
                first = j;
            } else if (j > sec) {
                third = sec;
                sec = j;
            } else if (j > third) {
                third = j;
            }
        }
        return third;
    }

    int getOddOccurrence(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], 1);
            else map.put(arr[i], map.get(arr[i]) + 1);
        }
        for (var i : map.entrySet()) if (i.getValue() % 2 != 0) return i.getKey();
        return -1;
    }

    public long[] minAnd2ndMin(long[] a, long n) {
        long first = Integer.MAX_VALUE, sec = first;
        for (long l : a) {
            if (l < first) {
                sec = first;
                first = l;
            } else if (l > first && l < sec) sec = l;
        }
        if (first == Integer.MAX_VALUE) return new long[]{-1};
        else if (sec == Integer.MAX_VALUE) return new long[]{-1};
        return new long[]{first, sec};
    }

    long minValueToBalance(long[] a, int n) {
        int mid = n / 2, leftSum = 0, rightSum = 0;
        for (int i = 0; i < n; i++)
            if (i < mid) leftSum += a[i];
            else rightSum += a[i];
        System.out.println(leftSum);
        System.out.println(rightSum);
        return Math.abs(leftSum - rightSum);
    }

    public long firstIndex(long[] arr, long n) {
        if (arr[(int) (n - 1)] == 0) return -1;
        if (arr[0] == 1) return 0;
        long start = 0, end = n - 1;
        while (start < end) {
            int mid = (int) (start + (end - start) / 2);
            if (arr[mid] == 1 && arr[mid - 1] == 0) return mid;
            else if (arr[mid] == 0) start = mid + 1;
            else if (arr[mid] == 1) end = mid;
        }
        if (arr[(int) start] == 1) return start;
        return -1;
    }

    public long totalFine(long n, long date, long[] car, long[] fine) {
        long modAns = 0, sumAns = 0;
        if (date % 2 == 0) modAns = 1;
        for (int i = 0; i < n; i++) if (car[i] % 2 == modAns) sumAns += fine[i];
        return sumAns;
    }

    long maxDays(long[] arr, int n) {
        long ans = Long.MIN_VALUE;
        for (long l : arr) if (ans < l) ans = l;
        return ans;
    }

    void nextGreatest(int[] arr, int n) {
        int i = 0, j = 1;
        while (i < n) {
            if (j < n) {
                if (arr[i] < arr[j]) {
                    arr[i] = arr[j];
                    i++;
                    if (i == j) j++;
                } else j++;
            } else {
                arr[i] = -1;
                i++;
            }
        }
    }

    public ArrayList<Integer> firstAndLast(int[] arr, int n, int x) {
        ArrayList<Integer> array = new ArrayList<>();
        int start = 0, end = n - 1;
        array.add(-1);
        array.add(-1);
        while (start <= end) {
            if (arr[start] == x) array.set(0, start);
            else start++;
            if (arr[end] == x) array.set(1, end);
            else end--;
            if (!array.contains(-1)) return array;
        }
        array.remove(1);
        return array;
    }

    Pair getFloorAndCeil(int[] arr, int n, int x) {
        int floor = -1, ceil = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i > floor && i < x) floor = i;
            if (i < ceil && i > x) ceil = i;
            if (i == x) {
                floor = i;
                ceil = i;
                break;
            }
        }
        if (ceil == Integer.MAX_VALUE) ceil = -1;
        return new Pair(floor, ceil);
    }

    int isPalindrome(String S) {
        int i = 0, j = S.length() - 1;
        while (i < j) {
            if (S.charAt(i) != S.charAt(j)) return 0;
            i++;
            j--;
        }
        return 1;
    }

    int maxProduct(int[] arr, int n) {
        int smaller = -1, big = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > big) {
                if (big > smaller) smaller = big;
                big = arr[i];
            } else if (arr[i] > smaller) smaller = arr[i];
        }
        return big * smaller;
    }

    long maxSum(long[] arr ,int n) {
        if (n==2) return Math.abs(arr[0]-arr[1])*2;
        long sum = 0;
        int i;
        System.out.println(Arrays.toString(arr));
        for (i = 1; i < n; i+=2) {
            System.out.println(i);
            if (arr[i]<arr[i-1]){
                swap(arr,i,i-1);
                sum += Math.abs(arr[i-1]-arr[i]);
            }
            if (i<n-1 && arr[i]<arr[i+1]) {
                swap(arr, i, i + 1);
                sum += Math.abs(arr[i + 1] - arr[i]);
            }
            System.out.println(Arrays.toString(arr));
        }
        if (n%2 == 0) sum+=Math.abs(arr[i-2]-arr[0]);
        return sum;
    }
    void swap(long[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    int totalCount(int[] arr, int n, int k) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int ansI= arr[i]/k;
            double ansD= (double) arr[i] /k;
            if (ansI<ansD) sum += ansI+1;
            else sum+= ansI;
        }
        return sum;
    }

    public static int num(int[] a, int n, int k) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = 1;
            while (j<a[i]){
                if ((a[i]/j)%10 == k) ans++;
                j *= 10;
            }
        }
        return ans;
    }

    public int[] pendulumArrangement(int[] arr, int n) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] ans = new int[n];
        int i = 0, j = n-1, index = 0;
        if (n%2==0) j = n-2;
        for (int k = j; k >= i; k-=2) {
            ans[index++] = arr[k];
        }
        if (n%2==0) i = 1;
        for (int k = i; k <= j+1; k+=2) {
            ans[index] = arr[k];
            index++;
        }
        return ans;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int i = 0, j = 1, sum = arr[i];
        ArrayList<Integer> array = new ArrayList<>();
        while (i<=j){
            if (sum == s){
                array.add(i+1);
                array.add(j);
                return array;
            } else if (sum > s) sum-=arr[i++];
            else {
                if (j<n-1) sum += arr[j++];
                else sum-=arr[i++];
            }
        }
        return array;
    }

    int missingNumber(int[] array, int n) {
        int ans = ((n*n)+n)/2;
        for (int j : array) ans -= j;
        return ans;
    }

    public int findUnique(int[] a, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : a) {
            if (map.containsKey(i)) {
                map.put(i,map.get(i)+1);
            }
            else map.put(i,1);
        }
        for (var entry : map.entrySet()){
            if (entry.getValue()<k) return entry.getKey();
            else if (entry.getValue()>k && entry.getValue()%k != 0) return entry.getKey();
        }
        return -1;
    }

    static Pair maxNtype(long arr[], long n) {
        long min = arr[0], max = arr[0];
        int l = (int)n-1, first = 0;
        for (int i = 0; i < (int)n; i++) {
            if (arr[i]<min) min = arr[i];
            if (arr[i]>max) max = arr[i];
        }
        if (arr[0] == min && arr[l]==max) first = 1;
        else if (arr[0]==max && arr[l] ==min) first = 2;
        else if(arr[0]<arr[l]) first = 3;
        else first = 4;
        return new Pair(first,max);
    }

    int maxRepeating(int[] arr, int n, int k) {
        int rep = 0, repValue = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (i>k) return -1;
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
                if (rep < map.get(i)) rep = map.get(i);
            }
            else map.put(i,1);
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue()>rep) repValue = entry.getKey();
            if (entry.getValue() == rep && entry.getKey()<repValue) repValue = entry.getKey();
        }
        return repValue;
    }
    static class Height {
        int feet;
        int inches;

        public Height(int ft, int inc) {
            feet = ft;
            inches = inc;
        }
    }

    static class Pair {
        long first, second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}
