package com.zzhoujay.richtext.ig;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.drawable.GifDrawable;
import com.zzhoujay.richtext.ext.ImageKit;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/classes2.dex */
abstract class SourceDecode<T> {
    static SourceDecode<byte[]> BASE64_SOURCE_DECODE = new SourceDecode<byte[]>() { // from class: com.zzhoujay.richtext.ig.SourceDecode.1
        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public ImageWrapper decodeAsBitmap(byte[] bArr, BitmapFactory.Options options) {
            return ImageWrapper.createAsBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options));
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public ImageWrapper decodeAsGif(byte[] bArr, BitmapFactory.Options options) {
            return ImageWrapper.createAsGif(new GifDrawable(Movie.decodeByteArray(bArr, 0, bArr.length), options.outHeight, options.outWidth));
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public void decodeSize(byte[] bArr, BitmapFactory.Options options) {
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public boolean isGif(byte[] bArr, BitmapFactory.Options options) {
            return ImageKit.isGif(bArr);
        }
    };
    static SourceDecode<String> LOCAL_FILE_SOURCE_DECODE = new SourceDecode<String>() { // from class: com.zzhoujay.richtext.ig.SourceDecode.2
        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public ImageWrapper decodeAsBitmap(String str, BitmapFactory.Options options) {
            return ImageWrapper.createAsBitmap(BitmapFactory.decodeFile(str, options));
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public ImageWrapper decodeAsGif(String str, BitmapFactory.Options options) {
            return ImageWrapper.createAsGif(new GifDrawable(Movie.decodeFile(str), options.outHeight, options.outWidth));
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public void decodeSize(String str, BitmapFactory.Options options) {
            BitmapFactory.decodeFile(str, options);
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public boolean isGif(String str, BitmapFactory.Options options) {
            return ImageKit.isGif(str);
        }
    };
    static SourceDecode<InputStream> INPUT_STREAM_DECODE = new SourceDecode<InputStream>() { // from class: com.zzhoujay.richtext.ig.SourceDecode.3
        private static final int MARK_POSITION = 1048576;

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public ImageWrapper decodeAsBitmap(InputStream inputStream, BitmapFactory.Options options) {
            BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
            if (options.inJustDecodeBounds) {
                bufferedInputStream.mark(1048576);
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
            if (options.inJustDecodeBounds) {
                try {
                    bufferedInputStream.reset();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return ImageWrapper.createAsBitmap(decodeStream);
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public ImageWrapper decodeAsGif(InputStream inputStream, BitmapFactory.Options options) {
            return ImageWrapper.createAsGif(new GifDrawable(Movie.decodeStream(inputStream), options.outHeight, options.outWidth));
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public void decodeSize(InputStream inputStream, BitmapFactory.Options options) {
            BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
            if (options.inJustDecodeBounds) {
                bufferedInputStream.mark(1048576);
            }
            BitmapFactory.decodeStream(bufferedInputStream, null, options);
            if (options.inJustDecodeBounds) {
                try {
                    bufferedInputStream.reset();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.zzhoujay.richtext.ig.SourceDecode
        public boolean isGif(InputStream inputStream, BitmapFactory.Options options) {
            return ImageKit.isGif(inputStream);
        }
    };

    public ImageWrapper decode(ImageHolder imageHolder, T t, BitmapFactory.Options options) {
        if (!imageHolder.isAutoPlay() || (!imageHolder.isGif() && !isGif(t, options))) {
            return decodeAsBitmap(t, options);
        }
        imageHolder.setIsGif(true);
        return decodeAsGif(t, options);
    }

    public abstract ImageWrapper decodeAsBitmap(T t, BitmapFactory.Options options);

    public abstract ImageWrapper decodeAsGif(T t, BitmapFactory.Options options);

    public abstract void decodeSize(T t, BitmapFactory.Options options);

    public abstract boolean isGif(T t, BitmapFactory.Options options);
}
