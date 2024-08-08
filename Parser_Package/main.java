package Parser_Package;

class main{
    public static void main(String[] args){
//        ParseJson parser1 = new ParseJson("tests/step1/valid.json");
//        System.out.println(parser1.checkJson());
//
//        ParseJson parser2 = new ParseJson("tests/step1/invalid.json");
//        System.out.println(parser2.checkJson());
//
//        ParseJson parser21 = new ParseJson("tests/step2/invalid2.json");
//        System.out.println(parser21.checkJson());
//
//        ParseJson parser22 = new ParseJson("tests/step2/invalid.json");
//        System.out.println(parser22.checkJson());
//
//        ParseJson parser23 = new ParseJson("tests/step2/valid2.json");
//        System.out.println(parser23.checkJson());
//
//        ParseJson parser24 = new ParseJson("tests/step2/valid.json");
//        System.out.println(parser24.checkJson());
//
//        ParseJson parser31 = new ParseJson("tests/step3/valid.json");
//        System.out.println(parser31.checkJson());
//
//        ParseJson parser32 = new ParseJson("tests/step3/invalid.json");
//        System.out.println(parser32.checkJson());

        ParseJson parser;
//        for(int i=1;i<34;i++){
//            parser = new ParseJson("test_2/fail"+ i +".json");
//            System.out.println(parser.checkJson());
//        }
//
//        for(int i=1;i<4;i++){
//            parser = new ParseJson("test_2/pass"+ i +".json");
//            System.out.println(parser.checkJson());
//        }

        parser = new ParseJson("test_2/pass"+ 2 +".json");
        System.out.println(parser.checkJson());
//
//        parser = new ParseJson("test_2/fail"+ 29 +".json");
//        System.out.println(parser.checkJson());


    }
}