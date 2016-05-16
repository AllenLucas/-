package sxtlal.allenlucas.gtproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AllenLucas on 2016/5/14.
 */
public class Adapter extends BaseAdapter {
    private List<Bean> list;
    private Context context;

    public Adapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder view = null;
        if(convertView==null){
            view=new ViewHolder();
            convertView = View.inflate(context,R.layout.gotogo,null);
            view.fromaddress= (TextView) convertView.findViewById(R.id.formtext);
            view.toaddress = (TextView) convertView.findViewById(R.id.totext);
            convertView.setTag(view);
        }else {
            view = (ViewHolder) convertView.getTag();
        }
        view.fromaddress.setText(list.get(position).fromaddress);
        view.toaddress.setText(list.get(position).toaddress);
        return convertView;
    }
    class ViewHolder{
        TextView fromaddress;
        TextView toaddress;
    }
}
