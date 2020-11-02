package com.company;

public class BinarySearchTree{
    private BTNode root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;

    }

    public BinarySearchTree(BTNode root,int size){
        setRoot(root);
        setSize(size);
    }
    public BinarySearchTree(String item){
        root = new BTNode(item,1,null,null,null);
    }

    public BinarySearchTree(BTNode root){
        this.root = root;
    }



    //This is a simple search method for the key insString.                 !Not finding the node we are looking for example!
    //If the key we want to find is greater lexicographically                        (n == null)             Suppose we are searching for T.
    //than the key of the node we are in we go to the right child                       K                   T's place would be where the
    //and if its less we go to the left child of the node.                          / \                  arrow indicates. But its not in
    //If the key that we are searching for does not exist in                          B   R                 our tree so the function returns
    //the tree we return the node that would be the parent of                            / \                the node that should have been T's
    //the node that we are searching for if option is true                              n   n <---          parent.
    // or null if option is false
    public BTNode findNode (String insString,BTNode v,boolean option){

        //Getting the element of the node that we are
        //in so we can compare it to our searching word
        String nodeString = v.getElement();

        //String is greater than the current element -->Right
        if( insString.compareTo(nodeString) > 0 ){
            if (v.getRight() == null){
                if (option)
                    return v;
                return null;
            }
            else{
                return findNode(insString,v.getRight(),option);
            }
        }
        //String is equal to the current element
        else if(insString.compareTo(nodeString) == 0){
            return v;
        }
        //String is less than the current element -->Left
        else{
            if (v.getLeft() == null){
                if (option)
                    return v;
                return null;
            }
            else{
                return findNode(insString,v.getLeft(),option);
            }

        }
    }


    //Insert function
    public BTNode addNode(String insString){


        //Binary Search Tree is empty so we initialize the root and set size to 1
        if(size() == 0){
            setRoot(new BTNode(insString,1,null,null,null));
            setSize(1);
            return root();
        }


        //Trying to find if it already exists in the tree.
        //If it doesnt exist, we get the supposed parent as
        //explained in the findNode function above
        BTNode insNode = findNode(insString,root(),true);
        String stringNode = insNode.getElement();


        //Word already exists in the tree, so we increment duplicates
        if(stringNode.compareTo(insString) == 0){
            insNode.setDuplicates(root().getDuplicates()+1);
            return insNode;
        }
        //Doesnt exist and as I explained insNode now is the
        //parent of the node that we are going to create
        else{
            //Less than the parent so it goes to parent's left
            if (stringNode.compareTo(insString) > 0){
                    System.out.println("Going to store "+ insString +" to the left of the node: " + insNode.getElement());
                    insNode.setLeft(new BTNode(insString,1,insNode,null,null));
                    setSize(size()+1);
                    return insNode.getLeft();
                }
            //Greater than the parent so it goes to parent's right
            else{
                System.out.println("Going to store "+ insString +" to the right of the node: " + insNode.getElement());
                insNode.setRight(new BTNode(insString,1,insNode,null,null));
                setSize(size()+1);
                return insNode.getRight();
            }
        }

    }

    public BTNode deleteString(String delString) {
        if (size() == 0)
            return null;

        BTNode delNode = findNode(delString,root(),true);
        String stringNode = delNode.getElement();

        if(delNode != null) {//Node with element delString does not exist
                BTNode temp1;
                if ((delNode.getRight() == null) || (delNode.getLeft() == null)) {

                    temp1 = (delNode.getLeft() != null ? delNode.getLeft() : delNode.getRight() != null ? delNode.getRight() : delNode.getParent());
                    deleteNode(delNode);
                    return temp1;

                }

                BTNode temp2, delParent;

                temp2 = findSuccessor(delNode);

                exchangeElemnts(temp2, delNode);
                delNode.setRight(temp2.getRight());
                delParent = temp2.getParent();
                deleteNode(temp2);
                return delParent;
        }
        else{
            return null;
        }


    }
    public void deleteNode(BTNode delNode){
        if (isRoot(delNode)) {
            BTNode child = (delNode.getLeft() != null ? delNode.getLeft() : delNode.getRight());
            root = child;
            if (root.getParent() != null) {
                root.setParent(null);
            }
        }
        else {
            BTNode delParent = delNode.getParent();

            BTNode child = (delNode.getLeft() != null ? delNode.getLeft() : delNode.getRight());
            if ((delParent.getRight() != null) && (delParent.getRight().getElement().compareTo(delNode.getElement()) == 0)) {
                    delParent.setRight(child);
            }
            else if ((delParent.getLeft() != null) && (delParent.getLeft().getElement().compareTo(delNode.getElement()) == 0)){
                    delParent.setLeft(child);
            }
            if (child != null)
                child.setParent(delParent);
        }
        size--;
        delNode.setLeft(null);
        delNode.setRight(null);
        delNode.setParent(null);

    }


    public void setSize(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }

    public BTNode root() {
        return root;
    }

    public boolean isRoot(BTNode o){
        return (o == root);
    }

    //This is a function to exchange elements between 2 nodes
    public void exchangeElemnts(BTNode a,BTNode b){
        String temp = a.getElement();
        a.setElement(b.getElement());
        b.setElement(temp);

    }

    //Function to find the inorder successor of a node
    public BTNode findSuccessor(BTNode a){


        BTNode rightSubtree = a.getRight(), temp2;
        if (rightSubtree == null)
            return a;
        if(rightSubtree.getLeft() == null){
            return rightSubtree;
        }
        temp2 = a.getRight();

        while ((temp2 != null) && temp2.getLeft()!= null) {
            temp2 = temp2.getLeft();
        }
        return temp2;
    }

    //Function to find the inorder predecessor of a node
    public BTNode findPredecessor(BTNode a){


        BTNode leftSubtree = a.getLeft(), temp2;
        if (leftSubtree == null)
            return a;
        if(leftSubtree.getLeft() == null){
            return leftSubtree;
        }
        temp2 = a.getLeft();

        while ((temp2 != null) && temp2.getRight()!= null) {
            temp2 = temp2.getRight();
        }
        return temp2;
    }
}
