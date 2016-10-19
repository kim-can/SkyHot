package sky.skyhot;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jc.sky.SKYHelper;
import jc.sky.core.Impl;
import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;

/**
 * @创建人 sky
 * @创建时间 16/10/14 下午2:44
 * @类描述 一句话描述你的UI
 */
public class TestActivity extends SKYActivity<ITestBiz> implements ITestActivity {

	@BindView(R.id.login_progress) ProgressBar	loginProgress;

	@BindView(R.id.email) AutoCompleteTextView	email;

	@BindView(R.id.password) EditText			password;

	@BindView(R.id.email_sign_in_button) Button	emailSignInButton;

	@BindView(R.id.tv_content) TextView			tvContent;

	@Override protected SKYBuilder build(SKYBuilder skyBuilder) {
		skyBuilder.layoutId(R.layout.activity_login);
		return skyBuilder;
	}

	@Override protected void initData(Bundle bundle) {
		tvContent.setText("修复");
	}

	/**
	 * 登陆
	 */
	@OnClick(R.id.email_sign_in_button) public void login() {
		biz().updateBug();
	}

	/**
	 * 修复
	 */
	@OnClick(R.id.btn_change) public void change() {
		biz().change();
	}

	@Override public void setContent(String bug) {
		tvContent.setText(bug);
	}
}

@Impl(TestActivity.class)
interface ITestActivity {

	void setContent(String bug);
}