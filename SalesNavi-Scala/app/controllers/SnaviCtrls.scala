package controllers

import play.api._
import play.api.mvc._
import play.api.i18n.Lang

/**
 * 各種画面用の設定を切り替えるためのトレートコントローラ。
 *
 * @author yoshiteru.shimamura
 */
trait SnaviCtrls extends Controller {
		def SnaviAction(f: Request[AnyContent] => PlainResult): Action[AnyContent] = {
			Action { request =>
//				f(request).withCookies(
//					request.cookies.get("SNAVI_STYLE") match {
//						case None => Cookie("SNAVI_STYLE", "black-tie")
//						case Some(cookie) => cookie
//					}
//				)
				f(request)
			}
		}

	override implicit def lang(implicit request: RequestHeader) = {
		request.cookies.get("SNAVI_LANG") match {
			case None => super.lang(request)
			case Some(cookie) => Lang(cookie.value)
		}
	}
}
