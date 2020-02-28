package src.Math;
// return 0 and 1 with equal prob
public class BiasedCoin {
    // if we have a function which returns 0 and 1 with 0.6 and 0.4 probability
    // then 0 followed by 1 has == 0.6 * 0.4 = 0.24 prob
    // 1 followed by 0 == 0.4 * 0.6 = 0.24 prob
    // so both occur with equal probability
    //  0 followed by 0 = 0.36
    // 1 followed by 1 = 0.16 prob
    // 0,1 and 1,0 have equal prob
    // so in once case we return 0 and other case we return 1
    static int myfun()
    {
        return 0 |1; // this needs to be changed to 0.6 and 0.4
    }
    static int equalprob()
    {
        int a = myfun();
        int b = myfun();
        if(a ==0 && b==1) // this with 0.6 * 0.4 = 0.24 prob
        {
            return 0;
        }
        else if(a==1 && b==0)// this with 0.4 * 0.6 = 0.24 prob , so both with equal probability
            return 1;
        else
            return equalprob();

    }
    public static void main(String[] args) {
        for(int i=0;i<30;++i)
        {
            System.out.println(equalprob());
        }
    }
}
