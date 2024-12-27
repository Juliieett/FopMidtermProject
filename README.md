# FopMidtermProject
Project Overview
The BASIC Interpreter Project is a minimalistic implementation of an interpreter for the BASIC programming language. It supports fundamental constructs like variable assignments, arithmetic operations, conditionals, and loops. The interpreter is capable of executing predefined algorithms to demonstrate its functionality.

This project is a collaborative effort by four team members and highlights the principles of interpreter design, language parsing, and execution.
-->
Language Subset Specification
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
