package com.umeng.analytics.pro;

import com.umeng.analytics.pro.dx;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: /tmp/classes2.dex */
public class dh {
    private final ed a;
    private final eq b;

    public dh() {
        this(new dx.a());
    }

    public dh(ef efVar) {
        eq eqVar = new eq();
        this.b = eqVar;
        this.a = efVar.a(eqVar);
    }

    private Object a(byte b, byte[] bArr, dl dlVar, dl... dlVarArr) {
        Object valueOf;
        try {
            try {
                dy j = j(bArr, dlVar, dlVarArr);
                if (j != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && j.b == 11) {
                                                    valueOf = this.a.z();
                                                    return valueOf;
                                                }
                                            } else if (j.b == 10) {
                                                valueOf = Long.valueOf(this.a.x());
                                                return valueOf;
                                            }
                                        } else if (j.b == 11) {
                                            valueOf = this.a.A();
                                            return valueOf;
                                        }
                                    } else if (j.b == 8) {
                                        valueOf = Integer.valueOf(this.a.w());
                                        return valueOf;
                                    }
                                } else if (j.b == 6) {
                                    valueOf = Short.valueOf(this.a.v());
                                    return valueOf;
                                }
                            } else if (j.b == 4) {
                                valueOf = Double.valueOf(this.a.y());
                                return valueOf;
                            }
                        } else if (j.b == 3) {
                            valueOf = Byte.valueOf(this.a.u());
                            return valueOf;
                        }
                    } else if (j.b == 2) {
                        valueOf = Boolean.valueOf(this.a.t());
                        return valueOf;
                    }
                }
                this.b.e();
                this.a.B();
                return null;
            } catch (Exception e) {
                throw new dk(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    private dy j(byte[] bArr, dl dlVar, dl... dlVarArr) {
        this.b.a(bArr);
        int length = dlVarArr.length + 1;
        dl[] dlVarArr2 = new dl[length];
        int i = 0;
        dlVarArr2[0] = dlVar;
        int i2 = 0;
        while (i2 < dlVarArr.length) {
            int i3 = i2 + 1;
            dlVarArr2[i3] = dlVarArr[i2];
            i2 = i3;
        }
        this.a.j();
        dy dyVar = null;
        while (i < length) {
            dyVar = this.a.l();
            if (dyVar.b == 0 || dyVar.c > dlVarArr2[i].a()) {
                return null;
            }
            if (dyVar.c != dlVarArr2[i].a()) {
                eg.a(this.a, dyVar.b);
                this.a.m();
            } else {
                i++;
                if (i < length) {
                    this.a.j();
                }
            }
        }
        return dyVar;
    }

    public Boolean a(byte[] bArr, dl dlVar, dl... dlVarArr) {
        return (Boolean) a((byte) 2, bArr, dlVar, dlVarArr);
    }

    public void a(de deVar, String str) {
        a(deVar, str.getBytes());
    }

    public void a(de deVar, String str, String str2) {
        try {
            try {
                a(deVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new dk("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.a.B();
        }
    }

    public void a(de deVar, byte[] bArr) {
        try {
            this.b.a(bArr);
            deVar.read(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public void a(de deVar, byte[] bArr, dl dlVar, dl... dlVarArr) {
        try {
            try {
                if (j(bArr, dlVar, dlVarArr) != null) {
                    deVar.read(this.a);
                }
            } catch (Exception e) {
                throw new dk(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Byte b(byte[] bArr, dl dlVar, dl... dlVarArr) {
        return (Byte) a((byte) 3, bArr, dlVar, dlVarArr);
    }

    public Double c(byte[] bArr, dl dlVar, dl... dlVarArr) {
        return (Double) a((byte) 4, bArr, dlVar, dlVarArr);
    }

    public Short d(byte[] bArr, dl dlVar, dl... dlVarArr) {
        return (Short) a((byte) 6, bArr, dlVar, dlVarArr);
    }

    public Integer e(byte[] bArr, dl dlVar, dl... dlVarArr) {
        return (Integer) a((byte) 8, bArr, dlVar, dlVarArr);
    }

    public Long f(byte[] bArr, dl dlVar, dl... dlVarArr) {
        return (Long) a((byte) 10, bArr, dlVar, dlVarArr);
    }

    public String g(byte[] bArr, dl dlVar, dl... dlVarArr) {
        return (String) a((byte) 11, bArr, dlVar, dlVarArr);
    }

    public ByteBuffer h(byte[] bArr, dl dlVar, dl... dlVarArr) {
        return (ByteBuffer) a((byte) 100, bArr, dlVar, dlVarArr);
    }

    public Short i(byte[] bArr, dl dlVar, dl... dlVarArr) {
        try {
            try {
                if (j(bArr, dlVar, dlVarArr) != null) {
                    this.a.j();
                    return Short.valueOf(this.a.l().c);
                }
                this.b.e();
                this.a.B();
                return null;
            } catch (Exception e) {
                throw new dk(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }
}
