package src.Trees;

import java.util.ArrayList;
import java.util.Arrays;

class TreeNode
{
    int data;
    TreeNode leftchild;
    TreeNode rightchild;
    TreeNode(){

    }
    TreeNode(int key)
    {
        data = key;
        leftchild = null;
        rightchild = null;
    }
    TreeNode insertValue(int data)
    {
        TreeNode temp = new TreeNode();
        temp.data = data;
        temp.leftchild = null;
        temp.rightchild = null;
        return temp;
    }
}
public class PathofaNode {
    static ArrayList<Integer> printPath(TreeNode root,int value,ArrayList<Integer> pathTillNow)
    {

        if(root != null) {
            System.out.println("value of node is " + root.data);
            ArrayList<Integer> pathNow = new ArrayList<>(pathTillNow);
            pathNow.add(root.data);
            System.out.println("pathnow is " + pathNow);
            if (root.data == value) {
                System.out.println("returnning fromr here");
                return pathNow;
                /*
                for (int i = 0; i < pathNow.size(); ++i) {
                    System.out.print(pathNow.get(i) + "  ");
                }

                 */

            } else {

                ArrayList<Integer> pathforRight = new ArrayList<>(pathNow);
                System.out.println("in else path for right is  " + pathforRight);
                System.out.println("calling for left   " + pathNow);
                printPath(root.leftchild, value, pathNow);
                printPath(root.rightchild, value, pathforRight);

            }
        }
        //System.out.println("returnning fromr hewre");
        return null;
    }
    public static void main(String[] args)
    {
        TreeNode obj = new TreeNode(1);
        obj.leftchild = new TreeNode(2);
        obj.rightchild = new TreeNode(3);
        obj.leftchild.leftchild = new TreeNode(4);
        obj.leftchild.rightchild = new TreeNode(5);
        obj.leftchild.leftchild.leftchild = new TreeNode(6);
        obj.leftchild.leftchild.rightchild = new TreeNode(7);
        obj.leftchild.rightchild.leftchild = new TreeNode(8);
        obj.leftchild.rightchild.rightchild = new TreeNode(9);
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> out =  printPath(obj,9,path);
        System.out.println("out  is "+out);
        /*
        ArrayList<Integer> obj2 = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> obj1 = new ArrayList<>(obj2);
        obj1.add(5);
        System.out.println("result is "+Arrays.toString(obj2.toArray()));

         */
    }
}
