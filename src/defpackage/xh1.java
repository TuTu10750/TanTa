package defpackage;

import defpackage.ai;
import defpackage.nw2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public abstract class xh1 implements nw2 {
    public static final Logger b = Logger.getLogger(xh1.class.getName());

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public uv2 a;
        public List b = new ArrayList();

        public a(uv2 uv2Var) {
            this.a = uv2Var;
        }

        public void a() {
            this.a = null;
            this.b = new ArrayList();
        }

        public uv2 b(byte[] bArr) {
            this.b.add(bArr);
            int size = this.b.size();
            uv2 uv2Var = this.a;
            if (size != uv2Var.e) {
                return null;
            }
            List list = this.b;
            uv2 d = ai.d(uv2Var, (byte[][]) list.toArray(new byte[list.size()]));
            a();
            return d;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b implements nw2.a {
        public a a = null;
        public nw2.a.InterfaceC0136a b;

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
        
            r1.b = java.lang.Integer.parseInt(r3.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
        
            throw new io.socket.parser.DecodingException("invalid payload");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static defpackage.uv2 d(java.lang.String r9) {
            /*
                Method dump skipped, instructions count: 302
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xh1.b.d(java.lang.String):uv2");
        }

        public static boolean e(int i, Object obj) {
            switch (i) {
                case 0:
                case 4:
                    return obj instanceof JSONObject;
                case 1:
                    return obj == null;
                case 2:
                case 5:
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray.length() > 0 && !jSONArray.isNull(0)) {
                            return true;
                        }
                    }
                    return false;
                case 3:
                case 6:
                    return obj instanceof JSONArray;
                default:
                    return false;
            }
        }

        @Override // nw2.a
        public void a(byte[] bArr) {
            a aVar = this.a;
            if (aVar == null) {
                kc1.a("got binary data when not reconstructing a packet");
                return;
            }
            uv2 b = aVar.b(bArr);
            if (b != null) {
                this.a = null;
                nw2.a.InterfaceC0136a interfaceC0136a = this.b;
                if (interfaceC0136a != null) {
                    interfaceC0136a.a(b);
                }
            }
        }

        @Override // nw2.a
        public void b(nw2.a.InterfaceC0136a interfaceC0136a) {
            this.b = interfaceC0136a;
        }

        @Override // nw2.a
        public void c(String str) {
            nw2.a.InterfaceC0136a interfaceC0136a;
            uv2 d = d(str);
            int i = d.a;
            if (5 != i && 6 != i) {
                nw2.a.InterfaceC0136a interfaceC0136a2 = this.b;
                if (interfaceC0136a2 != null) {
                    interfaceC0136a2.a(d);
                    return;
                }
                return;
            }
            a aVar = new a(d);
            this.a = aVar;
            if (aVar.a.e != 0 || (interfaceC0136a = this.b) == null) {
                return;
            }
            interfaceC0136a.a(d);
        }

        @Override // nw2.a
        public void destroy() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
            this.b = null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class c implements nw2.b {
        @Override // nw2.b
        public void a(uv2 uv2Var, nw2.b.a aVar) {
            int i = uv2Var.a;
            if ((i == 2 || i == 3) && af1.b(uv2Var.d)) {
                uv2Var.a = uv2Var.a == 2 ? 5 : 6;
            }
            if (xh1.b.isLoggable(Level.FINE)) {
                xh1.b.fine(String.format("encoding packet %s", uv2Var));
            }
            int i2 = uv2Var.a;
            if (5 == i2 || 6 == i2) {
                b(uv2Var, aVar);
            } else {
                aVar.call(new String[]{c(uv2Var)});
            }
        }

        public final void b(uv2 uv2Var, nw2.b.a aVar) {
            ai.a c = ai.c(uv2Var);
            String c2 = c(c.a);
            ArrayList arrayList = new ArrayList(Arrays.asList(c.b));
            arrayList.add(0, c2);
            aVar.call(arrayList.toArray());
        }

        public final String c(uv2 uv2Var) {
            StringBuilder sb = new StringBuilder("" + uv2Var.a);
            int i = uv2Var.a;
            if (5 == i || 6 == i) {
                sb.append(uv2Var.e);
                sb.append("-");
            }
            String str = uv2Var.c;
            if (str != null && str.length() != 0 && !"/".equals(uv2Var.c)) {
                sb.append(uv2Var.c);
                sb.append(",");
            }
            int i2 = uv2Var.b;
            if (i2 >= 0) {
                sb.append(i2);
            }
            Object obj = uv2Var.d;
            if (obj != null) {
                sb.append(obj);
            }
            if (xh1.b.isLoggable(Level.FINE)) {
                xh1.b.fine(String.format("encoded %s as %s", uv2Var, sb));
            }
            return sb.toString();
        }
    }
}
