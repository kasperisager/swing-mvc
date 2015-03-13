/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.framework;

// Utilities
import java.util.EventListener;

/**
 * The {@link Controller} class describes all the basic functionality of a
 * controller within the MVC architecture.
 *
 * <p>
 * From Wikipedia:
 *
 * <blockquote>
 * A controller can send commands to the model to update the model's state
 * (e.g., editing a document). It can also send commands to its associated view
 * to change the view's presentation of the model (e.g., by scrolling through a
 * document).
 * </blockquote>
 *
 * <p>
 * All {@link Controller Controllers} implement the {@link EventListener}
 * interface by default and thus aren't really useful out of the box. It is
 * therefore needed to further implement other {@link EventListener} interfaces
 * from the Java, AWT, and Swing packages in order to utilize controllers:
 *
 * <pre>
 * public final class MyController extends Controller&lt;MyModel, MyView&gt;
 *   implements KeyListener, MouseListener, ActionListener {
 *   // ...
 * }
 * </pre>
 *
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">
 *      http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller</a>
 *
 * @param <M> The type of model the the view of the controller will operate on.
 * @param <V> The type of view that this controller will operate on.
 */
public abstract class Controller<M extends Model, V extends View>
  implements EventListener {
  /**
   * The model that the view of the controller operates on.
   */
  private M model;

  /**
   * The view that the controller operates on.
   */
  private V view;

  /**
   * Set the model that the view of the controller operates on.
   *
   * <p>
   * This method is used by the {@link View} class when initializing its
   * controller and should never be used directly.
   *
   * @param model The model that the view of the controller operates on.
   */
  protected final void model(final M model) {
    if (model == null) {
      return;
    }

    this.model = model;
  }

  /**
   * Access the model that the view of the controller operates on.
   *
   * @return The model that the view of the controller operates on.
   */
  protected final M model() {
    return this.model;
  }

  /**
   * Set the view that the controller operates on.
   *
   * <p>
   * This method is used by the {@link View} class when initializing its
   * controller and should never be used directly.
   *
   * @param view  The view that the controller operates on.
   */
  protected final void view(final V view) {
    if (view == null) {
      return;
    }

    this.view = view;
  }

  /**
   * Access the view that the controller operates on.
   *
   * @return The view that the controller operates on.
   */
  protected final V view() {
    return this.view;
  }
}
