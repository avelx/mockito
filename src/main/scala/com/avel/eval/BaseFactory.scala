package com.avel.eval

class BaseFactory {
  private var dataFormat : String = ""

  def compute(a: Int, b: Int) : Int = (a + b) / 2

  def recompute(a: Int, b: Int, c: Int => Int) : Int = c(a + b)

  def format(f: String) : Unit = dataFormat = f

  def formatSize : Int = dataFormat.length
}

