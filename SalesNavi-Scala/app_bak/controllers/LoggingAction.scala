package controller

import play.api._
import play.api.mvc._

trait LoggingAction {
		def LoggingAction(f: Request[AnyContent] => PlainResult): Action[AnyContent] = {
		Action { request =>
			Logger.info("Calling action")
			f(request)
		}
	}
}
