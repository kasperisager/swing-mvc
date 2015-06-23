# Swing MVC

[![Build Status](https://travis-ci.org/kasperisager/swing-mvc.svg?branch=master)](https://travis-ci.org/kasperisager/swing-mvc)

A simple example of a JavaFX-esque MVC micro-framework for Swing applications. This was built as a demonstration of how to force some structure onto applications written using Swing. Many of the ideas presented in this micro-framework are based on the JavaFX way of doing MVC.

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

## Getting started

> Generated Javadoc documentation can be found at https://kasperisager.github.io/swing-mvc.

Below are some examples of the different aspects of the framework in use.

### Application

The `Application` class takes care of constructing the main application frame. To create a new MVC application one must therefore extend the `Application` class and implement the `start(JFrame)` method:

```java
public final class MyApp extends Application {
  protected void start(final JFrame frame) {
    frame.setTitle("My App");
    frame.getContentPane().add(new MyView(this).render());
  }
}
```

To get `MyApp` up and running, simply initialize it in, say, `main(String[])`:

```java
public static void main(final String[] args) {
  new MyApp();
}
```

### Model

```java
public final class MyModel extends Model {
  private String field;

  public MyModel(final Application application) {
    super(application);
  }

  public void getField() {
    return this.field;
  }

  public void setField(final String value) {
    this.field = value;
    this.emit("changed:field", this.field);
  }
}
```

### View

```java
public final class MyView extends View<MyModel, MyController> {
  public MyView(final Application application) {
    super(application);
    this.model(new MyModel(application));
    this.controller(new MyController(application));
  }

  public JButton render() {
    JButton button = new JButton("This view is a button!");
    button.addActionListener(e -> this.controller().myAction());

    this.model().on("changed:field", (String field) -> {
      System.out.println("Field was changed to " + field);
    });

    return button;
  }
}
```

### Controller

```java
public final class MyController extends Controller<MyModel, MyView> {
  public MyController(final Application application) {
    super(application);
  }

  public void myAction() {
    this.model().setField(101);
  }
}
```

---

Copyright &copy; 2015 [Kasper Kronborg Isager](https://github.com/kasperisager). Licensed under the terms of the [MIT license](LICENSE.md).
