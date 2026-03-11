public class TCS {
    static String show() {

        int i=100/0;

        try{return "your name";}

        catch(Exception e){return "your surname";}

        finally{return "hello world!!";}

    }
    public static void main(String[] args) {

        String s = show();

        System.out.println(s);
    }
}
