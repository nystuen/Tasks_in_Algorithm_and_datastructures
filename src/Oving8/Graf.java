package Oving8;


import javafx.scene.layout.Priority;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Graf {
    int N, K;
    Node[] node;
    int counter = 0;
    boolean dfs_print = false;


    /*
      Les inn graf fra fil
   */
    public void ny_vgraf(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i = 0; i < N; i++) node[i] = new Node();
        K = Integer.parseInt(st.nextToken());
        System.out.println("Antall node: " + N + " Antall kanter: " + K);
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            int vekt = Integer.parseInt(st.nextToken());
            Vkant k = new Vkant(node[til], (Vkant) node[fra].kant1, vekt);
            node[fra].kant1 = k;

        }
    }

    void forkort(Node n, Vkant k) {
        Forgj nd = (Forgj) n.d, md = (Forgj) k.til.d;
        if (md.dist > nd.dist + k.vekt) {
            md.dist = nd.dist + k.vekt;
            md.forgj = n;
        }
    }

    public void initforgj(Node s) {
        for (int i = N; i-- > 0; ) {
            node[i].d = new Forgj();
        }
        ((Forgj) s.d).dist = 0;
    }

    void lag_priko(PriorityQueue<Node> pri) {
        for (Node n : node) {
            pri.add(n);
        }
    }

    public void dijkstra(Node s) {
        initforgj(s);

        PriorityQueue<Node> pri = new PriorityQueue<>();
        lag_priko(pri);

        for (int i = N; i > 1; --i) {
            Node n = pri.poll();
            for (Vkant k = (Vkant) n.kant1; k != null; k = (Vkant) k.neste) {
                forkort(n, k);
            }
            System.out.println(n.kant1.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader leseforbTilFil = new FileReader("/Users/adnenystuen/Documents/Skole/Java/IdeaProjects/Tasks_in_AlgorithmAndDatastructures/src/Oving8_1/eksempelFil");
        BufferedReader br = new BufferedReader(leseforbTilFil);
        Graf g = new Graf();

        g.ny_vgraf(br);

        g.dijkstra(g.node[0]);

    }

}
