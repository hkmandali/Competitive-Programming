package src.Math;
// 5 is not present in number line return the give value in actual numberline
//
public class NumberLinewithout5 {
    static int countmissed(int input) // this function returns the number of numbers missed in between 1 and the input
    {
        if(input < 6)
            return 0;
        else if(input <10)
            return 1;
        else
        {
            int numdigits = (int) Math.log10(input);
            // missed[i] contains the number of numbers missed till 1 to 10 pow i
            int[] missed = new int[numdigits+1]; // this array contains the number of 5's missed till that number in pow 10 manner
            missed[0] =1;
            missed[1] =1;
            for(int i=2;i<missed.length;++i)
            {
                missed[i] = (int) (9*missed[i-1] + Math.pow(10,i-1));
            }
            int prev10pow = (int) Math.pow(10,numdigits); // this has the previous 10 pow vefore this num
            int rem = (input % prev10pow);
            if(rem == 0)
                return missed[numdigits];
            int firstdig = input / prev10pow;
            if(firstdig < 6)
            {

                // suppose the given num is 1428 , we break it down to 1-1000 + 1001 - 1428
                        // 1-1000        + 1001-1400                              + 1401 - 1428
                return missed[numdigits] + firstdig*missed[(int) Math.log10(rem)] + countmissed((int) (rem%Math.pow(10,(int) Math.log10(rem))));
            }
            else
            {
                // 5 is till 1500 for eg

                // for eg if we have 1628 , the ans is 1-1000 + 1001 - 1499 + 1500 - 1599 + 1600 - 1628
                            // 1-1000           + 5* 1-100 i.e ( 1001 -1499)      + 100 (i.e 10 pow 2)           + 628 - 600
                return (int) (missed[numdigits] + 5*missed[(int) Math.log10(rem)] + Math.pow(10,Math.log10(rem)) + countmissed((int) (rem- 6*Math.pow(10,Math.log(rem)))));
            }



        }
    }
    public static void main(String[] args) {
        int missed = countmissed(528);
        System.out.println("the number of missed are "+missed);
    }
}
