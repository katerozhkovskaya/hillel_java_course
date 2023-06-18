package lesson39;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {
    BinaryTree tree = new BinaryTree();

    @Test
    public void addTest() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        Assertions.assertTrue(tree.containsNode(7));
        Assertions.assertFalse(tree.containsNode(100));
    }

    @Test
    public void traverseInOrder() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        assertThat(tree.traverseInOrder().size()).isEqualTo(5);
    }
}
