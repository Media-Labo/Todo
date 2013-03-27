package jp.co.media_labo.android.todo.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;

import jp.co.media_labo.android.todo.entities.TodoEntity;
import jp.co.media_labo.android.todo.entities.TodoStatus;
import jp.co.media_labo.android.todo.entities.TodoEntity.TodoEntityBuilder;

import android.content.Context;

public class TodoFileUtil {

	private final String TODO_FILE_NAME="LOCAL_DATA";
	
	public void save (TodoEntityContainer entities, OutputStream stream){
		for (TodoEntity enty: entities.getValues()){
			String strData = enty.getId() + "," + enty.getSummary() + "," + enty.getDetail() + "," + enty.getStatus() + "," 
							+ enty.getWeight() + "," + enty.getCreateDate() + "," + enty.getStartDate() + "," + enty.getEndDate();
			try {
				stream.write(strData.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	public void save (TodoEntityContainer entities, Context context){
		FileOutputStream fs=null;
		try{
			fs = context.openFileOutput(TODO_FILE_NAME, Context.MODE_PRIVATE);
			save(entities,fs);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(fs != null){
					fs.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public TodoEntityContainer load (InputStream stream){
		TodoEntityContainer loadEntityConteine = new TodoEntityContainer();
		BufferedReader reader=null;
		try{
			TodoEntityBuilder todoEntyBuilder = new TodoEntityBuilder();
			reader= new BufferedReader(new InputStreamReader(stream));
			String tmp;
			while((tmp = reader.readLine()) != null){
				String[] strTodoEnty = tmp.split(",");
				todoEntyBuilder.setId(Integer.valueOf(strTodoEnty[0]) );
				todoEntyBuilder.setSummary(strTodoEnty[1]);
				todoEntyBuilder.setDetail(strTodoEnty[2]);
				// TODO enum
				//todoEntyBuilder.setStatus(strTodoEnty[3]);
				todoEntyBuilder.setWeight(Integer.valueOf(strTodoEnty[4]));
				todoEntyBuilder.setCreateDate(new Date(Date.parse(strTodoEnty[5])));
				todoEntyBuilder.setStartDate(new Date(Date.parse(strTodoEnty[6])));
				todoEntyBuilder.setEndDate(new Date(Date.parse(strTodoEnty[7])));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return loadEntityConteine;
	}
	
	public TodoEntityContainer load (Context context){
		TodoEntityContainer loadEntities = null;
		FileInputStream fs = null;
		try{
			fs = context.openFileInput(TODO_FILE_NAME);
			loadEntities = load(fs);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (fs != null){
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return loadEntities;
	}	
}
