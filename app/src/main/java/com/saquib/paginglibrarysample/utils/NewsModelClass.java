package com.saquib.paginglibrarysample.utils;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

/**
 * Created by ${Saquib} on 12-08-2018.
 */
public class NewsModelClass {

    private String newsImg, newsTitle;

    public String getNewsImg() {
        return newsImg;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public NewsModelClass(String newsTitle, String newsImg) {
        this.newsImg = newsImg;
        this.newsTitle = newsTitle;
    }

    public static DiffUtil.ItemCallback<NewsModelClass> DIFF_CALLBACK = new DiffUtil.ItemCallback<NewsModelClass>() {
        @Override
        public boolean areItemsTheSame(@NonNull NewsModelClass oldItem, @NonNull NewsModelClass newItem) {
            return oldItem.newsTitle.equals(newItem.newsTitle);
        }

        @Override
        public boolean areContentsTheSame(@NonNull NewsModelClass oldItem, @NonNull NewsModelClass newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        NewsModelClass article = (NewsModelClass) obj;
        return article.newsTitle.equals(this.newsTitle);
    }

}
