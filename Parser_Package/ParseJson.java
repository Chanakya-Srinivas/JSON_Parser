package Parser_Package;

import java.io.BufferedReader;
import java.io.FileReader;

public class ParseJson {


    String fileName;
    ParseObject object;

    ParseJson(String fileName){
        this.fileName = fileName;
    }

    public int printMessage(String message,int code){
        System.out.println(fileName + message);
        return code;
    }

    public int checkJson(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            char ch = (char)reader.read();
            if (ch != '{' && ch != '[')
                return printMessage(" is Invalid JSON file", 1);
            object = (ch == '{') ? new PareserBraces(false) : new ParseList(false);
            object.reader = reader;
            object.fileName = fileName;
            return object.checkObject();
        } catch (Exception e){
            return 1;
        }

    }

}
