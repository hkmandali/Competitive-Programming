package Serialization;

import java.io.*;

public class Serialize implements Serializable {
    int data;
    String name;
    static String filename = "absolute _path";;
    Serialize(int num,String name)
    {
        this.data = num;
        this.name = name;
    }

    Serialize() {
    }

    public static void main(String[] args) throws IOException {
        Serialize obj = new Serialize(1,"testname");
        // serialization is the process of converting the object into bytestream
        try {
            FileOutputStream fp = new FileOutputStream(filename);
            ObjectOutputStream ob = new ObjectOutputStream(fp);

            ob.writeObject(obj);
            System.out.println("serialized");
            ob.close();
            fp.close();
        }
        catch (Exception e)
        {
            System.out.println("excpetion is caught while serializing");
            e.printStackTrace();
        }
    }
}
