package account

import scala.slick.driver.H2Driver.simple._

object HelloAccount extends App {
  
  val account: TableQuery[Account] = TableQuery[Account]
  
  val db = Database.forURL("jdbc:h2:mem:hello", driver = "org.h2.Driver")
  db.withSession { implicit session =>
    account.ddl create
    
    account += (None, "antoine")
    account += (None, "alfred")
    
    val accounts: List[(Option[Long], String)] = account.list
    
    accounts foreach {
      case (Some(id), name) => println(s"Account of $name, $id")
      case (None, name) => println(s"Account of $name")
    }
  }

}