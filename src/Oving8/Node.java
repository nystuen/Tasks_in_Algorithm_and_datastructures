package Oving8;

class Node implements Comparable<Node> {
    Kant kant1;
    Object d;
    int i;


    @Override
    public int compareTo(Node o) {
        return ((Forgj)o.d).dist- ((Forgj)d).dist;
    }
}