// this problem is an application of maximum increasing sub sequence , we need to find out the max height
// this has been implemented by watching Tushar roys video
package DynamicProgramming;

import java.util.Arrays;

public class BoxStacking {
    static private class Box implements Comparable<Box>
    {
        int length;
        int width;
        int height;

        public int BaseArea()
        {
            return width*length;
        }
        Box(int length,int width,int height)
        {
            this.length = length; // we consider length is >= width ,
            this.width = width;
            this.height = height;
        }
        public int compareTo(Box x)
        {
            return x.BaseArea()-this.BaseArea();
        }
    }

    static private int maxHeight(Box[] arr)
    {
        int numBoxes = arr.length;
        Box[] allrotatedBoxes = new Box[3*numBoxes];
        int[] res = new int[3*numBoxes]; // this tells us the max height achieved
        int[] index = new int[3*numBoxes]; // this tells us which box is on top of which box
        // generating all the different boxes for all combos
        for(int i=0;i<numBoxes;++i)
        {
            allrotatedBoxes[3*i] = new Box(Math.max(arr[i].length,arr[i].width),
                    Math.min(arr[i].length,arr[i].width),arr[i].height); // this box has same order
            allrotatedBoxes[3*i+1] = new Box(Math.max(arr[i].height,arr[i].length),
                    Math.min(arr[i].height,arr[i].length),arr[i].width);
            allrotatedBoxes[3*i+2] = new Box(Math.max(arr[i].width,arr[i].height),
                    Math.min(arr[i].width,arr[i].height),arr[i].length);
        }
        Arrays.sort(allrotatedBoxes); // sorted in terms of decreasing base area ,
        // such that the box with highest base area always comes to bottom

        for(int i=0;i<allrotatedBoxes.length;++i)
        {
            res[i] = allrotatedBoxes[i].height; // this tells us that if the boxes are not piled up ,
            // what is the maximum height they can achieve
            //System.out.println(" assgined a height of "+res[i] + " to index "+i);
            index[i] = 0; // which box is on top of which box , currently every box is at zero i.e no one is piled up
        }

        for(int i=1;i<res.length;++i)
        {
            for(int j =0;j<i;++j) // if i needs to go on top of j , i's base whoudl be less than j's base
            {
              /*  System.out.println(" for box "+j +" length " +allrotatedBoxes[j].length+ "  width is "+allrotatedBoxes[j].width
                +"  height is "+allrotatedBoxes[j].height);
                System.out.println(" for box "+i +" length " +allrotatedBoxes[i].length+ "  width is "+allrotatedBoxes[i].width
                        +"  height is "+allrotatedBoxes[i].height);

                // checking width and length
               */
                if(allrotatedBoxes[i].width < allrotatedBoxes[j].width  &&
                        (allrotatedBoxes[i].length < allrotatedBoxes[j].length ))
                // if both width and length of top box(i) are lesser than bottom box(j) , it can go on top of bottom box(j)
                    // on the condition that its height + bottom box height should be greater than urrent height
                {
                    // checking height
                    if(res[j] +allrotatedBoxes[i].height > res[i] )
                    {
                        // if the bo height + bottom box height is > curr height
                        // update the current height , same as longest increasing subsequence
                        res[i] = res[j] +allrotatedBoxes[i].height;
                        index[i] = j; // i is going on top of j
                    }
                }
            }
        }
        int max_height =0;
        int max_index=0; // this is used to know the index ar which max height is found
        for(int i=0;i<res.length;++i)
        {
            if(res[i] > max_height)
            {
                max_height = res[i]; // updating the max height
                max_index =i; // storing the max index , this will be on top and the box at index zero
                // will be at the lowest as it has the highest base area
            }
        }
        System.out.println("the boxes order goes as starting from top");

        while(max_index != 0)
        {
            System.out.println(allrotatedBoxes[max_index].length+" "
                    +allrotatedBoxes[max_index].width+" "+allrotatedBoxes[max_index].height);
            max_index = index[max_index];
        }

        System.out.println(allrotatedBoxes[0].length+" "+allrotatedBoxes[0].width+" "+allrotatedBoxes[0].height);
        return max_height;
    }
    public static void main(String[] args)
    {


        Box[] arr = new Box[5];
        arr[0] = new Box(2,1,3);
        arr[1] = new Box(3,2,4);
        arr[2] = new Box(4,3,5);
        arr[3] = new Box(5,4,6);
        arr[4] = new Box(6,5,7);

        int maxheight =maxHeight(arr);
        System.out.println("the max height achieved is "+maxheight);
    }
}
