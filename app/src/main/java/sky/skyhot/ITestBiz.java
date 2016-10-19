package sky.skyhot;

import android.os.Environment;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

import jc.sky.SKYHelper;
import jc.sky.core.Impl;
import jc.sky.core.SKYBiz;
import jc.sky.core.SKYIBiz;
import jc.sky.modules.log.L;

/**
 * @创建人 sky
 * @创建时间 16/10/14 下午2:45
 * @类描述 一句话描述你的业务
 */
@Impl(TestBiz.class)
public interface ITestBiz extends SKYIBiz {

	void update();

	void change();

	void updateBug();

}

class TestBiz extends SKYBiz<ITestActivity> implements ITestBiz {

	@Override public void update() {
		SKYHelper.toast().show("修复asdfasdfasdfasdf");
		ui().setContent("修复asdfasdfsa");

	}

	@Override public void change() {
		File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
		L.i(file.getAbsolutePath());
		if (file.exists()) {
			SKYHelper.toast().show("修复BUG");
			TinkerInstaller.onReceiveUpgradePatch(SKYHelper.getInstance(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
		} else {
			SKYHelper.toast().show("没有文件");
		}
	}

	@Override public void updateBug() {
		SKYHelper.toast().show("我是已经修复了的啊撒旦发射点发撒旦");
		ui().setContent("我是已经修复了的啊撒旦发射点发撒旦");
	}
}