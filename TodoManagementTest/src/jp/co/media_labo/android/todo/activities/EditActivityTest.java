package jp.co.media_labo.android.todo.activities;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class EditActivityTest extends ActivityInstrumentationTestCase2<EditActivity> {

	// �R���|�[�l���g���ɂ͐ړ���c_��t��
	private TextView c_summaryLabel = null;
	
	// strings.xml�̐ݒ�l�ɂ͐ړ���s_��t��
	private String s_summaryLabel = null;
	/**
	 * �e�X�g�Ώۂ��w��
	 */
	public EditActivityTest() {
		// �e�X�g�Ώۂ̃p�b�P�[�W�ƃN���X��ݒ�
		super(	"jp.co.media_labo.android.todo.activities",
				EditActivity.class);
	}

	/**
	 * �e�e�X�g���\�b�h���Ă΂��O�Ɏ��s����郁�\�b�h
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		Activity activity = this.getActivity();
		
		// ���낢��Ȑݒ�l���擾
		this.c_summaryLabel 
			= (TextView)activity.findViewById(
					jp.co.media_labo.android.todo.R.id.summaryLabel );
		this.s_summaryLabel
			= activity.getString(
					jp.co.media_labo.android.todo.R.string.edit_text_title );
	}
	
	public void testSummaryLabel() throws Exception {
		assertEquals(
				this.s_summaryLabel,
				this.c_summaryLabel.getText().toString());
	}
}
