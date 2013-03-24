package jp.co.media_labo.android.todo.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;

public class TodoFileUtil {

	private final String TODO_FILE_NAME="LOCAL_DATA";
	
	public void save (TodoEntityContainer entities, OutputStream stream){
		
	}
	
	public void save (TodoEntityContainer entities, Context context){
		try{
			FileOutputStream fs = context.openFileOutput(TODO_FILE_NAME, Context.MODE_PRIVATE);
			save(entities,fs);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TodoEntityContainer load (InputStream stream){
		TodoEntityContainer loadEntities = null;
		return loadEntities;
	}
	
	public TodoEntityContainer load (Context context){
		TodoEntityContainer loadEntities = null;
		try{
			FileInputStream fs = context.openFileInput(TODO_FILE_NAME);
			loadEntities = load(fs);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return loadEntities;
	}
	
}
