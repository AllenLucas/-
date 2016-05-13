package sxtlal.allenlucas.gtproject;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by AllenLucas on 2016/5/10.
 */
public class BaseActivity extends AppCompatActivity {
    int barhight;
    private LayoutInflater inflater;
    private int statusBarHieght;
    private LinearLayout childGroup;
    private LinearLayout statusBarGroup;
    private View root;
    private View statusBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isStatusBar()){
            intiStuatBar();
        }
    }

    private void intiStuatBar() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    public boolean isStatusBar(){

        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(identifier>0){
            barhight =  getResources().getDimensionPixelSize(identifier);
        }
        return  barhight>0&&isEquealsOrMore();
    }
    public boolean isEquealsOrMore(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }
    public int Px2Dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
}

