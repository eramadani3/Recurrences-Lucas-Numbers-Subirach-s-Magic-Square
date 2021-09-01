import java.util.Scanner;

public class Lucas {
    public static Scanner obj = new Scanner(System.in);
    public static void main(String[] args) {
        //System.out.println("What lucas number do you want to calculate?: ");
        //int n = obj.nextInt();

        for(int i = 0; i < 41; i++){
            int a = i;
            int b = a+1;

            long ratioStart = System.currentTimeMillis();
            double lucasRatio = (double)lucas(b) / lucas(a);
            long ratioEnd = System.currentTimeMillis();

            System.out.println("Lucas Number " + a);
            long start = System.currentTimeMillis();
            int lucasNum = lucas(i);
            long end = System.currentTimeMillis();

            System.out.println("The lucas value of " + a + " is " + lucasNum);
            System.out.println("Time to compute = " +  (end - start));
            System.out.printf("The lucas ratio (L(n+1))/L(n): %.3f\n", lucasRatio);
            System.out.printf("The time for the lucas [T(L(n+1))/T(L(n)] = %d", (ratioEnd- ratioStart));
            System.out.println("\n");
        }

        for(int i =0; i < 5; i++){
            int bday = bdayLucas(i);
            System.out.println(bday);
        }
    }

    public static int lucas(int n){
        if(n ==0){
            return 2;
        }
        if(n ==1){
            return 1;
        }

        return lucas(n-1) + lucas(n-2);
    }

    public static int bdayLucas(int n){
        if(n ==0){
            return 12;
        }
        if(n ==1){
            return 24;
        }
        return bdayLucas(n-1) + bdayLucas(n-2);
    }
}
