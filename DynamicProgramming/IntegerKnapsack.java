package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// given a list of items and their values , give the maximum value within the specified weight
// the values can be taken as a whole and not in fractions
public class IntegerKnapsack {
    private int maxvalue(int[] weightarr,int[] valarr,int weight,int index)
    {
        // here we go from last index to start index by considering the item or discarding it
        if(index == -1 || weight <= 0)
            return 0;
        // 1. there are two cases , if the weight of current item is greater than weight required
        // then we need to discard this item and proceed for lower items
        if(weightarr[index] > weight)
            return maxvalue(weightarr,valarr,weight,index-1);
        // 2. if the current is included in the list then the
        // max value of weight - curr item weight needs to be calculated or the lower items weight
        else
            return Math.max(maxvalue(weightarr,valarr,weight,index-1), // excluding the current item
                    valarr[index] + maxvalue(weightarr,valarr,weight-weightarr[index],index-1));// including the current item
    }
    private int maxvaluedp(int[] weightarr,int[] valarr,int weight)
    {
        int totalrow = valarr.length;
        int[][] valuetoweightarr= new int[valarr.length +1][weight+1]; // items vs weight plotting
        // num of  items * weight  matrix
        int v,w;
        for(v=0;v<totalrow +1;++v)  // basically the index or num items
        {
            for(w=0;w<=weight;++w) // instead of maintaining the weight array , we are directly accessing the weights
            {
                if(v == 0 || w == 0)
                {
                    valuetoweightarr[v][w] = 0;//becuase there is no weight or value to be considred
                }
                else if(weightarr[v-1] > w)
                    valuetoweightarr[v][w]= valuetoweightarr[v-1][w];
                else
                    valuetoweightarr[v][w] = Math.max(valuetoweightarr[v-1][w] , // excluding the current item
                        valarr[v-1] + valuetoweightarr[v-1][w-weightarr[v-1]]);// including the current item
            }
        }

        return valuetoweightarr[totalrow][weight];
    }

    public static void main(String[] args) throws IOException
    {
        IntegerKnapsack obj = new IntegerKnapsack();
        int weightarr[] = {10,20,30,40};
        int valarr[] = {210,30,40,50};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the weight");
        int weight = Integer.parseInt(br.readLine());
        int max_value = obj.maxvalue(weightarr,valarr,weight,weightarr.length -1);
        System.out.println("the max value obtained is "+max_value);
        int max_value2 = obj.maxvaluedp(weightarr,valarr,weight );
        System.out.println("the max valuesuing dp obtained is "+max_value2);

    }
}
