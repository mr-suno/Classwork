# considering PEMDAS, we organize math funcs like this too

def perform(method, numbers):
    options = ["pow", "mul", "div", "add", "sub"] # doesn't include PAR (parenthesis)
    final = 0

    if method not in options:
        raise ValueError("Invalid method, use basic arithmatics only")
    # if len(numbers) < 2:
    #     raise IndexError("Missing requirement of at least 2 digits")

    if method == "pow":
        final = numbers[0]
        for num in numbers[1:]:
            final **= num
    elif method == "mul":
        final = 1
        for num in numbers:
            final *= num
    elif method == "div":
        final = numbers[0]
        for num in numbers[1:]:
            final /= num
    elif method == "add":
        for num in numbers:
            final += num
    elif method == "sub":
        final = numbers[0]
        for num in numbers[1:]:
            final -= num

    return final

class Math:
    pow = lambda numbers: perform("pow", numbers) # surely there's a better way... right?
    mul = lambda numbers: perform("mul", numbers)
    div = lambda numbers: perform("div", numbers)
    add = lambda numbers: perform("add", numbers)
    sub = lambda numbers: perform("sub", numbers)
