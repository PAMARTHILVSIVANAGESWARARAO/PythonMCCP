def calculate_bmi():

    height = float(input("Enter your height in meters  : "))
    weight = float(input("Enter your weight in kg  : "))

    print(f"Weight : {weight} kg  Height : {height} m  ")

    height = height * height

    bmi = weight / height
  
    print(f"Your BMI is : {bmi} ")

    if bmi < 18.5 :
        print("You are underweight ")
    elif bmi >= 18.5 and bmi < 25 :
        print("You are normal weight ")
    elif bmi >= 25 and bmi < 30 :
        print("You are overweight ")
    else :
        print("You are obese ")

if __name__ == "__main__":
    calculate_bmi()
