/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.framework;

// Swing utilities
import javax.swing.JFrame;

/**
 * The {@link Application} class describes a complete MVC application.
 *
 * <p>
 * The class takes care of constructing the main application frame and passing
 * it on to subclasses. To create a new MVC application one must therefore extend
 * the {@link Application} class and implement the {@link #start(JFrame)} method:
 *
 * <pre>
 * public final class MyApp extends Application {
 *   protected void start(final JFrame frame) {
 *     frame.getContentPane().add(...);
 *     frame.pack();
 *     frame.setVisible(true);
 *   }
 *
 *   public static void main(final String[] args) {
 *     new MyApp();
 *   }
 * }
 * </pre>
 *
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">
 *      http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller</a>
 */
public abstract class Application {
  /**
   * Initialize the application.
   */
  public Application() {
    // The main frame of the application.
    JFrame frame = new JFrame();

    // Exit the application when the main frame is closed.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Start the application.
    this.start(frame);
  }

  /**
   * Start the application.
   *
   * <p>
   * This method is called as the last step of {@link Application}
   * initialization. This is where the main frame of the application is made
   * available.
   *
   * @param frame The main frame of the application.
   */
  protected abstract void start(final JFrame frame);
}
