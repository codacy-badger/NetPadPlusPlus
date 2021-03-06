/*
 * © 2020. TU Dortmund University,
 * Institute of Energy Systems, Energy Efficiency and Energy Economics,
 * Research group Distribution grid planning and operation
*/
package edu.ie3.netpad.io;

import edu.ie3.datamodel.io.FileNamingStrategy;
import edu.ie3.datamodel.io.source.csv.*;
import edu.ie3.datamodel.models.input.container.GraphicElements;
import edu.ie3.datamodel.models.input.container.JointGridContainer;
import edu.ie3.datamodel.models.input.container.RawGridElements;
import edu.ie3.datamodel.models.input.container.SystemParticipants;

/**
 * //ToDo: Class Description
 *
 * @version 0.1
 * @since 15.05.20
 */
public class CsvGridSource {

  private final String CSV_SEP = ";"; // todo provide option field for csv separator

  private final FileNamingStrategy csvFileNamingStrategy = new FileNamingStrategy();
  private final CsvTypeSource csvTypeSource;
  private final CsvRawGridSource csvRawGridSource;
  private final CsvSystemParticipantSource csvSystemParticipantSource;
  private final CsvGraphicSource csvGraphicSource;
  private final CsvThermalSource csvThermalSource;

  private final String gridName;

  public CsvGridSource(String baseFolder, String gridName) {
    this.gridName = gridName;
    this.csvTypeSource = new CsvTypeSource(CSV_SEP, baseFolder, csvFileNamingStrategy);
    this.csvRawGridSource =
        new CsvRawGridSource(CSV_SEP, baseFolder, csvFileNamingStrategy, csvTypeSource);
    this.csvThermalSource =
        new CsvThermalSource(CSV_SEP, baseFolder, csvFileNamingStrategy, csvTypeSource);
    this.csvSystemParticipantSource =
        new CsvSystemParticipantSource(
            CSV_SEP,
            baseFolder,
            csvFileNamingStrategy,
            csvTypeSource,
            csvThermalSource,
            csvRawGridSource);
    this.csvGraphicSource =
        new CsvGraphicSource(
            CSV_SEP, baseFolder, csvFileNamingStrategy, csvTypeSource, csvRawGridSource);
  }

  public JointGridContainer getGrid() {
    final RawGridElements rawGridElements =
        csvRawGridSource
            .getGridData()
            .orElseThrow(
                () -> new RuntimeException("Error while trying to read new RawGridElements!"));
    final SystemParticipants systemParticipants =
        csvSystemParticipantSource
            .getSystemParticipants()
            .orElseThrow(
                () -> new RuntimeException("Error while trying to read new SystemParticipants!"));
    final GraphicElements graphicElements =
        csvGraphicSource
            .getGraphicElements()
            .orElseThrow(
                () -> new RuntimeException("Error while trying to read new GraphicElements!"));

    /* Call the constructor, that is calling several checks by itself */
    return new JointGridContainer(gridName, rawGridElements, systemParticipants, graphicElements);
  }
}
