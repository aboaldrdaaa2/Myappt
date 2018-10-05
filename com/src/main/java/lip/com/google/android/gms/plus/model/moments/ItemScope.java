package lip.com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.kn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {
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
        private final Set<Integer> acs = new HashSet();
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

        public ItemScope build() {
            return new kn(this.acs, this.act, this.acu, this.acv, this.acw, this.acx, this.acy, this.acz, this.acA, this.acB, this.acC, this.acD, this.acE, this.acF, this.acG, this.acH, this.acI, this.mk, this.acJ, this.acK, this.acL, this.acM, this.Mp, this.acN, this.acO, this.acP, this.acQ, this.acR, this.acS, this.acT, this.acU, this.xG, this.acV, this.acW, this.Vd, this.acX, this.Ve, this.mName, this.acY, this.acZ, this.ada, this.adb, this.adc, this.add, this.ade, this.adf, this.adg, this.adh, this.adi, this.adj, this.adk, this.qX, this.qY, this.adl, this.adm);
        }

        public Builder setAbout(ItemScope about) {
            this.act = (kn) about;
            this.acs.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.acu = additionalName;
            this.acs.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.acv = (kn) address;
            this.acs.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.acw = addressCountry;
            this.acs.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.acx = addressLocality;
            this.acs.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.acy = addressRegion;
            this.acs.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.acz = associated_media;
            this.acs.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.acA = attendeeCount;
            this.acs.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.acB = attendees;
            this.acs.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.acC = (kn) audio;
            this.acs.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.acD = author;
            this.acs.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.acE = bestRating;
            this.acs.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.acF = birthDate;
            this.acs.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.acG = (kn) byArtist;
            this.acs.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String caption) {
            this.acH = caption;
            this.acs.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.acI = contentSize;
            this.acs.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.mk = contentUrl;
            this.acs.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.acJ = contributor;
            this.acs.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.acK = dateCreated;
            this.acs.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.acL = dateModified;
            this.acs.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.acM = datePublished;
            this.acs.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String description) {
            this.Mp = description;
            this.acs.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String duration) {
            this.acN = duration;
            this.acs.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.acO = embedUrl;
            this.acs.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.acP = endDate;
            this.acs.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.acQ = familyName;
            this.acs.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String gender) {
            this.acR = gender;
            this.acs.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.acS = (kn) geo;
            this.acs.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.acT = givenName;
            this.acs.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String height) {
            this.acU = height;
            this.acs.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String id) {
            this.xG = id;
            this.acs.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String image) {
            this.acV = image;
            this.acs.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.acW = (kn) inAlbum;
            this.acs.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.Vd = latitude;
            this.acs.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.acX = (kn) location;
            this.acs.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.Ve = longitude;
            this.acs.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.acs.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.acY = (kn) partOfTVSeries;
            this.acs.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.acZ = performers;
            this.acs.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.ada = playerType;
            this.acs.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.adb = postOfficeBoxNumber;
            this.acs.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.adc = postalCode;
            this.acs.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.add = ratingValue;
            this.acs.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.ade = (kn) reviewRating;
            this.acs.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.adf = startDate;
            this.acs.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.adg = streetAddress;
            this.acs.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String text) {
            this.adh = text;
            this.acs.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.adi = (kn) thumbnail;
            this.acs.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.adj = thumbnailUrl;
            this.acs.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.adk = tickerSymbol;
            this.acs.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String type) {
            this.qX = type;
            this.acs.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String url) {
            this.qY = url;
            this.acs.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String width) {
            this.adl = width;
            this.acs.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.adm = worstRating;
            this.acs.add(Integer.valueOf(56));
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
