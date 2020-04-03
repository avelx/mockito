import com.avel.eval._
import org.scalatest.flatspec.AnyFlatSpec

class ScalaFeaturesSpec extends AnyFlatSpec {
  "Meter addition" should "return correct result" in {
    val x = new Meter(2.3)
    val y = new Meter(3.5)
    val z = x + y
    assert(z === Meter(5.8))
  }

  "Meter subtraction" should "return correct result" in {
    val x = new Meter(7.3)
    val y = new Meter(3.5)
    val z = x - y
    assert(z === Meter(3.8))
  }

  "Meter subtraction" should "raise exception" in {
    val x = new Meter(3.3)
    val y = new Meter(3.5)
    val thrown = intercept[Error]{
      x - y
    }
    assert(thrown.getMessage === "Negative result")
  }
}
