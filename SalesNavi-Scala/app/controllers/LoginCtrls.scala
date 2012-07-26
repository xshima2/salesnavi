package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

/** ログインの際に使用するユーザ情報。*/
case class User(uid: String, pass: String)

/**
 * ログイン画面用のコントローラ。
 *
 * @author yoshiteru.shimamura
 */
object LoginCtrls extends SnaviCtrls {
	val userForm = Form(
			mapping(
					"uid" -> nonEmptyText(0, 8),
					"pass" -> nonEmptyText(0, 8)
			)(User.apply)(User.unapply)
	)

	def index = SnaviAction { implicit request =>
		val user = User("", "")
		Ok(views.html.index(userForm.fill(user)))
	}

	def login = SnaviAction { implicit request =>
		userForm.bindFromRequest.fold(
				errors => BadRequest(views.html.index(errors)),
				user => {
					Ok(views.html.index(userForm.fill(user)))
				}
		)
	}
}
