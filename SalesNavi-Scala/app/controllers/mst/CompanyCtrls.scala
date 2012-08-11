package controllers.mst

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.data._
import play.api.data.Forms._
import com.codahale.jerkson.Json._
import play.api.libs.json.JsValue
import controllers.SnaviCtrls

/**
 * 会社マスタ管理用のコントローラ。
 *
 * @author yoshiteru.shimamura
 */
object CompanyCtrls extends SnaviCtrls {
	def index = Action { implicit request =>
		Ok(views.html.company_add(null))
	}
}
