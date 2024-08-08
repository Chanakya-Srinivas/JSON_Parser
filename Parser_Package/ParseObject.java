package Parser_Package;

import java.io.BufferedReader;

public abstract class ParseObject {

    String fileName;
    String line;
    String lastLine;
    BufferedReader reader;

    public int printMessage(String message,int code){
        System.out.println(fileName + message);
        return code;
    }
    public int checkKey(){
        if(line.charAt(0)!='"')
            return -1;
        int i=1;
        while(i<line.length()&&line.charAt(i)!='"') {
            if(line.charAt(i)=='\\'){
                i++;
                if(i<line.length()&&(line.charAt(i)!='"'||line.charAt(i)!='t'))
                    return -1;
            }
            i++;
        }
        return i<line.length()?i+1:-1;
    }

    public int checkBooleanAndNull(){
        String value = line.length()>=5 ? line.substring(0,4) : "";
        if(value.equals("null") || value.equals("true"))
            return 4;
        if((value+line.charAt(4)).equals("false"))
            return 5;
        return -1;
    }

    public int checkNum(){
        int i=0;
        int ch = line.charAt(0)-'0';
        while(ch>=0 && ch<10){
            i++;
            if(i==line.length())
                break;
            ch = line.charAt(i)-'0';
        }
        return i;
    }

    public int checkValue(BufferedReader reader){

        char firstChar = line.charAt(0);

        if(firstChar == '"') {
            return checkKey();
        } else if (firstChar == 'n' || firstChar == 't' || firstChar == 'f') {
            return checkBooleanAndNull();
        } else if(firstChar-'0'>=0 && firstChar-'0'<10){
            return checkNum();
        } else if (firstChar == '{') {
            ParseObject object = new PareserBraces(true);
            object.reader = reader;
            object.line = line.substring(1).trim();
            object.lastLine = lastLine;
            object.fileName = fileName;
            int tmp = object.checkObject();
            line = object.line;
            lastLine = object.lastLine;
            return tmp;
        } else if (firstChar == '[') {
            ParseObject object = new ParseList(true);
            object.reader = reader;
            object.line = line.substring(1).trim();
            object.lastLine = lastLine;
            object.fileName = fileName;
            int tmp = object.checkObject();
            line = object.line;
            lastLine = object.lastLine;
            return tmp;
        }
        return -1;
    }

    public abstract int checkObject();
}
