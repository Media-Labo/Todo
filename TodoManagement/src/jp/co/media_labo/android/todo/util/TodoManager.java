package jp.co.media_labo.android.todo.util;

import android.content.Context;
import jp.co.media_labo.android.todo.entities.TodoEntity;

public class TodoManager {

	private TodoEntityContainer todoData;
	
	public TodoManager(Context context){
		todoData = new  TodoEntityContainer();
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
	
	public void load (Context context){
		todoData = TodoFileUtil.load(context);		
	}
	
	public void save (Context context){
		TodoFileUtil.save(todoData, context);		
	}
	
	public int GetMaxId(){
		return todoData.GetMaxId();
	}
	
	
}
