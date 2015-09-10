# Sprout Method

When you need to add a feature to a system and it can be formulated completely as new code, write the code in a new method.

Call it from the places where the new functionality needs to be.

You might not be able to get those call points under test easily, but at the very least, you can write tests for the new code.

## Goal

We need to add code to verify that none of the new entries are already in `transactionBundle` before we post their dates and add them.

See `TransactionGate` for the original implementation and `BadTransactionGate` for a bad solution.

## Steps

1. Identify where you need to make your code change.
2. If the change can be formulated as a single sequence of statements in one place in a method, write down a call for a new method that will do the work involved and then comment it out.
3. Determine what local variables you need from the source method, and make them arguments to the call.
4. Determine whether the sprouted method will need to return values to source method. If so, change the
call so that its return value is assigned to a variable.
5. Develop the sprout method using test-driven development.
6. Remove the comment in the source method to enable the call.