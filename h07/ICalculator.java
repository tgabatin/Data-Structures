package edu.ics211.h07;

/**
 * Represents a ICalculator.
 *
 * @author Cam Moore
 *
 */
public interface ICalculator {
  /** Clears the calculator. */
  void clear();

  /**
   * Calculates the answer to the post-fix expression and returns it as a Number.
   *
   * @param expression the post-fix expression.
   * @return The answer as a Number.
   * @throws InvalidExpressionException if the expression is invalid.
   */
  Number postFixCalculate(String expression) throws InvalidExpressionException;

  /**
   * Calculates the answer to the pre-fix expression and returns it as a Number.
   * This method is optional. You will get extra credit if you implement this method.
   * Otherwise just throw an UnsupportedOperationException.
   *
   * @param expression the pre-fix expression.
   * @return The answer as a Number.
   * @throws InvalidExpressionException if the expression is invalid.
   */
  Number preFixCalculate(String expression) throws InvalidExpressionException;
}