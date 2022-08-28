package com.example.image_slider;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class PhotoViewAdapter extends PagerAdapter {
    private List<photo> mListPhoto ;

    public PhotoViewAdapter(List<photo> mListPhoto) {
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.image_photo,container,false) ;
        ImageView imgPhoto = view.findViewById(R.id.img_photo) ;
        photo photo = mListPhoto.get(position)  ;
        imgPhoto.setImageResource(photo.getResourceID());

        // add View
            container.addView(view);

        return view ;
    }

    @Override
    public int getCount() {
        if(mListPhoto != null)
        {
            return mListPhoto.size() ;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object); phai xoa tk nay di, neu ko sse bi loi crash app 
        container.removeView((View)object);
    }
}
