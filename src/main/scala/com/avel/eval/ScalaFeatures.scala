package com.avel.eval

// define value class
class Meter(val value: Double) extends AnyVal {
  def +(m: Meter): Meter = new Meter(value + m.value)
  def -(m: Meter): Meter =
    if (value < m.value)
      throw new Error("Negative result")
    else
      new Meter(value - m.value)
}

object Meter {
  def apply(value: Double): Meter = new Meter(value)
}