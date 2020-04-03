package com.avel.eval

class BaseFactory {

  def compute(a: Int, b: Int) : Int = (a + b) / 2

  def recompute(a: Int, b: Int, c: Int => Int) : Int = c(a + b)

}

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