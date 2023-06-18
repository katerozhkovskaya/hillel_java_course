package lesson39;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public List<Integer> traverseInOrder() {
        List<Integer> values = new ArrayList<>();
        traverseInOrderRecursive(root, values);
        return values;
    }

    private void traverseInOrderRecursive(Node node, List<Integer> values) {
        if (node != null) {
            traverseInOrderRecursive(node.left, values);
            values.add(node.value);
            traverseInOrderRecursive(node.right, values);
        }
    }
}
