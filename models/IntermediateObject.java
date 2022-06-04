package com.kbh.snl.models;

public abstract class IntermediateObject {

  private final int startPosition;
  private final int endPosition;

  public IntermediateObject(final int startPosition, final int endPosition) {
    this.startPosition = startPosition;
    this.endPosition = endPosition;
  }

  public int getStartPosition() {
    return startPosition;
  }

  public int getEndPosition() {
    return endPosition;
  }
}
