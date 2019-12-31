package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

// now we will deserialize the file which we have serialized in Serialize.java
public class DeSerialize {
    public static void main(String[] args) throws IOException {

        try{
            System.out.println("file name is "+Serialize.filename);
            FileInputStream fp = new FileInputStream(Serialize.filename);
            ObjectInputStream ob = new ObjectInputStream(fp);
            Serialize obj = (Serialize)ob.readObject();
            ob.close();
            fp.close();
            System.out.println("the values are "+obj.data + "  "+obj.name);
        }
        catch(Exception e)
        {
            System.out.println("we have seen an exception in deserialing the obj");
            e.printStackTrace();
        }
    }
}
