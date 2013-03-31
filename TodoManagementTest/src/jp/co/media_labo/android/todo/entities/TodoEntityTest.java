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
	
	/////////////////////
	// idのテスト
	/////////////////////
	
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

	/////////////////////
	// summaryのテスト
	/////////////////////
	
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

	/////////////////////
	// detailのテスト
	/////////////////////
	
	public void testDetailIsNull() {
		this.builder.setDetail(null);
		this.expectIllegalArgumentException(this.builder);
	}

	public void testDetailIsEmpty() {
		String set = "";
		this.builder.setDetail(set);
		assertEquals(set, this.builder.build().getDetail());
	}
	
	public void testStatusIsNull() {
		TodoStatus set = null;
		this.builder.setStatus(set);
		this.expectIllegalArgumentException(this.builder);
	}
	
	/////////////////////
	// statusのテスト
	/////////////////////
	
	public void testStatusIsNotNull() {
		TodoStatus set = TodoStatus.COMPLETED;
		this.builder.setStatus(set);
		assertEquals(set, this.builder.build().getStatus());
	}
	
	/////////////////////
	// weightのテスト
	/////////////////////
	
	public void testWeightIsNegative() {
		int set = -1;
		this.builder.setWeight(set);
		this.expectIllegalArgumentException(this.builder);
	}
	
	public void testWeightIs0() {
		int set = 0;
		this.builder.setWeight(set);
		assertEquals(set, this.builder.build().getWeight());
	}
	
	public void testWeightIsPositive() {
		int set = 1;
		this.builder.setWeight(set);
		assertEquals(set, this.builder.build().getWeight());
	}
	
	/////////////////////
	// createDateのテスト
	/////////////////////
	
	public void testCreateDateIsNull() {
		Date set = null;
		this.builder.setCreateDate(set);
		this.expectIllegalArgumentException(this.builder);
	}
	
	public void testCreateDateIsNotNull() {
		Date set = new Date();
		this.builder.setCreateDate(set);
		assertTrue( set.equals(this.builder.build().getCreateDate()));
	}
	
	public void testCreateDateIsNotSameObj() {
		Date set = new Date();
		this.builder.setCreateDate(set);
		assertFalse( set == this.builder.build().getCreateDate() );
	}
	
	/////////////////////
	// startDateのテスト
	/////////////////////
	
	public void testStartDateIsNull() {
		Date set = null;
		this.builder.setStartDate(set);
		this.expectIllegalArgumentException(this.builder);
	}
	
	public void testStartDateIsNotNull() {
		Date set = new Date();
		this.builder.setStartDate(set);
		assertTrue(set.equals(this.builder.build().getStartDate()));
	}
	
	public void testStartDateIsNotSameObj() {
		Date set = new Date();
		this.builder.setStartDate(set);
		assertFalse(set==this.builder.build().getStartDate());
	}
	
	/////////////////////
	// endDateのテスト
	/////////////////////
	
	public void testEndDateIsNull() {
		Date set = null;
		this.builder.setEndDate(set);
		this.expectIllegalArgumentException(this.builder);
	}
	
	public void testEndDateIsNotNull() {
		Date set = new Date();
		this.builder.setEndDate(set);
		assertTrue(set.equals(this.builder.build().getEndDate()));
	}
	
	public void testEndDateIsNotSameObj() {
		Date set = new Date();
		this.builder.setEndDate(set);
		assertFalse(set==this.builder.build().getEndDate());
	}
	
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
