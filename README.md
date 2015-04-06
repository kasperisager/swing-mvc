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

The `Application` class takes care of constructing the main application frame and passing it on to subclasses. To create a new MVC application one must therefore extend the `Application` class and implement the `start(JFrame)` method:

```java
public final class MyApp extends Application {
  protected void start(final JFrame frame) {
    frame.getContentPane().add(new MyView());
    frame.pack();
    frame.setVisible(true);
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
  
  public void getField() {
    return this.field;
  }
  
  public void setField(final String value) {
    this.field = value;
    this.changed(this.field);
  }
}
```

### View

```java
public final class MyView extends View<MyModel, MyController> {
  protected void initialize() {
    this.model(new MyModel());
    this.controller(new MyController());
  }
  
  protected void render() {
    someComponent.addActionListener(this.controller());
  }
  
  protected void update(final MyModel model, final Object value) {
    System.out.println(
      model + " changed a field value to " + value
    );
  }
}
```

### Controller

```java
public final class MyController extends Controller<MyModel, MyView>
  implements ActionListener {
  public void actionPerformed(final ActionEvent e) {
    this.model().setField(...);
  }
}
```

---

Copyright &copy; 2015 [Kasper Kronborg Isager](https://github.com/kasperisager). Licensed under the terms of the [MIT license](LICENSE.md).
