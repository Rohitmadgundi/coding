// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class ReverseRightAngeledTriangle {
    public static void main(String[] args) {
        
        /*
            *****
            ****
            ***
            **
            *
        */
        
        int n = 5;
        int m = 5;
        
        for(int i = 1; i<=n; i++){
            for(int j = 5; j>=i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}