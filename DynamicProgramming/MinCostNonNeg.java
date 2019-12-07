package src.DynamicProgramming;
// given an array with weights in each cell , find the min cost required to go to that cell from (0,0)
// direction can be only down or right
// for any cell the min cost can be thought of as MinCost[i,j] = Min(MinCost[i-1,j-1] , MinCost[i,j-1],MinCost[i-1,j]) + cost(i,j)
// arr contains the weights of those respective cells
public class MinCostNonNeg {
    static int mincost(int[][] arr,int m , int n)
    {
        int[][] resarr = new int[m][n];
        resarr[0][0] = arr[0][0];
        for(int i=1;i<m;++i)
        {
            resarr[i][0] = resarr[i-1][0] + arr[i][0];
        }
        for(int j=1;j<n;++j)
        {
            resarr[0][j] = resarr[0][j-1] + arr[0][j];
        }
        for(int i=1;i<m;++i)
        {
            for(int j=1;j<n;++j)
            {
                int currmax = Math.min(resarr[i][j-1],resarr[i-1][j]);
                resarr[i][j] = Math.min(resarr[i-1][j-1],currmax) + arr[i][j];
            }
        }
        return resarr[m-1][n-1];
    }
    public static void main(String[] args)
    {
        int[][] arr= { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        ,{3,4,5}};
        int col = arr[0].length;
        int row = arr.length;
        System.out.println("rows are "+row+"  columns are "+col);
        int res = mincost(arr,row,col);
        System.out.println(" result is "+res);
    }
}
