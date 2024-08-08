//package Parser_Package;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.Stack;
//
//public class Parser{
//
//    String fileName;
//
//    Parser(String fileName){
//        this.fileName = fileName;
//    }
//
//    public int printMessage(String message,int code){
//        System.out.println(fileName + message);
//        return code;
//    }
//
//    public int isValid(){
//        try{
//            BufferedReader reader = new BufferedReader(new FileReader(fileName));
//            if(reader.read()!='{')
//                return printMessage(" is Invalid JSON file",1);
//            String lastLine = null,line=reader.readLine();
//            int comma = 0;
//            Stack<Character> track = new Stack<>();
//            while(line!=null){
//                lastLine = line;
//                line = reader.readLine();
//                if(line==null){
//                    if(lastLine.charAt(lastLine.length()-1)!='}')
//                        return printMessage(" is Invalid JSON file",1);
//                    lastLine = lastLine.substring(0,lastLine.length()-1);
//                }
//                lastLine = lastLine.trim();
//                if(lastLine.length()>0) {
//                    for(String pair : lastLine.split(",",-1)){
//                        if(pair.trim() == ""){
//                            if(comma!=2)
//                                return printMessage(" is Invalid JSON file",1);
//                            comma = 1;
//                            continue;
//                        }
//                        String[] kp = pair.split(":",-1);
//                        if(kp.length == 2){
//                            kp[0] = kp[0].trim();
//                            if(kp[0].charAt(0)!='"' || kp[0].charAt(kp[0].length()-1)!='"')
//                                return printMessage(" is Invalid JSON file",1);
//                            kp[1] = kp[1].trim();
//                            if(kp[1].charAt(0)!='"' || kp[1].charAt(kp[1].length()-1)!='"')
//                                return printMessage(" is Invalid JSON file",1);
//                            comma = 2;
//                        } else
//                            return printMessage(" is Invalid JSON file",1);
//                    }
//                }
//            }
//            reader.close();
//            if(comma==1)
//                return printMessage(" is Invalid JSON file",1);
//            return printMessage(" is Valid JSON file",0);
//        } catch(Exception e){
//            return printMessage(e.getMessage(),1);
//        }
//    }
//
//}