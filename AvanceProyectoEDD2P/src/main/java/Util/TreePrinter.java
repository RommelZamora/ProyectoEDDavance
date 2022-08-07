package Util;

import TDAs.BinaryTree;

public class TreePrinter {

    private static final int COUNT = 40;

    private static void print2DUtil(BinaryTree tree, int space) {
        if(tree == null){
            return;
        }
        if (tree.isEmpty()) {
            return;
        }
        space += COUNT;
        print2DUtil(tree.getRight(), space);
        System.out.print("\n");
        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(tree.getRootContent() + "\n");
        print2DUtil(tree.getLeft(), space);
    }
    /**
     * Imprime un árbol binario en dos dimensiones
     * @param tree árbol binario 
     */
    public static void print2D(BinaryTree tree) {
        print2DUtil(tree, 0);
    }
}
