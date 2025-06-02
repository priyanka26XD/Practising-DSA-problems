import java.util.Arrays;

public class QuickSortPivotAnalysis {
    static int recCallsFirst = 0;
    static int recCallsLast = 0;
    static int recCallsMedian = 0;

    // ----------- Quick Sort with First Element as Pivot -----------
    public static void quickSortFirst(int[] arr, int low, int high) {
        if (low < high) {
            recCallsFirst++;
            int pi = partitionFirst(arr, low, high);
            quickSortFirst(arr, low, pi - 1);
            quickSortFirst(arr, pi + 1, high);
        }
    }

    public static int partitionFirst(int[] arr, int low, int high) {
        int pivot = arr[low]; // First element as pivot
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    // ----------- Quick Sort with Last Element as Pivot -----------
    public static void quickSortLast(int[] arr, int low, int high) {
        if (low < high) {
            recCallsLast++;
            int pi = partitionLast(arr, low, high);
            quickSortLast(arr, low, pi - 1);
            quickSortLast(arr, pi + 1, high);
        }
    }

    public static int partitionLast(int[] arr, int low, int high) {
        swap(arr, low, high); // Move last element to the front
        return partitionFirst(arr, low, high);
    }

    // ----------- Quick Sort with Median-of-Three Pivot -----------
    public static void quickSortMedian(int[] arr, int low, int high) {
        if (low < high) {
            recCallsMedian++;
            int pi = partitionMedian(arr, low, high);
            quickSortMedian(arr, low, pi - 1);
            quickSortMedian(arr, pi + 1, high);
        }
    }

    public static int partitionMedian(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        // Find median of arr[low], arr[mid], arr[high]
        int pivotIndex = medianOfThree(arr, low, mid, high);
        swap(arr, low, pivotIndex); // Move median to front
        return partitionFirst(arr, low, high);
    }

    // Utility to get index of median of three
    public static int medianOfThree(int[] arr, int i, int j, int k) {
        int a = arr[i], b = arr[j], c = arr[k];
        if ((a > b) != (a > c)) return i;
        else if ((b > a) != (b > c)) return j;
        else return k;
    }

    // Swap utility
    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        int[] original = {38, 27, 43, 3, 9, 82, 10};

        int[] arr1 = Arrays.copyOf(original, original.length);
        int[] arr2 = Arrays.copyOf(original, original.length);
        int[] arr3 = Arrays.copyOf(original, original.length);

        quickSortFirst(arr1, 0, arr1.length - 1);
        quickSortLast(arr2, 0, arr2.length - 1);
        quickSortMedian(arr3, 0, arr3.length - 1);

        System.out.println("Sorted Array (Any Strategy): " + Arrays.toString(arr1));

        System.out.println("\nRecursive Calls Comparison:");
        System.out.println("First Element Pivot : " + recCallsFirst);
        System.out.println("Last Element Pivot  : " + recCallsLast);
        System.out.println("Median-of-Three     : " + recCallsMedian);
    }
}
