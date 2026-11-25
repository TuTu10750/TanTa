package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;

/* loaded from: /tmp/classes2.dex */
public abstract class b43 {

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ProtoBuf$MemberKind.values().length];
            try {
                iArr[ProtoBuf$MemberKind.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$MemberKind.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf$MemberKind.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            try {
                iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            b = iArr2;
            int[] iArr3 = new int[ProtoBuf$Visibility.values().length];
            try {
                iArr3[ProtoBuf$Visibility.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ProtoBuf$Visibility.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[ProtoBuf$Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ProtoBuf$Visibility.PROTECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[ProtoBuf$Visibility.PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ProtoBuf$Visibility.LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            c = iArr3;
        }
    }

    public static final pk0 a(a43 a43Var, ProtoBuf$Visibility protoBuf$Visibility) {
        a43Var.getClass();
        switch (protoBuf$Visibility == null ? -1 : a.c[protoBuf$Visibility.ordinal()]) {
            case 1:
                pk0 pk0Var = ok0.d;
                pk0Var.getClass();
                return pk0Var;
            case 2:
                pk0 pk0Var2 = ok0.a;
                pk0Var2.getClass();
                return pk0Var2;
            case 3:
                pk0 pk0Var3 = ok0.b;
                pk0Var3.getClass();
                return pk0Var3;
            case 4:
                pk0 pk0Var4 = ok0.c;
                pk0Var4.getClass();
                return pk0Var4;
            case 5:
                pk0 pk0Var5 = ok0.e;
                pk0Var5.getClass();
                return pk0Var5;
            case 6:
                pk0 pk0Var6 = ok0.f;
                pk0Var6.getClass();
                return pk0Var6;
            default:
                pk0 pk0Var7 = ok0.a;
                pk0Var7.getClass();
                return pk0Var7;
        }
    }

    public static final CallableMemberDescriptor.Kind b(a43 a43Var, ProtoBuf$MemberKind protoBuf$MemberKind) {
        a43Var.getClass();
        int i = protoBuf$MemberKind == null ? -1 : a.a[protoBuf$MemberKind.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? CallableMemberDescriptor.Kind.DECLARATION : CallableMemberDescriptor.Kind.SYNTHESIZED : CallableMemberDescriptor.Kind.DELEGATION : CallableMemberDescriptor.Kind.FAKE_OVERRIDE : CallableMemberDescriptor.Kind.DECLARATION;
    }
}
