/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.view;

// AWT utilities
import java.awt.Component;

// Swing utilities
import javax.swing.JFrame;

// Framework
import app.framework.View;

/**
 * Example {@link View} using the MVC micro-framework presented in
 * {@link app.framework}.
 *
 * <p>
 * This view is sorta special in the sense that it's the main entry point to
 * the rest of the application. It renders as a JFrame that contains the other
 * views of the application.
 *
 * <p>
 * This view is also an example of a view associated with neither a model nor a
 * controller.
 */
public final class AppView extends View {
  /**
   * Render the application view.
   *
   * @return The rendered application view.
   */
  public Component render() {
    JFrame frame = new JFrame();

    FooView fooView = new FooView();

    frame.getContentPane().add(fooView.render());

    frame.pack();
    frame.setVisible(true);

    return frame;
  }
}
