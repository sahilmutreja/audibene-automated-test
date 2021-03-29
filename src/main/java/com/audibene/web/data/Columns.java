package com.audibene.web.data;

public enum Columns {
  LAST_NAME(1),
  FIRST_NAME(2),
  EMAIL(3);
  public int position;

  Columns(int index) {
    this.position = index;
  }
}
