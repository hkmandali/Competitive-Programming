package src.Strings;

public class AllNumstoBeginning {
    static String numtoBegin(String input)
    {
        int outlen = input.length();
        int num_index = outlen/2;
        int alphaindex = 0;
        char[] output = new char[outlen];
        for(int i=0;i<outlen;i+=2)
        {
            output[alphaindex++] = input.charAt(i);
            output[num_index++] = input.charAt(i+1);
        }
        return new String(output);
    }

    static String noExtramem(char[] input)
    {
        int outlen = input.length;
        int last_index = outlen-1;
        int charindex = outlen/2;
        for(int i=outlen-1;i>=0;i=i-2) // iterate through the array
        {
            char temp ='a';
        }
        int num_index = outlen/2;
        int alphaindex = 0;
        char[] output = new char[outlen];
        for(int i=0;i<outlen;i+=2)
        {
            //output[alphaindex++] = input.charAt(i);
            //output[num_index++] = input.charAt(i+1);
        }
        return new String(output);
    }
    public static void main(String[] args) {
        char[] input = "a1b2c3d4e5g7m3".toCharArray(); // given a string with num and alphabets alternating , we need to move all alphabets to beginning and nums to last
        System.out.println("the output array is "+ noExtramem(input));

    }
}
