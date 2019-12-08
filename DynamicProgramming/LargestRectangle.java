package DynamicProgramming;

import java.util.Stack;

// find the maximum area of the rectangle in a series of histograms
public class LargestRectangle {
    static int maximumarea(int[] blocks)
    {
        int num_towers = blocks.length;
        int maxarea =0,curr_area;
        int top=0;
        Stack<Integer> s= new Stack<>();
        // we keep pushing all the towers to the stack till a tower with lower height is seen
        // once a lower tower is seen , keep popping till the top of the stack is less than that and calculate areas for them
        // we need to find out the max area with every block as height and for that we need to right index and left index
        // till which the curr height can be extended
        // right index will be curr index and left index will be top of the stack
        int i=0;
        while(i<num_towers)
        {
            if(s.empty() || (blocks[s.peek()] <= blocks[i]))
            {
                System.out.println(" curr size is "+s.size() +"  pushing "+blocks[i]);
                s.push(i); // we push the blocks index number
                i++; // increasing the counter
            }
            else
            {
                top = s.pop();
                if(s.size() == 0)
                    curr_area = (i)*blocks[top];
                else
                    curr_area = (i-s.peek()-1)*blocks[top];
                System.out.println(" top is "+top+"  i is "+i +"  curr area is  "+curr_area);
                if(curr_area > maxarea)
                    maxarea = curr_area;
            }
        }
        System.out.println("poppong now");
        while(!s.empty())
        {
            top = s.pop();
            if(s.size() == 0)
                curr_area = (i)*blocks[top];
            else
                curr_area = (i-s.peek()-1)*blocks[top];
            System.out.println(" top is "+top+"   size is "+s.size()+"   i is "+i +"  curr area is  "+curr_area);
            if(curr_area > maxarea)
                maxarea = curr_area;
        }

        return maxarea;
    }
    public static void main(String[] args)
    {
        int[] towers ={6,2,5,4,5,1,6}; // eg: from gfg
        int max_area = maximumarea(towers);
        System.out.println("the maximum area enclosing the towers is "+max_area);
    }
}
