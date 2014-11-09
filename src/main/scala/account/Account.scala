package account

import scala.slick.driver.H2Driver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

class Account(tag: Tag) 
  extends Table[(Option[Long], String)](tag, "ACCOUNT"){
  
  def id: Column[Long] = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def name: Column[String] = column[String]("name")

  def * : ProvenShape[(Option[Long], String)] = (id ?, name)
}
