package sxtlal.allenlucas.gtproject.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sxtlal.allenlucas.gtproject.R;

/**
 * Created by AllenLucas on 2016/5/11.
 */
public class Xingchengfragment extends Fragment {
    private View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootview==null){
            rootview = inflater.inflate(R.layout.xingcheng_fragment,container,false);
        }else {
            ViewGroup group = (ViewGroup) rootview.getParent();
            if(group!=null){
                group.removeView(rootview);
            }
        }
        return rootview;
    }
}
