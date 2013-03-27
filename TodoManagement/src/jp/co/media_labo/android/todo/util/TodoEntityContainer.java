package jp.co.media_labo.android.todo.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import jp.co.media_labo.android.todo.entities.TodoEntity;

public class TodoEntityContainer {
	private Map<Integer, TodoEntity> entities;
	private int maxId=0;

	public TodoEntityContainer() {
		entities = new HashMap<Integer, TodoEntity>();
	}
	
	public int GetMaxId () {
		return maxId;
	}
	
	public  Boolean add(TodoEntity entity){
		
		Boolean isResult = false;
			try {
				//追加されるIDがMaxIdより大きい場合は、MaxIDを更新
				if(maxId < entity.getId()){
					maxId = entity.getId();
				}
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
