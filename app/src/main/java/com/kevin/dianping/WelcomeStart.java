package com.kevin.dianping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.Timer;
import java.util.TimerTask;
import com.kevin.dianping.Utils.ShareUtils;

/**
 * Created by Administrator on 2016/12/6.
 */
@ContentView(R.layout.welcome)
public class WelcomeStart extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        Timer timer = new Timer();
        timer.schedule(new Task(),3000);
    }

    private class Task extends TimerTask {
        @Override
        public void run() {
            if(ShareUtils.getWelcomeBoolean(getBaseContext())){
                startActivity(new Intent(WelcomeStart.this,MainActivity.class));
            }else {
                startActivity(new Intent(WelcomeStart.this,WelcomeGuide.class));
                //保存访问记录
                ShareUtils.putWelcomeBoolean(getBaseContext(),true);
            }
            finish();
        }
    }
}
