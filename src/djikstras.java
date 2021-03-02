import java.util.*;

class ExecuteCode {
    public static void main(String arg[]) {
        int[][] graph = new int[][]{
                {-1, 5, 20},
                {21, -1, 10},
                {-1, 1, -1}};
        int[][] graph1 = new int[][]{
                {-1, 5, 2, 15},
                {2, -1, 0, 3},
                {1, -1, -1, 9},
                {0, 0, 0, -1}
        };

        int result = nightRoute(graph1);
        System.out.println(result);
    }

    public static int nightRoute(int[][] city) {
        int vertice = city.length;
        int source = 0;

        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < vertice; i++) {
            List<Node> item = new ArrayList<>();
            adj.add(item);
        }

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                if (city[i][j] != -1) {
                    adj.get(i).add(new Node(j, city[i][j]));
                }
            }
        }
        djikstras djikstras = new djikstras(vertice);
        djikstras.execute(adj, source);

        return djikstras.dist[djikstras.dist.length - 1];
    }
}


public class djikstras {
    public int[] dist;
    public Set<Integer> settled;
    public PriorityQueue<Node> priorityQueue;
    public int numberOfVertices;
    public List<List<Node>> adj;


    public djikstras(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.dist = new int[numberOfVertices];
        this.settled = new HashSet<Integer>();
        this.priorityQueue = new PriorityQueue<Node>(numberOfVertices, new Node());
    }

    public void execute(List<List<Node>> adj, int src) {
        this.adj = adj;

        for (int i = 0; i < this.numberOfVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        priorityQueue.add(new Node(src, 0));

        dist[src] = 0;
        while (settled.size() != numberOfVertices) {
            int u = priorityQueue.remove().node;

            settled.add(u);

            e_Neighbours(u);
        }
    }


    private void e_Neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;


        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);


            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;


                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                priorityQueue.add(new Node(v.node, dist[v.node]));
            }
        }
    }
}

class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node() {

    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }


    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost) {
            return -1;
        }

        if (node1.cost > node2.cost) {
            return 1;
        }
        return 0;
    }
}