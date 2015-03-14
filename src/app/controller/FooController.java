/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.controller;

// AWT events
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Framework
import app.framework.Controller;

// Models
import app.model.Foo;

// Views
import app.view.FooView;

/**
 * Example controller using the MVC micro-framework presented in
 * {@link app.framework}.
 */
public final class FooController extends Controller<Foo, FooView>
  implements ActionListener {
  /**
   * An action was performed.
   *
   * @param e The action event that was performed.
   */
  public void actionPerformed(final ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Plus One":
        this.model().bar(1);
        break;
    }
  }
}
