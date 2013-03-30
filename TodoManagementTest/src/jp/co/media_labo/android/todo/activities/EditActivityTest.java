package jp.co.media_labo.android.todo.activities;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class EditActivityTest extends ActivityInstrumentationTestCase2<EditActivity> {

	// コンポーネント名には接頭辞c_を付加
	private TextView c_summaryLabel = null;
	
	// strings.xmlの設定値には接頭辞s_を付加
	private String s_summaryLabel = null;
	/**
	 * テスト対象を指定
	 */
	public EditActivityTest() {
		// テスト対象のパッケージとクラスを設定
		super(	"jp.co.media_labo.android.todo.activities",
				EditActivity.class);
	}

	/**
	 * 各テストメソッドが呼ばれる前に実行されるメソッド
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		Activity activity = this.getActivity();
		
		// いろいろな設定値を取得
		this.c_summaryLabel 
			= (TextView)activity.findViewById(
					jp.co.media_labo.android.todo.R.id.summaryLabel );
		this.s_summaryLabel
			= activity.getString(
					jp.co.media_labo.android.todo.R.string.edit_text_title );
	}
	
	public void testSummaryLabel() throws Exception {
		assertEquals(
				this.s_summaryLabel,
				this.c_summaryLabel.getText().toString());
	}
}
