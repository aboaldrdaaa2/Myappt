package lip.com.millennialmedia.android;

import java.text.SimpleDateFormat;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeMMCalendar extends MMJSObject {
    private static final String ADD_EVENT = "addEvent";
    private static final String TAG = BridgeMMCalendar.class.getName();
    private static final String[] mraidCreateCalendarEventDateFormats = new String[]{"yyyy-MM-dd'T'HH:mmZZZ", "yyyy-MM-dd'T'HH:mm:ssZZZ"};
    private static final SimpleDateFormat rruleUntilDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

    BridgeMMCalendar() {
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:0x00f9, code:
            com.millennialmedia.android.MMLog.e(TAG, "Unable to parse calendar addEvent parameters");
     */
    /* JADX WARNING: Missing block: B:82:?, code:
            return com.millennialmedia.android.MMJSResponse.responseWithError("Calendar Event Creation Failed.  Invalid parameters");
     */
    @android.annotation.TargetApi(14)
    public com.millennialmedia.android.MMJSResponse addEvent(Map<String, String> r24) {
        /*
        r23 = this;
        r19 = TAG;
        r20 = new java.lang.StringBuilder;
        r20.<init>();
        r21 = "addEvent parameters: ";
        r20 = r20.append(r21);
        r0 = r20;
        r1 = r24;
        r20 = r0.append(r1);
        r20 = r20.toString();
        com.millennialmedia.android.MMLog.d(r19, r20);
        r19 = android.os.Build.VERSION.SDK_INT;
        r20 = 14;
        r0 = r19;
        r1 = r20;
        if (r0 < r1) goto L_0x020f;
    L_0x0026:
        if (r24 == 0) goto L_0x020b;
    L_0x0028:
        r19 = "parameters";
        r0 = r24;
        r1 = r19;
        r19 = r0.get(r1);
        if (r19 == 0) goto L_0x020b;
    L_0x0034:
        r6 = 0;
        r11 = 0;
        r15 = 0;
        r8 = 0;
        r17 = 0;
        r16 = 0;
        r14 = 0;
        r13 = 0;
        r18 = 0;
        r10 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00f8 }
        r19 = "parameters";
        r0 = r24;
        r1 = r19;
        r19 = r0.get(r1);	 Catch:{ JSONException -> 0x00f8 }
        r19 = (java.lang.String) r19;	 Catch:{ JSONException -> 0x00f8 }
        r0 = r19;
        r10.<init>(r0);	 Catch:{ JSONException -> 0x00f8 }
        r19 = "description";
        r0 = r19;
        r17 = r10.getString(r0);	 Catch:{ JSONException -> 0x00ee }
    L_0x005b:
        r19 = "summary";
        r0 = r19;
        r6 = r10.getString(r0);	 Catch:{ JSONException -> 0x0107 }
    L_0x0063:
        r19 = "transparency";
        r0 = r19;
        r18 = r10.getString(r0);	 Catch:{ JSONException -> 0x0111 }
    L_0x006b:
        r19 = "reminder";
        r0 = r19;
        r14 = r10.getString(r0);	 Catch:{ JSONException -> 0x011b }
    L_0x0073:
        r19 = "location";
        r0 = r19;
        r11 = r10.getString(r0);	 Catch:{ JSONException -> 0x0125 }
    L_0x007b:
        r19 = "status";
        r0 = r19;
        r16 = r10.getString(r0);	 Catch:{ JSONException -> 0x012f }
    L_0x0083:
        r19 = "recurrence";
        r0 = r19;
        r12 = r10.getJSONObject(r0);	 Catch:{ JSONException -> 0x0139 }
        r0 = r23;
        r13 = r0.convertRecurrence(r12);	 Catch:{ JSONException -> 0x0139 }
    L_0x0091:
        r19 = "start";
        r0 = r19;
        r19 = r10.getString(r0);	 Catch:{ DateParseException -> 0x0143, JSONException -> 0x014d }
        r20 = mraidCreateCalendarEventDateFormats;	 Catch:{ DateParseException -> 0x0143, JSONException -> 0x014d }
        r15 = org.apache.http.impl.cookie.DateUtils.parseDate(r19, r20);	 Catch:{ DateParseException -> 0x0143, JSONException -> 0x014d }
    L_0x009f:
        r19 = "end";
        r0 = r19;
        r19 = r10.getString(r0);	 Catch:{ DateParseException -> 0x0157, JSONException -> 0x0161 }
        r20 = mraidCreateCalendarEventDateFormats;	 Catch:{ DateParseException -> 0x0157, JSONException -> 0x0161 }
        r8 = org.apache.http.impl.cookie.DateUtils.parseDate(r19, r20);	 Catch:{ DateParseException -> 0x0157, JSONException -> 0x0161 }
    L_0x00ad:
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Creating calendar event: title: %s, location: %s, start: %s, end: %s, status: %s, summary: %s, rrule: %s";
        r21 = 7;
        r0 = r21;
        r0 = new java.lang.Object[r0];	 Catch:{ JSONException -> 0x00f8 }
        r21 = r0;
        r22 = 0;
        r21[r22] = r17;	 Catch:{ JSONException -> 0x00f8 }
        r22 = 1;
        r21[r22] = r11;	 Catch:{ JSONException -> 0x00f8 }
        r22 = 2;
        r21[r22] = r15;	 Catch:{ JSONException -> 0x00f8 }
        r22 = 3;
        r21[r22] = r8;	 Catch:{ JSONException -> 0x00f8 }
        r22 = 4;
        r21[r22] = r16;	 Catch:{ JSONException -> 0x00f8 }
        r22 = 5;
        r21[r22] = r6;	 Catch:{ JSONException -> 0x00f8 }
        r22 = 6;
        r21[r22] = r13;	 Catch:{ JSONException -> 0x00f8 }
        r20 = java.lang.String.format(r20, r21);	 Catch:{ JSONException -> 0x00f8 }
        com.millennialmedia.android.MMLog.d(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        if (r17 == 0) goto L_0x00e0;
    L_0x00de:
        if (r15 != 0) goto L_0x016b;
    L_0x00e0:
        r19 = TAG;
        r20 = "Description and start must be provided to create calendar event.";
        com.millennialmedia.android.MMLog.e(r19, r20);
        r19 = "Calendar Event Creation Failed.  Minimum parameters not provided";
        r19 = com.millennialmedia.android.MMJSResponse.responseWithError(r19);
    L_0x00ed:
        return r19;
    L_0x00ee:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event description";
        com.millennialmedia.android.MMLog.e(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x005b;
    L_0x00f8:
        r7 = move-exception;
        r19 = TAG;
        r20 = "Unable to parse calendar addEvent parameters";
        com.millennialmedia.android.MMLog.e(r19, r20);
        r19 = "Calendar Event Creation Failed.  Invalid parameters";
        r19 = com.millennialmedia.android.MMJSResponse.responseWithError(r19);
        goto L_0x00ed;
    L_0x0107:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event description";
        com.millennialmedia.android.MMLog.d(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x0063;
    L_0x0111:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event transparency";
        com.millennialmedia.android.MMLog.d(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x006b;
    L_0x011b:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event reminder";
        com.millennialmedia.android.MMLog.d(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x0073;
    L_0x0125:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event location";
        com.millennialmedia.android.MMLog.d(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x007b;
    L_0x012f:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event status";
        com.millennialmedia.android.MMLog.d(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x0083;
    L_0x0139:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event recurrence";
        com.millennialmedia.android.MMLog.d(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x0091;
    L_0x0143:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Error parsing calendar event start date";
        com.millennialmedia.android.MMLog.e(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x009f;
    L_0x014d:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event start date";
        com.millennialmedia.android.MMLog.e(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x009f;
    L_0x0157:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Error parsing calendar event end date";
        com.millennialmedia.android.MMLog.e(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x00ad;
    L_0x0161:
        r7 = move-exception;
        r19 = TAG;	 Catch:{ JSONException -> 0x00f8 }
        r20 = "Unable to get calendar event end date";
        com.millennialmedia.android.MMLog.d(r19, r20);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x00ad;
    L_0x016b:
        r19 = new android.content.Intent;
        r20 = "android.intent.action.INSERT";
        r19.<init>(r20);
        r20 = android.provider.CalendarContract.Events.CONTENT_URI;
        r9 = r19.setData(r20);
        if (r15 == 0) goto L_0x0187;
    L_0x017a:
        r19 = "beginTime";
        r20 = r15.getTime();
        r0 = r19;
        r1 = r20;
        r9.putExtra(r0, r1);
    L_0x0187:
        if (r8 == 0) goto L_0x0196;
    L_0x0189:
        r19 = "endTime";
        r20 = r8.getTime();
        r0 = r19;
        r1 = r20;
        r9.putExtra(r0, r1);
    L_0x0196:
        if (r17 == 0) goto L_0x01a1;
    L_0x0198:
        r19 = "title";
        r0 = r19;
        r1 = r17;
        r9.putExtra(r0, r1);
    L_0x01a1:
        if (r6 == 0) goto L_0x01aa;
    L_0x01a3:
        r19 = "description";
        r0 = r19;
        r9.putExtra(r0, r6);
    L_0x01aa:
        if (r11 == 0) goto L_0x01b3;
    L_0x01ac:
        r19 = "eventLocation";
        r0 = r19;
        r9.putExtra(r0, r11);
    L_0x01b3:
        if (r13 == 0) goto L_0x01bc;
    L_0x01b5:
        r19 = "rrule";
        r0 = r19;
        r9.putExtra(r0, r13);
    L_0x01bc:
        if (r16 == 0) goto L_0x01c5;
    L_0x01be:
        r19 = TAG;
        r20 = "Calendar addEvent does not support status";
        com.millennialmedia.android.MMLog.w(r19, r20);
    L_0x01c5:
        if (r18 == 0) goto L_0x01ce;
    L_0x01c7:
        r19 = TAG;
        r20 = "Calendar addEvent does not support transparency";
        com.millennialmedia.android.MMLog.w(r19, r20);
    L_0x01ce:
        if (r14 == 0) goto L_0x01d7;
    L_0x01d0:
        r19 = TAG;
        r20 = "Calendar addEvent does not support reminder";
        com.millennialmedia.android.MMLog.w(r19, r20);
    L_0x01d7:
        r0 = r23;
        r0 = r0.contextRef;
        r19 = r0;
        r5 = r19.get();
        r5 = (android.content.Context) r5;
        if (r5 == 0) goto L_0x020b;
    L_0x01e5:
        com.millennialmedia.android.Utils.IntentUtils.startActivity(r5, r9);
        r19 = "PROPERTY_EXPANDING";
        r0 = r24;
        r1 = r19;
        r19 = r0.get(r1);
        r19 = (java.lang.String) r19;
        r0 = r23;
        r1 = r19;
        r3 = r0.getAdImplId(r1);
        r19 = "calendar";
        r0 = r19;
        com.millennialmedia.android.MMSDK.Event.intentStarted(r5, r0, r3);
        r19 = "Calendar Event Created";
        r19 = com.millennialmedia.android.MMJSResponse.responseWithSuccess(r19);
        goto L_0x00ed;
    L_0x020b:
        r19 = 0;
        goto L_0x00ed;
    L_0x020f:
        r19 = "Not supported";
        r19 = com.millennialmedia.android.MMJSResponse.responseWithError(r19);
        goto L_0x00ed;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.BridgeMMCalendar.addEvent(java.util.Map):com.millennialmedia.android.MMJSResponse");
    }

    private String convertRecurrence(JSONObject recurrence) {
        StringBuilder rrule = new StringBuilder();
        try {
            rrule.append("FREQ=").append(recurrence.getString("frequency")).append(";");
        } catch (JSONException e) {
            MMLog.d(TAG, "Unable to get calendar event recurrence frequency");
        }
        try {
            rrule.append("UNTIL=").append(rruleUntilDateFormat.format(DateUtils.parseDate(recurrence.getString("expires"), mraidCreateCalendarEventDateFormats))).append(";");
        } catch (DateParseException e2) {
            MMLog.e(TAG, "Error parsing calendar event recurrence expiration date");
        } catch (JSONException e3) {
            MMLog.d(TAG, "Unable to get calendar event recurrence expiration date");
        }
        try {
            JSONArray mraidDaysInWeek = recurrence.getJSONArray("daysInWeek");
            StringBuilder daysInWeek = new StringBuilder();
            for (int i = 0; i < mraidDaysInWeek.length(); i++) {
                daysInWeek.append(convertMraidDayToRRuleDay(mraidDaysInWeek.getInt(i))).append(",");
            }
            rrule.append("BYDAY=").append(daysInWeek).append(";");
        } catch (JSONException e4) {
            MMLog.d(TAG, "Unable to get days in week");
        }
        try {
            rrule.append("BYMONTHDAY=").append(recurrence.getString("daysInMonth").replaceAll("\\[", "").replaceAll("\\]", "")).append(";");
        } catch (JSONException e5) {
            MMLog.d(TAG, "Unable to get days in month");
        }
        try {
            rrule.append("BYMONTH=").append(recurrence.getString("monthsInYear:").replaceAll("\\[", "").replaceAll("\\]", "")).append(";");
        } catch (JSONException e6) {
            MMLog.d(TAG, "Unable to get months in year:");
        }
        try {
            rrule.append("BYYEARDAY=").append(recurrence.getString("daysInYear")).append(";");
        } catch (JSONException e7) {
            MMLog.d(TAG, "Unable to get days in year");
        }
        return rrule.toString().toUpperCase();
    }

    private String convertMraidDayToRRuleDay(int mraidDay) {
        switch (mraidDay) {
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            case 7:
                return "SU";
            default:
                return null;
        }
    }

    MMJSResponse executeCommand(String name, Map<String, String> arguments) {
        if (ADD_EVENT.equals(name)) {
            return addEvent(arguments);
        }
        return null;
    }
}
