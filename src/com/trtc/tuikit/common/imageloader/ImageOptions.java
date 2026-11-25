package com.trtc.tuikit.common.imageloader;

/* loaded from: /tmp/classes2.dex */
public class ImageOptions {
    private final float blurEffect;
    private final int errorImage;
    private final boolean isGif;
    private final int placeImage;
    private final int roundRadius;
    private final boolean skipDiskCache;
    private final boolean skipMemoryCache;

    /* loaded from: /tmp/classes2.dex */
    public static class Builder {
        private final boolean skipMemoryCache = false;
        private final boolean skipDiskCache = false;
        private int placeImage = 0;
        private int errorImage = 0;
        private int roundRadius = 0;
        private boolean isGif = false;
        private float blurEffect = 0.0f;

        public Builder asGif(boolean z) {
            this.isGif = z;
            return this;
        }

        public ImageOptions build() {
            return new ImageOptions(this);
        }

        public Builder setBlurEffect(float f) {
            this.blurEffect = f;
            return this;
        }

        public Builder setErrorImage(int i) {
            this.errorImage = i;
            return this;
        }

        public Builder setPlaceImage(int i) {
            this.placeImage = i;
            return this;
        }

        public Builder setRoundRadius(int i) {
            this.roundRadius = i;
            return this;
        }
    }

    private ImageOptions(Builder builder) {
        this.placeImage = builder.placeImage;
        this.errorImage = builder.errorImage;
        this.roundRadius = builder.roundRadius;
        this.isGif = builder.isGif;
        this.skipMemoryCache = false;
        this.skipDiskCache = false;
        this.blurEffect = builder.blurEffect;
    }

    public float getBlurEffect() {
        return this.blurEffect;
    }

    public int getErrorImage() {
        return this.errorImage;
    }

    public int getPlaceImage() {
        return this.placeImage;
    }

    public int getRoundRadius() {
        return this.roundRadius;
    }

    public boolean isGif() {
        return this.isGif;
    }

    public boolean skipDiskCache() {
        return this.skipDiskCache;
    }

    public boolean skipMemoryCache() {
        return this.skipMemoryCache;
    }
}
