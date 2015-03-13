/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.view;

// Utilities
import java.util.Observable;

// AWT utilities
import java.awt.Component;

// AWT eventt
import java.awt.event.ActionListener;

// Swing utilities
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
  public FooView() {
    this.model(new Foo());
    this.controller(new FooController());
  }

  /**
   * Render the view as an AWT component.
   *
   * @return The rendered AWT component.
   */
  public Component render() {
    JPanel panel = new JPanel();
    JButton button = new JButton("Plus One");
    panel.add(button);

    this.label = new JLabel("Count: " + this.model().bar());
    panel.add(this.label);

    // Add the controller of the view as an action listener on the button.
    button.addActionListener(this.controller());

    return panel;
  }

  /**
   * React to changes in the observed models of the view.
   *
   * @param model The model that changed.
   */
  public void update(final Foo model, final Object value) {
    this.label.setText("Count: " + value);
  }
}
