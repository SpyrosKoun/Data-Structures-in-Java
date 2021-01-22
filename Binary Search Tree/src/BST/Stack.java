package BST;

import javax.print.DocFlavor;

public class Stack {

    private StackNode root;

    static class StackNode{
        int data;
        StackNode next;

        StackNode(int data){
            this.data = data;
            next = null;
        }
    }

    public Stack(){
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void push(int data){

        StackNode newNode = new StackNode(data);

        if (isEmpty()){
            root = newNode;
        }
        else{
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
    }

    public StackNode pop(){
        if (isEmpty()){
            return null;
        }

        StackNode pop = root;
        root = root.next;
        return pop;

    }

    public int peek(){
        if (isEmpty()){
            return Integer.MIN_VALUE;
        }
        return root.data;
    }

    public void printStack(){
        StackNode temp = root;
        while(temp != null){
            System.out.println("|"+temp.data+"|");
            temp = temp.next;
        }
    }


}
