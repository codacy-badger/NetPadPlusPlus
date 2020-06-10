/*
 * © 2020. TU Dortmund University,
 * Institute of Energy Systems, Energy Efficiency and Energy Economics,
 * Research group Distribution grid planning and operation
*/
package edu.ie3.netpad.exception;

/**
 * //ToDo: Class Description
 *
 * @version 0.1
 * @since 10.06.20
 */
public class IoControllerException extends RuntimeException {

  public IoControllerException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public IoControllerException(final Throwable cause) {
    super(cause);
  }

  public IoControllerException(final String message) {
    super(message);
  }
}
