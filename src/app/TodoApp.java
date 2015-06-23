/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app;

// Swing utilities
import javax.swing.JFrame;

// Framework
import app.framework.Application;

// Views
import app.view.TodoView;
import app.view.MenuView;

/**
 * An example of a simple "Todo" application written using the MVC micro-
 * framework presented in {@link app.framework}.
 */
public final class TodoApp extends Application {
  /**
   * Start the {@link TodoApp}.
   *
   * @param frame The main frame of the {@link TodoApp}.
   */
  protected void start(final JFrame frame) {
    frame.setTitle("Todos");

    // Set the menu bar of the application frame.
    frame.setJMenuBar(new MenuView(this).render());

    // Render and add the main view to the application frame.
    frame.getContentPane().add(new TodoView(this).render());
  }

  /**
   * Boot up the {@link TodoApp}.
   *
   * @param args Runtime arguments.
   */
  public static void main(final String[] args) {
    new TodoApp();
  }
}
