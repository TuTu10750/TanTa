package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public abstract class jz0 {
    public static final Map a;
    public static final List b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a = linkedHashMap;
        linkedHashMap.put("[微笑]", Integer.valueOf(q83.c));
        linkedHashMap.put("[色]", Integer.valueOf(q83.d));
        linkedHashMap.put("[发呆]", Integer.valueOf(q83.e));
        linkedHashMap.put("[抽烟]", Integer.valueOf(q83.f));
        linkedHashMap.put("[抠鼻]", Integer.valueOf(q83.g));
        linkedHashMap.put("[哭]", Integer.valueOf(q83.h));
        linkedHashMap.put("[发怒]", Integer.valueOf(q83.i));
        linkedHashMap.put("[呲牙]", Integer.valueOf(q83.j));
        linkedHashMap.put("[睡]", Integer.valueOf(q83.k));
        linkedHashMap.put("[害羞]", Integer.valueOf(q83.l));
        linkedHashMap.put("[调皮]", Integer.valueOf(q83.m));
        linkedHashMap.put("[晕]", Integer.valueOf(q83.n));
        linkedHashMap.put("[衰]", Integer.valueOf(q83.o));
        linkedHashMap.put("[闭嘴]", Integer.valueOf(q83.p));
        linkedHashMap.put("[指点]", Integer.valueOf(q83.q));
        linkedHashMap.put("[关注]", Integer.valueOf(q83.r));
        linkedHashMap.put("[搞定]", Integer.valueOf(q83.s));
        linkedHashMap.put("[胜利]", Integer.valueOf(q83.t));
        linkedHashMap.put("[无奈]", Integer.valueOf(q83.u));
        linkedHashMap.put("[打脸]", Integer.valueOf(q83.v));
        linkedHashMap.put("[大笑]", Integer.valueOf(q83.w));
        linkedHashMap.put("[哈欠]", Integer.valueOf(q83.x));
        linkedHashMap.put("[害怕]", Integer.valueOf(q83.y));
        linkedHashMap.put("[喜欢]", Integer.valueOf(q83.z));
        linkedHashMap.put("[困]", Integer.valueOf(q83.A));
        linkedHashMap.put("[疑问]", Integer.valueOf(q83.B));
        linkedHashMap.put("[伤心]", Integer.valueOf(q83.C));
        linkedHashMap.put("[鼓掌]", Integer.valueOf(q83.D));
        linkedHashMap.put("[得意]", Integer.valueOf(q83.E));
        linkedHashMap.put("[捂嘴]", Integer.valueOf(q83.F));
        linkedHashMap.put("[惊恐]", Integer.valueOf(q83.G));
        linkedHashMap.put("[思考]", Integer.valueOf(q83.H));
        linkedHashMap.put("[吐血]", Integer.valueOf(q83.I));
        linkedHashMap.put("[卖萌]", Integer.valueOf(q83.J));
        linkedHashMap.put("[嘘]", Integer.valueOf(q83.K));
        linkedHashMap.put("[生气]", Integer.valueOf(q83.L));
        linkedHashMap.put("[尴尬]", Integer.valueOf(q83.M));
        linkedHashMap.put("[笑哭]", Integer.valueOf(q83.N));
        linkedHashMap.put("[口罩]", Integer.valueOf(q83.O));
        linkedHashMap.put("[斜眼]", Integer.valueOf(q83.P));
        linkedHashMap.put("[酷]", Integer.valueOf(q83.Q));
        linkedHashMap.put("[脸红]", Integer.valueOf(q83.R));
        linkedHashMap.put("[大叫]", Integer.valueOf(q83.S));
        linkedHashMap.put("[眼泪]", Integer.valueOf(q83.T));
        linkedHashMap.put("[见钱]", Integer.valueOf(q83.U));
        linkedHashMap.put("[嘟]", Integer.valueOf(q83.V));
        linkedHashMap.put("[吓]", Integer.valueOf(q83.W));
        linkedHashMap.put("[开心]", Integer.valueOf(q83.X));
        linkedHashMap.put("[想哭]", Integer.valueOf(q83.Y));
        linkedHashMap.put("[郁闷]", Integer.valueOf(q83.Z));
        linkedHashMap.put("[互粉]", Integer.valueOf(q83.a0));
        linkedHashMap.put("[赞]", Integer.valueOf(q83.b0));
        linkedHashMap.put("[拜托]", Integer.valueOf(q83.c0));
        linkedHashMap.put("[唇]", Integer.valueOf(q83.d0));
        linkedHashMap.put("[粉]", Integer.valueOf(q83.e0));
        linkedHashMap.put("[666]", Integer.valueOf(q83.f0));
        linkedHashMap.put("[玫瑰]", Integer.valueOf(q83.g0));
        linkedHashMap.put("[黄瓜]", Integer.valueOf(q83.h0));
        linkedHashMap.put("[啤酒]", Integer.valueOf(q83.i0));
        linkedHashMap.put("[无语]", Integer.valueOf(q83.j0));
        linkedHashMap.put("[纠结]", Integer.valueOf(q83.k0));
        linkedHashMap.put("[吐舌]", Integer.valueOf(q83.l0));
        linkedHashMap.put("[差评]", Integer.valueOf(q83.m0));
        linkedHashMap.put("[飞吻]", Integer.valueOf(q83.n0));
        linkedHashMap.put("[再见]", Integer.valueOf(q83.o0));
        linkedHashMap.put("[拒绝]", Integer.valueOf(q83.p0));
        linkedHashMap.put("[耳机]", Integer.valueOf(q83.q0));
        linkedHashMap.put("[抱抱]", Integer.valueOf(q83.r0));
        linkedHashMap.put("[嘴]", Integer.valueOf(q83.s0));
        linkedHashMap.put("[露牙]", Integer.valueOf(q83.t0));
        linkedHashMap.put("[黄狗]", Integer.valueOf(q83.u0));
        linkedHashMap.put("[灰狗]", Integer.valueOf(q83.v0));
        linkedHashMap.put("[蓝狗]", Integer.valueOf(q83.w0));
        linkedHashMap.put("[狗]", Integer.valueOf(q83.x0));
        linkedHashMap.put("[脸黑]", Integer.valueOf(q83.y0));
        linkedHashMap.put("[吃瓜]", Integer.valueOf(q83.z0));
        linkedHashMap.put("[绿帽]", Integer.valueOf(q83.A0));
        linkedHashMap.put("[汗]", Integer.valueOf(q83.B0));
        linkedHashMap.put("[摸头]", Integer.valueOf(q83.C0));
        linkedHashMap.put("[阴险]", Integer.valueOf(q83.D0));
        linkedHashMap.put("[擦汗]", Integer.valueOf(q83.E0));
        linkedHashMap.put("[瞪眼]", Integer.valueOf(q83.F0));
        linkedHashMap.put("[疼]", Integer.valueOf(q83.G0));
        linkedHashMap.put("[鬼脸]", Integer.valueOf(q83.H0));
        linkedHashMap.put("[拇指]", Integer.valueOf(q83.I0));
        linkedHashMap.put("[亲]", Integer.valueOf(q83.J0));
        linkedHashMap.put("[大吐]", Integer.valueOf(q83.K0));
        linkedHashMap.put("[高兴]", Integer.valueOf(q83.L0));
        linkedHashMap.put("[敲打]", Integer.valueOf(q83.M0));
        linkedHashMap.put("[加油]", Integer.valueOf(q83.N0));
        linkedHashMap.put("[吐]", Integer.valueOf(q83.O0));
        linkedHashMap.put("[握手]", Integer.valueOf(q83.P0));
        linkedHashMap.put("[18禁]", Integer.valueOf(q83.Q0));
        linkedHashMap.put("[菜刀]", Integer.valueOf(q83.R0));
        linkedHashMap.put("[威武]", Integer.valueOf(q83.S0));
        linkedHashMap.put("[给力]", Integer.valueOf(q83.T0));
        linkedHashMap.put("[爱心]", Integer.valueOf(q83.U0));
        linkedHashMap.put("[心碎]", Integer.valueOf(q83.V0));
        linkedHashMap.put("[便便]", Integer.valueOf(q83.W0));
        linkedHashMap.put("[礼物]", Integer.valueOf(q83.X0));
        linkedHashMap.put("[生日]", Integer.valueOf(q83.Y0));
        linkedHashMap.put("[喝彩]", Integer.valueOf(q83.Z0));
        linkedHashMap.put("[雷]", Integer.valueOf(q83.a1));
        b = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            b.add((String) ((Map.Entry) it.next()).getKey());
        }
    }

    public static Integer a(String str) {
        return (Integer) a.get(str);
    }

    public static List b() {
        return b;
    }
}
