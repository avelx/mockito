import com.avel.eval.BaseFactory
import org.mockito.MockitoSugar
import org.scalatest.flatspec.AnyFlatSpec

class BaseFactorySpec extends AnyFlatSpec with MockitoSugar {

  "Mochito" should "call method with exact arguments" in {
    val (a, b) = (5, 10)
    val obj = mock[BaseFactory]
    obj.compute(a, b)
    verify(obj).compute( a, b )
  }



}
