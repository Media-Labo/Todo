package jp.co.media_labo.android.todo.activities;

import jp.co.media_labo.android.todo.R;
import jp.co.media_labo.android.todo.R.layout;
import jp.co.media_labo.android.todo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EditActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        
        // 登録ボタンにイベントリスナーを設定
        Button btn = (Button)this.findViewById( R.id.registButton );
        btn.setOnClickListener( new OnClickListener() {
        
        	@Override
        	public void onClick(View v) {
        		EditActivity.this.regist();
        	}

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_edit, menu);
        return true;
    }

    /**
     * 入力内容を登録します。
     * @return true:登録成功 false:登録失敗
     */
    private boolean regist() {
    
    	// TODO [実装]入力内容の登録
    
    	return true;
    }
}
