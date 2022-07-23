package com.deahansi.utils;

public class TableUtils {
  public static String getTable(String nreTypeCode, String dataKind, String dataType) {
    StringBuilder tableBuilder = new StringBuilder("data_");
    switch (dataKind) {
      case "FREQUENCY":
        break;
      case "HOURLY":
        tableBuilder.append("1h_");
        break;
      case "DAILY":
        tableBuilder.append("24h_");
        break;
      case "MONTHLY":
        tableBuilder.append("month_");
        break;
      case "YEARLY":
        tableBuilder.append("year_");
        break;
    }
    switch (dataType) {
      case "raw":
        tableBuilder.append("raws_");
        break;
      case "kdtd":
        tableBuilder.append("kdtd_");
        break;
      case "kdtc":
        tableBuilder.append("24h_");
    }
    switch (nreTypeCode) {
      case "NM":
        tableBuilder.append("nm");
        break;
      case "NDD":
        tableBuilder.append("ndd");
        break;
    }
    return tableBuilder.toString();
  }
}
