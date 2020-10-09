package com.example.mvplib.Image;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.mvplib.net.RequestManager;

public class ImageUtil {

    public static void loadImage(String url, ImageView iv, int placeHolder, int erroeHolder){
        ImageLoader loader = new ImageLoader(RequestManager.getInstance().getRequestQueue(),
                new BitmapCache());

        if (iv instanceof NetworkImageView){
            ((NetworkImageView) iv).setDefaultImageResId(placeHolder);
            ((NetworkImageView) iv).setErrorImageResId(erroeHolder);
            ((NetworkImageView) iv).setImageUrl(url, loader);
        } else {
            ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv, placeHolder, erroeHolder);
            loader.get(url, listener);
        }
    }

    //实现LruCache图片缓存
    private static class BitmapCache implements ImageLoader.ImageCache {
        private LruCache cache;
        //设置缓存大小未10M
        private final int maxSize = 10*1024*1024;
        @Override
        public Bitmap getBitmap(String url) {
            return (Bitmap) cache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            cache.put(url, bitmap);
        }
    }
}
