class Queue:

    def __init__(self):
        
        self.queue = []
        

    def enqueue(self, x):
        
        self.queue.append(x)
        return self.traverse()


    def dequeue(self):
        if self.isEmpty(): 
            return None
        
        
        x = self.queue.pop(0) 
        self.traverse()
        return x 


    def size(self): 
        return len(self.queue)


    def isEmpty(self):
        
        return len(self.queue) == 0


    def front(self):
        if self.isEmpty(): 
            return "Queue is Empty"
        
        return self.queue[0]


    def traverse(self):
        
        return self.queue