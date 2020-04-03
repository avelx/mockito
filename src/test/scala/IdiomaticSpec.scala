import com.avel.eval.{Foo, Json, User, UserController, UserRepository}
import org.mockito.{ArgumentMatchersSugar, IdiomaticMockito, MockitoSugar}
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.DefaultAnswer
import org.scalatest.flatspec.AnyFlatSpec

class IdiomaticSpec extends AnyFlatSpec with IdiomaticMockito {

  "Trait method call" should "return expected value" in {
    val objMock = mock[Foo]
    objMock.bar returns "this is idiomatic data!"
    assert(objMock.bar === "this is idiomatic data!")
  }

  "UserController" should "return value out of defaults" in {
    implicit val defaultAnswer: DefaultAnswer = DefaultAnswer(Some(User(123, "DataTest")))

    val repo = mock[UserRepository]

    val testObject = new UserController(repo)

    assert(testObject.get(123) === Some(Json("DataTest")))
  }
}

class IdiomaticSpec2 extends AnyFlatSpec with MockitoSugar with ArgumentMatchersSugar {

  "Function Answers" should "intercept arguments actuals and overrrid result" in {
    val objMock = mock[Foo]
    when( objMock.bar("70", 42)) thenAnswer ( (v1: String, v2: Int) => v1.toInt + v2 )
    assert( objMock.bar("70", 42) === 112)
  }

}
