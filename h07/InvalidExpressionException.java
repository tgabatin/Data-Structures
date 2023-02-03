package edu.ics211.h07;

/**
 * Represents a InvalidExpressionException.
 *
 * @author Cam Moore
 *
 */
public class InvalidExpressionException extends Exception {

  /** Default constructor. */
  public InvalidExpressionException() {
    super();
  }


  /**
   * Constructs an IvalidExpressionException with the given message.
   * 
   * @param message the error message.
   */
  public InvalidExpressionException(String message) {
    super(message);
  }

  /** Holds the serialVersionUID value a long. */
  private static final long serialVersionUID = -5121813737929147074L;

}