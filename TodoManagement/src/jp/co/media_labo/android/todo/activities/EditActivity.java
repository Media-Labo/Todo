package jp.co.media_labo.android.todo.activities;

import java.util.Calendar;
import java.util.Date;

import jp.co.media_labo.android.todo.R;
import jp.co.media_labo.android.todo.R.layout;
import jp.co.media_labo.android.todo.R.menu;
import jp.co.media_labo.android.todo.entities.TodoEntity.TodoEntityBuilder;
import jp.co.media_labo.android.todo.entities.TodoStatus;
import jp.co.media_labo.android.todo.util.TodoManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends Activity {

	/** 期間の最大値 */
	private static final int TERM_MAX = 14;
	
	/** 星ひとつあたりの優先度 */
	private static final int RATE_PER_STAR = 2;
	
	/** 表示する星の数 */
	private static final int NUM_OF_STAR = 5;
	
	/** Todoに関する操作を行うクラス */
	private TodoManager manager = null;
	
	/**
	 * 編集画面を生成する。
	 */
	public EditActivity() {
		this.manager = new TodoManager( this );
	}
	
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
        
        // シークバーに値を設定
        SeekBar termBar = (SeekBar)this.findViewById( R.id.seekTerm );
        termBar.setMax( TERM_MAX );
        termBar.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO 自動生成されたメソッド・スタブ
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO 自動生成されたメソッド・スタブ
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO 自動生成されたメソッド・スタブ
				int term = EditActivity.this.getInputtedTerm();
				TextView label = (TextView)EditActivity.this.findViewById( R.id.textView2 );
				label.setText( "詳細(あと" + term + "日)");
			}
		});
        
        // 優先度を設定
        RatingBar rateBar = (RatingBar)this.findViewById( R.id.priorityBar );
        rateBar.setNumStars( NUM_OF_STAR );
        rateBar.setOnRatingBarChangeListener( new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
				// TODO 自動生成されたメソッド・スタブ
				int rate = EditActivity.this.getInputtedPriority();
				TextView label = (TextView)EditActivity.this.findViewById( R.id.textView3 );
				label.setText( "優先度(" + rate + ")");
				
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
    
    	try {
    		Calendar now = Calendar.getInstance();
	    	Calendar endDate = (Calendar)now.clone();
	    	endDate.add( Calendar.DATE, this.getInputtedTerm() );
	    	
	    	TodoEntityBuilder builder = new TodoEntityBuilder();
	    	
	    	// 入力内容を詰め込む
	    	// TODO [修正]IDを計算しないといけない
	    	builder.setId( 1 );
	    	
	    	builder.setSummary( this.getInputtedTitle() );
	    	builder.setDetail( this.getInputtedDetail() );
	    	builder.setStatus( TodoStatus.CREATED );
	    	builder.setWeight( this.getInputtedPriority() );
	    	builder.setCreateDate( now.getTime() );
	    	builder.setStartDate( now.getTime() );
	    	builder.setEndDate( endDate.getTime() );
	    	
	    	this.manager.create( builder.build() );
	    	
	    	Toast.makeText( this, "登録しました", Toast.LENGTH_LONG ).show();
	    	return true;
    	}
    	catch( Exception e ) {
    		// TODO [実装]ログ出力
    		e.printStackTrace();
	    	Toast.makeText( this, "登録できませんでした", Toast.LENGTH_LONG ).show();
    		return false;
    	}
    }
    
    /**
     * 入力されたタイトルを取得します。
     * @return タイトル
     */
    private String getInputtedTitle() {
    	EditText title = (EditText)this.findViewById( R.id.editTitle );
    	return title.toString();
    }
    
    /**
     * 入力された期間を取得します。
     * @return 期間(日)
     */
    private int getInputtedTerm() {
    	SeekBar bar = (SeekBar)this.findViewById( R.id.seekTerm );
    	return bar.getProgress();
    }
    
    /**
     * 入力された優先度を取得します。
     * @return 優先度
     */
    private int getInputtedPriority() {
    	RatingBar bar = (RatingBar)this.findViewById( R.id.priorityBar );
    	return Math.round( bar.getRating() * RATE_PER_STAR );
    }
    
    /**
     * 入力された開始日を取得します。
     * @return 開始日
     */
    private Date getInputtedStartDate() {
    	DatePicker picker = (DatePicker)this.findViewById( R.id.startDatePicker );
    	int year = picker.getYear();
    	int month = picker.getMonth();
    	int day = picker.getDayOfMonth();
    	
    	return new Date( year, month, day );
    }
    
    /**
     * 入力された終了日を取得します。
     * @return 終了日
     */
    private Date getInputtedEndDate() {
    	DatePicker picker = (DatePicker)this.findViewById( R.id.endDatePicker );
    	int year = picker.getYear();
    	int month = picker.getMonth();
    	int day = picker.getDayOfMonth();
    	
    	return new Date( year, month, day );
    }
    
    /**
     * 入力された詳細を取得します。
     * @return 詳細
     */
    private String getInputtedDetail() {
    	EditText edit = (EditText)this.findViewById( R.id.editDetail );
    	return edit.getText().toString();
    }
}
