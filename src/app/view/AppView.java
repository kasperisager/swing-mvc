/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.view;

// Framework
import app.framework.View;

/**
 * Example {@link View} using the MVC micro-framework presented in
 * {@link app.framework}.
 *
 * <p>
 * This view is sorta special in the sense that it's the main entry point to
 * the rest of the application. All it does is render the other views of the
 * application.
 *
 * <p>
 * This view is also an example of a view associated with neither a model nor a
 * controller.
 */
public final class AppView extends View {
  /**
   * Render the view.
   */
  protected void render() {
    this.add(new FooView());
  }
}
