package Oving4;

public class Tree {


    /**
     * Takes a sentence as argument and converts this into a binary search tree.
     * @param sentence
     * @return the root node of the binary search tree.
     */
    public static Node insertSentence(String sentence){
        String[] strArray = sentence.split(" ");
        Node root = new Node(strArray[0]);

        for(int i = 1; i<strArray.length; i++){
            Node node = new Node(strArray[i]);
            root.insert(node);
        }

        return root;
    }


    public static void print2D(Node root, int space){
        int TELLER = 10;

        // BASE CASE
        if(root == null){
            return;
        }

        // Increase distance between levels
        space += TELLER;

        // Print root's right child
        print2D(root.right, space);

        // Print root
        String str = "";
        for(int i = TELLER; i<space; i++){
            str += " ";
        }
        System.out.println("\n" + str + root.word);

        // Print root's left child
        print2D(root.left, space);
    }

    public static void main(String[] args){


        String str = "hode ben arm hake albue legg tå tann hår headset jakke";
        Node test = insertSentence(str);

        print2D(test, 0);

    }

}
