package defpackage;

import android.os.Handler;
import android.text.TextUtils;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.CommonAppContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class g00 {
    public static g00 c;
    public ArrayList a = new ArrayList();
    public Handler b = new Handler();

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ k30 a;

        public a(k30 k30Var) {
            this.a = k30Var;
        }

        /* JADX WARN: Not initialized variable reg: 2, insn: 0x002b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:45:0x002b */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0079 -> B:26:0x0090). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2;
            BufferedReader bufferedReader3 = null;
            try {
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader;
            }
            try {
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(CommonAppContext.n().getAssets().open("city.json"), "utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        } else {
                            sb.append(readLine);
                        }
                    }
                    String sb2 = sb.toString();
                    boolean isEmpty = TextUtils.isEmpty(sb2);
                    g00 g00Var = g00.this;
                    if (isEmpty) {
                        g00Var.k(this.a, null);
                    } else {
                        ArrayList j = g00Var.j(sb2);
                        if (g00.this.a == null) {
                            g00.this.a = new ArrayList();
                        }
                        g00.this.a.clear();
                        g00.this.a.addAll(j);
                        g00 g00Var2 = g00.this;
                        g00Var2.k(this.a, g00Var2.a);
                    }
                    bufferedReader2.close();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    g00.this.k(this.a, null);
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader2 = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public final /* synthetic */ k30 a;
        public final /* synthetic */ ArrayList b;

        public b(k30 k30Var, ArrayList arrayList) {
            this.a = k30Var;
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            k30 k30Var = this.a;
            if (k30Var != null) {
                k30Var.a(this.b);
            }
        }
    }

    public static g00 g() {
        if (c == null) {
            synchronized (g00.class) {
                try {
                    if (c == null) {
                        c = new g00();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public ArrayList e() {
        return this.a;
    }

    public void f(k30 k30Var) {
        new Thread(new a(k30Var)).start();
    }

    public final List h(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    City city = new City();
                    String string = jSONObject.getString("areaId");
                    city.setAreaId(string);
                    city.setAreaName(jSONObject.getString("areaName"));
                    city.setProvinceId(str);
                    city.setCounties(i(jSONObject.getJSONArray("counties"), string));
                    arrayList.add(city);
                }
            }
        }
        return arrayList;
    }

    public final List i(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    County county = new County();
                    county.setAreaId(jSONObject.getString("areaId"));
                    county.setAreaName(jSONObject.getString("areaName"));
                    county.setCityId(str);
                    arrayList.add(county);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList j(String str) {
        ArrayList arrayList = new ArrayList();
        JSONArray parseArray = JSON.parseArray(str);
        if (parseArray != null) {
            int size = parseArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = parseArray.getJSONObject(i);
                if (jSONObject != null) {
                    Province province = new Province();
                    String string = jSONObject.getString("areaId");
                    province.setAreaId(string);
                    province.setAreaName(jSONObject.getString("areaName"));
                    province.setCities(h(jSONObject.getJSONArray("cities"), string));
                    arrayList.add(province);
                }
            }
        }
        return arrayList;
    }

    public final void k(k30 k30Var, ArrayList arrayList) {
        this.b.post(new b(k30Var, arrayList));
    }
}
