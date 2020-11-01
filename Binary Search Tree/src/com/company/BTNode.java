package com.company;


public class BTNode {
    private BTNode Parent,Left,Right;
    private String element;
    private int duplicates;

    //Constructors
    public BTNode(){

    }

    public BTNode(String element,int duplicates,BTNode parent,BTNode right,BTNode left){
        setElement(element);
        setLeft(left);
        setParent(parent);
        setRight(right);
        setDuplicates(duplicates);
    }

    public BTNode getLeft() {
        return Left;
    }

    public void setLeft(BTNode left) {
        Left = left;
    }

    public BTNode getParent() {
        return Parent;
    }

    public void setParent(BTNode parent) {
        Parent = parent;
    }

    public BTNode getRight() {
        return Right;
    }

    public void setRight(BTNode right) {
        Right = right;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(int duplicates) {
        this.duplicates = duplicates;
    }
}
