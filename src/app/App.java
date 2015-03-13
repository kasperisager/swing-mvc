/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app;

// Views
import app.view.AppView;

/**
 * Quick and dirty demo application using the MVC micro-framework presented in
 * {@link app.framework}.
 */
public final class App {
  /**
   * Start the application.
   *
   * @param args Runtime arguments.
   */
  public static void main(final String[] args) {
    AppView appView = new AppView();
    appView.render();
  }
}
