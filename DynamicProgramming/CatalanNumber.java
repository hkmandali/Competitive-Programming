package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatalanNumber { // number of BST's possible for a given no of vertices
    private int getcatalan(int n)
    {
        int[] arr = new int[n+1];
        int len = arr.length;
        arr[0] =1; // because we multiply
        arr[1]= 1;
        for(int i=2;i<len;++i)
        {
            arr[i] =0;
            for(int j=0;j<i;++j)
            {
                arr[i] += arr[j] * arr[i-j-1];
            }
        }
        return arr[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the number");
        int n = Integer.parseInt(br.readLine());
        CatalanNumber obj = new CatalanNumber();
        int res = obj.getcatalan(n);
        //int t = obj.hashCode();
        System.out.println("the number of Bst's possible are "+res);

    }
}
