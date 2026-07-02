n = int(input("Enter the number : "))

def single_if( num ):

    if num > 0 :
        print("The number is positive ")

single_if(n)

def if_else( num ):

    if num > 0 :
        print("The number is positive ")
    else :
        print("The number is not Positive ")

if_else(n)

def if_elif_else( num ):

    if num > 0 :
        print("The number is positive ")
    elif num < 0 :
        print("The number is negative ")
    else :
        print("The number is zero ")

if_elif_else(n)

def nested_if( num ):
    
    if num % 2== 0:
        if num > 0 :
            print("The number is positive and even ")
        elif num < 0 :
            print("The number is negative and even ")
        else :
            print("The number is zero and even ")
    else :
        if num > 0 :
            print("The number is positive and odd ")
        elif num < 0 :
            print("The number is negative and odd ")
        else :
            print("The number is zero and odd ")
            
nested_if(n)
