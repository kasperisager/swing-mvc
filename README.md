# Swing MVC

A simple example of a JavaFX-esque MVC micro-framework for Swing applications. This was built as a demonstration of how to force some structure unto applications written using Swing. Many of the ideas presented in this micro-framework are based on the JavaFX way of doing MVC.

The framework takes a View-first approach where it becomes the responsibility of a View to initialize its associated Controller and Model. This works well with the window-based structure of Swing applications as Views can then easily be embedded within other Views without having to worry about injecting Controller and Model instances.

## Building

The project includes a simple Makefile for compiling and running the project. The following tasks are available:

__`compile`__ - Compile all Java source files.  
__`run`__ - Run the demo application.  
__`doc`__ - Generate Javadoc from the Java source files.  
__`clean`__ - Clean all output directories.

For the uninitiated, simply run the following from a terminal to execute any given task, substituting `[task]` with one of the tasks above:

```sh
make [task]
```

---

Copyright &copy; 2015 [Kasper Kronborg Isager](https://github.com/kasperisager). Licensed under the terms of the [MIT license](LICENSE.md).
