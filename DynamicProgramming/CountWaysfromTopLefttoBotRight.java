package src.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

// find the number of ways to reach from top left to bottom right in a m * n grid ,
public class CountWaysfromTopLefttoBotRight {
    static int numways(int m ,int n)
    {
        int[][] arr = new int[m][n];
        for(int i=0;i<m;++i)
        {
            arr[i][0] =1;
        }
        for(int j=0;j<n;++j)
        {
            arr[0][j] =1;
        }
        for(int i=1;i<m;++i)
        {
            for(int j=1;j<n;++j)
            {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        return arr[m-1][n-1];
    }
    public static void main(String[] args) throws IOException {
        System.out.println(" enter the two dimmensons");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(System.in);
        String s = br.readLine();
        String[] x = s.split("\\s");
        int m = Integer.parseInt(x[0]);
        int n = Integer.parseInt(x[1]);
        int res = numways(m,n);
        System.out.println(" the num of ways are "+res);
    }
}
