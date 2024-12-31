# IF statement 
// IF statement syntax:
// The condition is checked, and if true, the block of code inside {} is executed

// Example 1: Check if a is greater than b and print a message
IF a > b {
    PRINT "a is greater"; // This will print "a is greater" if a > b
}

// Example 2: Check if x equals 10 and print a message
IF x == 10 {
    PRINT "x is equal to 10"; // This will print if x equals 10
}

// Example 3: Check if a is less than b
IF a < b {
    PRINT "a is smaller than b"; // This will print if a < b
}

// Example 4: Nested IF statements
IF a > b {
    PRINT "a is greater than b";
    IF a == c {
        PRINT "a is also equal to c";
    }
}

// The ELSE condition can also be added to provide an alternative block if the condition is false
IF a > b {
    PRINT "a is greater";
} ELSE {
    PRINT "a is not greater";
}

# WHILE loop
// WHILE loop syntax:
// The condition is checked, and the loop continues executing as long as the condition is true

// Example 1: Print numbers from 0 to 4
LET count = 0;
WHILE count < 5 {
    PRINT count;  // This will print the current value of count
    LET count = count + 1; // Increment count after each iteration
}

// Example 2: Print a countdown from 5 to 1
LET x = 5;
WHILE x > 0 {
    PRINT x;  // Print the current value of x
    LET x = x - 1; // Decrement x after each iteration
}

// Example 3: Nested WHILE loop
LET i = 0;
WHILE i < 3 {
    LET j = 0;
    WHILE j < 3 {
        PRINT "i: " + i + ", j: " + j;
        LET j = j + 1; // Inner loop increment
    }
    LET i = i + 1; // Outer loop increment
}


## DO-WHILE Loop

### Syntax
- **DO-WHILE Loop**:  
  `DO <statement>; WHILE <condition>;`  
  The block of code inside the DO statement is executed at least once before the condition is checked, and it continues executing as long as the condition evaluates to true.

### Examples:

 Example 1: Print numbers from 0 to 4 using DO-WHILE
- **Description**: Print numbers from 0 to 4 using a DO-WHILE loop.
LET count = 0;  
DO  
    PRINT count;  
    LET count = count + 1;  
WHILE count < 5;  
This will print numbers from 0 to 4

#### For Loop
FOR Loop Syntax:
FOR Loop:
FOR <initialization>; <condition>; <increment/decrement> { <statement> }
The loop starts by initializing the loop variable, then checks the condition before each iteration, and after each iteration, it updates the loop variable.
Examples:

Example 1: Print numbers from 0 to 4
Description: Print numbers from 0 to 4 using a FOR loop.
FOR LET count = 0; count < 5; LET count = count + 1 {
    PRINT count;  
}
// This will print numbers from 0 to 4
Example 2: Print even numbers from 2 to 10
Description: Print even numbers between 2 and 10 using a FOR loop.
FOR LET i = 2; i <= 10; LET i = i + 2 {
    PRINT i;  
}
// This will print 2, 4, 6, 8, 10

Example 3: Nested FOR loop
Description: A nested FOR loop to print pairs of numbers.
FOR LET i = 0; i < 3; LET i = i + 1 {
    FOR LET j = 0; j < 3; LET j = j + 1 {
        PRINT "i: " + i + ", j: " + j;  
    }
}
// This will print pairs of i and j values, such as i: 0, j: 0; i: 0, j: 1; etc.

