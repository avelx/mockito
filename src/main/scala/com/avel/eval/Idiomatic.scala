package com.avel.eval

trait Foo {
  def bar: String

  def bar(v: String, x: Int = 0): Int
}

case class Json(v: String)

object UserJsonSupport {
  def toJson(a: User): Json = Json(a.name)
}

case class User(id: Int, name: String)

class UserRepository {
  private val items = Seq[User]()

  def find(id: Int): Option[User] = items.find(_.id == id)
}

class UserController(userRepository: UserRepository) {
  def get(userId: Int): Option[Json] =
    userRepository.find(userId).map(user => UserJsonSupport.toJson(user))
}
