package account

import scala.slick.driver.H2Driver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

class Account(tag: Tag) 
  extends Table[(Option[Int], String)](tag, "ACCOUNT"){
  
  def id: Column[Int] = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def name: Column[String] = column[String]("name")

  def * : ProvenShape[(Option[Int], String)] = (id ?, name)
}
