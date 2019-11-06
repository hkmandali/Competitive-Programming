package DynamicProgramming;
// given a sequence find out the next number using the relation
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1 {
    private int findnext(int n)
    {
        if(n > 1)
        {
            int[] arr = new int[n+1];
            arr[0] = arr[1] =2;
            arr[2] = 2*arr[0]*arr[1];
            for(int i=3;i<n+1;++i)
            {
                arr[i] = 2 * arr[i-1]*arr[i-2] + arr[i-1];
            }
            return arr[n];
        }
        else
            return 2;
    }
    public static void main(String[] args) throws IOException {
        Prob1 obj = new Prob1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int res = obj.findnext(n);
        System.out.println(" the result is "+ res);
    }
}

