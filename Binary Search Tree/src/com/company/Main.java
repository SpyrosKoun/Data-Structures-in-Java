package com.company;

public class Main {

    public static void main(String[] args) {

        /*Just a basic app to test the Binary Search Tree
        and its methods.*/
        BinarySearchTree Tree = new BinarySearchTree();

        Tree.addNode("K");
        Tree.addNode("B");
        Tree.addNode("B");
        Tree.addNode("Q");
        Tree.addNode("R");
        Tree.addNode("F");
        Tree.addNode("H");
        Tree.addNode("J");
        Tree.addNode("T");
        Tree.deleteString("T");

        //Could find Q so its element is displayed
        System.out.println( Tree.findNode( "Q",Tree.root() ).getElement() );

        //Could not find T so we display the element of the node
        //that would be T's parent, if T was in the Tree. In our
        //case it's R
        System.out.println( Tree.findNode( "T",Tree.root() ).getElement() );
    }
}
