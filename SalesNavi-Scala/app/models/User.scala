package models

case class User(uid: String, name: String, mail: Option[String], tel1: String, memo: String)
