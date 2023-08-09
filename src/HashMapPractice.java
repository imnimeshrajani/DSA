import java.util.HashMap;
import java.util.Scanner;

public class HashMapPractice {
    public static void main(String[] args) {
        HashMapPractice mapPractice = new HashMapPractice();
//        System.out.println(mapPractice.addValueInHashMap());
        /*for (Map.Entry<String, Integer> e : mapPractice.getHashMapFromUser().entrySet()){
            System.out.println("Hash Code: " + e.hashCode());
            System.out.println("Hash Key:" + e.getKey());
            System.out.println("Hash Value" + e.getValue());
            System.out.println();
        }*/

//        System.out.println(mapPractice.anagram());
//        System.out.println(mapPractice.isomorphic());
        Utils.printArray(mapPractice.twoValueSum());
    }

    HashMap<String, Integer> getHashMapFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Hash Map Length: ");
        int n = scanner.nextInt();
        System.out.println("Enter Hash Map Key & Value: ");
        HashMap<String, Integer> map = new HashMap<>();

        //PUT Example manually
        /*map.put("India", 150);
        map.put("China", 180);
        map.put("USA", 100);
        map.put("Indonesia", 80);*/
        for (int i = 0; i < n; i++) {
            map.put(scanner.next(), scanner.nextInt());
        }
        return map;
    }

    // Hash Map Problems

    boolean anagram() { // check if both strings char & its length is same or not
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Two Strings: ");
        String input1 = scanner.next();
        String input2 = scanner.next();
        if (input1.length() != input2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            Character ch = input1.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (int i = 0; i < input2.length(); i++) {
            Character ch2 = input2.charAt(i);
            if (!map.containsKey(ch2)) {
                return false;
            } else {
                map.put(ch2, map.get(ch2) - 1);
            }
        }
        return true;
    }

    boolean isomorphic(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Two Strings: ");
        String input1 = scanner.next();
        String input2 = scanner.next();

        if (input1.length()!=input2.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            Character ch = input1.charAt(i);
            Character ch2 = input2.charAt(i);
            if (!map.containsKey(ch) && !map.containsValue(ch2)){
                map.put(ch,ch2);
            } else if ((!map.containsKey(ch) && map.containsValue(ch2)) || (map.containsKey(ch) && !map.containsValue(ch2))){
                return false;
            }
        }
        return true;
    }

    int[] twoValueSum(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Array Length: ");
        int n = scanner.nextInt();
        System.out.println("Enter Your Array Value: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter your Target Sum Value: ");
        int target = scanner.nextInt();
        int searchingAns;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            searchingAns = target - arr[i];
            if (map.containsKey(searchingAns)){
                return new int[]{map.get(searchingAns), i};
            } else {
                map.put(arr[i],i);
            }
        }
        return new int[]{-1};
    }
}
