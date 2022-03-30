#процедура, вычисляющую разность между количествами вершин, имеющих только левых потомков и вершин, имеющих только правых потомков

# Дерево
class BinarySearchTree:

    def __init__(self):
        self.root = None
        self.size = 0

    def length(self):
        return self.size

    def __len__(self):
        return self.size

    def __iter__(self):
        return self.root.__iter__()

    def put(self, key, val):
        if self.root:
            self._put(key, val, self.root)
        else:
            self.root = TreeNode(key, val)
        self.size = self.size + 1

    def _put(self, key, val, currentNode):
        if key < currentNode.key:
            if currentNode.has_left_child():
                self._put(key, val, currentNode.leftChild)
            else:
                currentNode.leftChild = TreeNode(key, val, parent=currentNode)
        elif key > currentNode.key:
            if currentNode.has_right_child():
                self._put(key, val, currentNode.rightChild)
            else:
                currentNode.rightChild = TreeNode(key, val, parent=currentNode)
        else:
            print('Такой узел уже существует')

    def __setitem__(self, k, v):
        self.put(k, v)


# Узел
class TreeNode:
    def __init__(self, key, val, left=None, right=None,
                 parent=None):
        self.key = key
        self.payload = val
        self.leftChild = left
        self.rightChild = right
        self.parent = parent

    def has_left_child(self):
        return self.leftChild

    def has_right_child(self):
        return self.rightChild

    def is_left_child(self):
        return self.parent and self.parent.leftChild == self

    def is_right_child(self):
        return self.parent and self.parent.rightChild == self

    def is_root(self):
        return not self.parent

    def is_leaf(self):
        return not (self.rightChild or self.leftChild)

    def has_any_children(self):
        return self.rightChild or self.leftChild

    def has_both_children(self):
        return self.rightChild and self.leftChild

    def replace_node_data(self, key, value, lc, rc):
        self.key = key
        self.payload = value
        self.leftChild = lc
        self.rightChild = rc
        if self.has_left_child():
            self.leftChild.parent = self
        if self.has_right_child():
            self.rightChild.parent = self

    def __iter__(self):
        if self:
            if self.has_left_child():
                for elem in self.leftChild:
                    yield elem
            yield self.key
            if self.has_right_child():
                for elem in self.rightChild:
                    yield elem


# Вырожденное или нет
def is_degenerate(current_vertex: TreeNode, left_sum, right_sum):
    if current_vertex.is_leaf():    # 3 сложность
        return left_sum, right_sum                    # 1 сложность
    else:
        if current_vertex.has_left_child():          # 5 сложность
            left_sum, right_sum = is_degenerate(current_vertex.leftChild, left_sum + 1, right_sum)  # 2 сложность
        if current_vertex.has_right_child():         # 5 сложность
            left_sum, right_sum = is_degenerate(current_vertex.rightChild, left_sum, right_sum + 1)   # 2 сложность
        return left_sum, right_sum


if __name__ == "__main__":
    tree = BinarySearchTree()
    print('Для каждой вершины вводите ключ и значение')
    print('Сначала введите корень дерева:')
    rk = int(input('Ключ: '))
    rv = input('Значение: ')
    tree[rk] = rv
    o = True
    while o:
        print('Введите веришну или "stop"')
        vk = input('Ключ: ')
        if vk == "stop":
            o = False
        if o:
            vv = input('Значение: ')
            if vv == "stop":
                o = False
            if o:
                tree[int(vk)] = vv
    left_sum = 0
    right_sum = 0
    res_left, res_right = is_degenerate(tree.root, left_sum, right_sum)

    print(res_left)
    print(res_right)
