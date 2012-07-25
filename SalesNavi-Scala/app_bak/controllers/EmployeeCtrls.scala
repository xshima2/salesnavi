package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import forms._
import controller.LoggingAction

object EmployeeCtrls extends Controller with LoggingAction {
	val employeeForm = Form(
		mapping(
				"name" -> text,
				"mail" -> optional(email),
				"age"  -> number,
				"address" -> mapping("city" -> text)(Address.apply)(Address.unapply)
		)(Employee.apply)(Employee.unapply)
	)

	def index = LoggingAction { implicit request =>
		val emp: Employee = Employee("", Option(""), 1, Address("saitama"))
		val f: Form[Employee] = employeeForm.fill(emp)
		Ok(views.html.employee.index(f))
	}

	def regist = LoggingAction { implicit request =>
//		val employee: Employee = employeeForm.bindFromRequest.get
		employeeForm.bindFromRequest.fold(
				errors => BadRequest("<h1>入力エラー</h1>"),
				employee => {
					Ok(<p>
							name: {employee.name}<br />
							mail: {employee.mail}<br />
							age : {employee.age}<br />
							city: {employee.address.city}
							</p>).as(HTML)
				}
		)
	}
}
