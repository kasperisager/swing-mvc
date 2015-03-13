/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.framework;

// Utilities
import java.util.Observable;

/**
 * The {@link Model} class describes all the basic functionality of a model
 * within the MVC architecture.
 *
 * <p>
 * From Wikipedia:
 *
 * <blockquote>
 * A model notifies its associated views and controllers when there has been a
 * change in its state. This notification allows the views to produce updated
 * output, and the controllers to change the available set of commands.
 * </blockquote>
 *
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">
 *      http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller</a>
 */
public abstract class Model extends Observable {
  /**
   * Utility method for quickly notifying observers about changes to the
   * model.
   */
  protected final void changed() {
    // Mark the model as having been changed.
    this.setChanged();

    // Notify observers about the change.
    this.notifyObservers();
  }

  /**
   * Utility method for quickly notifying observers about changes to the
   * model.
   *
   * @param value The value that changed in the model.
   */
  protected final void changed(final Object value) {
    // Mark the model as having been changed.
    this.setChanged();

    // Notify observers about the change.
    this.notifyObservers(value);
  }
}
