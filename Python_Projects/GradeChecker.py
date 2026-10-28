# Python program for determining grade average of user input
# Utilized input(), f".2f", lists, if-elif-else statement
# User is asked to enter name
# User is then asked to enter grade, which loops 3 times in this program
# Grades taken are then put in a list to calculate the average
# Average is then taken to an if-elif-else statement to validate the average
# Edge cases not fixed: Name does not handle input mismatch, no limit to the grade which is not following the real world example


name = input("Enter Name: ")
grades = []

for i in range(3):
    grade = float(input("Enter 3 grades: "))
    grades.append(grade)

average = sum(grades) / len(grades)

if average > 90:
    print(f"{name} {average:.2f} Excellent")
elif average >= 75:
    print(f"{name} {average:.2f} Passed")
else:
    print(f"{name} {average:.2f} Failed")
