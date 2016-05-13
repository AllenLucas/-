package sxtlal.allenlucas.gtproject.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import sxtlal.allenlucas.gtproject.R;

/**
 * Created by AllenLucas on 2016/5/11.
 */
public class Yudingfragment extends Fragment {

    private View rootview;
    private Button tab;
    private Button from;
    private Button to;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootview==null){
            rootview = inflater.inflate(R.layout.yuding_fragment,container,false);
        }else {
            ViewGroup group = (ViewGroup) rootview.getParent();
            if(group!=null){
                group.removeView(rootview);
            }
        }
        initView(container);
        return rootview;
    }

    private void initView(@Nullable ViewGroup container) {
        tab = (Button) container.findViewById(R.id.tab);
        from = (Button) container.findViewById(R.id.form);
        to = (Button) container.findViewById(R.id.to);
        tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
