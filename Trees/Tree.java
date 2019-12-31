package Trees;

// this class constructs a tree and assigns left child and right child
public class Tree {

    public int root;
    public Tree leftchild;
    public Tree rightchild;

    public Tree(){

    }
    public Tree(int data)
    {
        root = data;
        leftchild = null;
        rightchild = null;
    }

    public static Tree addChild(int currentvalue) // this adds a new child to the tree , left or right depends on the input
    {
        Tree obj = new Tree();
        obj.root = currentvalue;
        obj.leftchild = null;
        obj.rightchild = null;
        return obj;
    }

}
