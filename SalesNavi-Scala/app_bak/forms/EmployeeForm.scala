package forms

import play.api.data._
import play.api.data.Forms._

case class Employee(name: String, mail: Option[String], age: Int, address: Address)

case class Address(city: String)

case class Test(
		val1: String,
		val2: String,
		val3: String,
		val4: String,
		val5: String,
		val6: String,
		val7: String,
		val8: String,
		val9: String,
		val10: String,
		val11: String,
		val12: String,
		val13: String,
		val14: String,
		val15: String,
		val16: String,
		val17: String,
		val18: String,
		val19: String,
		val20: String,
		val21: String,
		val22: String
//		val23: String,
//		val24: String,
//		val25: String,
//		val26: String
		)
