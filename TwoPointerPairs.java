public class TwoPointerPairs {

    public static void findPairs(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == target) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                i++;
                j--;

                // Skip duplicates
                while (i < j && arr[i] == arr[i - 1]) i++;
                while (i < j && arr[j] == arr[j + 1]) j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 6};  // sorted array
        int target = 7;

        System.out.println("Pairs with sum = " + target + ":");
        findPairs(arr, target);
    }
}
