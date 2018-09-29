package Oving4;

public class Node {
    Node left, right;
    String word;

    public Node(String word){
        this.word = word;
    }


    public void insert(Node newWord){
        if(newWord.word.compareTo(word) <= 0){
            if(left == null) {
                left = newWord;
            } else {
                left.insert(newWord);
            }
        } else {
            if(right == null){
                right = newWord;
            } else {
                right.insert(newWord);
            }
        }
    }

    public boolean contains(String findWord){
        if(findWord.equals(word)){
            return true;
        } else if (findWord.compareTo(word) < 0){
            if(left != null){
               return left.contains(findWord);
            } else {
                return false;
            }
        } else {
            if(right != null){
                return right.contains(findWord);
            } else {
                return false;
            }
        }
    }

    public String getSpaces(int number){
        String spaces = "-";
        for(int i = 0; i<number; i++){
            spaces += "----";
        }

        return number + spaces;
    }





}
