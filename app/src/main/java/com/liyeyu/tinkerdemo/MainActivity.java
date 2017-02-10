package com.liyeyu.tinkerdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 loadPath();
            }
        });

        tv.setText("tinker_hotfix");
    }

    private void loadPath() {
         /* 补丁的路径,从服务器下载到手机 */
        String patchPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk";
        TinkerInstaller.onReceiveUpgradePatch(this.getApplication(), patchPath);
    }
}
