public class MedianOfTwoSortedArrays {

    // Function to find median of a single sorted array
    private static double median(int[] arr, int start, int end) {
        int len = end - start + 1;
        int mid = start + (end - start) / 2;
        if (len % 2 == 0) {
            return (arr[mid] + arr[mid + 1]) / 2.0;
        } else {
            return arr[mid];
        }
    }

    // Function to find median of two sorted arrays of same size
    public static double findMedian(int[] A, int[] B, int startA, int endA, int startB, int endB) {
        // Base case: Only two elements in each array
        if (endA - startA == 1) {
            int maxLeft = Math.max(A[startA], B[startB]);
            int minRight = Math.min(A[endA], B[endB]);
            return (maxLeft + minRight) / 2.0;
        }

        double m1 = median(A, startA, endA);
        double m2 = median(B, startB, endB);

        // If medians are equal
        if (m1 == m2) return m1;

        // If m1 < m2, median must be in A[mid...end] and B[start...mid]
        if (m1 < m2) {
            int newStartA = (startA + endA + 1) / 2;
            int newEndB = (startB + endB + 1) / 2;
            return findMedian(A, B, newStartA, endA, startB, newEndB);
        } else {
            int newEndA = (startA + endA + 1) / 2;
            int newStartB = (startB + endB + 1) / 2;
            return findMedian(A, B, startA, newEndA, newStartB, endB);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 12, 15, 26, 38};
        int[] B = {2, 13, 17, 30, 45};

        int n = A.length;

        double median = findMedian(A, B, 0, n - 1, 0, n - 1);
        System.out.println("Median of the two sorted arrays is: " + median);
    }
}
