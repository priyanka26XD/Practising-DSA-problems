import java.util.Random;

public class QuickSelect {

    // Main function to find kth smallest element
    public static int quickSelect(int[] arr, int k) {
        return quickSelectHelper(arr, 0, arr.length - 1, k - 1); // k-1 for 0-based indexing
    }

    // Helper function (recursive)
    private static int quickSelectHelper(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(arr, low, high);

            if (pivotIndex == k) {
                return arr[pivotIndex]; // Found kth smallest
            } else if (pivotIndex > k) {
                return quickSelectHelper(arr, low, pivotIndex - 1, k); // Search left part
            } else {
                return quickSelectHelper(arr, pivotIndex + 1, high, k); // Search right part
            }
        }

        return -1; // Invalid case
    }

    // Partition function using randomized pivot
    private static int partition(int[] arr, int low, int high) {
        // Random pivot selection
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);
        swap(arr, pivotIndex, high); // Move pivot to end

        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high); // Place pivot in correct position
        return i;
    }

    // Swap helper
    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int result = quickSelect(arr, k);
        System.out.println(k + "rd smallest element is: " + result);
    }
}
