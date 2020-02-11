package com.redtek.rootsys.capabilities;

import com.redtek.rootsys.capabilities.mode.IMode;
import com.redtek.rootsys.capabilities.mode.ToolMode;
import jdk.internal.dynalink.linker.LinkerServices;

import java.util.concurrent.Callable;

public class Factory implements Callable<IMode> {
  @Override
  public IMode call() throws Exception {
    return new ToolMode();
  }
}
