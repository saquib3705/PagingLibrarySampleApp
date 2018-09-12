package com.saquib.paginglibrarysample.ui;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

/**
 * Created by ${Saquib} on 12-08-2018.
 */
public class ImageBinder {

    @BindingAdapter({"imageURL"})
    public static void loadImage(ImageView img, String imageUrl) {
        img.setImageURI(Uri.parse(imageUrl));
    }
}
