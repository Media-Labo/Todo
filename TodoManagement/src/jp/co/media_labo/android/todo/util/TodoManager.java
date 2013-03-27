package jp.co.media_labo.android.todo.util;

import android.content.Context;
import jp.co.media_labo.android.todo.entities.TodoEntity;

public class TodoManager {

	private TodoEntityContainer todoData;
	
	public TodoManager(Context context){
		
	}

	public Boolean create(TodoEntity entity){
		return todoData.add(entity);		
	}
	
	public TodoEntity read(int id) {
		return todoData.get(id);
	}
	
	public Boolean update(TodoEntity entity){
		todoData.remove(entity.getId());
		return todoData.add(entity);
	}
	
	public Boolean delete (int id){
		return todoData.remove(id);
	}
	
	//読み込み処理
	public void load (Context context){
		TodoFileUtil fileUtil=new TodoFileUtil();
		todoData = fileUtil.load(context);		
	}
	
	public void save (Context context){
		TodoFileUtil fileUtil=new TodoFileUtil();
		fileUtil.save(todoData, context);		
	}
	
}
