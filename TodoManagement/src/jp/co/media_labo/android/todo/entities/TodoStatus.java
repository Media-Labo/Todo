/**
 *
 */
package jp.co.media_labo.android.todo.entities;

/**
 * ToDoの状態を表す列挙
 * @author tanabe
 *
 */
public enum TodoStatus {
	CREATED(0),	// 作成直後で未着手
	COMPLETED(1),	// 終了
	DELETED(2);	// 削除
	
	/** 対応する数値 */
	private int value;
	
	/**
	 * 数値を紐づけます
	 * @param value 数値
	 */
	private TodoStatus( int value ) {
		this.value = value;
	}
	
	/**
	 * 列挙型から数値に変換
	 * @return 数値
	 */
	public int toValue() {
		return this.value;
	}
	
	/**
	 * 数値に対応する列挙型を取得
	 * @param value 数値
	 * @return 数値に対応する列挙型。対応するものがない場合はnull。
	 */
	public static TodoStatus valueOf( int value ) {
		for( TodoStatus t : values() ) {
			if( t.toValue() == value ) {
				return t;
			}
		}
		return null;
	}
}
