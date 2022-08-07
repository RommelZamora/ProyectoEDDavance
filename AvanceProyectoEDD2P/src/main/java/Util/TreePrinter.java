package Util;

import TDAs.BinaryTree;

public class TreePrinter {

    private static final int COUNT = 40;

    private static void print2DUtil(BinaryTree tree, int space) {
        // Base case
        if(tree == null){
            return;
        }
        if (tree.isEmpty()) {
            return;
        }
        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(tree.getRight(), space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(tree.getRootContent() + "\n");

        // Process left child
        print2DUtil(tree.getLeft(), space);
    }

// Wrapper over print2DUtil()
    public static void print2D(BinaryTree root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
}
