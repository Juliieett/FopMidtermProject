
### how interpreter works
copy this BASIC's codes into our interpreter at the end of the code u can always change the numbers :) :String program = """
              
                //here
        """; 

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

### sum of digits
LET NUM = 1234
LET SUM = 0
WHILE NUM > 0
    LET DIGIT = NUM % 10
    LET SUM = SUM + DIGIT
    LET NUM = NUM / 10
WEND
PRINT SUM


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

### Find the Largest Digit in X
LET X = 9347
   LET MAX_DIGIT = 0
     WHILE X > 0
     LET DIGIT = X % 10
    IF DIGIT > MAX_DIGIT
     LET MAX_DIGIT = DIGIT
     LET X = X / 10
     WEND
     PRINT MAX_DIGIT

### Check if the number is prime
LET X = 13
   LET IS_PRIME = 1
   FOR I = 2 TO X - 1
    LET TEMP = X % I
  IF TEMP = 0 THEN LET IS_PRIME = 0
  NEXT
  IF IS_PRIME = 1 THEN PRINT "Prime"
   IF IS_PRIME = 0 THEN PRINT "Not Prime"
