package com.redtek.rootsys.capabilities.mode;

public class ToolMode implements IMode {

  private String toolMode = "Normal";

  @Override
  public void nextMode() {
    switch (this.getMode()) {
      default:
        this.toolMode = "Hammer";
        break;
      case "Hammer":
        this.toolMode = "Vein";
        break;
      case "Vein":
        this.toolMode = "Normal";
        break;
    }
  }

  @Override
  public void setMode(String mode) {
    this.toolMode = mode;
  }

  @Override
  public String getMode() {
    return this.toolMode;
  }
}
