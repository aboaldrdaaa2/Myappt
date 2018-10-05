package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.hy.a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class kn extends hy implements SafeParcelable, ItemScope {
    public static final ko CREATOR = new ko();
    private static final HashMap<String, a<?, ?>> acr = new HashMap();
    private String Mp;
    private double Vd;
    private double Ve;
    private int acA;
    private List<kn> acB;
    private kn acC;
    private List<kn> acD;
    private String acE;
    private String acF;
    private kn acG;
    private String acH;
    private String acI;
    private List<kn> acJ;
    private String acK;
    private String acL;
    private String acM;
    private String acN;
    private String acO;
    private String acP;
    private String acQ;
    private String acR;
    private kn acS;
    private String acT;
    private String acU;
    private String acV;
    private kn acW;
    private kn acX;
    private kn acY;
    private List<kn> acZ;
    private final Set<Integer> acs;
    private kn act;
    private List<String> acu;
    private kn acv;
    private String acw;
    private String acx;
    private String acy;
    private List<kn> acz;
    private String ada;
    private String adb;
    private String adc;
    private String add;
    private kn ade;
    private String adf;
    private String adg;
    private String adh;
    private kn adi;
    private String adj;
    private String adk;
    private String adl;
    private String adm;
    private String mName;
    private String mk;
    private String qX;
    private String qY;
    private String xG;
    private final int xM;

    static {
        acr.put("about", a.a("about", 2, kn.class));
        acr.put("additionalName", a.k("additionalName", 3));
        acr.put("address", a.a("address", 4, kn.class));
        acr.put("addressCountry", a.j("addressCountry", 5));
        acr.put("addressLocality", a.j("addressLocality", 6));
        acr.put("addressRegion", a.j("addressRegion", 7));
        acr.put("associated_media", a.b("associated_media", 8, kn.class));
        acr.put("attendeeCount", a.g("attendeeCount", 9));
        acr.put("attendees", a.b("attendees", 10, kn.class));
        acr.put("audio", a.a("audio", 11, kn.class));
        acr.put("author", a.b("author", 12, kn.class));
        acr.put("bestRating", a.j("bestRating", 13));
        acr.put("birthDate", a.j("birthDate", 14));
        acr.put("byArtist", a.a("byArtist", 15, kn.class));
        acr.put("caption", a.j("caption", 16));
        acr.put("contentSize", a.j("contentSize", 17));
        acr.put("contentUrl", a.j("contentUrl", 18));
        acr.put("contributor", a.b("contributor", 19, kn.class));
        acr.put("dateCreated", a.j("dateCreated", 20));
        acr.put("dateModified", a.j("dateModified", 21));
        acr.put("datePublished", a.j("datePublished", 22));
        acr.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, a.j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        acr.put("duration", a.j("duration", 24));
        acr.put("embedUrl", a.j("embedUrl", 25));
        acr.put("endDate", a.j("endDate", 26));
        acr.put("familyName", a.j("familyName", 27));
        acr.put(MMRequest.KEY_GENDER, a.j(MMRequest.KEY_GENDER, 28));
        acr.put(Event.INTENT_MAPS, a.a(Event.INTENT_MAPS, 29, kn.class));
        acr.put("givenName", a.j("givenName", 30));
        acr.put(MMLayout.KEY_HEIGHT, a.j(MMLayout.KEY_HEIGHT, 31));
        acr.put("id", a.j("id", 32));
        acr.put("image", a.j("image", 33));
        acr.put("inAlbum", a.a("inAlbum", 34, kn.class));
        acr.put("latitude", a.h("latitude", 36));
        acr.put("location", a.a("location", 37, kn.class));
        acr.put("longitude", a.h("longitude", 38));
        acr.put("name", a.j("name", 39));
        acr.put("partOfTVSeries", a.a("partOfTVSeries", 40, kn.class));
        acr.put("performers", a.b("performers", 41, kn.class));
        acr.put("playerType", a.j("playerType", 42));
        acr.put("postOfficeBoxNumber", a.j("postOfficeBoxNumber", 43));
        acr.put("postalCode", a.j("postalCode", 44));
        acr.put("ratingValue", a.j("ratingValue", 45));
        acr.put("reviewRating", a.a("reviewRating", 46, kn.class));
        acr.put("startDate", a.j("startDate", 47));
        acr.put("streetAddress", a.j("streetAddress", 48));
        acr.put("text", a.j("text", 49));
        acr.put("thumbnail", a.a("thumbnail", 50, kn.class));
        acr.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, a.j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        acr.put("tickerSymbol", a.j("tickerSymbol", 52));
        acr.put("type", a.j("type", 53));
        acr.put("url", a.j("url", 54));
        acr.put(MMLayout.KEY_WIDTH, a.j(MMLayout.KEY_WIDTH, 55));
        acr.put("worstRating", a.j("worstRating", 56));
    }

    public kn() {
        this.xM = 1;
        this.acs = new HashSet();
    }

    kn(Set<Integer> set, int i, kn knVar, List<String> list, kn knVar2, String str, String str2, String str3, List<kn> list2, int i2, List<kn> list3, kn knVar3, List<kn> list4, String str4, String str5, kn knVar4, String str6, String str7, String str8, List<kn> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, kn knVar5, String str18, String str19, String str20, String str21, kn knVar6, double d, kn knVar7, double d2, String str22, kn knVar8, List<kn> list6, String str23, String str24, String str25, String str26, kn knVar9, String str27, String str28, String str29, kn knVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.acs = set;
        this.xM = i;
        this.act = knVar;
        this.acu = list;
        this.acv = knVar2;
        this.acw = str;
        this.acx = str2;
        this.acy = str3;
        this.acz = list2;
        this.acA = i2;
        this.acB = list3;
        this.acC = knVar3;
        this.acD = list4;
        this.acE = str4;
        this.acF = str5;
        this.acG = knVar4;
        this.acH = str6;
        this.acI = str7;
        this.mk = str8;
        this.acJ = list5;
        this.acK = str9;
        this.acL = str10;
        this.acM = str11;
        this.Mp = str12;
        this.acN = str13;
        this.acO = str14;
        this.acP = str15;
        this.acQ = str16;
        this.acR = str17;
        this.acS = knVar5;
        this.acT = str18;
        this.acU = str19;
        this.xG = str20;
        this.acV = str21;
        this.acW = knVar6;
        this.Vd = d;
        this.acX = knVar7;
        this.Ve = d2;
        this.mName = str22;
        this.acY = knVar8;
        this.acZ = list6;
        this.ada = str23;
        this.adb = str24;
        this.adc = str25;
        this.add = str26;
        this.ade = knVar9;
        this.adf = str27;
        this.adg = str28;
        this.adh = str29;
        this.adi = knVar10;
        this.adj = str30;
        this.adk = str31;
        this.qX = str32;
        this.qY = str33;
        this.adl = str34;
        this.adm = str35;
    }

    public kn(Set<Integer> set, kn knVar, List<String> list, kn knVar2, String str, String str2, String str3, List<kn> list2, int i, List<kn> list3, kn knVar3, List<kn> list4, String str4, String str5, kn knVar4, String str6, String str7, String str8, List<kn> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, kn knVar5, String str18, String str19, String str20, String str21, kn knVar6, double d, kn knVar7, double d2, String str22, kn knVar8, List<kn> list6, String str23, String str24, String str25, String str26, kn knVar9, String str27, String str28, String str29, kn knVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.acs = set;
        this.xM = 1;
        this.act = knVar;
        this.acu = list;
        this.acv = knVar2;
        this.acw = str;
        this.acx = str2;
        this.acy = str3;
        this.acz = list2;
        this.acA = i;
        this.acB = list3;
        this.acC = knVar3;
        this.acD = list4;
        this.acE = str4;
        this.acF = str5;
        this.acG = knVar4;
        this.acH = str6;
        this.acI = str7;
        this.mk = str8;
        this.acJ = list5;
        this.acK = str9;
        this.acL = str10;
        this.acM = str11;
        this.Mp = str12;
        this.acN = str13;
        this.acO = str14;
        this.acP = str15;
        this.acQ = str16;
        this.acR = str17;
        this.acS = knVar5;
        this.acT = str18;
        this.acU = str19;
        this.xG = str20;
        this.acV = str21;
        this.acW = knVar6;
        this.Vd = d;
        this.acX = knVar7;
        this.Ve = d2;
        this.mName = str22;
        this.acY = knVar8;
        this.acZ = list6;
        this.ada = str23;
        this.adb = str24;
        this.adc = str25;
        this.add = str26;
        this.ade = knVar9;
        this.adf = str27;
        this.adg = str28;
        this.adh = str29;
        this.adi = knVar10;
        this.adj = str30;
        this.adk = str31;
        this.qX = str32;
        this.qY = str33;
        this.adl = str34;
        this.adm = str35;
    }

    protected boolean a(a aVar) {
        return this.acs.contains(Integer.valueOf(aVar.fN()));
    }

    protected Object aF(String str) {
        return null;
    }

    protected boolean aG(String str) {
        return false;
    }

    protected Object b(a aVar) {
        switch (aVar.fN()) {
            case 2:
                return this.act;
            case 3:
                return this.acu;
            case 4:
                return this.acv;
            case 5:
                return this.acw;
            case 6:
                return this.acx;
            case 7:
                return this.acy;
            case 8:
                return this.acz;
            case 9:
                return Integer.valueOf(this.acA);
            case 10:
                return this.acB;
            case 11:
                return this.acC;
            case 12:
                return this.acD;
            case 13:
                return this.acE;
            case 14:
                return this.acF;
            case 15:
                return this.acG;
            case 16:
                return this.acH;
            case 17:
                return this.acI;
            case 18:
                return this.mk;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.acJ;
            case MMException.DISPLAY_AD_NOT_READY /*20*/:
                return this.acK;
            case MMException.DISPLAY_AD_EXPIRED /*21*/:
                return this.acL;
            case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                return this.acM;
            case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                return this.Mp;
            case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                return this.acN;
            case MMException.AD_BROKEN_REFERENCE /*25*/:
                return this.acO;
            case MMException.AD_NO_ACTIVITY /*26*/:
                return this.acP;
            case 27:
                return this.acQ;
            case 28:
                return this.acR;
            case 29:
                return this.acS;
            case 30:
                return this.acT;
            case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                return this.acU;
            case 32:
                return this.xG;
            case 33:
                return this.acV;
            case 34:
                return this.acW;
            case 36:
                return Double.valueOf(this.Vd);
            case 37:
                return this.acX;
            case 38:
                return Double.valueOf(this.Ve);
            case 39:
                return this.mName;
            case 40:
                return this.acY;
            case 41:
                return this.acZ;
            case 42:
                return this.ada;
            case 43:
                return this.adb;
            case 44:
                return this.adc;
            case 45:
                return this.add;
            case 46:
                return this.ade;
            case 47:
                return this.adf;
            case 48:
                return this.adg;
            case 49:
                return this.adh;
            case 50:
                return this.adi;
            case 51:
                return this.adj;
            case 52:
                return this.adk;
            case 53:
                return this.qX;
            case 54:
                return this.qY;
            case 55:
                return this.adl;
            case 56:
                return this.adm;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
        }
    }

    public int describeContents() {
        ko koVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof kn)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        kn knVar = (kn) obj;
        for (a aVar : acr.values()) {
            if (a(aVar)) {
                if (!knVar.a(aVar)) {
                    return false;
                }
                if (!b(aVar).equals(knVar.b(aVar))) {
                    return false;
                }
            } else if (knVar.a(aVar)) {
                return false;
            }
        }
        return true;
    }

    public HashMap<String, a<?, ?>> fG() {
        return acr;
    }

    public ItemScope getAbout() {
        return this.act;
    }

    public List<String> getAdditionalName() {
        return this.acu;
    }

    public ItemScope getAddress() {
        return this.acv;
    }

    public String getAddressCountry() {
        return this.acw;
    }

    public String getAddressLocality() {
        return this.acx;
    }

    public String getAddressRegion() {
        return this.acy;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.acz;
    }

    public int getAttendeeCount() {
        return this.acA;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.acB;
    }

    public ItemScope getAudio() {
        return this.acC;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.acD;
    }

    public String getBestRating() {
        return this.acE;
    }

    public String getBirthDate() {
        return this.acF;
    }

    public ItemScope getByArtist() {
        return this.acG;
    }

    public String getCaption() {
        return this.acH;
    }

    public String getContentSize() {
        return this.acI;
    }

    public String getContentUrl() {
        return this.mk;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.acJ;
    }

    public String getDateCreated() {
        return this.acK;
    }

    public String getDateModified() {
        return this.acL;
    }

    public String getDatePublished() {
        return this.acM;
    }

    public String getDescription() {
        return this.Mp;
    }

    public String getDuration() {
        return this.acN;
    }

    public String getEmbedUrl() {
        return this.acO;
    }

    public String getEndDate() {
        return this.acP;
    }

    public String getFamilyName() {
        return this.acQ;
    }

    public String getGender() {
        return this.acR;
    }

    public ItemScope getGeo() {
        return this.acS;
    }

    public String getGivenName() {
        return this.acT;
    }

    public String getHeight() {
        return this.acU;
    }

    public String getId() {
        return this.xG;
    }

    public String getImage() {
        return this.acV;
    }

    public ItemScope getInAlbum() {
        return this.acW;
    }

    public double getLatitude() {
        return this.Vd;
    }

    public ItemScope getLocation() {
        return this.acX;
    }

    public double getLongitude() {
        return this.Ve;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.acY;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.acZ;
    }

    public String getPlayerType() {
        return this.ada;
    }

    public String getPostOfficeBoxNumber() {
        return this.adb;
    }

    public String getPostalCode() {
        return this.adc;
    }

    public String getRatingValue() {
        return this.add;
    }

    public ItemScope getReviewRating() {
        return this.ade;
    }

    public String getStartDate() {
        return this.adf;
    }

    public String getStreetAddress() {
        return this.adg;
    }

    public String getText() {
        return this.adh;
    }

    public ItemScope getThumbnail() {
        return this.adi;
    }

    public String getThumbnailUrl() {
        return this.adj;
    }

    public String getTickerSymbol() {
        return this.adk;
    }

    public String getType() {
        return this.qX;
    }

    public String getUrl() {
        return this.qY;
    }

    int getVersionCode() {
        return this.xM;
    }

    public String getWidth() {
        return this.adl;
    }

    public String getWorstRating() {
        return this.adm;
    }

    public boolean hasAbout() {
        return this.acs.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.acs.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.acs.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.acs.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.acs.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.acs.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.acs.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.acs.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.acs.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.acs.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.acs.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.acs.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.acs.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.acs.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.acs.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.acs.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.acs.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.acs.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.acs.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.acs.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.acs.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.acs.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.acs.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.acs.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.acs.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.acs.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.acs.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.acs.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.acs.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.acs.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.acs.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.acs.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.acs.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.acs.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.acs.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.acs.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.acs.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.acs.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.acs.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.acs.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.acs.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.acs.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.acs.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.acs.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.acs.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.acs.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.acs.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.acs.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.acs.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.acs.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.acs.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.acs.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.acs.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.acs.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        Iterator it = acr.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            a aVar = (a) it.next();
            if (a(aVar)) {
                i = b(aVar).hashCode() + (i2 + aVar.fN());
            } else {
                i = i2;
            }
        }
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: kA */
    public kn freeze() {
        return this;
    }

    Set<Integer> kk() {
        return this.acs;
    }

    kn kl() {
        return this.act;
    }

    kn km() {
        return this.acv;
    }

    List<kn> kn() {
        return this.acz;
    }

    List<kn> ko() {
        return this.acB;
    }

    kn kp() {
        return this.acC;
    }

    List<kn> kq() {
        return this.acD;
    }

    kn kr() {
        return this.acG;
    }

    List<kn> ks() {
        return this.acJ;
    }

    kn kt() {
        return this.acS;
    }

    kn ku() {
        return this.acW;
    }

    kn kv() {
        return this.acX;
    }

    kn kw() {
        return this.acY;
    }

    List<kn> kx() {
        return this.acZ;
    }

    kn ky() {
        return this.ade;
    }

    kn kz() {
        return this.adi;
    }

    public void writeToParcel(Parcel out, int flags) {
        ko koVar = CREATOR;
        ko.a(this, out, flags);
    }
}
