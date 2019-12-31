package Trees;
// the class traverses the tree in prefix i.e first root and then left child followed by right child

public class PreOrderTraversal {
    public static void preorder(Tree obj)
    {
        if(obj == null)
        {
            return;
        }
        System.out.print(obj.root+" ");
        preorder(obj.leftchild);
        preorder(obj.rightchild);
    }
    public static void main(String[] args)
    {
        Tree obj = new Tree(1);
        obj.leftchild = obj.addChild(2);
        obj.rightchild = obj.addChild(3);
        obj.leftchild.leftchild = obj.addChild(4);
        obj.leftchild.rightchild = obj.addChild(5);
        obj.leftchild.leftchild.leftchild = obj.addChild(6);
        obj.leftchild.leftchild.rightchild = obj.addChild(7);
        obj.leftchild.rightchild.leftchild = obj.addChild(8);
        obj.leftchild.rightchild.rightchild = obj.addChild(9);
        preorder(obj);

    }
}
