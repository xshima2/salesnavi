package controllers

import play.api._
import play.api.mvc._

object HelloCtrls extends Controller {
	def index(name: String) = Action {
		Ok(<p>Hello {name}!!</p>).as(HTML)
	}
}
