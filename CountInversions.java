public class CountInversions {

    // Wrapper function
    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    // Modified merge sort
    private static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count in left half
            count += mergeSort(arr, left, mid);

            // Count in right half
            count += mergeSort(arr, mid + 1, right);

            // Count while merging
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    // Merge and count inversions
    private static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;      // pointer for left subarray
        int j = mid + 1;   // pointer for right subarray
        int k = 0;         // pointer for temp array
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i] > arr[j], so count all remaining elements in left subarray
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        // Copy remaining elements
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // Copy back to original array
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }

        return invCount;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int inversions = countInversions(arr);
        System.out.println("Total Inversions: " + inversions);
    }
}
