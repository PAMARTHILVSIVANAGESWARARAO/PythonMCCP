from Queue import Queue
class Node:
    def __init__(self , data):
        self.data = data
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self , root , x):
        if root is None:
            return Node(x)

        if x < root.data:
            root.left = self.insert(root.left , x)
        elif x > root.data:
            root.right = self.insert(root.right , x)
        else:
            print("Same Element Given")

        return root

    def delete(self, root, x):
        if root is None:
            return root

        if x < root.data:
            root.left = self.delete(root.left, x)

        elif x > root.data:
            root.right = self.delete(root.right, x)

        else:
            if root.left is None and root.right is None:
                return None

            elif root.left is None:
                return root.right

            elif root.right is None:
                return root.left

            else:
                s = self.getSuccessor(root.right)
                root.data = s.data
                root.right = self.delete(root.right, s.data)

        return root


    def getSuccessor(self, curr):
        while curr.left is not None:
            curr = curr.left
        return curr


    def inorder(self, root):
        if root is not None:
            self.inorder(root.left)
            print(root.data, end=" ")
            self.inorder(root.right)


    def levelorder(self, root):
        if root is None:
            return

        q = Queue()
        q.enqueue(root)

        while not q.isEmpty():
            curr = q.dequeue()

            print(curr.data, end=" ")

            if curr.left:
                q.enqueue(curr.left)

            if curr.right:
                q.enqueue(curr.right)


