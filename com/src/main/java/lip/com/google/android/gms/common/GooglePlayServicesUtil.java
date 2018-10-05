package lip.com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.he;
import com.google.android.gms.internal.ii;
import com.google.android.gms.internal.ip;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class GooglePlayServicesUtil {
    static final byte[][] CV = new byte[][]{au("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u00000t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u001e\u0017\r080821231334Z\u0017\r360107231334Z0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000«V.\u0000Ø;¢\b®\no\u0012N)Ú\u0011ò«VÐXâÌ©\u0013\u0003é·TÓrö@§\u001b\u001dË\u0013\tgbNFV§wj\u0019=²å¿·$©\u001ew\u0018\u000ejG¤;3Ù`w\u00181EÌß{.XftÉáV[\u001fLjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\u0015Jd_qhÀ±¿Æ\u0012ê¿xWi»4ªyÜ~.¢vL®\u0007ØÁqT×î_d¥\u001aD¦\u0002ÂI\u0005AWÜ\u0002Í_\\\u000eUûï\u0019ûã'ð±Q\u0016Å o\u0019ÑõÄÛÂÖ¹?hÌ)yÇ\u000e\u0018«k;ÕÛU*\u000e;LßXûíÁº5à\u0003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\u000b\u0014[j¡y\u0002\u0001\u0003£Ù0Ö0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014Ç}Â!\u0017V%Óßkãä×¥0¦\u0006\u0003U\u001d#\u00040\u0014Ç}Â!\u0017V%Óßkãä×¥¡x¤v0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android\t\u0000ÂàFdJ00\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0001\u0001\u0000mÒRÎï0,6\nªÎÏòÌ©\u0004»]z\u0016aø®F²B\u0004ÐÿJhÇí\u001aS\u001eÄYZb<æ\u0007c±g)zzãW\u0012Ä\u0007ò\bðË\u0010)\u0012M{\u0010b\u0019ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\u0005»?âËD~s\u0010v­E³?`\tê\u0019Áaæ&Aª'\u001dýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\u000b\u0010q§Ä@ðþ \u001c¶'ÊgCiÐ½/Ù\u0011ÿ\u0006Í¿,ú\u0010Ü\u000f:ãWbHÇïÆLqD\u0017B÷\u0005ÉÞW:õ[9\r×ý¹A1]_u0\u0011&ÿb\u0014\u0010Ài0"), au("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u000001\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r080415233656Z\u0017\r350901233656Z01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000ÖÎ.\b\n¿â1MÑ³ÏÓ\u0018\\´=3ú\ftá½¶ÑÛ\u0013ö,\\9ßVøF=e¾ÀóÊBk\u0007Å¨íZ9ÁgçkÉ¹'K\u000b\"\u0000\u0019©)\u0015årÅm*0\u001b£oÅü\u0011:ÖËt5¡m#«}úîáeäß\u001f\n½§\nQlN\u0005\u0011Ê|\fU\u0017[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\u0006¸Ì\u0018^±Uyîøm\b\u000b\u001daÀù¯±ÂëÑ\u0007êE«Ûh£Ç^TÇlSÔ\u000b\u0012\u001dç»Ó\u000eb\f\u0018áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\u001a¾^òÑ\u0018á¸®ó)ðf¿láD¬èm\u001c\u001b\u000f\u0002\u0001\u0003£ü0ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u001cÅ¾LC<a:\u0015°L¼\u0003òOà²0É\u0006\u0003U\u001d#\u0004Á0¾\u0014\u001cÅ¾LC<a:\u0015°L¼\u0003òOà²¡¤01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com\t\u0000Õ¸l}ÓNõ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0001\u0001\u0000\u0019Ó\fñ\u0005ûx?L\r}Ò##=@zÏÎ\u0000\b\u001d[×ÆéÖí k\u000e\u0011 \u0006Al¢D\u0013ÒkJ àõ$ÊÒ»\\nL¡\u0001j\u0015n¡ì]ÉZ^:\u0001\u00006ôHÕ\u0010¿.\u001eag:;åm¯\u000bw±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\u00199u3¯Øª\u0016\u000fBÂÐ\u0016>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\u0012þû¤Ä#ûOøÌIL\u0002ðõ\u0005\u0016\u0012ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\u00035iÞ;¿ÿ|©Ú>\u0012Cö\u000b")};
    static final byte[][] CW = new byte[][]{au("0\u0002R0\u0001»\u0002\u0004I4~0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u00000p1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u000b0\t\u0006\u0003U\u0004\b\u0013\u0002CA1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle, Inc1\u00140\u0012\u0006\u0003U\u0004\u000b\u0013\u000bGoogle, Inc1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Unknown0\u001e\u0017\r081202020758Z\u0017\r360419020758Z0p1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u000b0\t\u0006\u0003U\u0004\b\u0013\u0002CA1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle, Inc1\u00140\u0012\u0006\u0003U\u0004\u000b\u0013\u000bGoogle, Inc1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Unknown00\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u00000\u0002\u0000H\u0003\u0019ù±G&8N\u0004SÑ\u000b¿Ç{%\u0004¤± |LlDº¼\u0000­Æa\u000f¦¶«-¨\u000e3òîñk&£ö¸[úÊû¾³ôÉO~\"§àë§\\í=Ò)úseô\u0015\u0016AZ©Áa}ÕÎ\u0019ºè »Øü\u0017©´½&@Q!ªÛwÞ´\u0000\u00138\u0014\u0018.Å\"üX\r\u0002\u0003\u0001\u0000\u00010\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0000@fÖ1ÚCÝÐaÒ&às¹Ä¹øµä¾<¾P\u001eß\u001co©YÀÎ`\\OÒ¬m\u001cÎÞ Glº±èò :ÿw\u0017­e-Ì\u0007\bÑ!m¨DWY&IàéÓÄ»Lõ¡±ÔüA¼¹XOdæ_A\r\u0005)ý[h\u0014\u001d\nÑÛ\u0011Ë*\r÷ê\f±-³¤"), au("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000~OòÖµÞ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u000001\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r100120010135Z\u0017\r370607010135Z01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000Ø(q|6Ñ\u0017\u000fÔM\n{\u000f\u0007\u0011&è[¿ß3°4`\u0000ZÌûe¥Û ²Cß`±¿\u0006ß\u001d\\\n3âÑcõ\u0013ß\u001d\"SAê<3y\"è\\\u0002ì4ÎÙL¸\u0007#¦#ÿK¯û´åïæw;>¢¾¸¼²\u0002gÏçQ\u001f.ù«uþ\u001e)Ï¼M\b:\u001f\u0012R\u0000wsò\u0016[i{\u0000£ Á:Ì0ò!cÁn=J²\u00146LEÀC\u00142p9ñÚ\t`ñ³ü\u0018¶V\u0010Æ\"_Ç\u0010+|o\u0013¤]$ãàÅNgã[g\b'\u0013ÒÖðWÝ4WÑÄþÝì:O?#\u0005\u0019§\n(64¬5£J½¡}Z\n\tûø\u0006\u000b\u0003j'x`cú\f7¹çò¡\u000ev¼w\u0002\u0001\u0003£ü0ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014µÇù\u0012ox\r:ûÊess?õ\"k\u001770É\u0006\u0003U\u001d#\u0004Á0¾\u0014µÇù\u0012ox\r:ûÊess?õ\"k\u00177¡¤01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com\t\u0000~OòÖµÞ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000L>§e}&æ»×\u0011\f\u0019ß\u001f¡\t}3\u000fiÞ¿ÊÛF£~å³\u000f»4{\u001cuU¼»<T\u0014F_y*\u0002ÐÛå¦Ga³yG«kÿ°ºÆ¢Á Íøbøw©g\rýo\u0006.@nÎ\u0018\u0006\f`Iü6'\u0011qåoË¡Ræ\u0005ÎÎY\u001fÄô©+3ºØ\u0019mwoU·Ð\u001aÏ1Ý×\fì·xv\u0006e\u0010ùI¥RJ11³ËeAÏ5B\u000e¼ÄR%Y?Bfi\u0005rfbO³ÏÛR\u0017\u001d\u0011\u001cn\u0003F\u0016øQ!\u0018Ð¢¦\u0013×ðÍ\u0011ÛÕ#ZT¥JÂQçÒ,Dj?î\u0014\u0012\u0010éDGK@c\u0007»&+OkÓU\u001csQÿ¢`[\u0005â$×\u0015Øzö")};
    static final byte[][] CX = new byte[][]{au("0\u0002§0\u0002e \u0003\u0002\u0001\u0002\u0002\u0004P\u0005|B0\u000b\u0006\u0007*HÎ8\u0004\u0003\u0005\u0000071\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00160\u0014\u0006\u0003U\u0004\u0003\u0013\rAndroid Debug0\u001e\u0017\r120717145250Z\u0017\r220715145250Z071\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00160\u0014\u0006\u0003U\u0004\u0003\u0013\rAndroid Debug0\u0001·0\u0001,\u0006\u0007*HÎ8\u0004\u00010\u0001\u001f\u0002\u0000ýS\u001du\u0012)RßJ.ìäçö\u0011·R<ïD\u0000Ã\u001e?¶Q&iE]@\"QûY=Xú¿Åõº0öËUl×;\u001d4oòf`·kP¥¤è\u0004{\u0010\"ÂO»©×þ·Æ\u001bø;WçÆ¨¦\u0015\u000f\u0004ûöÓÅ\u001eÃ\u00025T\u0013Z\u00162öuó®+a×*ïò\"\u0003\u0019ÑH\u0001Ç\u0002\u0015\u0000`P\u0015#\u000bÌ²¹¢ë\u000bðX\u001cõ\u0002\u0000÷á Ö=ÞË¼«\\6¸W¹y¯»ú:êùWL\u000b=\u0007gQYWºÔYOæq\u0007\u0010´I\u0016q#èL(\u0016\u0013·Ï\t2È¦á<\u0016zT|(à£®\u001e+³¦un£\u000bú!5bñûbz\u0001$;Ì¤ñ¾¨Q¨ßáZå\u0006f^{U%d\u0001L;þÏI*\u0003\u0000\u0002jÑ\u001b×ÕfÒzô9À.Ah¬ýE´¾¼{\u001cwTi?\rB¤üá\u00108BO¦Ñ0RNïöñ78c/¦7)þMF ¸feîðA\u00179\u0001\u0003[\u001cj£\u0018\u0018\r0:¨ÌY#àjo«úuh<E;²\u0007w|òýçÏ±\u001408\u0014ª\u001d÷´=[\"+W\u0006´0\u000b\u0006\u0007*HÎ8\u0004\u0003\u0005\u0000\u0003/\u00000,\u0002\u0014\tÒÑ°G\u0002)µ¾Ò&aÑ\u0012òpÅæ\u001d\u0002\u0014gP\u0002\u0006§Pºx®Ç\u0017O\u0016\u0004ê¢÷")};
    static final byte[][] CY = new byte[][]{au("0\u0004L0\u00034 \u0003\u0002\u0001\u0002\u0002\t\u0000¨Í\u0017É=¥Ù0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u001e\u0017\r110324010653Z\u0017\r380809010653Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000Ã\u000f­Ù´\tj,XjZ5kú\u0002iXøÿ\f]úõI&ØpÞè!¥>\u001f[\u0017\u000fÉbE£É§ËE'\u0005;ã^4óÒK\"ì\fRn&teàhuêb\u001fù@ã4[ I\u0007ÌTt:ÍªÎeV_HºtÍA!ÍÈvß5\"ºÛ\t\\ Ù4Åj>\\9>åðà/àb\u001f\u001f5¨$%,o¦¶3§hk>Ha-\u0006©ÏoI¿ñ\u001d](þ\u0014¬WbCÝ)êý¹\rã&5\u0013©\u0005¬¯ ~Fu\nZ·¿w&/G°?Z<nm{Q4?iÇ÷%÷\u000bÌ\u001bJÕ%\u000bpZæè>â®7þW\u0001¼½²oîýÿö\u000fj[ßµ¶G\u0002\u0001\u0003£Ü0Ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u001cÎÎ\u000eêMÁ\u0012\u001fÇQ_\r\n\fràÉm0©\u0006\u0003U\u001d#\u0004¡0\u0014\u001cÎÎ\u000eêMÁ\u0012\u001fÇQ_\r\n\fràÉm¡{¤y0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC\t\u0000¨Í\u0017É=¥Ù0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000¤pÇ(áÓ\u001b\u0006Ù¯jçhµe\u0004lWkCrI1×]L¡\f2\u0015 Ó<Ïí*¦Tb#Lù¶ù\u0010ÌgkËÖÀgcWO»x3\u0012uÜ\\óº©\u0018×\u0005\u001fû¢­èó\u0003ÍèÙæ\u0004\u001fÛ|*I²\"ÆÿB+ñUi¸^îí°J£\bsÛæKtøòÂöÄ\u0001$ª¨Ñx\r\u0018Q+T\nÝ(³éX\u0019q¤\u0017\rØhÏ_1äG\u0012²Â;µ\u00107×ï¦å½³^,ëk°\"cl\u0017¥j¼zP%\u000bÒí{1UZ\u0018E.\u00172\u001a\rRö?t-tÿyXj\\»¯q¨KÏtC\u0010éé'Y\u0000¢=Ð\u0006`\f\"8Ù\u000b/³rßÛºu½."), au("0\u0004L0\u00034 \u0003\u0002\u0001\u0002\u0002\t\u0000Þv\u0004\u001dvPÀ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u001e\u0017\r110324010324Z\u0017\r380809010324Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000æÿ=ïé*¡\rqë\u000f¦@À6·âCîíh¦¤v=Ç¥*1u|ÚÆ\u001få\u0010»sÇ\u0016ä\u0000\u0001\u0004&[4ÎÎôÄ+ñá7Ð¨vð(\"»Áù½Õ×\u0013²ö©5£yÒË©ÉoÒÐx|\u0011ñë\u0019T\b¦ r³Klú\ná'gé\u0000u0\u0016i¡\u001cïFÎ÷Ç\u0004mÞ1û`(M\u0012\n°çÞ\u001dc?\u0007h}FQ\u0013ÿýÆ¼ |©\u0004¸¾\u001d ª{NuoC`d¾\\®<hè»yBÍõ\u0016\u0007É0¢üÚe[uÐuº­\u0006ç9½\u000b¢\u001f@BÂÀ¨ZZ°ÐgÆÃìI! B¬c§å;Tle´`´ãæâ>\u001fwÏçöÞtK\u001ae\u0002\u0001\u0003£Ü0Ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014¢èd°]\b\\4Û\n\u0000P\u0011zì0©\u0006\u0003U\u001d#\u0004¡0\u0014¢èd°]\b\\4Û\n\u0000P\u0011zì¡{¤y0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC\t\u0000Þv\u0004\u001dvPÀ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u00007q\fè|<Rê0ÆébÙKM_\u0012Â]&\u0015AýµU]\u0012Îó¸1,?]ö¨ªàL¹³\u0005ä'ý\u001d-\u0019áÒxñ<R\u000f\u0018!\u0002cØÔ½6QHØØº&Ø¹¿\tõý>»\u000e£ÂðÉ7o\u001e\u001fÊvó¦¤\u0005B\b\u001bu*z·Vé«DÚA«ÈáèøÂu§CûsæPqW\fËkzÝ!¹ÆäVá,\"=\\\u0007JßUö«Ú&-dê\nEîÍ´\u0012~uÇSÃÿ0ËÆxµ\u001cR\u0014rñ}¢\n\rÆ'J¢F44Á©¶\u0014ßi}õÊ\u0001ç¢\\}³û\u0005]eV\u0004°\u001d8«ºW³¡p>ÂçJÓ4")};
    static final byte[][] CZ = new byte[][]{au("0\u0005a0\u0003K\u0002\u0006\u0001DÓ0\u000b\u0006\t*H÷\r\u0001\u0001\u00050v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\u0013\tClockWork0\u001e\u0017\r140307220225Z\u0017\r380119031407Z0v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\u0013\tClockWork0\u0002\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0002\u000f\u00000\u0002\n\u0002\u0002\u0001\u0000º<9\u000bþYb¼ü<Æ'Z\u0015íÜÝ7:Uj\u000bâýC÷\u0018³\u0001Ò@'ãr\tÎýâ|&° Þ6}\u001aßãN§®7óõà&rzN\b(;ïvøöC¼\u0015'6 H?É·«R<ó½{f-*'L\u0000Øç\u0011è°&_í©uÜÈåB\u0013jbq.\u000b/9yQÛ$±W¡¿çÅkÎJ8\u000b%ú¹&c>¨\u00048à¶\u000b¹~.ú\u0005<2)Ùao¤½!{7C\u001fÍØí!§òðFà\u001c¼ZbãJ\u0015káZ\u0017ÿ\u0002\u0017dDÖ\u0013±\u001e×_\u0018î´ýäZã\u001cä¯¤68¶,\\ÒÛ\n\u0001Ä2a(äÅ\u0019z¾¬ÌmÂè­¤B_\u000fÕ¥¥X$a¿x\u0011á.Î\u000eê\u0006\u0003?T9íàqÿÄl òß¾##:dÁÎ\t­¡ËÎkö¼¢.JÀÉjluOì\u0018qØ{\u0010Á Þ`¼}wÞ0ÕN¸GÎk\u0012|\u0019\u001e§o\nFÁFó6¹4êºZ_\u001c\u0003d·RUD2Pýcªå{ë«à&?\t\bM\u0019D\u0006\f:Ù»ºyôÞ<+-7º³\rK¹\u0011ÜQià¯RôÓ=³òË\u001cR\u0002Rpa¿\u0001°BÐ~ä\u0011©ª 'ðDÚ(ÅÝØSW§\u001e9»Q³Wëor\u0018üÌ\u0017\u0018¦0gF1àU9\u001azgòZ b\u0001Ö\"¸Ð\tÝ\u0011Õ\u0006¢\u0003\u000f$'®gØ\u001b47yy\u0002\u0003\u0001\u0000\u00010\u000b\u0006\t*H÷\r\u0001\u0001\u0005\u0003\u0002\u0001\u0000¤Ä4aÈ5¥±\nÍ\u0001$7jÚ'C¬0\u0003Hg\u000b +­ã?/º*\u0007d\u0003µ\u000bèqÊ*²¾½»Ä\u0006Û\t9AÉ\u0017j\u000eFÿÿ\u0000\u0016\u0016\u0004DnÜá0þ\u0010\u001eã\u0005·~=©¢­4©Ò´Ú\u001b&ýZ[p\u001cÕlþédzä\u0014;¦|\u0002e±\u0014ò2¥ï\u0017ád¡I\u0017\u001c0½Z6«øóBÈã¯¼oICs\u0007}j\u0011×9\"\rZ×µ\u0019/\u001cþJr±¸Tuàé¾hrfe±+ôîÃ\"VTõáò+ëU¾fwÖ_\t-ù^þï\u000fÇêÊ]\u000e¾\u001dA\u0004\u001fç Ë20~9.\u0013ñ 9Ti0\u0002\u0017@-öÇ rçß8ºÃ×\"5oæTj|WßgÉ=+5T5ðù¡\u0013Î-ìÍm¡ÃKAì®Ö ëR0%Åà\u0004ì´Q¼EáHZÌ6¶I¯YLU\u001b\u000bÉ8ËÖ\u001aÕgY ÷:eá©È¤Û¬\u001eë\f)\t^ÞA\u0005{<®êN\u0016Å¹EKâY\u0011´¢\u001f?z¿Àgô\u0018.A¤ä4ð/í¯WrJU3WÚ_³ÍüùTÿØÉQwçu\u0004¦B¾\\Û á\u0000eü|h\u0012í'³¨\u0004×¤ÍÙ\fÓìË\u0005¨È`ÐV N´\u001e\u0005ý9\\\u001f§{³\u001d¥$4^\n½N\u0001µ\u0006OêºBÓ-Ôg>ÏÀ\u0017\u001d&éÍ\\FïÐ"), au("0\u0003¿0\u0002§ \u0003\u0002\u0001\u0002\u0002\t\u0000ÚÃÙ\u0015sÓï0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\f\tClockWork0\u001e\u0017\r140307220118Z\u0017\r410723220118Z0v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\f\tClockWork0\u0001\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\u000f\u00000\u0001\n\u0002\u0001\u0001\u0000Ü\u001doK(í80\u0014²öÚÿÓ\u001dÞ{\u001ec\b@e\u000bX±e£j®¶,qS.\u0004E\t¯\u001fºO\u0018dÃ§µÖSÌ\u0000\u0015\u0000\u0010áåfú7ªÿ\u00186]®{JÝ±óÌGp¢>bþµrÁi1Z¯Nôê¥®\u001fÍÖçåêÔ1\u0013tFF\f|(û2,\\\\z¨wÃp?à·~¶ n¬krê ­!\n°*\u001fÜüvbttA©?<ê\u0016ô\"Áã2A2~ÂÉ÷01.\u001bïî)\u000bE\u001a4,¬ï[\u0014rÖÙ~ùT(ÌÕï\u0004¸Äñõ\rÒBÕ]rXfP[^K\u001b\u001eY­\u001d/ H\u0015g;ÆæC)ìÄêÔÛd©k1ÛÉ\u0007\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014G\u0010¤<³êø?«!b \u0000Î,z0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0014G\u0010¤<³êø?«!b \u0000Î,z0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000\u00079b\u000b¢}*\u000fTC­\u001b`\u001c)Ù\u0001(êü?Ö(__bj>ðWæî²¬\\¢æ\u0005Ê=3õk\u00002ÄGæP\u000f%½\u0017Êù\u00039@ÈîlÜµ;íä±òHçÐ çÊê¥2ÏÚþJ¥í@@ND÷[ïÒÊÛ5¸²\u001bxF^\u0017\"òzû+\u000bn\u0015DÄ«\fOe{\u0019×}SÉÏ¹î-OE¶Tà\u0012¼éäÂâÃÓQ\u0003Ø®M,ÁÈbxW®u?\u001d{\u0002£§\u0005xÆ\u0005ã\u0005\u001cl\u001d©I\u001aÎ\u0013»Ð}}Ô&Q®¤G5\rë@^ò«óf®/ÊXÒö¿\u001d¿K\u001cHà \u0001TßÏ\u0002%\u0012õ¡Ç\"s\u001dãðGÖø")};
    static final byte[][] Da = new byte[][]{au("0\u0003m0\u0002W\u0002\u0006\u0001=døÖ³0\u000b\u0006\t*H÷\r\u0001\u0001\u00050|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\u0013\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\u0013\u000eGlass Platform0\u001e\u0017\r130313181742Z\u0017\r380119031407Z0|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\u0013\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\u0013\u000eGlass Platform0\u0001\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\u000f\u00000\u0001\n\u0002\u0001\u0001\u0000¡3¦Òi¯Ø6ã®Ü-¤­9¿øâ\u0019æH3´\u0018µ=5lì\u0014¸GF´\u000bß\u001eB¡þôÑõ×B\fÀØ+çÚe\tÄ¯?ÛÎ/PTïìçA©éRZ\u0013#\u0003ÿÎ\u0015D¦9»ÊØt¯ ¼¼õ\u0016öYÚ7Á­/è£ÄZæ\u001eÊ¨W¢\u0005C9í¿oð@nÂA½\buqc).s©)\u0004ù=ìk½@c¼¥>y¸©Cp|¹üA;X\u000f0ðGE´õ7­§æ\u001aÿüw\u000bNÓ<><ttb\u001ez­Ôw­\u0005ÜuL\r3\rÁXõæáõ¢`<Q&¬Bô\u0018Û xF)à\r§ë\u00065ÙºGµE\fZ¢dØ/\u0002\u0003\u0001\u0000\u00010\u000b\u0006\t*H÷\r\u0001\u0001\u0005\u0003\u0001\u0001\u0000è\u0015JôØôu°ã[ðÒR\u0006c\bLÏÑr%éKþÁJ\u001f¾7ErpÀÿVöVÁPéË¹Ùl\u001c;\u000b¡æ<êõÔæ«C*Ü±\u0013Wòc´èÍ®Ð¼p}ó\u0016í.©¶VxÔMþíä/°#¯cc±NSÄB²+ø«À¿i\u0005÷ó[(\u0012Kæc\u001dF\f9_5éu«FÞ\f?ß0Ï\u000f\u0007ÙE­}Ç¨d;ICà.&[\u0010tÕùKùXìÚúªoÅ¾¨Ìfý!»²nÏeéø.µ{gìÁéx·Ú'\u0017æÖ\u001dç¦l!¿ÂY¶ÞÉ½zµòÓÛÅ\u0013\u0005ÚÚ¨ïâ)<¢\u0017:ì#\b`pNwÉÀ¦b0§"), au("0\u0003É0\u0002± \u0003\u0002\u0001\u0002\u0002\t\u0000Ãi ­ßtÇ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\f\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\f\u000eGlass Platform0\u001e\u0017\r130226205628Z\u0017\r400714205628Z0|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\f\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\f\u000eGlass Platform0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000¯ÊGêäÐ;\u001e\bà\tw¢ø\u0006Æ¢\u0017\u001dí§[pâ:¢ñ¹¿h¥/?v,¾Æ:\bÑBZÃ\u001bé2m\u0001\u001e|\u0006Î¡ÈJëp?Ð9*1\u0006²}\u0004^|áT\u0004K\"Ê¥\u001d[õù±$â\"ºsA-ÔY0h,Fg1°Y¯¦¤èÝ?^µ@øº\u0011](G@)×\u001f1å»°ê^0 äuµ¤ý4\u0017\nÔ.ØPë9T,+éµm5þ¶²¨4iúKæ+È¤|è\u0000\u0003l®ðõ3sÉX\u0015¸ÊÙs[¿·\u0000eh¾mæw\u0010-E¿¶9z:\u001f\u0001%¸\u0015\u0005\u0005·«ÝÂ`\u001f~ñXÕ(á­;pmhE\u000f%:\u0013íyÀ\u0002l¨\u0013\u0011ÕËß·\u0002\u0001\u0003£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014óSB\u001f\u000fÍ{#j_µ\u001ffWc\u0019Ð{0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0014óSB\u001f\u000fÍ{#j_µ\u001ffWc\u0019Ð{0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000©X±/\u0007ï\u0014}CÅ=ÂÉèá\u0001¥b\bfF¼\u0004·\u001d÷yxÜ!/ü|\u0003ú¯Y%;èõ2Â_]uºæïº´XRp(hk\u0001B'¥A·C§³/4Ñ[Yô \u0015X%ý¼ì>ÒtÎìÇ\u0001Ë«[Ug\"3wn÷ä´â\u0001R\u000eFÕEI\\\u0014Ày­}\u001fýã¢±Ê\u001bQ[ +7[÷/6\u000fó-­`S:Ú×Å~#dRE¥ºÊÊBTý!³d!_\u0004vòéI\u0019÷W \u0013Xv\nF!î\u0003UÙ»@h\u000fÚó±¨f\u0004+Ë@3àw,Öãª\u001e Æñ\u0002\u0004úå[£áÙßëÔ@Uü\u0007¨æ­;Ô\u00117ö/_f£÷\u0018$õO({Úø?")};
    static final byte[][] Db = new byte[][]{au("0\u0003Á0\u0002© \u0003\u0002\u0001\u0002\u0002\t\u0000é\u0005DY+P0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\f\nmediashell0\u001e\u0017\r140527043400Z\u0017\r411012043400Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\f\nmediashell0\u0001\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\u000f\u00000\u0001\n\u0002\u0001\u0001\u0000Ðuk\u0017*HI*Õî>r~ë`\"¬Ø\b»W\fECÚCÄaåçb\u001c\u0005\n]ç¢½\u000f\f\u0002`ÿâr]ØHH$\u001a\u0006îf¬+ýáÞ\r\tEWËÇ\"ne¿)\u001d\u000få-¨ÑRg7ìj\u000e.7ù³ÎÓÓÙå°\tªYÛ!VÈÊ#u´\u001cfö9\n-\u000e\u000eIÁxt\tÀÙ%_ËÅY\u0012\u001bOòâ-±ât\u001a\u0000ÚIYôan­\u000e\u0012mÀKeðï\u000f¼BzÔ2ÏOïM:d`ÊÄ÷rXê-è½@¿\u0007ó?`]}Wf¾z!òJ',ªX¥9\\Íÿ&}\u000bÔò~D-É¼ÄJ\u0014dW§:J½!_w\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014³ÌD*Ûè6xð[4q4¬c\u001e` 0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0014³ÌD*Ûè6xð[4q4¬c\u001e` 0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000+ù\u001bqéèî\u0002[Ué<â¨R\u0017%¡ª\u0019\u0010Bï­6¸) É\u001b'\u001fãûiD3\u0013gú¦&¤â(\u001dì¥ßÌÝ\u0003ÆBªñ{tÜ&ü^P½OLââ\u001bkûìë\u001bÝpåÿÈ[þ²A\u0019D'3ôÐÚMc<^¾å\n\u001f\u0014?E£ÏÎ@®ÐaÕ+\u0007¹b¼fÑ_>ÔùÖÆH²\u00118ÊúþvôÜ»å\"¢l.Õ\b¦·\táW*P¯SÑ\u0006:\u00171½\u0017i[GÙ¡4!g.\fp\u001cÊÎ¶\u0016g5.IaÁ\f×JD6y+6N5³\u0010 _+\u0014²hsbK7èi:\u001c´í3oVáØ zé\u0002³>9\u000eQ²Ê4@\""), au("0\u0003Á0\u0002© \u0003\u0002\u0001\u0002\u0002\t\u0000ÐTãÎÛÎ\u00040\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\f\nmediashell0\u001e\u0017\r140603192622Z\u0017\r411019192622Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\f\nmediashell0\u0001\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\u000f\u00000\u0001\n\u0002\u0001\u0001\u0000µ\u001f{°ìÎp4cÎÓ\u001d4r¬¶©£õ?ßÐæ#ð={4]\u001fõ\"Øízeå3´â>ñ@k}Õ\u0014h\u001d>vÎÐe\u0005óM#\u0011_\u0000WG6I-hÏ|¶Ø|§uÂeÞ!\u001f­pg\bø¯1,í3.Çgb\bà/{í{4f¡2\u0005tu²gm¸q\u001cvà;Ì7¤c\u0005(#ä_*rN8'\u0010&\u0007oTÂéÈ¹ÿ#Az/Èµ s®\t_\u001e«ÜJÎzó%\u0003s\u0003d\u0012Ôñó,(Lâ¾ý_öèÃ\u0011äÎ\u001bTgHûý¡ãß0¦ø,ä¥ËÕ*?ò\u0015s:°ÈKz\u0018ïQlÐá¯°\u000f\b­\u001f\u0006ÿ2é;©\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014§L:À:o°\núúÉ×@(\\ «\u00100\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0014§L:À:o°\núúÉ×@(\\ «\u00100\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000 >dBCQ¼>Y_Ôà¥\n=-à\"s7\u0000KÌ;7|yê²¬\u0019íÎ]$<W2¤sóPh9\u0000þÖd\u0006Î\bÈ\u0013&Ò\u0013ÔûÃ%ßkøê»¹\u001b<.a°ÚtFS`sj\u001fH-Ét;â÷a\u0014\u0018èCY]\u001a\u001a¶¡-ÐvÆ}L#ª\u000f×°ñ\bã;÷\u001fEn·RÃº\u0007öÐ{¤Wß\u0001t²\b§¡^ÉD#n[ÔØ7\u0001Ý_\f  r8bø\u0002aÈ4r9¤\u000bÍ\u0010\u000f\f(âÏ*~º#%o_¬$f#\u000f§Ï}ÆâDD\u0010\u000fÝ¾)Áí|G\u00100ïV\u0006ý\u0005Ç`\u0017¥¯ð2Sh¯\u0001£ ÷\u000fO\r\u0000+E\u0016¨4ÚÌ\tÍq6")};
    static final byte[][] Dc = new byte[][]{au("0\u0003µ0\u0002 \u0003\u0002\u0001\u0002\u0002\t\u0000å×\u0017Ît¡0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000q1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\r0\u000b\u0006\u0003U\u0004\u0003\f\u0004nova0\u001e\u0017\r140529162639Z\u0017\r411014162639Z0q1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\r0\u000b\u0006\u0003U\u0004\u0003\f\u0004nova0\u0001\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\u000f\u00000\u0001\n\u0002\u0001\u0001\u0000¾¡ÀW\u001f¸\f]xw#T\u0011;\u0003b\u001aÖrV&-.-hI°\u0011ÑùK7ký\u0017üÞ7¤ÿ\u0011+*?/Rn\u000bïæÅÌÃBátÑ2Ã$_{ó\u0018U'ï²-µ\u000e¿yËò3ÝÚ1K\u0004»Íò|è/75ì$e\\Ô+/5®JRÍ¢îtÒ+ÛR\u0013SègZÉ¸ýR®\u0019ªªo^ë_Ùºs³b &©hÔÂnW'f\u000fp®A\u0019/v;=pUV1*ý\u001f\n`Öþ\u0011úR¦\u0012: Î3A$ýÆ\n~*z6yÛ£=ø\"´\u0007mÊº»«ÎÛ\u001c&Ë\u0001ëÏÂ\u0013fð\u001b0\u000eµHÊñ\u0005xÆ\r:kihR\\x<\u0003Ý\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014Â¸ç\u0001Að\nà\u000b\\\u0006?Mnú\u0007p¦0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0014Â¸ç\u0001Að\nà\u000b\\\u0006?Mnú\u0007p¦0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000H¡LÏsf¦\u0005óS\u0003,P\u0010$Ze%\u0010Å)@ìÛ¾_Ü} Ý4­Ò\u001bÏVðÂ-Ã9þI\u0013:ûÐÂ!£í_rEå!9¼\u0012VwòI2í34·|«­\u0015F\u0012tN¼\u0018Ý&Cóc#UHÌ^Á?JqxP?c÷\u000f6C@ùc7]ÈÉ=úzO'ÂØZîý¬¢¹Ï\u000bq¤\rrþAÌ\u0004d¯,1\bì|\u0006Uõ«Ò«¢UáÍY\"³v·Kº\u001b\u0005[Ç×¶ó' §Òõ ¼\u0003çµn+Û'¦ð)qG\u0015$ éÑDÀþåÎ¢)ß\b-ù\u00107p\u0000uî<èÀÎ\\\u0003¹5Óý\u0015v\u0005Fl"), au("0\u0003µ0\u0002 \u0003\u0002\u0001\u0002\u0002\t\u0000åo\t\u001b\u001f0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000q1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\r0\u000b\u0006\u0003U\u0004\u0003\f\u0004nova0\u001e\u0017\r140529162612Z\u0017\r411014162612Z0q1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\r0\u000b\u0006\u0003U\u0004\u0003\f\u0004nova0\u0001\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\u000f\u00000\u0001\n\u0002\u0001\u0001\u0000Ä_Uº4\\Ñ@_IÚÏ96Ör\u000fË6áMÚÿ\u0000ß[rÂÑN­ÌdÑþÈ/ðLÂ®Öæ¤ÑKc\u001fØÖ\u0018]à\u0010A\u0014\u001ew\tUñq­«*­ÉV94O+úzQ×ëÜ.Îñh~¶\u001e\u0001ÀñI?\u0003Tj\u001a­­$\\÷22ZÿZ·À\u001b\t\u0001a~\u0012\u001e\u0015»Æ{(WiËZ6+6¦2s§\u0001y ë@QÅ¦@ùvTOo\u0015Á»À\\®r&.t#2¡ßK°ð;àU·6TÛ?óú)°ÔÍZË=§Äø~jü\u001bYy\t·\u0015Å\"eÖÃh,æ\u0015E­ê)å­ÎçWà¯\u0002õx\r©\u0018Z9\u0018-#G\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014à»øÁWûã»ùfÉä;¤Ü\u0004'\nõH0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0014à»øÁWûã»ùfÉä;¤Ü\u0004'\nõH0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000îÅô/jêâ6\u001dðÇÕ\bQér\u0016eàF\u0000ÅøÌ×^64Ì õÅÓ2»gÖà­\u0015k\u0003oímÒ[\u001eh¿7åiå[vN\f\u0019\u0017¾\u001dÏ¿|\t\u000eQ¿¯\u0006\u0004¬\u0019Ï×@åøväj'½ü¾¦·®\u001e Up\u001d\"0\u0005ì ½Àþz\u0011a¤Û}Ñ\u0017ë\u0014th¾Ø(¬JbåîW·5Â\u0012¿ò^tòIJ\nZÖ8Y½\feóÍÒDN±*\u0014Å¸\n*Ý×{\u0006ÓqÌ·Î¢«S:\u001fz[(S4é\u0010 ó²EÜkÊ¦Ä,Ë(;ìá/1Û\u0014t%KPIÙ\u0017yÍ#}ò¦*b£\bÜ?Ñ7$gÍ`q")};
    private static final byte[][] Dd = a(CV, CW, CX, CY, CZ, Da, Db, Dc);
    private static final byte[][] De = new byte[][]{CV[0], CW[0], CY[0], CZ[0], Da[0], Db[0], Dc[0]};
    public static boolean Df = false;
    public static boolean Dg = false;
    private static int Dh = -1;
    private static final Object Di = new Object();
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 5089000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    private static void A(Context context) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable e) {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.version");
            if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 5089000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
            return;
        }
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }

    private static String B(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    public static Intent Z(int i) {
        switch (i) {
            case 1:
            case 2:
                return he.aD(GOOGLE_PLAY_SERVICES_PACKAGE);
            case 3:
                return he.aB(GOOGLE_PLAY_SERVICES_PACKAGE);
            case 12:
                return he.fA();
            default:
                return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ff  */
    private static Dialog a(int r5, Activity r6, Fragment r7, int r8, OnCancelListener r9) {
        /*
        r2 = 0;
        r0 = com.google.android.gms.internal.ip.gf();
        if (r0 == 0) goto L_0x0112;
    L_0x0007:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r1 = r6.getTheme();
        r3 = 16843529; // 0x1010309 float:2.3695736E-38 double:8.321809E-317;
        r4 = 1;
        r1.resolveAttribute(r3, r0, r4);
        r1 = r6.getResources();
        r0 = r0.resourceId;
        r0 = r1.getResourceEntryName(r0);
        r1 = "Theme.Dialog.Alert";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x0112;
    L_0x0029:
        r0 = new android.app.AlertDialog$Builder;
        r1 = 5;
        r0.<init>(r6, r1);
    L_0x002f:
        if (r0 != 0) goto L_0x0036;
    L_0x0031:
        r0 = new android.app.AlertDialog$Builder;
        r0.<init>(r6);
    L_0x0036:
        r1 = d(r6, r5);
        r0.setMessage(r1);
        if (r9 == 0) goto L_0x0042;
    L_0x003f:
        r0.setOnCancelListener(r9);
    L_0x0042:
        r3 = c(r6, r5);
        if (r7 != 0) goto L_0x0076;
    L_0x0048:
        r1 = new com.google.android.gms.internal.gz;
        r1.<init>(r6, r3, r8);
    L_0x004d:
        r3 = e(r6, r5);
        if (r3 == 0) goto L_0x0056;
    L_0x0053:
        r0.setPositiveButton(r3, r1);
    L_0x0056:
        switch(r5) {
            case 0: goto L_0x007c;
            case 1: goto L_0x0083;
            case 2: goto L_0x0099;
            case 3: goto L_0x008e;
            case 4: goto L_0x007e;
            case 5: goto L_0x00e0;
            case 6: goto L_0x007e;
            case 7: goto L_0x00b6;
            case 8: goto L_0x00c8;
            case 9: goto L_0x00a4;
            case 10: goto L_0x00d4;
            case 11: goto L_0x00f2;
            case 12: goto L_0x00ff;
            default: goto L_0x0059;
        };
    L_0x0059:
        r1 = "GooglePlayServicesUtil";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unexpected error code ";
        r2 = r2.append(r3);
        r2 = r2.append(r5);
        r2 = r2.toString();
        android.util.Log.e(r1, r2);
        r0 = r0.create();
    L_0x0075:
        return r0;
    L_0x0076:
        r1 = new com.google.android.gms.internal.gz;
        r1.<init>(r7, r3, r8);
        goto L_0x004d;
    L_0x007c:
        r0 = r2;
        goto L_0x0075;
    L_0x007e:
        r0 = r0.create();
        goto L_0x0075;
    L_0x0083:
        r1 = com.google.android.gms.R.string.common_google_play_services_install_title;
        r0 = r0.setTitle(r1);
        r0 = r0.create();
        goto L_0x0075;
    L_0x008e:
        r1 = com.google.android.gms.R.string.common_google_play_services_enable_title;
        r0 = r0.setTitle(r1);
        r0 = r0.create();
        goto L_0x0075;
    L_0x0099:
        r1 = com.google.android.gms.R.string.common_google_play_services_update_title;
        r0 = r0.setTitle(r1);
        r0 = r0.create();
        goto L_0x0075;
    L_0x00a4:
        r1 = "GooglePlayServicesUtil";
        r2 = "Google Play services is invalid. Cannot recover.";
        android.util.Log.e(r1, r2);
        r1 = com.google.android.gms.R.string.common_google_play_services_unsupported_title;
        r0 = r0.setTitle(r1);
        r0 = r0.create();
        goto L_0x0075;
    L_0x00b6:
        r1 = "GooglePlayServicesUtil";
        r2 = "Network error occurred. Please retry request later.";
        android.util.Log.e(r1, r2);
        r1 = com.google.android.gms.R.string.common_google_play_services_network_error_title;
        r0 = r0.setTitle(r1);
        r0 = r0.create();
        goto L_0x0075;
    L_0x00c8:
        r1 = "GooglePlayServicesUtil";
        r2 = "Internal error occurred. Please see logs for detailed information";
        android.util.Log.e(r1, r2);
        r0 = r0.create();
        goto L_0x0075;
    L_0x00d4:
        r1 = "GooglePlayServicesUtil";
        r2 = "Developer error occurred. Please see logs for detailed information";
        android.util.Log.e(r1, r2);
        r0 = r0.create();
        goto L_0x0075;
    L_0x00e0:
        r1 = "GooglePlayServicesUtil";
        r2 = "An invalid account was specified when connecting. Please provide a valid account.";
        android.util.Log.e(r1, r2);
        r1 = com.google.android.gms.R.string.common_google_play_services_invalid_account_title;
        r0 = r0.setTitle(r1);
        r0 = r0.create();
        goto L_0x0075;
    L_0x00f2:
        r1 = "GooglePlayServicesUtil";
        r2 = "The application is not licensed to the user.";
        android.util.Log.e(r1, r2);
        r0 = r0.create();
        goto L_0x0075;
    L_0x00ff:
        r1 = "GooglePlayServicesUtil";
        r2 = "The date of the device is not valid.";
        android.util.Log.e(r1, r2);
        r1 = com.google.android.gms.R.string.common_google_play_services_unsupported_title;
        r0 = r0.setTitle(r1);
        r0 = r0.create();
        goto L_0x0075;
    L_0x0112:
        r0 = r2;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtil.a(int, android.app.Activity, android.support.v4.app.Fragment, int, android.content.DialogInterface$OnCancelListener):android.app.Dialog");
    }

    public static boolean a(PackageManager packageManager, PackageInfo packageInfo) {
        boolean z = true;
        boolean z2 = false;
        if (packageInfo == null) {
            return false;
        }
        if (c(packageManager)) {
            if (a(packageInfo, Dd) == null) {
                z = false;
            }
            return z;
        }
        if (a(packageInfo, De) != null) {
            z2 = true;
        }
        if (z2 || a(packageInfo, Dd) == null) {
            return z2;
        }
        Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
        return z2;
    }

    public static boolean a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (ip.gc() && ((resources.getConfiguration().screenLayout & 15) > 3)) || b(resources);
    }

    private static byte[] a(PackageInfo packageInfo, byte[]... bArr) {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X509");
            if (packageInfo.signatures.length != 1) {
                Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
                return null;
            }
            byte[] toByteArray = packageInfo.signatures[0].toByteArray();
            try {
                try {
                    ((X509Certificate) instance.generateCertificate(new ByteArrayInputStream(toByteArray))).checkValidity();
                    for (byte[] bArr2 : bArr) {
                        if (Arrays.equals(bArr2, toByteArray)) {
                            return bArr2;
                        }
                    }
                    if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
                        Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(toByteArray, 0));
                    }
                    return null;
                } catch (CertificateExpiredException e) {
                    Log.w("GooglePlayServicesUtil", "Certificate has expired.");
                    return null;
                } catch (CertificateNotYetValidException e2) {
                    Log.w("GooglePlayServicesUtil", "Certificate is not yet valid.");
                    return null;
                }
            } catch (CertificateException e3) {
                Log.w("GooglePlayServicesUtil", "Could not generate certificate.");
                return null;
            }
        } catch (CertificateException e4) {
            Log.w("GooglePlayServicesUtil", "Could not get certificate instance.");
            return null;
        }
    }

    private static byte[][] a(byte[][]... bArr) {
        int i = 0;
        for (byte[][] length : bArr) {
            i += length.length;
        }
        byte[][] bArr2 = new byte[i][];
        int length2 = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            byte[][] bArr3 = bArr[i2];
            i = i3;
            i3 = 0;
            while (i3 < bArr3.length) {
                int i4 = i + 1;
                bArr2[i] = bArr3[i3];
                i3++;
                i = i4;
            }
            i2++;
            i3 = i;
        }
        return bArr2;
    }

    private static byte[] au(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static boolean b(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        boolean z = false;
        Dialog a = a(i, activity, fragment, i2, onCancelListener);
        if (a == null) {
            return z;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(a, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), GMS_ERROR_DIALOG);
        } else if (ip.gc()) {
            ErrorDialogFragment.newInstance(a, onCancelListener).show(activity.getFragmentManager(), GMS_ERROR_DIALOG);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    public static boolean b(PackageManager packageManager) {
        synchronized (Di) {
            if (Dh == -1) {
                try {
                    if (a(packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64), Dd[1]) != null) {
                        Dh = 1;
                    } else {
                        Dh = 0;
                    }
                } catch (NameNotFoundException e) {
                    Dh = 0;
                }
            }
        }
        return Dh != 0;
    }

    public static boolean b(PackageManager packageManager, String str) {
        try {
            return a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (NameNotFoundException e) {
            if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
                Log.d("GooglePlayServicesUtil", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }

    private static boolean b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return ip.ge() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }

    @Deprecated
    public static Intent c(Context context, int i) {
        return Z(i);
    }

    public static boolean c(PackageManager packageManager) {
        return b(packageManager) || !ey();
    }

    public static String d(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return a(context.getResources()) ? resources.getString(R.string.common_google_play_services_install_text_tablet) : resources.getString(R.string.common_google_play_services_install_text_phone);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_text);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_text);
            case 5:
                return resources.getString(R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(R.string.common_google_play_services_unsupported_text);
            case 12:
                return resources.getString(R.string.common_google_play_services_unsupported_date_text);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue);
        }
    }

    public static String e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_button);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    public static boolean ey() {
        return Df ? Dg : "user".equals(Build.TYPE);
    }

    public static String f(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_notification_needs_installation_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_notification_needs_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_needs_enabling_title);
            case 5:
                return resources.getString(R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(R.string.common_google_play_services_unsupported_text);
            case 12:
                return resources.getString(R.string.common_google_play_services_unsupported_date_text);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue);
        }
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode) {
        return getErrorDialog(errorCode, activity, requestCode, null);
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return a(errorCode, activity, null, requestCode, cancelListener);
    }

    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
        Intent c = c(context, errorCode);
        return c == null ? null : PendingIntent.getActivity(context, requestCode, c, DriveFile.MODE_READ_ONLY);
    }

    public static String getErrorString(int errorCode) {
        switch (errorCode) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 12:
                return "DATE_INVALID";
            default:
                return "UNKNOWN_ERROR_CODE";
        }
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (System.currentTimeMillis() < 1227312000288L) {
            return 12;
        }
        A(context);
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            if (ii.aD(packageInfo.versionCode)) {
                try {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(context.getPackageName(), 64);
                    if (ey()) {
                        if (a(packageInfo, CV[0], Da[0]) == null) {
                            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid (release key) on Glass.");
                            return 9;
                        }
                        if (a(packageInfo2, Da[0]) == null) {
                            Log.w("GooglePlayServicesUtil", "Calling package " + packageInfo2.packageName + " signature (release key) invalid on Glass.");
                            return 9;
                        }
                    }
                    if (a(packageInfo, CV[1], Da[1]) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature (test key) invalid on Glass.");
                        return 9;
                    }
                    if (a(packageInfo2, CV[1], Da[1]) == null) {
                        Log.w("GooglePlayServicesUtil", "Calling package " + packageInfo2.packageName + " signature (test key) invalid on Glass.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Calling package info missing.");
                    return 9;
                }
            } else if (!ii.F(context)) {
                try {
                    if (a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), CV) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (a(packageInfo, a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), CV)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                    return 9;
                }
            } else if (a(packageInfo, CV) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (ii.aB(packageInfo.versionCode) < ii.aB(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 5089000 but found " + packageInfo.versionCode);
                return 2;
            }
            try {
                return !packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0).enabled ? 3 : 0;
            } catch (NameNotFoundException e3) {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                e3.printStackTrace();
                return 1;
            }
        } catch (NameNotFoundException e4) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    public static boolean isUserRecoverableError(int errorCode) {
        switch (errorCode) {
            case 1:
            case 2:
            case 3:
            case 9:
            case 12:
                return true;
            default:
                return false;
        }
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode) {
        return showErrorDialogFragment(errorCode, activity, requestCode, null);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return b(errorCode, activity, null, requestCode, cancelListener);
    }

    public static void showErrorNotification(int errorCode, Context context) {
        Resources resources = context.getResources();
        Notification notification = new Notification(17301642, resources.getString(R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
        notification.flags |= 16;
        CharSequence f = f(context, errorCode);
        String B = B(context);
        notification.setLatestEventInfo(context, f, resources.getString(R.string.common_google_play_services_error_notification_requested_by_msg, new Object[]{B}), getErrorPendingIntent(errorCode, context, 0));
        ((NotificationManager) context.getSystemService("notification")).notify(39789, notification);
    }

    public static void z(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent c = c(context, isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (c == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", c);
        }
    }
}
