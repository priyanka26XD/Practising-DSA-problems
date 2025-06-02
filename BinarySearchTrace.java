public class BinarySearchTrace {

    // Binary Search function
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        System.out.println("Tracing mid-values checked:");

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids overflow
            System.out.println("Mid index: " + mid + ", Value: " + arr[mid]);

            if (arr[mid] == key) {
                return mid; // Key found
            } else if (arr[mid] < key) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Key not found
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 15, 42, 55, 56, 77, 89, 95};
        int key = 42;

        int result = binarySearch(arr, key);

        if (result != -1) {
            System.out.println("Element " + key + " found at index: " + result);
        } else {
            System.out.println("Element " + key + " not found in the array.");
        }
    }
}
