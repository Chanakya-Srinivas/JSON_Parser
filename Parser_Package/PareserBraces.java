package Parser_Package;

import java.io.BufferedReader;

public class PareserBraces extends ParseObject{

//    BufferedReader reader;
    boolean child;

    PareserBraces(boolean child){
//        this.reader = reader;
        this.child = child;
    }

    public int checkObject(){
        try{
//            System.out.println("braces");
            if(!child)
                lastLine=reader.readLine().trim();
            int flag = -1;
            while((line!=null && line.length()>0)  || lastLine!=null){
                if(line==null || line.length()==0) {
                    line = lastLine.trim();
                    lastLine = reader.readLine();
                }
                if(lastLine==null){
                    if(line.charAt(line.length()-1)!='}') {
                        if(child)
                            return -1;
                        return printMessage(" is Invalid JSON file", 1);
                    }
                    line = line.substring(0,line.length()-1).trim();
                }
                while(line.length()>0){
                    int i = 0;
                    switch (flag){
                        case -1:
                            if(child && line.charAt(0)=='}')
                                return 1;
                        case 0:
                            i = checkKey();
                            if(i==-1) {
                                reader.close();
                                if(child)
                                    return -1;
                                throw new Exception(" is Invalid JSON file");
                            }
                            line = line.substring(i).trim();
                            flag = 1;
                            if(line.length()==0)
                                break;
                        case 1:
                            if(line.length()>0 && line.charAt(0)!=':'){
                                reader.close();
                                if(child)
                                    return -1;
                                throw new Exception(" is Invalid JSON file");
                            }
                            line = line.substring(1).trim();
                            flag = 2;
                            if(line.length()==0)
                                break;
                        case 2:
                            i = checkValue(reader);
                            if(i==-1 || lastLine == null){
                                reader.close();
                                if(child)
                                    return -1;
                                throw new Exception(" is Invalid JSON file");
                            }
                            line = line.substring(i).trim();
                            flag = 3;
                            if(line.length()==0)
                                break;
                        case 3:
                            if(child && line.charAt(0)=='}')
                                return 1;
                            if(line.length()>0 && line.charAt(0)!=','){
                                reader.close();
                                if(child)
                                    return -1;
                                throw new Exception(" is Invalid JSON file");
                            }
                            line = line.substring(1).trim();
                            flag = 0;
                    }
                }
            }
            reader.close();
            if(flag==0){
                reader.close();
                if(child)
                    return -1;
                throw new Exception(" is Invalid JSON file");
            } else if(child){
                return 0;
            }
            return printMessage(" is Valid JSON file",0);
        } catch(Exception e){
            return printMessage(e.getMessage(),1);
        }
    }

}
