package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.c;

/* loaded from: /tmp/classes2.dex */
public class hu0 extends n00 {
    public final ea4 i;
    public final MemberScope j;
    public final wq2 k;
    public final j8 l;

    /* loaded from: /tmp/classes2.dex */
    public class a extends dk2 {
        public final ek2 b;
        public final ek2 c;
        public final wq2 d;
        public final /* synthetic */ hu0 e;

        /* renamed from: hu0$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0072a implements n81 {
            public final /* synthetic */ hu0 a;

            public C0072a(hu0 hu0Var) {
                this.a = hu0Var;
            }

            @Override // defpackage.n81
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke(zo2 zo2Var) {
                return a.this.m(zo2Var);
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements n81 {
            public final /* synthetic */ hu0 a;

            public b(hu0 hu0Var) {
                this.a = hu0Var;
            }

            @Override // defpackage.n81
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke(zo2 zo2Var) {
                return a.this.n(zo2Var);
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class c implements l81 {
            public final /* synthetic */ hu0 a;

            public c(hu0 hu0Var) {
                this.a = hu0Var;
            }

            @Override // defpackage.l81
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection invoke() {
                return a.this.l();
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class d extends rq2 {
            public final /* synthetic */ Set a;

            public d(Set set) {
                this.a = set;
            }

            public static /* synthetic */ void f(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // defpackage.cv2
            public void a(CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    f(0);
                }
                OverridingUtil.K(callableMemberDescriptor, null);
                this.a.add(callableMemberDescriptor);
            }

            @Override // defpackage.rq2
            public void e(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    f(1);
                }
                if (callableMemberDescriptor2 == null) {
                    f(2);
                }
            }
        }

        public a(hu0 hu0Var, lu3 lu3Var) {
            if (lu3Var == null) {
                h(0);
            }
            this.e = hu0Var;
            this.b = lu3Var.h(new C0072a(hu0Var));
            this.c = lu3Var.h(new b(hu0Var));
            this.d = lu3Var.i(new c(hu0Var));
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static /* synthetic */ void h(int r13) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: hu0.a.h(int):void");
        }

        @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection a(zo2 zo2Var, z82 z82Var) {
            if (zo2Var == null) {
                h(5);
            }
            if (z82Var == null) {
                h(6);
            }
            Collection collection = (Collection) this.b.invoke(zo2Var);
            if (collection == null) {
                h(7);
            }
            return collection;
        }

        @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set b() {
            Set set = (Set) this.e.k.invoke();
            if (set == null) {
                h(17);
            }
            return set;
        }

        @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection c(zo2 zo2Var, z82 z82Var) {
            if (zo2Var == null) {
                h(1);
            }
            if (z82Var == null) {
                h(2);
            }
            Collection collection = (Collection) this.c.invoke(zo2Var);
            if (collection == null) {
                h(3);
            }
            return collection;
        }

        @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set d() {
            Set set = (Set) this.e.k.invoke();
            if (set == null) {
                h(19);
            }
            return set;
        }

        @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.c
        public Collection f(hk0 hk0Var, n81 n81Var) {
            if (hk0Var == null) {
                h(13);
            }
            if (n81Var == null) {
                h(14);
            }
            Collection collection = (Collection) this.d.invoke();
            if (collection == null) {
                h(15);
            }
            return collection;
        }

        @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set g() {
            Set set = Collections.EMPTY_SET;
            if (set == null) {
                h(18);
            }
            return set;
        }

        public final Collection l() {
            HashSet hashSet = new HashSet();
            for (zo2 zo2Var : (Set) this.e.k.invoke()) {
                NoLookupLocation noLookupLocation = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(a(zo2Var, noLookupLocation));
                hashSet.addAll(c(zo2Var, noLookupLocation));
            }
            return hashSet;
        }

        public final Collection m(zo2 zo2Var) {
            if (zo2Var == null) {
                h(8);
            }
            return p(zo2Var, o().a(zo2Var, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        public final Collection n(zo2 zo2Var) {
            if (zo2Var == null) {
                h(4);
            }
            return p(zo2Var, o().c(zo2Var, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        public final MemberScope o() {
            MemberScope s = ((fx1) this.e.k().c().iterator().next()).s();
            if (s == null) {
                h(9);
            }
            return s;
        }

        public final Collection p(zo2 zo2Var, Collection collection) {
            if (zo2Var == null) {
                h(10);
            }
            if (collection == null) {
                h(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.f.v(zo2Var, collection, Collections.EMPTY_SET, this.e, new d(linkedHashSet));
            return linkedHashSet;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hu0(lu3 lu3Var, m00 m00Var, fx1 fx1Var, zo2 zo2Var, wq2 wq2Var, j8 j8Var, xr3 xr3Var) {
        super(lu3Var, m00Var, zo2Var, xr3Var, false);
        if (lu3Var == null) {
            A0(6);
        }
        if (m00Var == null) {
            A0(7);
        }
        if (fx1Var == null) {
            A0(8);
        }
        if (zo2Var == null) {
            A0(9);
        }
        if (wq2Var == null) {
            A0(10);
        }
        if (j8Var == null) {
            A0(11);
        }
        if (xr3Var == null) {
            A0(12);
        }
        this.l = j8Var;
        this.i = new v00(this, Collections.EMPTY_LIST, Collections.singleton(fx1Var), lu3Var);
        this.j = new a(this, lu3Var);
        this.k = wq2Var;
    }

    private static /* synthetic */ void A0(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[1] = "getModality";
                break;
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[1] = "getVisibility";
                break;
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                objArr[1] = "getAnnotations";
                break;
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static hu0 L0(lu3 lu3Var, m00 m00Var, zo2 zo2Var, wq2 wq2Var, j8 j8Var, xr3 xr3Var) {
        if (lu3Var == null) {
            A0(0);
        }
        if (m00Var == null) {
            A0(1);
        }
        if (zo2Var == null) {
            A0(2);
        }
        if (wq2Var == null) {
            A0(3);
        }
        if (j8Var == null) {
            A0(4);
        }
        if (xr3Var == null) {
            A0(5);
        }
        return new hu0(lu3Var, m00Var, m00Var.u(), zo2Var, wq2Var, j8Var, xr3Var);
    }

    @Override // defpackage.m00
    public boolean C() {
        return false;
    }

    @Override // defpackage.ck2
    public boolean E0() {
        return false;
    }

    @Override // defpackage.m00
    public boolean I0() {
        return false;
    }

    @Override // defpackage.m00
    public Collection J() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            A0(23);
        }
        return list;
    }

    @Override // defpackage.ck2
    public boolean K() {
        return false;
    }

    @Override // defpackage.m00
    public b P() {
        return null;
    }

    @Override // defpackage.m00
    public MemberScope Q() {
        MemberScope.a aVar = MemberScope.a.b;
        if (aVar == null) {
            A0(15);
        }
        return aVar;
    }

    @Override // defpackage.m00
    public m00 S() {
        return null;
    }

    @Override // defpackage.a8
    public j8 getAnnotations() {
        j8 j8Var = this.l;
        if (j8Var == null) {
            A0(21);
        }
        return j8Var;
    }

    @Override // defpackage.m00, defpackage.ya0
    public pk0 getVisibility() {
        pk0 pk0Var = ok0.e;
        if (pk0Var == null) {
            A0(20);
        }
        return pk0Var;
    }

    @Override // defpackage.m00
    public ClassKind i() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            A0(18);
        }
        return classKind;
    }

    @Override // defpackage.m00
    public boolean isInline() {
        return false;
    }

    @Override // defpackage.z00
    public ea4 k() {
        ea4 ea4Var = this.i;
        if (ea4Var == null) {
            A0(17);
        }
        return ea4Var;
    }

    @Override // defpackage.m00, defpackage.ck2
    public Modality l() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            A0(19);
        }
        return modality;
    }

    @Override // defpackage.m00
    public Collection m() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            A0(16);
        }
        return list;
    }

    @Override // defpackage.m00
    public boolean n() {
        return false;
    }

    @Override // defpackage.a10
    public boolean o() {
        return false;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    @Override // defpackage.m00, defpackage.a10
    public List w() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            A0(22);
        }
        return list;
    }

    @Override // defpackage.m00
    public boolean y() {
        return false;
    }

    @Override // defpackage.m00
    public nf4 y0() {
        return null;
    }

    @Override // defpackage.fm2
    public MemberScope z0(c cVar) {
        if (cVar == null) {
            A0(13);
        }
        MemberScope memberScope = this.j;
        if (memberScope == null) {
            A0(14);
        }
        return memberScope;
    }
}
