import shared.Node;

import java.util.ArrayList;
import java.util.List;

class Execute {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.insert(-1);
        bfs.insert(5);
        bfs.insert(20);
        bfs.insert(21);
        bfs.insert(-1);
        bfs.insert(10);
        bfs.insert(-1);
        bfs.insert(1);
        bfs.insert(-1);

        System.out.println("BFS: " + bfs.breadthFirstSearch().toString());
    }
}


public class BFS {
    private Node root;

    public BFS() {
        this.root = null;
    }

    void insert(int value) {
        Node newNode = new Node(value);

        if (this.root == null) {
            this.root = newNode;
        } else {
            Node currentNode = this.root;
            while (true) {
                if (value < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        break;
                    }
                    currentNode = currentNode.getLeft();
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        break;
                    }
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    Node lookup(int value) {
        if (this.root == null) {
            return null;
        }

        Node currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                return currentNode;
            } else if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if (value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    List<Integer> breadthFirstSearch() {
        Node currentNode = this.root;
        List<Integer> list = new ArrayList<>();
        List<Node> queue = new ArrayList<>();

        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove(0);
            list.add(currentNode.getValue());

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return list;
    }

}


