package src.Math;
// generate 0 and 1's with 25 and 75 probability
public class gen0and1with2575pro {
    static int rand50()
    {
        double a = 10*Math.random(); // math.random returns between 0 and 1
        int b =(int)a & 1;
        //System.out.println(" b is "+b);
        return b;
    }
    static int myfun()
    {

        return rand50() | rand50();
    }
    public static void main(String[] args) {

        for(int i=0;i<15;++i)
            System.out.print(myfun());

    }
}
