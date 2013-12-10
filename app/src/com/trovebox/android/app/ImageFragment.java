
package com.trovebox.android.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public final class ImageFragment extends com.trovebox.android.app.common.CommonFragment {
    int imageResourceId;
    int contentResourceId;
    private static final String KEY_CONTENT = "ImageFragment:imageResourceId";
    int mNum;

    public static Fragment newInstance(int i, int content) {
        ImageFragment f = new ImageFragment();
        f.imageResourceId = i;
        f.contentResourceId = content;
        return f;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            imageResourceId = savedInstanceState.getInt(KEY_CONTENT);
            
        }
    
    }
    @Override
    public View onCreateView(org.holoeverywhere.LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        View v = inflater.inflate(R.layout.fragment_image_intro, container, false);

        refresh(v);
        return v;
        
       
    }
    void refresh(View v)
    {
        TextView text = (TextView)v.findViewById(R.id.introText);
        text.setText(getString(contentResourceId));
        ImageView image = (ImageView)v.findViewById(R.id.introImage);
        image.setImageResource(imageResourceId);;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTENT, imageResourceId);
    }

}
