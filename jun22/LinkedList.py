class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:

    __all__ = ['add' , 'add_first' , 'add_last' , 'add_at_position' , 'traverse' , 'delete_head' , 'delete_end' , 'search' , 'research' , 'size' , 'to_list']

    def __init__(self):
        self.head = None


    def add(self, x):  #Similar Method TO Java 
        t = Node(x)

        if self.head is None:
            self.head = t
        else:
            curr = self.head
            while curr.next is not None:    curr = curr.next
            curr.next = t

        return self.head


    def add_first(self, x):
        t = Node(x)
        t.next = self.head
        self.head = t

    def add_last(self, x):
        t = Node(x)

        if self.head is None:
            self.head = t
        else:
            curr = self.head
            while curr.next is not None:    curr = curr.next
            curr.next = t

        return self.head

    def add_at_position(self, x, pos):
        t = Node(x)


        if pos < 1:
            return self.head


       
        if pos == 1:
            t.next = self.head
            self.head = t
            return self.head

        curr = self.head

        for i in range(pos - 2):
            if curr is None:
                return self.head
            curr = curr.next

        if curr is None:
            return self.head

        t.next = curr.next
        curr.next = t

        return self.head
    

    def traverse(self):
        t = self.head
        while t is not None:
            print(t.data, end=" -> ")
            t = t.next
        print("None")

    def delete_head(self):
        if self.head is None:   return self.head
        else: 
            temp = self.head
            self.head = self.head.next
            temp = None

        return self.head

    
    def delete_end(self):
        if self.head is None:
            return None

        if self.head.next is None:
            self.head = None
            return None

        prev = None
        curr = self.head

        while curr.next:
            prev = curr
            curr = curr.next

        prev.next = None
        return self.head

    def delete_pos(self, pos):
        if self.head is None or pos < 1:
            return self.head

        if pos == 1:
            temp = self.head
            self.head = self.head.next
            temp = None
            return self.head

        prev = None
        curr = self.head

        for _ in range(1, pos):
            if curr is None:
                return self.head
            prev = curr
            curr = curr.next

        if curr is None:
            return self.head

        prev.next = curr.next
        curr = None

        return self.head
    
   
    def search(self, x):
        curr = self.head

        while curr is not None:
            if curr.data == x:
                return True
            curr = curr.next

        return False

    def research(self, data, cur):
        if cur is None:
            return False

        if cur.data == data:
            return True

        return self.research(data, cur.next)


    def to_list(self):
        result = []
        curr = self.head

        while curr is not None:
            result.append(curr.data)
            curr = curr.next

        return result


    def size(self):
        count = 0
        curr = self.head

        while curr is not None:
            count += 1
            curr = curr.next

        return count