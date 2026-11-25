package com.yunbao.live.music;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LiveMusicBean {
    private String artist;
    private String id;
    private String name;
    private int progress;

    @JSONField(name = "artist_name")
    public String getArtist() {
        return this.artist;
    }

    @JSONField(name = "audio_id")
    public String getId() {
        return this.id;
    }

    @JSONField(name = "audio_name")
    public String getName() {
        return this.name;
    }

    public int getProgress() {
        return this.progress;
    }

    @JSONField(name = "artist_name")
    public void setArtist(String str) {
        this.artist = str;
    }

    @JSONField(name = "audio_id")
    public void setId(String str) {
        this.id = str;
    }

    @JSONField(name = "audio_name")
    public void setName(String str) {
        this.name = str;
    }

    public void setProgress(int i) {
        this.progress = i;
    }
}
