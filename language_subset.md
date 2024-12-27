## Variable Assignment

### Syntax:
The syntax for variable assignment is:
- `LET <variable_name> = <expression>`
- Example: `LET x = 10`

### Rules:
- `LET` keyword is used for variable assignment.
- Variables can consist of letters, numbers, and underscores, but cannot start with a number (e.g., `x_1` is valid, `1x` is invalid).
- Expressions on the right-hand side can be simple numbers or arithmetic expressions.

## Arithmetic Operations

### Supported Operators:
The following arithmetic operators are supported in the interpreter:
- Addition (`+`)
- Subtraction (`-`)
- Multiplication (`*`)
- Division (`/`)
- Modulus (`%`)

### Syntax:
Arithmetic expressions can be written using the operators above, and the interpreter follows the standard order of operations (PEMDAS):
1. Parentheses `()`
2. Multiplication `*` and Division `/` (left to right)
3. Addition `+` and Subtraction `-` (left to right)

### Examples:
- `LET a = 5 + 3 * 2` → Result: `a = 11` (Multiplication happens first)
- `LET b = (5 + 3) * 2` → Result: `b = 16` (Parentheses have higher precedence)

### Notes:
- Arithmetic operations will be performed on integers.
- Division will truncate results to integers (no floating-point numbers).
- Parentheses can be used to control the order of operations.
