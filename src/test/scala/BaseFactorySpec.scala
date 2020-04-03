import java.util
import com.avel.eval._
import org.mockito.MockitoSugar
import org.mockito.captor.ArgCaptor
import org.scalatest.flatspec.AnyFlatSpec

class BaseFactorySpec extends AnyFlatSpec with MockitoSugar {

  "Mochito" should "verify method with exact value of arguments" in {
    val mockObj = mock[BaseFactory]
    mockObj.compute(5, 10)
    verify(mockObj).compute(5, 10)
  }

  "Mockito" should "stub method calls" in {
    val mockObj = mock[BaseFactory]
    when(mockObj.compute(5, 11)) thenReturn 25
    assert(mockObj.compute(5, 11) === 25)
  }

  "Mockito" should "verify function matchers" in {
    val mockObj = mock[BaseFactory]
    val double = (x: Int) => x * 2
    mockObj.recompute(5, 4, double)
    verify(mockObj) recompute(5, 4, double)
  }

  "Mockito captor" should "verify argument call" in {
    val mockObj = mock[BaseFactory]
    val captor = ArgCaptor[String]
    mockObj.format("NewDataFormat")
    verify(mockObj).format(captor)
    captor.hasCaptured("NewDataFormat")
  }

  "formatSize" should "return 100" in {
    val ba = spy( new BaseFactory() )
    when(ba.formatSize).thenReturn(100)
    assert(ba.formatSize === 100)
  }

}