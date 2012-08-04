package controllers

import play.api._
import play.api.mvc._
import play.api.i18n.Lang
import play.api.libs.iteratee._
import play.api.http._
import play.api.mvc.{ Results => BaseResults }

/**
 * 各種画面用の設定を切り替えるためのトレートコントローラ。
 *
 * @author yoshiteru.shimamura
 */
trait SnaviCtrls extends Controller {
	override implicit def lang(implicit request: RequestHeader) = {
		request.cookies.get("SNAVI_LANG") match {
			case None => super.lang(request)
			case Some(cookie) => Lang(cookie.value)
		}
	}

	object Redirect {
		def apply(url: String, status: Int)(implicit request: RequestHeader): SimpleResult[BaseResults.EmptyContent] =
			this.apply(url, Map.empty, status)

		def apply(call: Call)(implicit request: RequestHeader): SimpleResult[BaseResults.EmptyContent] =
			this.apply(call.url)

		def apply(url: String, queryString: Map[String, Seq[String]] = Map.empty, status: Int = SEE_OTHER)
		(implicit request: RequestHeader) = {
			BaseResults.Redirect(url, queryString, status).withHeaders("REDIRECT-URL" -> url)
		}
	}

	object Action {
		def apply[A](bodyParser: BodyParser[A])(block: Request[A] => Result): Action[A] = new Action[A] {
			def parser = bodyParser
			def apply(ctx: Request[A]) = block(ctx)
		}

		def apply(block: Request[AnyContent] => Result): Action[AnyContent] = {
			Action(BodyParsers.parse.anyContent)(block)
		}

		def apply(block: => Result): Action[AnyContent] = {
			this.apply(_ => block)
		}
	}
}
