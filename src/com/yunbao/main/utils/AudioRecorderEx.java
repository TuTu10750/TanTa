package com.yunbao.main.utils;

import android.media.AudioRecord;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.statistics.UMErrorCode;
import defpackage.lx1;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class AudioRecorderEx {
    public static final int[] r = {44100, 22050, 11025, 8000};
    public String b;
    public AudioRecord c;
    public int d;
    public State e;
    public RandomAccessFile f;
    public short g;
    public int h;
    public short i;
    public int j;
    public int k;
    public int l;
    public int m;
    public byte[] n;
    public int o;
    public List a = new ArrayList();
    public int p = 0;
    public AudioRecord.OnRecordPositionUpdateListener q = new a();

    /* loaded from: /tmp/classes2.dex */
    public enum State {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    /* loaded from: /tmp/classes2.dex */
    public class a implements AudioRecord.OnRecordPositionUpdateListener {

        /* renamed from: com.yunbao.main.utils.AudioRecorderEx$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0052a implements Runnable {
            public RunnableC0052a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AudioRecorderEx.this.m();
            }
        }

        public a() {
        }

        @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
        public void onMarkerReached(AudioRecord audioRecord) {
        }

        @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
        public void onPeriodicNotification(AudioRecord audioRecord) {
            new Thread(new RunnableC0052a()).start();
        }
    }

    public AudioRecorderEx(int i, int i2, int i3, int i4) {
        this.c = null;
        this.d = 0;
        try {
            if (i4 == 2) {
                this.i = (short) 16;
            } else {
                this.i = (short) 8;
            }
            if (i3 == 16) {
                this.g = (short) 1;
            } else {
                this.g = (short) 2;
            }
            this.k = i;
            this.h = i2;
            this.l = i4;
            int i5 = (i2 * UMErrorCode.E_UM_BE_NOT_MAINPROCESS) / IjkMediaCodecInfo.RANK_MAX;
            this.m = i5;
            int i6 = (((i5 * 2) * this.i) * this.g) / 8;
            this.j = i6;
            if (i6 < AudioRecord.getMinBufferSize(i2, i3, i4)) {
                int minBufferSize = AudioRecord.getMinBufferSize(i2, i3, i4);
                this.j = minBufferSize;
                this.m = minBufferSize / (((this.i * 2) * this.g) / 8);
                lx1.b("Increasing buffer size to " + Integer.toString(this.j));
            }
            AudioRecord audioRecord = new AudioRecord(i, i2, i3, i4, this.j);
            this.c = audioRecord;
            if (audioRecord.getState() != 1) {
                throw new Exception("AudioRecord initialization failed");
            }
            this.c.setRecordPositionUpdateListener(this.q);
            this.c.setPositionNotificationPeriod(this.m);
            this.d = 0;
            this.b = null;
            this.e = State.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                lx1.b(e.getMessage());
            } else {
                lx1.b("Unknown error occured while initializing recording");
            }
            this.e = State.ERROR;
        }
    }

    public static AudioRecorderEx d() {
        return new AudioRecorderEx(1, r[3], 16, 2);
    }

    public void b() {
        List list = this.a;
        if (list == null || list.size() == 0) {
            return;
        }
        this.a.clear();
    }

    public void c() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final short e(byte b, byte b2) {
        return (short) ((b2 << 8) | b);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File f() {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.main.utils.AudioRecorderEx.f():java.io.File");
    }

    public void g() {
        try {
            if (this.e != State.INITIALIZING) {
                lx1.b("prepare() method called on illegal state");
                h();
                this.e = State.ERROR;
                return;
            }
            if (!(this.c.getState() == 1) || !(this.b != null)) {
                lx1.b("prepare() method called on uninitialized recorder");
                this.e = State.ERROR;
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.b, "rw");
            this.f = randomAccessFile;
            randomAccessFile.setLength(0L);
            this.f.writeBytes("RIFF");
            this.f.writeInt(0);
            this.f.writeBytes("WAVE");
            this.f.writeBytes("fmt ");
            this.f.writeInt(Integer.reverseBytes(16));
            this.f.writeShort(Short.reverseBytes((short) 1));
            this.f.writeShort(Short.reverseBytes(this.g));
            this.f.writeInt(Integer.reverseBytes(this.h));
            this.f.writeInt(Integer.reverseBytes(((this.h * this.i) * this.g) / 8));
            this.f.writeShort(Short.reverseBytes((short) ((this.g * this.i) / 8)));
            this.f.writeShort(Short.reverseBytes(this.i));
            this.f.writeBytes(cl.b);
            this.f.writeInt(0);
            lx1.b("fileheader length:" + this.f.length());
            this.n = new byte[((this.m * this.i) / 8) * this.g];
            this.e = State.READY;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                lx1.b(e.getMessage());
            } else {
                lx1.b("Unknown error occured in prepare()");
            }
            this.e = State.ERROR;
        }
    }

    public void h() {
        State state = this.e;
        if (state == State.RECORDING) {
            l();
        } else if (state == State.READY) {
            try {
                this.f.close();
            } catch (IOException unused) {
                lx1.b("I/O exception occured while closing output file");
            }
            new File(this.b).delete();
        }
        AudioRecord audioRecord = this.c;
        if (audioRecord != null) {
            audioRecord.release();
        }
    }

    public void i() {
        try {
            if (this.e != State.ERROR) {
                this.b = null;
                this.d = 0;
                this.e = State.INITIALIZING;
            }
        } catch (Exception e) {
            lx1.b(e.getMessage());
            this.e = State.ERROR;
        }
    }

    public void j(String str) {
        try {
            if (this.e == State.INITIALIZING) {
                this.b = str;
            }
        } catch (Exception e) {
            if (e.getMessage() != null) {
                lx1.b(e.getMessage());
            } else {
                lx1.b("Unknown error occured while setting output path");
            }
            this.e = State.ERROR;
        }
    }

    public void k() {
        if (this.e != State.READY) {
            lx1.b("start() called on illegal state");
            this.e = State.ERROR;
            return;
        }
        this.o = 0;
        this.c.startRecording();
        AudioRecord audioRecord = this.c;
        byte[] bArr = this.n;
        audioRecord.read(bArr, 0, bArr.length);
        this.e = State.RECORDING;
        this.a.add(this.b);
    }

    public synchronized void l() {
        if (this.e == State.RECORDING) {
            this.c.stop();
            lx1.b("payloadSize:" + this.o);
            try {
                this.f.seek(4L);
                this.f.writeInt(Integer.reverseBytes(this.o + 36));
                this.f.seek(40L);
                this.f.writeInt(Integer.reverseBytes(this.o));
                this.f.close();
            } catch (IOException unused) {
                lx1.b("I/O exception occured while closing output file");
                this.e = State.ERROR;
            }
            this.e = State.STOPPED;
        } else {
            lx1.b("stop() called on illegal state");
            this.e = State.ERROR;
        }
    }

    public final synchronized void m() {
        try {
            if (this.e == State.STOPPED) {
                return;
            }
            AudioRecord audioRecord = this.c;
            byte[] bArr = this.n;
            int i = 0;
            audioRecord.read(bArr, 0, bArr.length);
            try {
                this.f.write(this.n);
                this.o += this.n.length;
                lx1.b("buffer size:" + this.n.length + " payloadSize:" + this.o);
                if (this.i != 16) {
                    while (true) {
                        byte[] bArr2 = this.n;
                        if (i >= bArr2.length) {
                            break;
                        }
                        byte b = bArr2[i];
                        if (b > this.d) {
                            this.d = b;
                        }
                        i++;
                    }
                } else {
                    while (true) {
                        byte[] bArr3 = this.n;
                        if (i >= bArr3.length / 2) {
                            break;
                        }
                        int i2 = i * 2;
                        short e = e(bArr3[i2], bArr3[i2 + 1]);
                        if (e > this.d) {
                            this.d = e;
                        }
                        i++;
                    }
                }
            } catch (Exception unused) {
                lx1.b("Error occured in updateListener, recording is aborted");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
