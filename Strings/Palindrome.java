package src.Strings;
//check whether a string is palindrome or not
public class Palindrome {
    // returns 1 is input is a palindrome , else 0
    protected static int palindromecheck(String s,int start,int end)
    {

        int last = end;
        for (int i = start; i <= start + (end - start) / 2; ++i) {
            //System.out.println("char now is "+s.charAt(i) +"  "+s.charAt(end-i));
            if (s.charAt(i) != s.charAt(last))
                return 0;
            last--;
        }
        return 1;

    }
    public static void main(String[] args)
    {
        String input = "ajskhdfjahsdf";
        input ="abcba";
        input ="dfdbs";
        int res = palindromecheck(input,0,input.length()-1);
        if(res == 1 )
            System.out.println("the given string is palindrome");
        else
            System.out.println("the given string is not a palindrome");
    }
}
