package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.i18n.Lang

/**
 * 共通的な処理を保持する。
 *
 * @author yoshiteru.shimamura
 */
object CommonCtrls extends Controller {
//	def changeSetting = Action { implicit request =>
//		val params: Map[String, Seq[String]] = request.queryString
//		if (params.contains("lang")) Lang.set(params("lang").head)
//		Redirect(params("prev").head)
//	}
}
