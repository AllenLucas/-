package sxtlal.allenlucas.gtproject.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.gtproject.Adapter;
import sxtlal.allenlucas.gtproject.Bean;
import sxtlal.allenlucas.gtproject.R;

/**
 * Created by AllenLucas on 2016/5/11.
 */
public class Yudingfragment extends Fragment {

    @Bind(R.id.shop)
    RadioButton shop;
    @Bind(R.id.airkey)
    RadioButton airkey;
    @Bind(R.id.car)
    RadioButton car;
    @Bind(R.id.drik)
    RadioButton drik;
    @Bind(R.id.topmenu1)
    RadioGroup topmenu1;
    @Bind(R.id.key)
    TextView key;
    @Bind(R.id.lin1)
    View lin1;
    @Bind(R.id.layout1)
    LinearLayout layout1;
    @Bind(R.id.form)
    Button form;
    @Bind(R.id.tab)
    Button tab;
    @Bind(R.id.to)
    Button to;
    @Bind(R.id.layout2)
    LinearLayout layout2;
    @Bind(R.id.lin2)
    View lin2;
    @Bind(R.id.date)
    TextView date;
    @Bind(R.id.week)
    TextView week;
    @Bind(R.id.layout3)
    LinearLayout layout3;
    @Bind(R.id.sousuo)
    RadioButton sousuo;
    @Bind(R.id.dislist)
    ListView dislist;
    @Bind(R.id.sousuog)
    RelativeLayout sousuog;
    private View rootview;
    private List<Bean> list;
    private Bean bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootview == null) {
            rootview = inflater.inflate(R.layout.yuding_fragment, container, false);
        } else {
            ViewGroup group = (ViewGroup) rootview.getParent();
            if (group != null) {
                group.removeView(rootview);
            }
        }
        initeData();
        ButterKnife.bind(this, rootview);
        initlistener();

        return rootview;
    }

    private void initlistener() {
        sousuo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        bean = new Bean();
                        String[] a = new String[list.size()];
                        String[] b = new String[list.size()];
                        for(int i =0;i <list.size();i++){
                            a[i] = list.get(i).fromaddress;
                            b[i] = list.get(i).toaddress;
                        }
                        if(!(form.getText().equals(a))&&!(to.getText().equals(b))){
                            bean.fromaddress = form.getText().toString();
                            bean.toaddress = to.getText().toString();
                            list.add(bean);
                        }

                        break;
                    case MotionEvent.ACTION_UP:
                        Adapter adapter = new Adapter(list,getActivity());
                        dislist.setAdapter(adapter);
                        dislist.setSelection(list.size());
                        break;
                }
                return true;
            }
        });
    }

    private void initeData() {

        list = new ArrayList<>();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.shop, R.id.airkey, R.id.car, R.id.drik, R.id.form, R.id.tab, R.id.to, R.id.date, R.id.sousuo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shop:

                break;
            case R.id.airkey:
                break;
            case R.id.car:
                break;
            case R.id.drik:
                break;
            case R.id.form:
                break;
            case R.id.tab:
                form.startAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.tran_left));
                to.startAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.tran_right));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String s = form.getText().toString();
                        form.setText(to.getText().toString());
                        to.setText(s);
                    }
                },300);
                break;
            case R.id.to:
                break;
            case R.id.date:
                break;
            case R.id.sousuo:
                break;
        }
    }
}
