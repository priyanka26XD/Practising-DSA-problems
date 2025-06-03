import java.util.*;

// Node of Huffman Tree
class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = this.right = null;
    }
}

// Comparator for PriorityQueue (min-heap based on frequency)
class HuffmanComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode n1, HuffmanNode n2) {
        return n1.freq - n2.freq;
    }
}

public class HuffmanCoding {

    // Build the Huffman Tree
    public static HuffmanNode buildTree(char[] chars, int[] freqs) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new HuffmanComparator());

        // Step 1: Create leaf nodes and insert in queue
        for (int i = 0; i < chars.length; i++) {
            pq.add(new HuffmanNode(chars[i], freqs[i]));
        }

        // Step 2: Combine two smallest nodes until one remains
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode merged = new HuffmanNode('-', left.freq + right.freq);
            merged.left = left;
            merged.right = right;

            pq.add(merged);
        }

        return pq.poll(); // Root node of the Huffman Tree
    }

    // Generate and print Huffman codes
    public static void printCodes(HuffmanNode root, String code) {
        if (root == null)
            return;

        // It's a leaf node → output the character and its code
        if (root.left == null && root.right == null && root.ch != '-') {
            System.out.println(root.ch + ": " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freqs = new int[n];

        System.out.println("Enter characters and their frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Character: ");
            chars[i] = sc.next().charAt(0);
            System.out.print("Frequency: ");
            freqs[i] = sc.nextInt();
        }

        HuffmanNode root = buildTree(chars, freqs);
        System.out.println("\nHuffman Codes:");
        printCodes(root, "");
    }
}
