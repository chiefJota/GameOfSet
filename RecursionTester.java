public class RecursionTester {

    public static int factroial (int n) {
       // int fact = 1;
        //for (int i = 0; i <= n; i++) {
           // fact *= i;
        //}
       // return fact;

        //base case
        if(n==0){
            return 1;
        }

        return n * factroial(n-1);
    }

    public static void main(String[] args){
        int ans = factroial(5);
        System.out.print(ans);
    }
}
