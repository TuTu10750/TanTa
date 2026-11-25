package defpackage;

/* loaded from: /tmp/classes2.dex */
public interface nw2 {
    public static final String[] a = {"CONNECT", "DISCONNECT", "EVENT", "ACK", "ERROR", "BINARY_EVENT", "BINARY_ACK"};

    /* loaded from: /tmp/classes2.dex */
    public interface a {

        /* renamed from: nw2$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public interface InterfaceC0136a {
            void a(uv2 uv2Var);
        }

        void a(byte[] bArr);

        void b(InterfaceC0136a interfaceC0136a);

        void c(String str);

        void destroy();
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {

        /* loaded from: /tmp/classes2.dex */
        public interface a {
            void call(Object[] objArr);
        }

        void a(uv2 uv2Var, a aVar);
    }
}
