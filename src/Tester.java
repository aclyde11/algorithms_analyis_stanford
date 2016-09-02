import Hashing.MyHashTable;

/**
 * Created by austin on 8/27/16.
 */


public class Tester {

    public static void main (String[] args) {
        //Merge Sort testing
        /*
        System.out.println("Testing Mergesort");
        int merge_test_size = 11;
        Integer[] ins = new Integer[merge_test_size];
        for(int i = 0; i < ins.length; i++) {
            ins[i] = (int) (Math.random() * 101);
        }
        System.out.println("before sorting: ");
        print_array(ins);
        System.out.println("after sorting");
        Merge_Sort.merge_sort(ins);
        print_array(ins);
        */

        //Data_Structures.MyStringBuilder Testing
        /*
        Data_Structures.MyStringBuilder bs = new Data_Structures.MyStringBuilder();
        bs.append("hi");
        bs.append("stfu");
        bs.append("SUPERLONGSTRINGTHISMIGHTBEALOTFORITPOHANDLE");
        System.out.println(bs.toString());

        Data_Structures.MyStringBuilder x = new Data_Structures.MyStringBuilder("HIT");
        x.insert("hi", 2);
        System.out.println(x);
        */


        MyHashTable<String, String> directory = new MyHashTable<>(2);
        directory.put("Austin", "5854069146");
        directory.put("Clyde", "3124069146");
        directory.put("Randy", "5853550332");
        directory.put("Lynn", "5856904113");

        directory.print_map();

    }

    private static void print_array (Object[] arr) {
        String s = "{";
        for(int i = 0; i < arr.length; i ++ ) {
            s += arr[i] + " ";
        }
        System.out.println(s + "}");
    }
}
