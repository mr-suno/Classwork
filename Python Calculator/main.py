from calculations import Math

running = True

letters = "abcdefghijklmopqrstuvwxyz"
numbers = "0123456789"

while running:
    line = input("Enter a set of numbers (Separate using \",\"): ")
    characters, digits, currentDigits = [], [], []

    for char in line:
        if char == ",":
            characters.append(char) # append a new comma to the list when found
        if char in numbers:
            characters.append(char) # only add the character here if it's found in our "numbers" string

    formula = input("Decide between formulas (Use \"pow\", \"mul\", \"div\", \"add\", \"sub\"): ").lower()

    for char in characters:
        if char in numbers:
            currentDigits.append(char)
        elif char == ",":
            digits.append(int("".join(currentDigits)))
            currentDigits = []
    
    if currentDigits:
        digits.append(int("".join(currentDigits)))

    if formula == "pow":
        Math.pow(digits)
    elif formula == "mul":
        Math.mul(digits)
    elif formula == "div":
        Math.div(digits)
    elif formula == "add":
        Math.add(digits)
    elif formula == "sub":
        Math.sub(digits)
