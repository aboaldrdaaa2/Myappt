package lip.com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.ip;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject AA;
    private int BA;
    private int BB;
    private float Bs;
    private int Bt;
    private int Bu;
    private int Bv;
    private int Bw;
    private int Bx;
    private int By;
    private String Bz;
    private int td;

    public TextTrackStyle() {
        clear();
    }

    private int ah(String str) {
        int i = 0;
        if (str == null || str.length() != 9 || str.charAt(i) != '#') {
            return i;
        }
        try {
            return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
        } catch (NumberFormatException e) {
            return i;
        }
    }

    private void clear() {
        this.Bs = 1.0f;
        this.Bt = 0;
        this.td = 0;
        this.Bu = -1;
        this.Bv = 0;
        this.Bw = -1;
        this.Bx = 0;
        this.By = 0;
        this.Bz = null;
        this.BA = -1;
        this.BB = -1;
        this.AA = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!ip.gi()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(0);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private String o(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    public void b(JSONObject jSONObject) throws JSONException {
        String string;
        clear();
        this.Bs = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.Bt = ah(jSONObject.optString("foregroundColor"));
        this.td = ah(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.Bu = 0;
            } else if ("OUTLINE".equals(string)) {
                this.Bu = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.Bu = 2;
            } else if ("RAISED".equals(string)) {
                this.Bu = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.Bu = 4;
            }
        }
        this.Bv = ah(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.Bw = 0;
            } else if ("NORMAL".equals(string)) {
                this.Bw = 1;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.Bw = 2;
            }
        }
        this.Bx = ah(jSONObject.optString("windowColor"));
        if (this.Bw == 2) {
            this.By = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.Bz = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.BA = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.BA = 1;
            } else if ("SERIF".equals(string)) {
                this.BA = 2;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.BA = 3;
            } else if ("CASUAL".equals(string)) {
                this.BA = 4;
            } else if ("CURSIVE".equals(string)) {
                this.BA = 5;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.BA = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.BB = 0;
            } else if ("BOLD".equals(string)) {
                this.BB = 1;
            } else if ("ITALIC".equals(string)) {
                this.BB = 2;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.BB = 3;
            }
        }
        this.AA = jSONObject.optJSONObject("customData");
    }

    public JSONObject dZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.Bs);
            if (this.Bt != 0) {
                jSONObject.put("foregroundColor", o(this.Bt));
            }
            if (this.td != 0) {
                jSONObject.put("backgroundColor", o(this.td));
            }
            switch (this.Bu) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.Bv != 0) {
                jSONObject.put("edgeColor", o(this.Bv));
            }
            switch (this.Bw) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.Bx != 0) {
                jSONObject.put("windowColor", o(this.Bx));
            }
            if (this.Bw == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.By);
            }
            if (this.Bz != null) {
                jSONObject.put("fontFamily", this.Bz);
            }
            switch (this.BA) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.BB) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.AA != null) {
                jSONObject.put("customData", this.AA);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.AA == null) != (textTrackStyle.AA == null)) {
            return false;
        }
        if (this.AA != null && textTrackStyle.AA != null && !in.d(this.AA, textTrackStyle.AA)) {
            return false;
        }
        if (!(this.Bs == textTrackStyle.Bs && this.Bt == textTrackStyle.Bt && this.td == textTrackStyle.td && this.Bu == textTrackStyle.Bu && this.Bv == textTrackStyle.Bv && this.Bw == textTrackStyle.Bw && this.By == textTrackStyle.By && gi.a(this.Bz, textTrackStyle.Bz) && this.BA == textTrackStyle.BA && this.BB == textTrackStyle.BB)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.td;
    }

    public JSONObject getCustomData() {
        return this.AA;
    }

    public int getEdgeColor() {
        return this.Bv;
    }

    public int getEdgeType() {
        return this.Bu;
    }

    public String getFontFamily() {
        return this.Bz;
    }

    public int getFontGenericFamily() {
        return this.BA;
    }

    public float getFontScale() {
        return this.Bs;
    }

    public int getFontStyle() {
        return this.BB;
    }

    public int getForegroundColor() {
        return this.Bt;
    }

    public int getWindowColor() {
        return this.Bx;
    }

    public int getWindowCornerRadius() {
        return this.By;
    }

    public int getWindowType() {
        return this.Bw;
    }

    public int hashCode() {
        return hk.hashCode(Float.valueOf(this.Bs), Integer.valueOf(this.Bt), Integer.valueOf(this.td), Integer.valueOf(this.Bu), Integer.valueOf(this.Bv), Integer.valueOf(this.Bw), Integer.valueOf(this.Bx), Integer.valueOf(this.By), this.Bz, Integer.valueOf(this.BA), Integer.valueOf(this.BB), this.AA);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.td = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.AA = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.Bv = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.Bu = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.Bz = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.BA = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.Bs = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.BB = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.Bt = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.Bx = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.By = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.Bw = windowType;
    }
}
