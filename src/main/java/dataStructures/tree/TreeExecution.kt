package dataStructures.tree

fun main() {
    val tree = BinaryTree<Int>()
    tree.insert(5)
    tree.insert(3)
    tree.insert(7)
    tree.insert(2)
    tree.insert(4)
    tree.insert(6)
    tree.insert(8)

    println("Inorder Traversal:")
    tree.inOrderTraversal()

    println("\nPreorder Traversal:")
    tree.preOrderTraversal()

    println("\nPostOrder Traversal:")
    tree.postOrderTraversal()
}