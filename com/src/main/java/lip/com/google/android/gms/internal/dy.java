package lip.com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dy {
    private static final SimpleDateFormat qA = new SimpleDateFormat("yyyyMMdd");

    public static du a(Context context, ds dsVar, String str) {
        try {
            du duVar;
            List list;
            List list2;
            List list3;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            String optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            String optString5 = jSONObject.optString("debug_dialog", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString6 = jSONObject.optString("orientation", null);
            int i = -1;
            if ("portrait".equals(optString6)) {
                i = eo.bS();
            } else if ("landscape".equals(optString6)) {
                i = eo.bR();
            }
            if (TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString2)) {
                    eu.D("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new du(0);
                }
                du a = dx.a(context, dsVar.kQ.sw, optString2, null, null);
                optString = a.oA;
                optString4 = a.qe;
                j = a.qk;
                duVar = a;
            } else if (TextUtils.isEmpty(optString)) {
                eu.D("Could not parse the mediation config: Missing required ad_base_url field");
                return new du(0);
            } else {
                duVar = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = duVar == null ? null : duVar.nt;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    list4.add(optJSONArray.getString(i2));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = duVar == null ? null : duVar.nu;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    list4.add(optJSONArray2.getString(i3));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = duVar == null ? null : duVar.qi;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    list4.add(optJSONArray3.getString(i4));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (duVar != null) {
                if (duVar.orientation != -1) {
                    i = duVar.orientation;
                }
                if (duVar.qf > 0) {
                    j2 = duVar.qf;
                }
            }
            String optString7 = jSONObject.optString("active_view");
            String str2 = null;
            boolean optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str2 = jSONObject.optString("ad_passback_url", null);
            }
            return new du(optString, optString4, list, list2, j2, false, -1, list3, -1, i, optString3, j, optString5, optBoolean, str2, optString7);
        } catch (JSONException e) {
            eu.D("Could not parse the mediation config: " + e.getMessage());
            return new du(0);
        }
    }

    public static String a(ds dsVar, ec ecVar, Location location, String str) {
        try {
            Map hashMap = new HashMap();
            if (!(str == null || str.trim() == "")) {
                hashMap.put("eid", str);
            }
            if (dsVar.pW != null) {
                hashMap.put("ad_pos", dsVar.pW);
            }
            a((HashMap) hashMap, dsVar.pX);
            hashMap.put("format", dsVar.kT.me);
            if (dsVar.kT.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (dsVar.kT.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (dsVar.kT.mg != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (al alVar : dsVar.kT.mg) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(alVar.width == -1 ? (int) (((float) alVar.widthPixels) / ecVar.rr) : alVar.width);
                    stringBuilder.append("x");
                    stringBuilder.append(alVar.height == -2 ? (int) (((float) alVar.heightPixels) / ecVar.rr) : alVar.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            hashMap.put("slotname", dsVar.kN);
            hashMap.put("pn", dsVar.applicationInfo.packageName);
            if (dsVar.pY != null) {
                hashMap.put("vc", Integer.valueOf(dsVar.pY.versionCode));
            }
            hashMap.put("ms", dsVar.pZ);
            hashMap.put("ms2", dsVar.qd);
            hashMap.put("seq_num", dsVar.qa);
            hashMap.put("session_id", dsVar.qb);
            hashMap.put("js", dsVar.kQ.sw);
            a((HashMap) hashMap, ecVar);
            if (dsVar.pX.versionCode >= 2 && dsVar.pX.ma != null) {
                a((HashMap) hashMap, dsVar.pX.ma);
            }
            if (dsVar.versionCode >= 2) {
                hashMap.put("quality_signals", dsVar.qc);
            }
            if (eu.p(2)) {
                eu.C("Ad Request JSON: " + eo.o(hashMap).toString(2));
            }
            return eo.o(hashMap).toString();
        } catch (JSONException e) {
            eu.D("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    private static void a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void a(HashMap<String, Object> hashMap, ai aiVar) {
        String bP = el.bP();
        if (bP != null) {
            hashMap.put("abf", bP);
        }
        if (aiVar.lS != -1) {
            hashMap.put("cust_age", qA.format(new Date(aiVar.lS)));
        }
        if (aiVar.extras != null) {
            hashMap.put("extras", aiVar.extras);
        }
        if (aiVar.lT != -1) {
            hashMap.put("cust_gender", Integer.valueOf(aiVar.lT));
        }
        if (aiVar.lU != null) {
            hashMap.put("kw", aiVar.lU);
        }
        if (aiVar.lW != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(aiVar.lW));
        }
        if (aiVar.lV) {
            hashMap.put("adtest", "on");
        }
        if (aiVar.versionCode >= 2) {
            if (aiVar.lX) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(aiVar.lY)) {
                hashMap.put("ppid", aiVar.lY);
            }
            if (aiVar.lZ != null) {
                a((HashMap) hashMap, aiVar.lZ);
            }
        }
        if (aiVar.versionCode >= 3 && aiVar.mb != null) {
            hashMap.put("url", aiVar.mb);
        }
    }

    private static void a(HashMap<String, Object> hashMap, aw awVar) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(awVar.mD) != 0) {
            hashMap.put("acolor", o(awVar.mD));
        }
        if (Color.alpha(awVar.backgroundColor) != 0) {
            hashMap.put("bgcolor", o(awVar.backgroundColor));
        }
        if (!(Color.alpha(awVar.mE) == 0 || Color.alpha(awVar.mF) == 0)) {
            hashMap.put("gradientto", o(awVar.mE));
            hashMap.put("gradientfrom", o(awVar.mF));
        }
        if (Color.alpha(awVar.mG) != 0) {
            hashMap.put("bcolor", o(awVar.mG));
        }
        hashMap.put("bthick", Integer.toString(awVar.mH));
        switch (awVar.mI) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (awVar.mJ) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (awVar.mK != null) {
            hashMap.put("channel", awVar.mK);
        }
        if (Color.alpha(awVar.mL) != 0) {
            hashMap.put("dcolor", o(awVar.mL));
        }
        if (awVar.mM != null) {
            hashMap.put("font", awVar.mM);
        }
        if (Color.alpha(awVar.mN) != 0) {
            hashMap.put("hcolor", o(awVar.mN));
        }
        hashMap.put("headersize", Integer.toString(awVar.mO));
        if (awVar.mP != null) {
            hashMap.put("q", awVar.mP);
        }
    }

    private static void a(HashMap<String, Object> hashMap, ec ecVar) {
        hashMap.put("am", Integer.valueOf(ecVar.rb));
        hashMap.put("cog", m(ecVar.rc));
        hashMap.put("coh", m(ecVar.rd));
        if (!TextUtils.isEmpty(ecVar.re)) {
            hashMap.put("carrier", ecVar.re);
        }
        hashMap.put("gl", ecVar.rf);
        if (ecVar.rg) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", m(ecVar.rh));
        hashMap.put("sp", m(ecVar.ri));
        hashMap.put("hl", ecVar.rj);
        if (!TextUtils.isEmpty(ecVar.rk)) {
            hashMap.put("mv", ecVar.rk);
        }
        hashMap.put("muv", Integer.valueOf(ecVar.rl));
        if (ecVar.rm != -2) {
            hashMap.put("cnt", Integer.valueOf(ecVar.rm));
        }
        hashMap.put("gnt", Integer.valueOf(ecVar.rn));
        hashMap.put("pt", Integer.valueOf(ecVar.ro));
        hashMap.put("rm", Integer.valueOf(ecVar.rp));
        hashMap.put("riv", Integer.valueOf(ecVar.rq));
        hashMap.put("u_sd", Float.valueOf(ecVar.rr));
        hashMap.put("sh", Integer.valueOf(ecVar.rt));
        hashMap.put("sw", Integer.valueOf(ecVar.rs));
        Bundle bundle = new Bundle();
        bundle.putInt("active_network_state", ecVar.rx);
        bundle.putBoolean("active_network_metered", ecVar.rw);
        hashMap.put("connectivity", bundle);
        bundle = new Bundle();
        bundle.putBoolean("is_charging", ecVar.rv);
        bundle.putDouble("battery_level", ecVar.ru);
        hashMap.put("battery", bundle);
    }

    private static Integer m(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String o(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }
}
