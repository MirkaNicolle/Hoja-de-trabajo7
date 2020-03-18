/*Hoja de trabajo 7
 * Diccionario ingles - español
 * Mirka Monzon 18139
 * BinaryTree class
 */

public class BinaryTree <E> {
    //Atributos
    Object node = null;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(){
    }

    //nodo
    public BinaryTree(Object node) {this.node = node;}

    //Se añade un nodo al arbol
    public void insert(Object newNode){
        if (this.node == null){ //Si esta vacio crea un uno nuevo
            setNode(newNode);
        } else {
            if (newNode.toString().compareTo(node.toString()) < 0){
                if (left == null){
                    left = new BinaryTree();
                    left.insert(newNode);
                } else {
                    left.insert(newNode);
                }
            } else if (newNode.toString().compareTo(node.toString()) > 0){
                if (right == null){
                    right = new BinaryTree();
                    right.insert(newNode);
                } else {
                    right.insert(newNode);
                }
            }
        }
    }

    //busca el nodo
    public Object search(Object searchNode){
        if (this.node != null){
            if (this.node.toString().equals(searchNode)){
                return this.node;
            } else {
                if (searchNode.toString().compareTo(node.toString()) < 0){
                    if (left != null){
                        return left.search(searchNode);
                    } else {
                        return null;
                    }
                } else if (searchNode.toString().compareTo(node.toString()) > 0){
                    if (right != null){
                        return right.search(searchNode);
                    } else {
                        return null;
                    }
                }
            }
        } else {
            return null;
        }
        return null;
    }

    //String en orden
    public static Object inOrder(BinaryTree binaryTree){
        String inOrder = "";

        if (binaryTree.getLeft() != null){
            inOrder += inOrder(binaryTree.getLeft());
        }

        inOrder += binaryTree.getNode() + "\n";

        if (binaryTree.getRight() != null){
            inOrder += inOrder(binaryTree.getRight());
        }

        return inOrder;
    }


    //left BinaryTree getter
    public BinaryTree getLeft() {
        return left;
    }

    //left BinaryTree setter
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    //right BinaryTree getter
    public BinaryTree getRight() {
        return right;
    }

    //right Binary setter
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    //getter nodo
    public Object getNode() {
        return node;
    }

    //setter nodo
    public void setNode(Object node) {
        this.node = node;
    }



}
