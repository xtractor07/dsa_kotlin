package dataStructures.tree

class BinaryTree<T: Comparable<T>> {
    var root: TreeNode<T>? = null

    fun insert(value: T) {
        root = insertRec(root, value)
    }

    private fun insertRec(current: TreeNode<T>?, value: T): TreeNode<T> {
        if (current == null) {
            return TreeNode(value)
        }

        if (value < current.value) {
           current.left = insertRec(current.left, value)
        } else if (value > current.value) {
            current.right = insertRec(current.right, value)
        }

        return  current
    }

    fun inOrderTraversal() {
        inOrderRec(root)
    }

    private fun inOrderRec(node: TreeNode<T>?) {
        if (node != null) {
            inOrderRec(node.left)
            print("${node.value}")
            inOrderRec(node.right)
        }
    }

    fun preOrderTraversal() {
        preOrderRec(root)
    }

    private fun preOrderRec(node: TreeNode<T>?) {
        if (node != null) {
            print(node.value)
            preOrderRec(node.left)
            preOrderRec(node.right)
        }
    }

    fun postOrderTraversal() {
        postOrderRec(root)
    }

    private fun postOrderRec(node: TreeNode<T>?) {
        if (node != null) {
            postOrderRec(node.left)
            postOrderRec(node.right)
            print(node.value)
        }
    }
}