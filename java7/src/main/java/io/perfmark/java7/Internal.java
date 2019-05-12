package io.perfmark.java7;

import io.perfmark.impl.Generator;

public final class Internal {

  public static Generator createMethodHandleGenerator() {
    return new SecretMethodHandleGenerator.MethodHandleGenerator();
  }

  private Internal() {
    throw new AssertionError("nope");
  }
}