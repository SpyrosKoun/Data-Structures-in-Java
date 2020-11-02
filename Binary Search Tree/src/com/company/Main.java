package com.company;

public class Main {

    public static void main(String[] args) {

        /*Just a basic app to test the Binary Search Tree
        and its methods.*/
        BinarySearchTree Tree = new BinarySearchTree();


        Tree.addNode("K");
        Tree.addNode("F");
        Tree.addNode("Q");
        Tree.addNode("I");
        Tree.addNode("C");
        Tree.addNode("A");
        Tree.addNode("E");
        Tree.addNode("N");
        Tree.addNode("P");
        Tree.addNode("V");
        Tree.addNode("S");
        Tree.addNode("Y");
        Tree.addNode("W");
        Tree.addNode("R");
        Tree.addNode("T");
        //Tree.deleteString("V");

        //Could find Q so its element is displayed
        System.out.println( Tree.findNode( "Q",Tree.root() ).getElement() );

        //Could not find T so we display the element of the node
        //that would be T's parent, if T was in the Tree. In our
        //case it's R
        System.out.println( Tree.findNode( "V",Tree.root() ).getElement() );

        System.out.println(Tree.findSuccessor( Tree.findNode("V",Tree.root() ) ).getElement());
        System.out.println(Tree.findPredecessor( Tree.findNode("V",Tree.root() ) ).getElement());
    }
}
