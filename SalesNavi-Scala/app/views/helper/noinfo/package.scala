package views.html.helper

/**
 * ヘルパーをカスタマイズ。
 *
 * @author Yoshiteru.Shimamura
 */
package object noinfo {
	/**
	 * 入力項目などのフィールド用のコンストラクタを入れ替え。
	 */
  implicit val noinfoField = new FieldConstructor {
    def apply(elts: FieldElements) = noInfoFieldConstructor(elts)
  }
}
