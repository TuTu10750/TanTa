package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.de;
import com.umeng.analytics.pro.dk;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.dv;
import com.umeng.analytics.pro.dx;
import com.umeng.analytics.pro.dy;
import com.umeng.analytics.pro.ed;
import com.umeng.analytics.pro.eg;
import com.umeng.analytics.pro.ei;
import com.umeng.analytics.pro.ej;
import com.umeng.analytics.pro.el;
import com.umeng.analytics.pro.em;
import com.umeng.analytics.pro.en;
import com.umeng.analytics.pro.eo;
import com.umeng.analytics.pro.ep;
import defpackage.fe1;
import defpackage.rr4;
import defpackage.sr4;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class Response implements de<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, dq> metaDataMap;
    private static final Map<Class<? extends el>, em> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final ei STRUCT_DESC = new ei("Response");
    private static final dy RESP_CODE_FIELD_DESC = new dy("resp_code", (byte) 8, 1);
    private static final dy MSG_FIELD_DESC = new dy(cl.h, (byte) 11, 2);
    private static final dy IMPRINT_FIELD_DESC = new dy(bv.X, (byte) 12, 3);

    /* loaded from: /tmp/classes2.dex */
    public static class a extends en<Response> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, Response response) {
            edVar.j();
            while (true) {
                dy l = edVar.l();
                byte b = l.b;
                if (b == 0) {
                    break;
                }
                short s = l.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            eg.a(edVar, b);
                        } else if (b == 12) {
                            com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                            response.imprint = dVar;
                            dVar.read(edVar);
                            response.setImprintIsSet(true);
                        } else {
                            eg.a(edVar, b);
                        }
                    } else if (b == 11) {
                        response.msg = edVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        eg.a(edVar, b);
                    }
                } else if (b == 8) {
                    response.resp_code = edVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    eg.a(edVar, b);
                }
                edVar.m();
            }
            edVar.k();
            if (response.isSetResp_code()) {
                response.validate();
            } else {
                rr4.a("Required field 'resp_code' was not found in serialized data! Struct: ", this);
            }
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, Response response) {
            response.validate();
            edVar.a(Response.STRUCT_DESC);
            edVar.a(Response.RESP_CODE_FIELD_DESC);
            edVar.a(response.resp_code);
            edVar.c();
            if (response.msg != null && response.isSetMsg()) {
                edVar.a(Response.MSG_FIELD_DESC);
                edVar.a(response.msg);
                edVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                edVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(edVar);
                edVar.c();
            }
            edVar.d();
            edVar.b();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b implements em {
        private b() {
        }

        @Override // com.umeng.analytics.pro.em
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c extends eo<Response> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.el
        public void a(ed edVar, Response response) {
            ej ejVar = (ej) edVar;
            ejVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            ejVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                ejVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(ejVar);
            }
        }

        @Override // com.umeng.analytics.pro.el
        public void b(ed edVar, Response response) {
            ej ejVar = (ej) edVar;
            response.resp_code = ejVar.w();
            response.setResp_codeIsSet(true);
            BitSet b = ejVar.b(2);
            if (b.get(0)) {
                response.msg = ejVar.z();
                response.setMsgIsSet(true);
            }
            if (b.get(1)) {
                com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint = dVar;
                dVar.read(ejVar);
                response.setImprintIsSet(true);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class d implements em {
        private d() {
        }

        @Override // com.umeng.analytics.pro.em
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public enum e implements dl {
        RESP_CODE(1, "resp_code"),
        MSG(2, cl.h),
        IMPRINT(3, bv.X);

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return RESP_CODE;
            }
            if (i == 2) {
                return MSG;
            }
            if (i != 3) {
                return null;
            }
            return IMPRINT;
        }

        public static e a(String str) {
            return d.get(str);
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            sr4.a("Field ", i, " doesn't exist!");
            return null;
        }

        @Override // com.umeng.analytics.pro.dl
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.dl
        public String b() {
            return this.f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        hashMap.put(en.class, new b());
        hashMap.put(eo.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.RESP_CODE, (e) new dq("resp_code", (byte) 1, new dr((byte) 8)));
        enumMap.put((EnumMap) e.MSG, (e) new dq(cl.h, (byte) 2, new dr((byte) 11)));
        enumMap.put((EnumMap) e.IMPRINT, (e) new dq(bv.X, (byte) 2, new dv((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, dq> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        dq.a(Response.class, unmodifiableMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new dx(new ep(objectInputStream)));
        } catch (dk e2) {
            fe1.a(e2.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            write(new dx(new ep(objectOutputStream)));
        } catch (dk e2) {
            fe1.a(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.de
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    @Override // com.umeng.analytics.pro.de
    public de<Response, e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.de
    public e fieldForId(int i) {
        return e.a(i);
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return db.a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.de
    public void read(ed edVar) {
        schemes.get(edVar.D()).b().b(edVar, this);
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = db.a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = db.b(this.__isset_bitfield, 0);
    }

    public void validate() {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.umeng.analytics.pro.de
    public void write(ed edVar) {
        schemes.get(edVar.D()).b().a(edVar, this);
    }
}
