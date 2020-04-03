import com.avel.eval._
import org.mockito.MockitoSugar
import org.scalatest.flatspec.AnyFlatSpec

class BaseFactorySpec extends AnyFlatSpec with MockitoSugar {

  "Mochito" should "verify method with exact value of arguments" in {
    val mockObj = mock[BaseFactory]
    mockObj.compute(5, 10)
    verify(mockObj).compute(5, 10)
  }

  "Mochito" should "stub method calls" in {
    val mockObj = mock[BaseFactory]
    when(mockObj.compute(5, 11)) thenReturn 25
    assert(mockObj.compute(5, 11) === 25)
  }

  "Mochito" should "verify function matchers" in {
    val mockObj = mock[BaseFactory]
    val double = (x: Int) => x * 2
    mockObj.recompute(5, 4, double)
    verify(mockObj) recompute(5, 4, double)
  }

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