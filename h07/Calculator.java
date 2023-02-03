package edu.ics211.h07;

/**
 * The calculator class, using prefix and postfix methods to calculate.
 * 
 * @author Taylor D. Gabatino received help from Cam Moore and Matthew Kirts.
 *
 */
public class Calculator implements ICalculator {
  public static Calculator instance;
  private TaylorStack<Number> numbers;


  /**
   * A constructor for the calculator class.
   */
  private Calculator() {
    this.numbers = new TaylorStack<Number>();
  }


  /**
   * Creates a new instance of the Stack class to call the Stack Interface.
   */
  @Override
  public void clear() {
    this.numbers = new TaylorStack<Number>();

  }


  /**
   * Returns the singleton.
   * 
   * @return the singleton
   */
  public static Calculator getInstance() {
    if (instance == null) {
      instance = new Calculator();
    }
    return instance;

  }


  /**
   * The postFix calculator that supports postfix calculation.
   * 
   * @param expression the expression
   * @return answer the answer
   * @throws InvalidExpressionException throws the exception if there is no token.
   */
  public Number postFixCalculate(String expression) throws InvalidExpressionException {
    String[] tokens = expression.split("\\s+");
    for (String token : tokens) {
      if (isNumber(token)) {
        numbers.push(toNumber(token));
      } else if (isOperator(token)) {
        Number rhs = numbers.pop();
        Number lhs = numbers.pop();
        Number answer = doTheMath(rhs, lhs, token);
        numbers.push((answer));
      } else {
        throw new InvalidExpressionException();
      }
    }
    Number answer = numbers.pop();
    if (!numbers.empty()) {
      throw new InvalidExpressionException();
    }
    return answer;
  }


  /**
   * The prefix calculator that supports prefix calculation.
   * 
   * @param expression the expression
   * @return answer the answer
   * @throws InvalidExpressionException throw if numbers not empty
   */
  public Number preFixCalculate(String expression) throws InvalidExpressionException {
    String[] tokens = expression.split("\\s+");
    for (int i = tokens.length - 1; i >= 0; i--) {
      String token = tokens[i];
      if (isNumber(token)) {
        numbers.push(toNumber(token));
      } else if (isOperator(token)) {
        Number lhs = numbers.pop();
        Number rhs = numbers.pop();
        Number answer = doTheMath(rhs, lhs, token);
        numbers.push((answer));
      } else {
        throw new InvalidExpressionException();
      }
    }
    Number answer = numbers.pop();
    if (!numbers.empty()) {
      throw new InvalidExpressionException();
    }
    return answer;
  }


  /**
   * Boolean method to check if the token being parsed is an integer.
   * 
   * @param token the token within the parameters to be parsed to an integer.
   * @return false
   */
  private boolean isNumber(String token) {
    try {
      Integer.parseInt(token);
    } catch (NumberFormatException nfe) {
      try {
        Double.parseDouble(token);
      } catch (NumberFormatException e) {
        return false;
      }
    }
    return true;
  }


  /**
   * Does the math for the postfix or prefix methods determined.
   * 
   * @param rhs the values for the right hand side of the equation.
   * @param lhs the values for the left hand side of the equation.
   * @param token the expressions that is used to calculate the rhs and lhs.
   * @return the rhs and lhs variables.
   */
  private Number doTheMath(Number rhs, Number lhs, String token) {
    switch (token) {
      case ("+"):
        if (lhs instanceof Integer && rhs instanceof Integer) {
          return lhs.intValue() + rhs.intValue();
        }
        return lhs.doubleValue() + rhs.doubleValue();
      case ("-"):
        if (lhs instanceof Integer && rhs instanceof Integer) {
          return lhs.intValue() - rhs.intValue();
        }
        return lhs.doubleValue() - rhs.doubleValue();
      case ("*"):
        if (lhs instanceof Integer && rhs instanceof Integer) {
          return lhs.intValue() * rhs.intValue();
        }
        return lhs.doubleValue() * rhs.doubleValue();
      case ("/"):
        if (lhs instanceof Integer && rhs instanceof Integer) {
          return lhs.intValue() / rhs.intValue();
        }
        return lhs.doubleValue() / rhs.doubleValue();
      default:
        return null;
    }
  }


  /**
   * Checks to see which operator is being used.
   * 
   * @param token The operator in which the operand is to conduct calculations.
   * @return true.
   * @throws InvalidExpressionException throws the error if incorrect operator.
   */
  private boolean isOperator(String token) throws InvalidExpressionException {
    switch (token) {
      case "+":
      case "-":
      case "*":
      case "/":
        return true;
      default:
        throw new InvalidExpressionException();
    }
  }


  /**
   * Takes in the token as parameters and parses it to an integer.
   * 
   * @param token the operator to be parsed to an integer.
   * @return the result of the token that is parsed.
   */
  private Number toNumber(String token) {
    Number result = null;
    try {
      result = Integer.parseInt(token);
    } catch (NumberFormatException nfe) {
      try {
        result = Double.parseDouble(token);
      } catch (NumberFormatException e) {
        // This is accepted.
      }
    }
    return result;
  }

}
