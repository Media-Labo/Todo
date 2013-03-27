package jp.co.media_labo.android.todo.util;

import java.util.Collection;
import java.util.Map;

import jp.co.media_labo.android.todo.entities.TodoEntity;

public class TodoEntityContainer {
	private Map<Integer, TodoEntity> entities;

	public TodoEntityContainer() {
		
	}
	
	public  Boolean add(TodoEntity entity){
		
		Boolean isResult = false;
			try {
				entities.put(entity.getId(),entity);
				isResult = true;
			}
			catch (Exception e){
				e.printStackTrace();
				isResult = false;
			}
		return isResult;
	}
	
	public Boolean remove (int id){
		Boolean isResult = false;
		try{
			entities.remove(id);
			isResult = true;
		}catch (Exception e) {
			e.printStackTrace();
			isResult = false;
		}
		return isResult;
	}
	
	public TodoEntity get (int id){
		try{
			return entities.get(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Collection<TodoEntity> getValues(){
		return entities.values();
	}
}
