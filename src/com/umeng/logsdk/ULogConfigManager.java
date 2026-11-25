package com.umeng.logsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class ULogConfigManager {
    private Context b;
    private EfsReporter c;
    private final String a = "ULogConfigManager";
    private Vector<b> d = new Vector<>();

    public ULogConfigManager(Context context, EfsReporter efsReporter) {
        this.b = context.getApplicationContext();
        this.c = efsReporter;
        if (efsReporter != null) {
            Log.i("ULogConfigManager", "[log register] begin.");
            this.c.getAllSdkConfig(new String[]{a.d, a.c, a.g}, new IConfigCallback() { // from class: com.umeng.logsdk.ULogConfigManager.1
                public final void onChange(Map<String, Object> map) {
                    SharedPreferences.Editor edit;
                    String str;
                    String str2;
                    StringBuilder sb;
                    if (map != null) {
                        try {
                            Log.i("ULogConfigManager", "[log register] call back config.");
                            SharedPreferences sharedPreferences = ULogConfigManager.this.b.getSharedPreferences("efs_ulog", 0);
                            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                                return;
                            }
                            Object obj = map.get(a.d);
                            String str3 = "";
                            if (obj != null) {
                                str = obj.toString();
                                edit.putString(a.d, str);
                                Log.i("ULogConfigManager", "[log register] save did is ".concat(String.valueOf(str)));
                            } else {
                                str = "";
                            }
                            Object obj2 = map.get(a.c);
                            if (obj2 != null) {
                                String obj3 = obj2.toString();
                                Log.i("ULogConfigManager", "[log register] save uid before base64 is ".concat(String.valueOf(obj3)));
                                str2 = c.a(obj3.getBytes());
                                edit.putString(a.c, str2);
                                Log.i("ULogConfigManager", "[log register] save uid after base64 is ".concat(String.valueOf(str2)));
                            } else {
                                str2 = "";
                            }
                            Object obj4 = map.get(a.g);
                            if (obj4 != null && str2.equals(ULogManager.getUserID()) && str.equals(ULogManager.getDeviceID())) {
                                String obj5 = obj4.toString();
                                if (!TextUtils.isEmpty(obj5)) {
                                    JSONArray jSONArray = new JSONArray(obj5);
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                                        if (jSONObject != null) {
                                            String optString = jSONObject.optString(a.h, a.p);
                                            if (!TextUtils.isEmpty(optString)) {
                                                if (TextUtils.isEmpty(str3)) {
                                                    sb = new StringBuilder();
                                                    sb.append(str3);
                                                } else {
                                                    sb = new StringBuilder();
                                                    sb.append(str3);
                                                    sb.append("_");
                                                }
                                                sb.append(optString);
                                                str3 = sb.toString();
                                                edit.putString(optString, jSONObject.toString());
                                                Log.i("ULogConfigManager", "[log register] save task id is " + optString + ", task is " + jSONObject.toString());
                                                b bVar = new b();
                                                int optInt = jSONObject.optInt(a.i, -1);
                                                int optInt2 = jSONObject.optInt(a.j, -1);
                                                if (optInt == 0) {
                                                    String str4 = optInt2 == 0 ? str2 : optInt2 == 1 ? str : null;
                                                    if (!TextUtils.isEmpty(str4)) {
                                                        bVar.a = optString;
                                                        bVar.b = optInt;
                                                        bVar.c = optInt2;
                                                        bVar.d = str4;
                                                        bVar.e = jSONObject.optLong(a.l, 0L);
                                                        bVar.f = jSONObject.optLong(a.m, 0L);
                                                        Log.i("ULogConfigManager", "[log register] add mem task id is ".concat(String.valueOf(optString)));
                                                        ULogConfigManager.this.d.add(bVar);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                edit.putString(a.e, str3);
                                Log.i("ULogConfigManager", "[log register] save task id set is ".concat(String.valueOf(str3)));
                            }
                            edit.commit();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public List<b> getTaskList() {
        return this.d;
    }

    public void reMoveTaskFroSP(String str) {
        String[] split;
        try {
            Log.i("ULogConfigManager", "[log remove] remove sp. delete task id is ".concat(String.valueOf(str)));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SharedPreferences sharedPreferences = this.b.getSharedPreferences("efs_ulog", 0);
            if (sharedPreferences == null || sharedPreferences.edit() == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString(a.d, "");
            String string2 = sharedPreferences.getString(a.c, "");
            String string3 = sharedPreferences.getString(a.e, "");
            if (!string2.equals(ULogManager.getUserID()) || !string.equals(ULogManager.getDeviceID()) || TextUtils.isEmpty(string3) || (split = string3.split("_")) == null) {
                return;
            }
            for (int i = 0; i < split.length; i++) {
                String str2 = split[i];
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    Log.i("ULogConfigManager", "[log remove] taskId is ".concat(str2));
                    if (string3.equals(str2)) {
                        string3 = "";
                    } else {
                        string3 = string3.replaceFirst(i == split.length - 1 ? "_".concat(str2) : str2 + "_", "");
                    }
                    Log.i("ULogConfigManager", "[log remove] put id set is ".concat(String.valueOf(string3)));
                    edit.putString(a.e, string3);
                    edit.remove(str2);
                    edit.commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeTask(b bVar) {
        Vector<b> vector = this.d;
        if (vector == null || !vector.contains(bVar)) {
            return;
        }
        Log.i("ULogConfigManager", "[log remove] remove mem. task id is " + bVar.a);
        this.d.remove(bVar);
    }
}
