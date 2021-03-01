import java.util.*;

class ExecuteCode {
    public static void main(String arg[])
    {
        int V = 5;
        int source = 0;

        List<List<Node> > adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        djikstras djikstras = new djikstras(V);
        djikstras.execute(adj, source);

        System.out.println("The shorted path from node :");
        for (int i = 0; i < djikstras.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + djikstras.dist[i]);
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