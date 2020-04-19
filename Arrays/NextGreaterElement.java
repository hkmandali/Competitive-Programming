package src.Arrays;
// given an array we need to findout next greater element for each of the array element

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    int[] nextgreater(int[] input,int[] output)
    {
        int len = input.length;
        output[len-1] =0;
        Stack<Integer> s= new Stack<>();
        for(int i=len-1;i>=0;--i)
        {

            while (!s.isEmpty() && s.peek() <= input[i] )
                s.pop();

            if(s.isEmpty())
            {
                output[i] =0;
            }
            else {
                output[i] = s.peek();
            }

            s.push(input[i]);
        }

        return output;
    }
    public static void main(String[] args) {
        int[] input ={3,1,2,4};
        int[] output = new int[input.length];
        output = new NextGreaterElement().nextgreater(input,output);
        System.out.println("the output array is "+ Arrays.toString(output));
    }
}
