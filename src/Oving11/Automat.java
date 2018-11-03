package Oving11;

public class Automat {

    private char[] inputAlphabet;
    private int[] acceptStates;
    private int[][] nextStateArray;

    public Automat(char[] inputAlphabet, int[] acceptStates, int[][] nextStateArray){
        this.inputAlphabet = inputAlphabet;
        this.acceptStates = acceptStates;
        this.nextStateArray = nextStateArray;
    }

    public boolean validInput(char[] input){
        int countValid = 0;
        if(input.length == 0) return false;

        for(char c1 : input){
            for(char c2 : inputAlphabet){
                if(c1 == c2) countValid++;
            }
        }
        return (countValid == input.length);
    }

    public boolean validAcceptState(int a){
        for(int i : acceptStates){
            if(i == a) return true;
        }
        return false;
    }

    public int getPosition(char c){
        for(int i = 0; i<inputAlphabet.length; i++){
            if(inputAlphabet[i] == c) return i;
        }
        return -1;
    }

    public boolean checkInput(char[] input){
        boolean result = false;
        int currentState = 0;
        int position = 0;

        for(char c : input){
            position = getPosition(c);
            if(position < 0) return false;
            currentState = nextStateArray[currentState][position];
        }

        return validAcceptState(currentState);
    }


    public static void main(String[] args){

        // Automat 1
        char[] iA1 = {'0', '1'};
        int aS1[] = {2};
        int[][] nSA1 = {{1,3},{1, 2},{2, 3},{3, 3}};
        Automat a1 = new Automat(iA1, aS1, nSA1);

        char[][] check1 = {
                {},
                {'0','1','0'},
                {'1','1','1'},
                {'0','1','0','1','1','0'},
                {'0','0','1','0','0','0'}};

        System.out.println("--Checking check1--");
        for(int i = 0; i<check1.length; i++){
            System.out.println("check1[" + i + "]: " + a1.checkInput(check1[i]));
        }

        // Automat 2
        System.out.println("\n--Checking check2--");
        char[] iA2 = {'a', 'b'};
        int aS2[] = {3};
        int[][] nSA2 = {{1, 2}, {4, 3}, {3, 4}, {3, 3}, {4, 4}};
        Automat a2 = new Automat(iA2, aS2, nSA2);

        char[][] check2 = {
                {'a', 'b', 'b', 'b'},
                {'a', 'a', 'a', 'b'},
                {'b', 'a', 'b', 'a', 'b'}};

        for(int i = 0; i<check2.length; i++){
            System.out.println("check2[" + i + "]: " + a2.checkInput(check2[i]));
        }
    }


}
