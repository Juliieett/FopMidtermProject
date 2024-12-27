# FopMidtermProject
## Project Overview
The BASIC Interpreter Project is a minimalistic implementation of an interpreter for the BASIC programming language. It supports fundamental constructs like variable assignments, arithmetic operations, conditionals, and loops. The interpreter is capable of executing predefined algorithms to demonstrate its functionality.

This project is a collaborative effort by four team members and highlights the principles of interpreter design, language parsing, and execution.
-->
## Language Subset Specification
The interpreter supports the following BASIC constructs:

-->
Variable Assignment
Syntax: LET <variable> = <expression>
Example:
LET X = 5
LET Y = X + 10
-->
Arithmetic Operations
Supported operators: +, -, *, /, % (addition, subtraction, multiplication, division, modulus).
Example:
LET Z = X * Y
LET W = Z / 2
-->
Conditional Statements
Syntax: IF <condition> THEN <statement> ELSE <statement>
Example:
IF X > Y THEN PRINT "X is greater" ELSE PRINT "Y is greater"
Loops
FOR Loop Syntax:
FOR <variable> = <start> TO <end>
    <statements>
NEXT <variable>
WHILE Loop Syntax:
WHILE <condition>
    <statements>
WEND
Example (FOR Loop):
FOR I = 1 TO 10
  PRINT I
NEXT I
...
## Algorithms Implemented
The following algorithms are implemented using the BASIC subset:

-Sum of First N Numbers: Calculate the sum of the first N natural numbers.
-Factorial of N: Compute the factorial of a given number N.
-GCD of Two Numbers: Use the Euclidean algorithm to find the greatest common divisor.
-Reverse a Number: Reverse the digits of an integer.
-Check if a Number is Prime: Determine if a number is prime.
-Check if a Number is Palindrome: Check if a number reads the same backward and forward.
-Find the Largest Digit in a Number: Identify the largest digit in an integer.
-Sum of Digits: Calculate the sum of the digits of a number.
-Multiplication Table: Generate the multiplication table for a given number.
-Nth Fibonacci Number: Compute the Nth Fibonacci number.
-->
## Project Workflow
GitHub Repository Structure
Main Branch: Contains stable and thoroughly tested code.
Feature Branches: Each team member is responsible for working on a dedicated branch for their assigned features or tasks.
Daily GitHub Workflow
Pull the latest updates from the repository to ensure your local copy is up-to-date.
Work on your assigned task within your designated feature branch.
Commit changes regularly with clear and descriptive messages (e.g., Added parser for variable assignments).
Push your feature branch to the remote repository and create a Pull Request (PR).
A teammate must review and approve the PR before it is merged into the main branch.
-->
## Contributors
Juli Chaphidze
Sandro Iobidze
Temur Tsevelidze
Tedo Rionidze
-->
Deliverables
Interpreter Implementation: A fully functional BASIC interpreter capable of executing the defined language subset.
Language Specification: A concise document detailing the syntax and features supported by the BASIC subset.
Test Cases: A set of predefined BASIC programs to validate the interpreter's functionality.
Documentation: Comprehensive project documentation, including this README and a user guide for end users.
