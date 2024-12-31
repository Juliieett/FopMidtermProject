### factorial
LET N = 5
LET FACT = 1
FOR I = 1 TO N
LET FACT = FACT * I
NEXT
PRINT FACT 

### fibonacci
LET X = 10
LET A = 0
LET B = 1
FOR I = 2 TO X
    LET A = A + B
    LET B = A
NEXT
PRINT B

### GCD
LET X = 48
LET Y = 18
WHILE Y != 0
    LET TEMP = Y
    LET Y = X % Y
    LET X = TEMP
WEND
PRINT X

### Multiplication Table
LET X = 5
  FOR I = 1 TO 10
  PRINT X * I            
  NEXT

### Palindrome num checker
LET NUM = 121
  PALINDROME NUM
  LET OTHER = 123
        PALINDROME OTHER 

### Reverse
LET X = 1234
LET REVERSED = 0
WHILE X > 0
    LET REVERSED = REVERSED * 10 + X % 10
    LET X = X / 10
WEND
PRINT REVERSED

### Sum of first N numbers
LET X = 10
LET SUM = 0
FOR I = 1 TO X
LET SUM = SUM + I
NEXT
PRINT SUM
