package Divide_Conquer;

/**
 * Created by austin on 8/27/16.
 * For academic use
 */
public class Merge_Sort {

    public static int binary_search (Comparable[] array, Comparable target) {
        int low =0;
        int high = array.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target.equals(array[mid])) {
                return mid;
            } else if (target.compareTo(array[mid]) <= 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void merge_sort(Comparable[] array) {
        merge_divide(array, 0, array.length-1);
    }

    private static void merge_divide(Comparable[] items, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            merge_divide(items, start, mid);
            merge_divide(items, mid+1, end);
            merge(items, start, mid, end);
        }
    }

    private static void merge(Comparable[] items, int start, int mid, int end) {
        Comparable[] temp = new Comparable[items.length];
        int pos1 = start;
        int pos2 = mid + 1;
        int spot = start;

        while (pos1 <= mid || pos2 <= end) {
            if ((pos1 > mid) || (pos2 <= end && items[pos2].compareTo(items[pos1]) < 0)) {
                temp[spot] = items[pos2];
                pos2++;
            } else {
                temp[spot] = items[pos1];
                pos1++;
            }
            spot++;
        }
        for (int i = start; i <= end; i++)
            items[i] = temp[i];
    }
}