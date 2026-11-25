package defpackage;

import com.yunbao.im.dao.IMUserBean;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public interface th1 {
    void a(IMUserBean iMUserBean);

    default void b(List list) {
        IMUserBean d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                IMUserBean iMUserBean = (IMUserBean) it.next();
                if (iMUserBean != null && ((d = d(iMUserBean.getUserID())) == null || iMUserBean.getLastMsgTime() > d.getLastMsgTime())) {
                    if (iMUserBean.getUserNiceName().length() != 0) {
                        a(iMUserBean);
                    }
                }
            }
        }
    }

    void c(String str);

    IMUserBean d(String str);

    default void e(IMUserBean iMUserBean) {
        if (iMUserBean != null) {
            IMUserBean d = d(iMUserBean.getUserID());
            if (d == null || iMUserBean.getLastMsgTime() > d.getLastMsgTime()) {
                a(iMUserBean);
            }
        }
    }

    List getAll();
}
