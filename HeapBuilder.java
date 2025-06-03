import java.util.Arrays;

public class HeapBuilder {

    // Function to build Min-Heap
    public static void buildMinHeap(int[] arr) {
        int n = arr.length;
        // Start from the last internal node and heapify each one
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, n, i);
        }
    }

    // Heapify subtree rooted at i for Min-Heap
    private static void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {
            // Swap and continue heapifying
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(arr, n, smallest);
        }
    }

    // Function to build Max-Heap
    public static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    // Heapify subtree rooted at i for Max-Heap
    private static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] input = {9, 5, 6, 2, 3};

        // Build and display Min-Heap
        int[] minHeap = Arrays.copyOf(input, input.length);
        buildMinHeap(minHeap);
        System.out.println("Min-Heap: " + Arrays.toString(minHeap));

        // Build and display Max-Heap
        int[] maxHeap = Arrays.copyOf(input, input.length);
        buildMaxHeap(maxHeap);
        System.out.println("Max-Heap: " + Arrays.toString(maxHeap));
    }
}
