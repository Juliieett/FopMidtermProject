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

 ## Comparison Operators

### Supported Comparison Operators:
The following comparison operators are supported for evaluating conditions:

- Greater than (`>`)
- Less than (`<`)
- Equal to (`==`)
- Not equal to (`!=`)
- Greater than or equal to (`>=`)
- Less than or equal to (`<=`)
  
### Examples:
LET a = 5
LET b = 10
PRINT a > b  // Output: false (a is not greater than b)
PRINT a < b  // Output: true (a is less than b)
PRINT a == b // Output: false (a is not equal to b)
PRINT a != b // Output: true (a is not equal to b)

### Syntax:
Comparison operators are used to compare two values and return a boolean result (either `true` or `false`).

### Examples:

## PRINT Statement

The `PRINT` statement outputs the result of an expression to the console.

### Syntax:

- The `<expression>` can be a literal value (e.g., `5`) or a variable.
- The `<expression>` can include simple arithmetic operations, such as `+`, `-`, `*`, `/`, etc.

### Examples:
- `PRINT 5 + 3;` → Output: `8`
- `LET a = 10; PRINT a;` → Output: `10`
- `PRINT a * 2 + 4;` → Output: Result of the arithmetic expression (depends on the value of `a`).

LET a = 2;
LET b = 3;
LET c = 4;
PRINT a * b + c;

