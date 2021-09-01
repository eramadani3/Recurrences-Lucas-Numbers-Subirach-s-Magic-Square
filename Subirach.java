import java.util.ArrayList;
import java.util.Arrays;

public class Subirach {
    public static int fourCombo = 0;
    public static int numCombos=0;
    public static int topCombo;
    public static int finalCombo;
    public static int numMostCombo;
    public static int target = 33;
    public static int s;
    public static void main(String[] args) {
        Integer[] magic = {1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15};
        int n = magic.length;

        //Find the number of 4 element combos
        System.out.println("4 number combos of 33 \n");
        fourNum(magic,33,n);

        //Find all possible combos up to 33

        System.out.println("\n");
        System.out.println("All combinations of 33: ");
        add(new ArrayList<Integer>(Arrays.asList(magic)), target, true);
        System.out.printf("There are %d combinations in the square that add up to the the magic number! \n", numCombos);

        //Every possible sum, set the original count to 0 since we dont need it anymore
        numCombos =0;
        addAll(magic, s, false);

        System.out.printf("There are %d 4 number combinations in the magic square \n", fourCombo);
    }

    //The order of growth of this function is O(n^3)
    public static void fourNum(Integer[] array, int target, int length){
        Arrays.sort(array);
        for(int i =0; i < length-3; i ++){
            for(int j = i+1; j < length-2; j++){
                int begin = j+1, end = length-1;
                while(begin < end){
                    int sum = array[i] + array[j] + array[begin] + array[end];
                    if(sum == target){
                        System.out.printf("%d + %d + %d + %d = %d \n", array[i], array[j], array[begin], array[end], sum);
                        fourCombo++;
                        begin++;
                        end--;
                    }else if(sum < target){
                        begin++;
                    }else{
                        end--;
                    }
                }
            }
        }
    }
    public static void diffCombo(ArrayList<Integer> square, ArrayList<Integer> part, int target, boolean show){
        int sum = 0;
        for (int x: part) sum += x;

        if (sum == target) {
            if(show){
                System.out.println(Arrays.toString(part.toArray()));
            }
            numCombos++;
            topCombo++;
            if(topCombo > finalCombo){
                finalCombo = topCombo;
                numMostCombo = sum;
            }
        }
        if(sum >= target) return;

        for(int i =0; i < square.size(); i++){
            ArrayList<Integer> whatsLeft = new ArrayList<>();
            int h = square.get(i);

            for(int j = i + 1; j < square.size(); j++){
                whatsLeft.add(square.get(j));
            }

            ArrayList<Integer> newLeft = new ArrayList<Integer>(part);
            newLeft.add(h);
            diffCombo(whatsLeft,newLeft,target, show);
            }

    }

    public static void add(ArrayList<Integer> square,int target, boolean show){
        diffCombo(square, new ArrayList<Integer>(), target, show);
    }

    public static void addAll(Integer[] square, int s, boolean show){
        System.out.println("\n");
        System.out.println("All sums in the square: ");
        System.out.println(s);

        for(int i =0; i < square.length; i++){
            s += square[i];
            System.out.println(s);
        }

        for (int i = 0; i < s; i++){
            topCombo = 0;
            add(new ArrayList<Integer>(Arrays.asList(square)), i, show);
        }
        System.out.printf("The number of every possible sum that can be found = %d \n", numCombos);
        System.out.printf("The number with the most combinations is %d with %d combinations! \n", numMostCombo, finalCombo);
    }
}
