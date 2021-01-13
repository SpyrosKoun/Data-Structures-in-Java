import BST.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        /*Just a basic app to test the Binary Search Tree
        and its methods.*/
        BinarySearchTree Tree = new BinarySearchTree();

        //Adding various letters to form a Binary Search Tree
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

        //Deleting some nodes with no kids, one kid or two kids
        Tree.deleteString("S");
        Tree.deleteString("Y");
        Tree.deleteString("K");
        Tree.deleteString("F");
        Tree.deleteString("Q");

        try {
            System.out.println( Tree.findNode( "T",Tree.root(),false ).getElement() );
            System.out.println( Tree.findNode( "Q",Tree.root(),false).getElement() );
            System.out.println(Tree.findSuccessor(Tree.findNode("Q", Tree.root(), false)).getElement());
        }
        catch (NullPointerException e){
            System.out.println("Error occurred.Function findNode returned null.");
            System.out.println("Element does not exist in the Binary Search Tree");
        }
    }
}
