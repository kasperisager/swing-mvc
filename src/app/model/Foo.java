/**
 * Copyright (C) 2015 Kasper Kronborg Isager.
 */
package app.model;

// Framework
import app.framework.Model;

/**
 * Example {@link Model} using the MVC micro-framework presented in
 * {@link app.framework}.
 */
public final class Foo extends Model {
  /**
   * Bar of the foo.
   */
  private int bar;

  /**
   * Get the bar of the foo.
   *
   * @return The bar of the foo.
   */
  public int bar() {
    return this.bar;
  }

  /**
   * Set the bar of the foo.
   *
   * @param bar The bar of the foo.
   */
  public void bar(final int bar) {
    this.bar += bar;

    // Let observers know that we changed the bar.
    this.changed(this.bar);
  }
}
