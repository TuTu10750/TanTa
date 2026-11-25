package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /tmp/classes2.dex */
public class wb implements Parcelable {
    public static final Parcelable.Creator<wb> CREATOR = new a();
    public final String a;
    public final float b;
    public final float c;

    /* loaded from: /tmp/classes2.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public wb createFromParcel(Parcel parcel) {
            return new wb(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public wb[] newArray(int i) {
            return new wb[i];
        }
    }

    public wb(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
    }

    public wb(String str, float f, float f2) {
        this.a = str;
        this.b = f;
        this.c = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.a;
    }

    public float f() {
        return this.b;
    }

    public float g() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
    }
}
