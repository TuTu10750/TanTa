package com.zzhoujay.richtext.cache;

import android.graphics.Bitmap;
import com.zzhoujay.richtext.drawable.DrawableSizeHolder;
import com.zzhoujay.richtext.ext.Debug;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/classes2.dex */
public class BitmapPool {
    private static final int MAX_SIZE_CACHE_SIZE = 100;
    private static final int MAX_SIZE_LOCAL_CACHE_SIZE = 1048576;
    private static final int MAX_TEMP_LOCAL_CACHE_SIZE = 524288000;
    private static final String RICH_TEXT_DIR_NAME = "_rt";
    private static final String SIZE_DIR_NAME = "_s";
    private static final String TEMP_DIR_NAME = "_t";
    private static final int bitmapCacheSize = (int) (Runtime.getRuntime().maxMemory() / 4);
    private static File cacheDir = null;
    private static File sizeDir = null;
    private static bn0 sizeDiskLruCache = null;
    private static File tempDir = null;
    private static bn0 tempDiskLruCache = null;
    private static final int version = 1;
    private j92 bitmapCache;
    private j92 sizeHolderCache;

    /* loaded from: /tmp/classes2.dex */
    public static class BitmapPoolHolder {
        private static final BitmapPool BITMAP_POOL = new BitmapPool();

        private BitmapPoolHolder() {
        }
    }

    private BitmapPool() {
        this.bitmapCache = new j92(bitmapCacheSize) { // from class: com.zzhoujay.richtext.cache.BitmapPool.1
            public int sizeOf(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
        this.sizeHolderCache = new j92(100);
    }

    public static BitmapPool getPool() {
        return BitmapPoolHolder.BITMAP_POOL;
    }

    private static bn0 getSizeDiskLruCache() {
        if (sizeDiskLruCache == null && cacheDir != null) {
            try {
                sizeDiskLruCache = bn0.D0(sizeDir, 1, 1, 1048576L);
            } catch (IOException e) {
                Debug.e(e);
            }
        }
        return sizeDiskLruCache;
    }

    private static bn0 getTempDiskLruCache() {
        if (tempDiskLruCache == null && cacheDir != null) {
            try {
                tempDiskLruCache = bn0.D0(tempDir, 1, 1, 524288000L);
            } catch (IOException e) {
                Debug.e(e);
            }
        }
        return tempDiskLruCache;
    }

    public static int getVersion() {
        return 1;
    }

    public static void setCacheDir(File file) {
        if (cacheDir != null || file == null) {
            return;
        }
        cacheDir = file;
        File file2 = new File(file, RICH_TEXT_DIR_NAME);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(file2, SIZE_DIR_NAME);
        sizeDir = file3;
        if (!file3.exists()) {
            sizeDir.mkdir();
        }
        File file4 = new File(file2, TEMP_DIR_NAME);
        tempDir = file4;
        if (file4.exists()) {
            return;
        }
        tempDir.mkdir();
    }

    public void cache(String str, Bitmap bitmap, DrawableSizeHolder drawableSizeHolder) {
        cacheBitmap(str, bitmap);
        cacheSize(str, drawableSizeHolder);
    }

    public void cacheBitmap(String str, Bitmap bitmap) {
        this.bitmapCache.put(str, bitmap);
    }

    public void cacheSize(String str, DrawableSizeHolder drawableSizeHolder) {
        this.sizeHolderCache.put(str, drawableSizeHolder);
        CacheIOHelper.SIZE_CACHE_IO_HELPER.writeToCache(str, drawableSizeHolder, getSizeDiskLruCache());
    }

    public void clear() {
        this.bitmapCache.evictAll();
        this.sizeHolderCache.evictAll();
    }

    public void clearLocalDiskCache() {
        try {
            bn0 sizeDiskLruCache2 = getSizeDiskLruCache();
            if (sizeDiskLruCache2 != null) {
                sizeDiskLruCache2.s0();
            }
        } catch (IOException e) {
            Debug.e(e);
        }
    }

    public Bitmap getBitmap(String str) {
        return (Bitmap) this.bitmapCache.get(str);
    }

    public DrawableSizeHolder getSizeHolder(String str) {
        DrawableSizeHolder drawableSizeHolder = (DrawableSizeHolder) this.sizeHolderCache.get(str);
        return drawableSizeHolder == null ? CacheIOHelper.SIZE_CACHE_IO_HELPER.readFromCache(str, getSizeDiskLruCache()) : drawableSizeHolder;
    }

    public boolean hasBitmapLocalCache(String str) {
        return CacheIOHelper.REMOTE_IMAGE_CACHE_IO_HELPER.hasCache(str, getTempDiskLruCache());
    }

    public InputStream readBitmapFromTemp(String str) {
        return CacheIOHelper.REMOTE_IMAGE_CACHE_IO_HELPER.readFromCache(str, getTempDiskLruCache());
    }

    public void writeBitmapToTemp(String str, InputStream inputStream) {
        CacheIOHelper.REMOTE_IMAGE_CACHE_IO_HELPER.writeToCache(str, inputStream, getTempDiskLruCache());
    }
}
