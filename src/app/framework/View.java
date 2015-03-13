/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.framework;

// Utilities
import java.util.Observable;
import java.util.Observer;

// Swing utilities
import javax.swing.JPanel;

/**
 * The {@link View} class describes all the basic functionality of a view
 * within the MVC architecture.
 *
 * <p>
 * From Wikipedia:
 *
 * <blockquote>
 * A view requests information from the model that it uses to generate an output
 * representation to the user.
 * </blockquote>
 *
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">
 *      http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller</a>
 *
 * @param <M> The type of model that the view will operate on. This can be
 *            omitted if no model will ever be operated on by the view.
 * @param <C> The type of controller that will operate on the view. This can be
 *            omitted if no controller will ever operate on the view.
 */
public abstract class View<M extends Model, C extends Controller> extends JPanel
  implements Observer {
  /**
   * The model that the view operates on.
   */
  private M model;

  /**
   * The controller operating on the view.
   */
  private C controller;

  /**
   * Initialize the view.
   */
  public View() {
    // Run view initialization such as loading controllers and models.
    this.initialize();

    // Render the view now that the controllers and models are available.
    this.render();
  }

  /**
   * Set the model that the view operates on.
   *
   * @param model The model that the view operates on.
   */
  @SuppressWarnings("unchecked")
  protected final void model(final M model) {
    if (model == null) {
      return;
    }

    // If a model has already been associated with the view, remove the view
    // as an observer from the old model.
    if (this.model != null) {
      this.model.deleteObserver(this);
    }

    this.model = model;

    // Add the view as an observer of the model.
    this.model.addObserver(this);

    // Set the model on the controller if the controller exists.
    if (this.controller != null) {
      this.controller.model(this.model);
    }
  }

  /**
   * Access the model that the view displays.
   *
   * @return The model that the view displays.
   */
  protected final M model() {
    return this.model;
  }

  /**
   * Set the controller operating on the view.
   *
   * @param controller The controller operating on the view.
   */
  @SuppressWarnings("unchecked")
  protected final void controller(final C controller) {
    if (controller == null) {
      return;
    }

    this.controller = controller;
    this.controller.view(this);

    // Set the model on the controller if the model eixsts.
    if (this.model != null) {
      this.controller.model(this.model);
    }
  }

  /**
   * Access the controller operating on the view.
   *
   * @return The controller operating on the view.
   */
  protected final C controller() {
    return this.controller;
  }

  /**
   * Initialize the view.
   *
   * <p>
   * This method must be overriden if a controller and model is set on the view.
   * This ensures that initialization of controllers/models and rendering the
   * view happens in the correct order.
   *
   * <p>
   * The order in which the controller and model are initialized does not make a
   * difference.
   */
  protected void initialize() {
    ; // Do nothing by default.
  }

  /**
   * Render the view.
   *
   * <p>
   * This method must be implemented by subclasses and is where the view is
   * actually rendered. Subclasses have access to both the controller and model
   * of the view when this step is reached.
   */
  protected abstract void render();

  /**
   * React to changes in the observed models of the view.
   *
   * <p>
   * This method simply casts the observable to a {@link Model }of the generic
   * type as specified by the {@link View} after which the call is proxied to
   * {@link #update(Model, Object)}.
   *
   * <p>
   * This method should never be called directly and is only used by observable
   * {@link Model Models}. Use {@link #update(Model, Object)} instead.
   *
   * @param observable  The observable that changed.
   * @param object      The object that changed.
   */
  @SuppressWarnings("unchecked")
  public final void update(final Observable observable, final Object object) {
    this.update((M) observable, object);
  }

  /**
   * React to changes in the observed models of the view.
   *
   * <p>
   * This method must be overriden by subclasses if they wish to be observers.
   * Views that do not observe models do not have to override the method.
   *
   * @param model The model that changed.
   * @param value The value that changed.
   */
  public void update(final M model, final Object value) {
    throw new UnsupportedOperationException();
  }
}
