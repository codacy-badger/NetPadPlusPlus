/*
 * © 2020. TU Dortmund University,
 * Institute of Energy Systems, Energy Efficiency and Energy Economics,
 * Research group Distribution grid planning and operation
*/
package edu.ie3.netpad.main;

/**
 * Helper class needed when launching the app from IntelliJ. see
 * https://stackoverflow.com/questions/52653836/maven-shade-javafx-runtime-components-are-missing
 *
 * @author hiry
 * @version 0.1
 * @since 2019-05-18
 */
public class IntelliJMainLauncher {

  public static void main(String[] args) {
    NetPadPlusPlus.main(args);
  }
}
