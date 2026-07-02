class Operations:

    __all__ = ["add" , "sub" , "mul" , "div" , "integer_div" , "float_div"]
    def __init__(self, a, b):
        self._a = a
        self._b = b

    def add(self):
        return self._a + self._b

    def sub(self):
        return self._a - self._b

    def mul(self):
        return self._a * self._b

    def div(self):
        return self._a / self._b

    def integer_div(self):
        if type(self._a) != int and type(self._b):
            return "Both Types Must Be Integers Only"
        else:
            return self._a // self._b

    def float_div(self):     return self._a // self._b