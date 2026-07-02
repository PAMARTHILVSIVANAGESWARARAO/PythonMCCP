import modules 
from modules import calci
from modules import numericoperations


while(True):

    print("---------------------------------------------------------------------------")
    print("1.Calculation Operations")
    print("2.Number Opeartions")
    print("3.Exit")

    print(modules.__all__)

    print("---------------------------------------------------------------------------")


    choice = int(input("Enter Choice"))
    match choice:
        case 1:

            print("---------------------------------------------------------------------------")

            a , b = map(int , input("Enter A,B").split())

            obj = calci.Operations(a , b)
            print("Addition :",obj.add())
            print("Subtraction :",obj.sub())
            print("Multiplication :",obj.mul())
            print("Division :",obj.div())

            print("Integer Division :",obj.div())
            print("Float Division :",obj.div())

            print("All functions" , obj.__all__)

            print("---------------------------------------------------------------------------")

        
        case 2:

            print("---------------------------------------------------------------------------")

            x = int(input("Enter Number"))

            print("Double Value Of The number" , numericoperations.double(x))
            print("Half of the number : ",numericoperations.half(x))
            print("cube of the number",numericoperations.cube(x))
            print(numericoperations.__all__)

            print("---------------------------------------------------------------------------")


        case 3:
            break
        case _:
            break
        
