package defpackage;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* loaded from: /tmp/classes2.dex */
public final class re3 {
    public final LockFreeLinkedListNode a;

    public re3(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.a = lockFreeLinkedListNode;
    }

    public String toString() {
        return "Removed[" + this.a + ']';
    }
}
