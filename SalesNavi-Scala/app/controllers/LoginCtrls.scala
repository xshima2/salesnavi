package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.data._
import play.api.data.Forms._
import com.codahale.jerkson.Json._
import play.api.libs.json.JsValue

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
			"pass" -> nonEmptyText(0, 8))(User.apply)(User.unapply))

	def index = Action { implicit request =>
		val user = User("", "")
		Ok(views.html.index(userForm.fill(user)))
	}

	def login = Action { implicit request =>
		userForm.bindFromRequest.fold(
			errors => BadRequest(views.html.index(errors)),
			user => {
				Redirect(routes.TopCtrls.index)
			})
	}
}
