package Oving9;

import java.util.ArrayList;

class RelationProperties {
    /*
     * Assuming that a two column array containing the relation and a one column          * array containing the set the relation is on is given in each method.
     * No checks are performed.
     */

    public static boolean isReflexive(char[][] relation, char[] set) {
        int count = 0;

        for (char[] r : relation) {
            if (r[0] == r[1]) {
                count++;
            }
        }

        return (count == set.length);
    }

    public static boolean isSymmetric(char[][] relation, char[] set) {
        int counter = 0;

        for (char[] r : relation) {
            counter = 0;
            if (r[0] != r[1]) {
                for (int i = 0; i < relation.length; i++) {
                    if (relation[i][0] == r[1]) {
                        if (relation[i][1] == r[0]) {
                            counter++;
                        }

                    }
                }
                if (counter == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isTransitive(char[][] relation, char[] set) {
        char currentChar;
        for(char[] r : relation){
            currentChar = r[0];
            for(char[] r2 : relation){
                char[] check = {r[1], r2[1]};
                if(r[1] == r2[0] && !containsExcept(relation, check)){
                    char[] check2 = {r[0], r2[1]};
                    if(!contains(relation, check2)){
                       return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean contains(char[][] relation, char[] c){
        for(char[] c1 : relation){
            if(c1 == c){
               return true;
            }
        }
        return false;
    }

    public static boolean containsExcept(char[][] relation, char[] c){
        for(char[] c1 : relation){
            if(c1 != c){
                for(char c2 : c1){
                    if(c2 == c[1]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isAntiSymmetric(char[][] relation, char[] set) {
        /* Antisymmetrisk hvis:
            a R b og b R a så er a = b
         */

        for (char[] r : relation) {
            if (r[0] != r[1]) {
                for (int i = 0; i < relation.length; i++) {
                    if (relation[i][0] == r[1]) {
                        if (relation[i][1] == r[0]) {
                           if(relation[i][0] != relation[i][1]){
                               return false;
                           }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean isEquivalenceRelation(char[][] relation, char[] set) {
        if(isReflexive(relation, set) && isSymmetric(relation, set) && isTransitive(relation, set)){
            return true;
        }
        return false;
    }

    public static boolean isPartialOrder(char[][] relation, char[] set) {
        if(isReflexive(relation, set) && isAntiSymmetric(relation, set) && isTransitive(relation, set)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] setA = {'a', 'x', 'r', 'm', '2', '0'};
        char[][] rel1 = {{'a', 'a'}, {'r', 'a'}, {'a', '2'}, {'x', 'x'}, {'r', '2'}, {'r', 'r'}, {'m', 'm'}, {'2', 'r'}, {'0', '0'}, {'a', 'r'}, {'2', '2'}, {'2', 'a'}};
        char[][] rel2 = {{'a', 'x'}, {'r', '2'}, {'0', '0'}, {'m', '2'}};
        System.out.println("Rel1 is reflexive: " + isReflexive(rel1, setA));
        System.out.println("Rel2 is reflexive: " + isReflexive(rel2, setA));
        System.out.println("Rel1 is symmetric: " + isSymmetric(rel1, setA));
        System.out.println("Rel2 is symmetric: " + isSymmetric(rel2, setA));
        System.out.println("Rel1 is transitive: " + isTransitive(rel1, setA));
        System.out.println("Rel2 is transitive: " + isTransitive(rel2, setA));
        System.out.println("Rel1 is antisymmetric: " + isAntiSymmetric(rel1, setA));
        System.out.println("Rel2 is antisymmetric: " + isAntiSymmetric(rel2, setA));
        System.out.println("Rel1 is an equivalence relation: " + isEquivalenceRelation(rel1, setA));
        System.out.println("Rel2 is an equivalence relation: " + isEquivalenceRelation(rel2, setA));
        System.out.println("Rel1 is a partial order: " + isPartialOrder(rel1, setA));
        System.out.println("Rel2 is a partial order: " + isPartialOrder(rel2, setA));
	/* skal gi følgende utskrift:
	   Rel1 is reflexive: true
	   Rel2 is reflexive: false
	   Rel1 is symmetric: true
	   Rel2 is symmetric: false
	   Rel1 is transitive: true
	   Rel2 is transitive: true
	   Rel1 is antisymmetric: false
	   Rel2 is antisymmetric: true
	   Rel1 is an equivalence relation: true
	   Rel2 is an equivalence relation: false
	   Rel1 is a partial order: false
	   Rel2 is a partial order: false
	 */
    }


}