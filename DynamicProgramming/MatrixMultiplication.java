package DynamicProgramming;

public class MatrixMultiplication {
    // this function gets called recursively to findout which sequence produces the min
    // (ABCD) = A(BCD) = (AB)(CD) = ABC(D) and they can be taken recursively as sub probs
    private int minMul(int[] arr,int start,int end)
    {
        if(start == end) // because if there is only one matrix , the no of ways to multiply is zero
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k = start;k<end;++k)
        {
            int numWays = minMul(arr,start,k) // if we select any element k , it is the number of ways from start to k
            // i.e if ABCDE and k =3 it is (ABC)(DE) and in turn it is divided into sub prbs
                    + minMul(arr,k+1,end)  // it is from k+1 to end
                    + arr[start-1] * arr[k] * arr[end]; // this is because once everything
             // is multiplied the cost is rows * columns and the matrices start fropm arr[1] i.e
            // for first matrix the indices are arr[0] * arr[1]
            if(numWays < min)
                min = numWays;
        }
        return min;
    }
    // this has been implemented by watching tushar roy's video
    private int minMuldp(int[] arr,int size)
    {
        int[][] temparr = new int[size][size];
        for(int i=1;i<size;++i)
        {
            temparr[i][i] = 0; // as discussed above if only one matrix no of ways is zero ,
            // we didnt consider temparr[0][0] becuase the matrices start from index 1
        }
        int min = Integer.MAX_VALUE;

        for(int i=2; i <= size; ++i)
        {
            for(int j=1;j< size - i +1;++j)
            {
                int k = j+i -1;
                if(k == size) continue;
                temparr[j][k] = Integer.MAX_VALUE;
                for(int l = i+1;l<k;++l)
                {
                    int countways = temparr[j][l] + temparr[l][k] + arr[l]*arr[k]*arr[j];
                    if(countways < temparr[i][j]){
                        temparr[j][k] = countways;
                    }
                }
            }

        }
        return temparr[0][size-1];
    }
    public static void main(String[] args)
    {
        MatrixMultiplication obj = new MatrixMultiplication();
        int[] arr = {10,20,30,40,50}; // matrices 10 * 20 , 20 * 30 , 30 *40 , 40 *50
        //int[] arr = {2,3,6,4,5};
        int size = arr.length;
        int count = obj.minMul(arr,1,size-1); // 1 because the first matrix starts at that
        System.out.println("the min number of ways are "+count);
        int count2 = obj.minMuldp(arr,size);
        System.out.println("the min number of ways using dp are "+count2);
    }
}
