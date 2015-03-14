/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.view;

// Utilities
import java.util.Observable;

// AWT events
import java.awt.event.ActionListener;

// Swing utilities
import javax.swing.JButton;
import javax.swing.JLabel;

// Framework
import app.framework.View;

// Models
import app.model.Foo;

// Controllers
import app.controller.FooController;

/**
 * Example {@link View} using the MVC micro-framework presented in
 * {@link app.framework}.
 */
public final class FooView extends View<Foo, FooController> {
  /**
   * A label that displays some information about our model.
   */
  private JLabel label;

  /**
   * Initialize the view.
   */
  protected void initialize() {
    this.model(new Foo());
    this.controller(new FooController());
  }

  /**
   * Render the view.
   */
  protected void render() {
    JButton button = new JButton("Plus One");
    this.add(button);

    this.label = new JLabel("Count: " + this.model().bar());
    this.add(this.label);

    // Add the controller of the view as an action listener on the button.
    button.addActionListener(this.controller());
  }

  /**
   * React to changes in the observed models of the view.
   *
   * @param model The model that changed.
   * @param value The value that changed.
   */
  protected void update(final Foo model, final Object value) {
    this.label.setText("Count: " + value);
  }
}
