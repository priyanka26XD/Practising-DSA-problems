public class HeapSort {

    // Function to sort an array using Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // STEP 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Print the heap
        System.out.print("Max Heap: ");
        printArray(arr);

        // STEP 2: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);

            // Print heap after each step
            System.out.print("Heap after removing max: ");
            printArray(arr);
        }
    }

    // Function to maintain max-heap property
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Utility function to print array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        System.out.print("Original Array: ");
        printArray(arr);

        heapSort(arr);

        System.out.print("Sorted Array: ");
        printArray(arr);
    }
}
