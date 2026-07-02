class Stack:

    def __init__(self):
        

        self.stack = []
        

    def push(self, x):
        self.stack.append(x)
        return self.traverse()


    def pop(self):
        if self.isEmpty(): 
            return None
        
        
        x = self.stack.pop() 
        self.traverse()
        return x 


    def size(self): 
        return len(self.stack)


    def isEmpty(self):
        
        return len(self.stack) == 0


    def top(self):
        if self.isEmpty(): 
            return "No top element (Stack is Empty)"
        
        return self.stack[-1]


    def traverse(self):
        
        return self.stack[::-1]