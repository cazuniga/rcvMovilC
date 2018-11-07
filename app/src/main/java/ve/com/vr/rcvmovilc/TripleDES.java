package ve.com.vr.rcvmovilc;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class TripleDES {
    public static String ALGO = "DESede/CBC/PKCS7Padding";
    private static byte[] mykey  = {1, 1, 3, 2, 0, 6, 7, 8, 9, 10, 11, 12, 17, 14, 15, 10, 15, 18, 19, 20, 21, 29, 40, 42};
    private static byte[] myIV  = {4, 1, 5, 3, 7, 2, 0, 1};


    public static String _encrypt(String message ) throws Exception {

        Cipher cipher = Cipher.getInstance(ALGO);

        SecretKeySpec myKey = new SecretKeySpec(mykey,"DESede");
        IvParameterSpec ivspec = new IvParameterSpec(myIV);
        cipher.init(Cipher.ENCRYPT_MODE, myKey, ivspec);

        byte[] plainTextBytes = message.getBytes("UTF-8");
        byte[] buf = cipher.doFinal(plainTextBytes);
        byte[] base64Bytes = Base64.encode(buf, Base64.DEFAULT);
        String base64EncryptedString = new String(base64Bytes);
        return base64EncryptedString;
    }

    public static String _decrypt(String encryptedText ) throws Exception {

        byte[] message = Base64.decode(encryptedText.getBytes(), Base64.DEFAULT);

        IvParameterSpec ivspec = new IvParameterSpec(myIV);
        Cipher decipher = Cipher.getInstance(ALGO);
        SecretKeySpec myKey = new SecretKeySpec(mykey,"DESede");
        decipher.init(Cipher.DECRYPT_MODE, myKey, ivspec);

        byte[] plainText = decipher.doFinal(message);

        return new String(plainText, "UTF-8");
    }

    public static String mfData_Asc_Hex (String data) throws UnsupportedEncodingException {
        return HexStringConverter.getHexStringConverterInstance().stringToHex(data);
    }
    public static String mfData_Hex_Asc(String data){
        return HexStringConverter.getHexStringConverterInstance().hexToString(data);
    }

    public static String mfEncrypt (String data) throws Exception {
        return mfData_Asc_Hex(_encrypt (data));
    }
    public static String mfDencrypt (String data) throws Exception {
        return _decrypt(mfData_Hex_Asc(data));
    }
}
