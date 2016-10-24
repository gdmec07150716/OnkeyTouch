package cn.edu.gdmec.s07150716.test1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tView;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView = new TextView(this);
        tView.setText("请单击按键或屏幕");
        setContentView(tView);
           }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_HOME:
                SetMessage("你按下了：Home键");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("你按下了：菜单键");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("你按下了：回退键");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("你按下了：声音加大键");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("你按下了：声音减小键");
                event.startTracking();
                return true;
            default:
                SetMessage("你按下的键码是："+keyCode);
                event.startTracking();
                break;
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_HOME:
                SetMessage("你放开了：Home键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("你放开了：菜单键");
                break;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("你放开了：回退键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("你放开了：声音加大键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("你放开了：声音减小键");
                break;
            default:
                SetMessage("你放开的键码是："+keyCode);
                event.startTracking();
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_HOME:
                SetMessage("你长按了：Home键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("你长按了：菜单键");
                break;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("你长按了：回退键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("你长按了：声音加大键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("你长按了：声音减小键");
                break;
            default:
                SetMessage("你长按的键码是："+keyCode);
                break;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action =event.getAction();
        if (action==MotionEvent.ACTION_CANCEL||action==MotionEvent.ACTION_DOWN||action==MotionEvent.ACTION_MOVE){
            return  false;
        }
        String x=String.valueOf(event.getX());
        String y=String.valueOf(event.getY());
        SetMessage("触点坐标：("+x+","+y+")");
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SetMessage("你按下了返回键");
    }

    private void SetMessage(String str) {
        String oldStr = tView.getText().toString();
        String newStr = oldStr + "\n" + str;
        tView.setText(newStr);
    }
}
