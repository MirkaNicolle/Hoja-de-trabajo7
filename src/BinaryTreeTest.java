import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @org.junit.jupiter.api.Test
    void insert() {
        BinaryTree result = new BinaryTree();
        Association association = new Association("dog", "perro");
        BinaryTree expected = new BinaryTree(association);

        result.insert(association);

        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void search() {
        BinaryTree binaryTree = new BinaryTree();
        Association expected = new Association("dog", "perro");
        binaryTree.insert(expected);

        Association result = (Association)binaryTree.search("dog");

        assertEquals(expected, result);
    }
}