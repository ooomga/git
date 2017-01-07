package net.juntech.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * <ul>
 * <li>ZX 2016年12月27日 新建</li>
 * <li>{@link #方法名自动提示}功能描述,方便查找方法</li>
 * </ul>
 *
 */
public class AESUtil {
//	private final static String e = Config.getString("cbc");
	private final static String sKey = Constants.AES_KEY;
	/**
	 * 加密
	 * 01 算法/模式/填充 16字节加密后数据长度 不满16字节加密后长度 02 AES/CBC/NoPadding 16 不支持 03
	 * AES/CBC/PKCS5Padding 32 16 04 AES/CBC/ISO10126Padding 32 16 05
	 * AES/CFB/NoPadding 16 原始数据长度 06 AES/CFB/PKCS5Padding 32 16 07
	 * AES/CFB/ISO10126Padding 32 16 08 AES/ECB/NoPadding 16 不支持 09
	 * AES/ECB/PKCS5Padding 32 16 10 AES/ECB/ISO10126Padding 32 16 11
	 * AES/OFB/NoPadding 16 原始数据长度 12 AES/OFB/PKCS5Padding 32 16 13
	 * AES/OFB/ISO10126Padding 32 16 14 AES/PCBC/NoPadding 16 不支持 15
	 * AES/PCBC/PKCS5Padding 32 16 16 AES/PCBC/ISO10126Padding 32 16
	 * 
	 * CryptoJS supports the following padding schemes:
	 * 
	 * Pkcs7 (the default) Iso97971 AnsiX923 Iso10126 ZeroPadding NoPadding
	 */
    public static String Encrypt(String sSrc) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
//        byte[] raw = key.getBytes("ASCII");
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// "算法/模式/补码方式"0102030405060708  
//        IvParameterSpec iv = new IvParameterSpec(v.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度  
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
//            byte[] raw = key.getBytes("ASCII");
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");  
//            IvParameterSpec iv = new IvParameterSpec(v.getBytes());  
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);  
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
