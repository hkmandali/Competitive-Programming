package Trees;

public class InorderTraversal {
    public static void inorder(Tree obj)
    {
        if(obj == null)
        {
            return;
        }
        inorder(obj.leftchild);
        System.out.print(obj.root+" ");
        inorder(obj.rightchild);
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
        inorder(obj);
    }
}
