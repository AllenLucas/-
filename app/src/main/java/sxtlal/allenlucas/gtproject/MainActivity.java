package sxtlal.allenlucas.gtproject;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import sxtlal.allenlucas.gtproject.Fragment.Fuwufragment;
import sxtlal.allenlucas.gtproject.Fragment.Myfragment;
import sxtlal.allenlucas.gtproject.Fragment.Xingchengfragment;
import sxtlal.allenlucas.gtproject.Fragment.Yudingfragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private RadioButton yuding;
    private RadioButton fuwu;
    private RadioButton xingcheng;
    private RadioButton my;
    private RadioGroup bottommenu;
    private TextView title;
    private View add;
    private FragmentManager manager;
    private Yudingfragment yudingfragment;
    private Xingchengfragment xingchengfragment;
    private Fuwufragment fuwufragment;
    private Myfragment myfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        onClick(yuding);
        initListener();
    }

    private void initListener() {
        yuding.setOnClickListener(this);
        xingcheng.setOnClickListener(this);
        fuwu.setOnClickListener(this);
        my.setOnClickListener(this);
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool);
        title = (TextView) findViewById(R.id.title);
        yuding = (RadioButton) findViewById(R.id.yuding);
        fuwu = (RadioButton) findViewById(R.id.fuwu);
        xingcheng = (RadioButton) findViewById(R.id.xingcheng);
        my = (RadioButton) findViewById(R.id.my);
        bottommenu = (RadioGroup) findViewById(R.id.bottommenu);
        add = findViewById(R.id.add);
        yuding.setSelected(true);
        add.setVisibility(View.GONE);
        manager = getSupportFragmentManager();
        yudingfragment = new Yudingfragment();
        xingchengfragment = new Xingchengfragment();
        fuwufragment = new Fuwufragment();
        myfragment = new Myfragment();
    }
    public void intibutton(){
        yuding.setSelected(false);
        xingcheng.setSelected(false);
        fuwu.setSelected(false);
        my.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        intibutton();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.yuding:
                yuding.setSelected(true);
                title.setText("高铁管家");
                title.setTextSize(25);
                add.setVisibility(View.GONE);
                toolbar.setVisibility(View.VISIBLE);
                transaction.replace(R.id.fragment,yudingfragment);
                break;
            case R.id.xingcheng:
                xingcheng.setSelected(true);
                title.setText("我关注的行程");
                title.setTextSize(20);
                add.setVisibility(View.VISIBLE);
                toolbar.setVisibility(View.VISIBLE);
                transaction.replace(R.id.fragment,xingchengfragment);
                break;
            case R.id.fuwu:
                fuwu.setSelected(true);
                title.setText("旅行服务");
                title.setTextSize(20);
                add.setVisibility(View.GONE);
                toolbar.setVisibility(View.VISIBLE);
                transaction.replace(R.id.fragment,fuwufragment);
                break;
            case R.id.my:
                my.setSelected(true);
                toolbar.setVisibility(View.GONE);
                add.setVisibility(View.GONE);
                transaction.replace(R.id.fragment,myfragment);
                break;
        }
        transaction.commit();
    }
}
