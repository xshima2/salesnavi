package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

/** ログインの際に使用するユーザ情報。*/
case class User(uid: String, pass: String)

object LoginCtrls extends Controller {
	val userForm = Form(
			mapping(
					"uid" -> nonEmptyText(1, 8),
					"pass" -> nonEmptyText(1, 8)
			)(User.apply)(User.unapply)
	)

	def index = Action { implicit request =>
		val user = User("", "")
		Ok(views.html.index(userForm.fill(user)))
	}

	def login = Action { implicit request =>
		userForm.bindFromRequest.fold(
				errors => BadRequest(views.html.index(errors)),
				user => {
					Ok(views.html.index(userForm.fill(user)))
				}
		)
	}
}
