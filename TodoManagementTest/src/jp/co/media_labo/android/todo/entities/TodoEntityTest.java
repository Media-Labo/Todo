package jp.co.media_labo.android.todo.entities;

import java.util.Date;

import jp.co.media_labo.android.todo.entities.TodoEntity.TodoEntityBuilder;
import junit.framework.TestCase;

public class TodoEntityTest extends TestCase {

	TodoEntityBuilder builder = null;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.builder = this.createDefaultBuilder();
	}
	
	public void testIdIsNegative() {
		this.builder.setId(-1);
		this.expectIllegalArgumentException( this.builder );
	}
	
	public void testIdIs0() {
		int set = 0;
		this.builder.setId(set);
		assertEquals(set, this.builder.build().getId());
	}
	
	public void testIdIsPositive() {
		int set = 1;
		this.builder.setId(set);
		assertEquals(set, this.builder.build().getId());
	}

	public void testSummaryIsNull() {
		this.builder.setSummary(null);
		this.expectIllegalArgumentException(this.builder);
	}
	
	public void testSummaryIsEmpty() {
		this.builder.setSummary("");
		this.expectIllegalArgumentException(this.builder);
	}

	public void testSummaryIsNotEmpty() {
		String set = "test";
		this.builder.setSummary(set);
		assertEquals(set, this.builder.build().getSummary());
	}

	public void testDetailIsNull() {
		this.builder.setDetail(null);
		this.expectIllegalArgumentException(this.builder);
	}

	public void testDetailIsEmpty() {
		String set = "";
		this.builder.setDetail(set);
		assertEquals(set, this.builder.build().getDetail());
	}
	
	
	// TODO statusのテスト
	// TODO weightのテスト
	// TODO createDateのテスト
	// TODO startDateのテスト
	// TODO endDateのテスト
	
	
	////////////////////////////////////
	// 以下はテストで使用するための便利メソッド
	////////////////////////////////////
	
	/**
	 * エラーが出ない値をセットしたTodoEntityBuilderを生成します。
	 */
	private TodoEntityBuilder createDefaultBuilder() {
		TodoEntityBuilder builder = new TodoEntityBuilder();
		
		builder.setId(10);
		builder.setSummary("summary");
		builder.setDetail("detail");
		builder.setStatus( TodoStatus.CREATED );
		builder.setWeight( 10 );
		builder.setCreateDate( new Date() );
		builder.setStartDate( new Date() );
		builder.setEndDate( new Date() );
		
		return builder;
	}
	
	/**
	 * TodoEntityの生成時にIllegalArgumentExceptionが発生することを確認します。
	 * @param builder 組み立てを行うTodoEntityBuilder
	 */
	private void expectIllegalArgumentException( TodoEntityBuilder builder ) {
		try {
			builder.build();
			fail( "失敗" );
		}
		catch( IllegalArgumentException e ) {
			assertTrue(true);
		}
	}
	
}
