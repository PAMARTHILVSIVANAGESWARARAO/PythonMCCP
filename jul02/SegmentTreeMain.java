import java.util.Scanner;

class SegmentTreeNode {
    int start;
    int end;
    int sum;

    SegmentTreeNode left;
    SegmentTreeNode right;

    SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.left = null;
        this.right = null;
    }
}

class SegmentTree {

    SegmentTreeNode root;

    SegmentTree(int[] arr) {
        root = buildTree(arr, 0, arr.length - 1);
    }

    // Build Segment Tree
    private SegmentTreeNode buildTree(int[] arr, int start, int end) {

        if (start > end)
            return null;

        SegmentTreeNode node = new SegmentTreeNode(start, end);

        // Leaf Node
        if (start == end) {
            node.sum = arr[start];
            return node;
        }

        int mid = start + (end - start) / 2;

        node.left = buildTree(arr, start, mid);
        node.right = buildTree(arr, mid + 1, end);

        node.sum = node.left.sum + node.right.sum;

        return node;
    }

    // Range Sum Query
    public int rangeSum(int left, int right) {
        return rangeSum(root, left, right);
    }

    private int rangeSum(SegmentTreeNode node, int left, int right) {

        if (node == null)
            return 0;

        // No Overlap
        if (node.end < left || node.start > right)
            return 0;

        // Complete Overlap
        if (node.start >= left && node.end <= right)
            return node.sum;

        // Partial Overlap
        return rangeSum(node.left, left, right)
                + rangeSum(node.right, left, right);
    }

    // Print Tree (Inorder)
    public void display() {
        display(root);
    }

    private void display(SegmentTreeNode node) {

        if (node == null)
            return;

        display(node.left);

        System.out.println(
                "[" + node.start + "," + node.end + "] -> Sum = " + node.sum);

        display(node.right);
    }
}

public class SegmentTreeMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements :");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        SegmentTree tree = new SegmentTree(arr);

        System.out.println("\nSegment Tree Nodes:");
        tree.display();

        char ch;

        do {

            System.out.print("\nEnter Left Index : ");
            int left = sc.nextInt();

            System.out.print("Enter Right Index : ");
            int right = sc.nextInt();

            if (left < 0 || right >= n || left > right) {
                System.out.println("Invalid Range");
            } else {
                int ans = tree.rangeSum(left, right);
                System.out.println("Range Sum = " + ans);
            }

            System.out.print("\nDo you want to continue (y/n)? ");
            ch = sc.next().charAt(0);

        } while (ch == 'y' || ch == 'Y');

        sc.close();
    }
}