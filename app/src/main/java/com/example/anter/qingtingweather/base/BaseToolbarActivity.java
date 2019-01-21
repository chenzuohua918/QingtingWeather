package com.example.anter.qingtingweather.base;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class BaseToolbarActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();// 真正实现回退功能的代码
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
