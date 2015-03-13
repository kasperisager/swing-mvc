/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app;

// Swing utilities
import javax.swing.JFrame;

// Framework
import app.framework.Application;

// Views
import app.view.AppView;

/**
 * Quick and dirty demo application using the MVC micro-framework presented in
 * {@link app.framework}.
 */
public final class App extends Application {
  /**
   * Start the application.
   *
   * @param frame The main frame of the application.
   */
  protected void start(final JFrame frame) {
    frame.setTitle("MVC Demo");

    frame.getContentPane().add(new AppView());

    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Boot up the application.
   *
   * @param args Runtime arguments.
   */
  public static void main(final String[] args) {
    new App();
  }
}
