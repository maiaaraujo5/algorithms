import shared.Node;

import java.util.ArrayList;
import java.util.List;

class Execute {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.insert(10);
        bfs.insert(5);
        bfs.insert(20);
        bfs.insert(21);
        bfs.insert(5);
        bfs.insert(10);
        bfs.insert(6);
        bfs.insert(1);
        bfs.insert(2);

        System.out.println("BFS: " + bfs.breadthFirstSearch().toString());
        System.out.println("DFS In Order: " + bfs.DFSInOrder().toString());
        System.out.println("DFS Pre Order: " + bfs.DFSPreOrder().toString());
        System.out.println("DFS Post Order: " + bfs.DFSPostOrder().toString());
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

    List<Integer> DFSInOrder() {
        Node currentNode = this.root;
        List<Integer> list = new ArrayList<>();
        return traverserInOrder(currentNode, list);
    }

    List<Integer> DFSPreOrder() {
        Node currentNode = this.root;
        List<Integer> list = new ArrayList<>();
        return traverserPreOrder(currentNode, list);
    }

    List<Integer> DFSPostOrder() {
        Node currentNode = this.root;
        List<Integer> list = new ArrayList<>();
        return traversePostOrder(currentNode, list);
    }

    List<Integer> traverserInOrder(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            traverserInOrder(node.getLeft(), list);
        }
        list.add(node.getValue());
        if (node.getRight() != null) {
            traverserInOrder(node.getRight(), list);
        }
        return list;
    }

    List<Integer> traverserPreOrder(Node node, List<Integer> list) {
        list.add(node.getValue());
        if (node.getLeft() != null) {
            traverserPreOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            traverserPreOrder(node.getRight(), list);
        }
        return list;
    }

    List<Integer> traversePostOrder(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            traversePostOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            traversePostOrder(node.getRight(), list);
        }
        list.add(node.getValue());
        return list;
    }
}


