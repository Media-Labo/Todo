package jp.co.media_labo.android.todo.util;

import android.content.Context;
import jp.co.media_labo.android.todo.entities.TodoEntity;

public class TodoManager {

	private TodoEntityContainer todoData;
	
	public TodoManager(Context context){
		
	}

	public Boolean create(TodoEntity entity){
		return true;		
	}
	
	public TodoEntity read(int id) {
		return null;
	}
	
	public Boolean update(TodoEntity entity){
		return true;
	}
	
	public Boolean delete (int id){
		return true;
	}
	
	//ÉtÉ@ÉCÉãÇÊÇËì«Ç›çûÇ›
	public void load (Context context){
		TodoFileUtil fileUtil=new TodoFileUtil();
		todoData = fileUtil.load(context);		
	}
	
	public void save (Context context){
		
	}
	
}
