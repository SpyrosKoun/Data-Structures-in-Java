package BST;

public class BTNode {
    private BTNode Parent,Left,Right;
    private String element;
    private int duplicates;

    //Constructors
    public BTNode(){

    }

    public BTNode(String element, int duplicates){
        this.element = element;
        this.duplicates = duplicates;
        this.Parent = null;
        this.Right = null;
        this.Left = null;
    }

    public BTNode(String element,int duplicates,BTNode parent,BTNode right,BTNode left){
        this.element = element;
        this.duplicates = duplicates;
        this.Parent = parent;
        this.Right = right;
        this.Left = left;
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
