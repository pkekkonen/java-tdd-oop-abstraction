# Object-oriented Programming - Abstraction

## Learning Objectives
- Explain what "exposing implementation details" means
- Explain the difference between a public and private interface of a class
- Use abstraction to hide implementation details

## Set up instructions
- Fork this repository and clone the forked version to your machine
- Open the root directory of the project in IntelliJ

## Introduction

We can think of methods as an "interface for the class", though we don't usually refer to them as such to avoid confusion with another topic we'll cover later.

Methods (and members) can be public, so other classes can interact with them, or private. Private means only the class itself can access those particular methods & members. There are other types of visibility that we'll discover later, but those are the two most important ones.

Consider driving a car. The steering wheel, pedals and gear stick are the public interface to the car; they are exposed to the user so they can perform some interactions. We don't need to know how the engine works or how the exhaust system is hooked up in order to drive the car, we just use the simple "methods" that the car has given us. Use the steering wheel to turn, press the pedals to stop and go, the car takes care of all the complex logic.

What I've described there is *abstraction*; hiding the implementation details of a system. Let's try it with a class:

```java
public class TrafficLight {
    public String colour;
    
    public TrafficLight() {
        this.colour = "green";
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getColour() {
        return this.colour;
    }
}
```

In order for a developer to use this class, they need to understand the colours that the light should be!

```java
public class Car {
    public void main() {
        TrafficLight tLight = new TrafficLight();
        
        if (tLight.getColour() == "green") {
            this.accelerate();
        }
        
        if (tLight.getColour() == "red") {
            this.stop();
        }
        
        if (tLight.getColour() == "purple") {
            // I don't know what to do with this colour...
        }
    }
    
    public void accelerate();
    public void stop();
}
```

The TrafficLight class has *poor abstraction*. The implementation details are completely exposed! In order to use the class, the developer must know the light colour is represented as a string, they must know all the possible values the string could be, they must know what green means and what red means. It's a mess! We should properly hide the implementation details, *abstract* away the logic, and provide an easier public interface.

```java
public class TrafficLight {
    public String colour;

    public TrafficLight() {
        this.colour = "green";
    }
    
    public boolean canGo() {
        return !this.colour.equals("red");
    }
    
    public void setGreen() {
        this.colour = "green";
    }
    
    public void setRed() {
        this.colour = "red";
    }
}
```

This class is now much easier for a developer to use. They don't need to know what the internal workings of the class are, they don't even need to know that colour is a string, they just have the ability to change the state from red to green and have a `canGo` method to tell them when the car is allowed to move. We can change the inner workings of the TrafficLight class safely now, say if we wanted to introduce the colour "yellow", without causing issues for anyone already using the class.

There is still one problem: the `colour` member is marked as `public`! This means that any other class can reach in and change the value of this member without going through the methods that the TrafficLight class has defined. This exposes implementation details, too!

## Exercise 1

There is a `TodoItem` class with poor abstraction in the `./src/main/com/booleanuk/core/` directory. It exposes a lot of implementation details and provides a bad public interface to other classes.

- Refactor the class to demonstrate abstraction
- Use a test-driven development approach by writing your tests first in the `./src/test/com/booleanuk/core/TotoItemTest.java` class
- Share your work with your morning teacher for feedback and discussion

## Exercise 2

Using the user stories below, create a domain model or class diagram before creating an implementation in the `./src/main/com/booleanuk/core/` directory.

- Your solution should demonstrate good abstraction
- Add your model / diagram to the project.

```
As a system administrator,
I want my users to have to create a user account with an email address and a password.

I want them to receive an "invalid password" message if they provide a
password less than 8 characters in length.

I want them to receive an "invalid email" message if they provide an email
address without an @ symbol in it.

I want new accounts to be disabled by default until I manually set them as enabled.

I want users to know if they are able to log in or not based on whether their
account is enabled or disabled.
```

Share your work with your morning teacher for feedback and discussion.

## Next steps

Now that you've practiced abstraction, introduce this concept into your ongoing Bob's Bagels OOP exercise. Refactor your existing code if necessary. You should have multiple classes that hide their implementation details and expose easy to use interfaces for their logic.

## Test Output

![](./assets/run-a-test.PNG)

When you run a test, it's either going to pass or fail. When it fails, you'll be presented with a big red stream of text. This is called a stack trace and, though intimidating, does contain some useful information.

One of the core skills of a developer is debugging stack traces like this. The stack trace details in which classes & files the failure happened, and gives you a line number at the end. Most of the lines in the stack trace are irrelevant most of the time, you want to try and identify the files that you're actually working with.

In the sample screenshot below, we've tried to complete the first step of the exercise but provided an invalid value. Then we run the test associated with it and we see a big red stack trace, a test failure.

At the top, we see `expected: <32> but was: <33>`. This means the test expected the value to be 32, but the value the student provided was 33. We can see this in the code snippets at the top of the screenshot.

In the stack trace itself, we see this line: `at app//com.booleanuk.core.TodoItemTest.shouldBeAged32(ExerciseTest.java:20)`. This is helpful! This tells us the exact line in the ExerciseTest.java file (line 20) where the failure happened, as well as the method name (shouldBeAged32), helping us to identify where the issue began. This is the kind of thing you need to look for; a relevant file name, method name, class name and line number to give you a good starting point for debugging.

![](./assets/test-failure.PNG)
