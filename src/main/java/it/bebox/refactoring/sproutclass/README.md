# Sprout Class

Sprout Method is a powerful technique, but in some tangled dependency situations, it isn't powerful enough.

Consider the case in which you have to make changes to a class, but there is just no way that you are going to be able to create objects of that class in a test harness in a reasonable amount of time, so there is no way to sprout a method and write tests for it on that class. Maybe you have a large set of creational dependencies, things that make it hard to instantiate your class. Or you could have many hidden dependencies. To get rid of them, you'd need to do a lot of invasive refactoring to separate them out well enough to compile the class in a test harness.

In these cases, you can create another class to hold your changes and use it from the source class.


## Goal

Let's suppose that the change that we need to make to the code is to add a header row for the HTML table `QuarterlyReportGenerator` producing.

The header row should look something like this:

    <tr><td>Department</td><td>Manager</td><td>Profit</td><td>Expenses</td></tr>

Furthermore, let's suppose that `QuarterlyReportGenerator` is a huge class and that it would take about a day to get the class in a test harness, and this is time that we just can't afford right now.


We could formulate the change as a little class called `QuarterlyReportTableHeaderProducer` and develop it using test-driven development


## Steps

1. Identify where you need to make your code change.
2. If the change can be formulated as a single sequence of statements in one place
in a method, think of a good name for a class that could do that work.
Afterward, write code that would create an object of that class in that place,
and call a method in it that will do the work that you need to do; then comment those lines out.
3. Determine what local variables you need from the source method, and make them arguments to the classes' constructor.
4. Determine whether the sprouted class will need to return values to the source method.
If so, provide a method in the class that will supply those values, and add a call in the source method to receive those values.
5. Develop the sprout class test first with test-driven development.
6. Remove the comment in the source method to enable the object creation and calls.
