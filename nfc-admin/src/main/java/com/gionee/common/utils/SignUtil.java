/**
 * 
 */
package com.gionee.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.gionee.epay.client.EpaySDKUtils;

/**
 * @author zhanggq
 *
 *         2017年8月25日
 */
public class SignUtil {
	private static final String ENCODING = "UTF-8";
	private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

	public static String sign(String data, String privateKey) throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException, SignatureException,
			UnsupportedEncodingException, Exception {
		return encodeBase64(sign256(data, getPrivateKey(privateKey)));
	}

	public static boolean verifySign(String data, String sign, String publicKey) throws Exception {
		return verify256(data, decodeBase64(sign.getBytes()), getPublicKey(publicKey));
	}

	private static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = EpaySDKUtils.decryptBASE64(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	private static PublicKey getPublicKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = EpaySDKUtils.decryptBASE64(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	/**
	 * SHA256WithRSA签名
	 * 
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] sign256(String data, PrivateKey privateKey) throws NoSuchAlgorithmException,
			InvalidKeySpecException, InvalidKeyException, SignatureException, UnsupportedEncodingException {

		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);

		signature.initSign(privateKey);

		signature.update(data.getBytes(ENCODING));

		return signature.sign();
	}

	private static boolean verify256(String data, byte[] sign, PublicKey publicKey) {
		if (data == null || sign == null || publicKey == null) {
			return false;
		}

		try {
			Signature signetcheck = Signature.getInstance(SIGNATURE_ALGORITHM);
			signetcheck.initVerify(publicKey);
			signetcheck.update(data.getBytes("UTF-8"));
			return signetcheck.verify(sign);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 二进制数据编码为BASE64字符串
	 * 
	 * @param data
	 * @return
	 */
	private static String encodeBase64(byte[] bytes) {
		return new String(Base64.encodeBase64(bytes));
	}

	/**
	 * BASE64解码
	 * 
	 * @param bytes
	 * @return
	 */
	private static byte[] decodeBase64(byte[] bytes) {
		byte[] result = null;
		try {
			result = Base64.decodeBase64(bytes);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, UnsupportedEncodingException, Exception {
		String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs9NdGkOsJ6BJcw+nHIKPr4Tt5gYYoOT1KHkEffan4QppNHS123Wcyn3Fvxi8pVvNhrJZ/SNXwfBqaDynGPA8EKHSZ9tGN5Eq02ea69ySNpabDzyr8A7D6mYxHaEaLyJ6FFUJtSkvg8XDqI+6FjqxyhO1OjDG0fIQTjvAHnLxwp3O1C5T8wxiYr0/fQMZ8APdZ3msFRr4jQ7JbTNpy6KpsErT7WZxrMRifmPSvvXZlb3CKsexJKUP/I3yYTK/1LFbkEQLymbE2cx3zncTi9TxzE8jbvjr+3W3wT60bCWTx9oEVTsSAHARHI6uUDzlFMS61IZLInbbmWqSzPxv75XsnwIDAQAB";
		String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCz010aQ6wnoElzD6ccgo+vhO3mBhig5PUoeQR99qfhCmk0dLXbdZzKfcW/GLylW82Gsln9I1fB8GpoPKcY8DwQodJn20Y3kSrTZ5rr3JI2lpsPPKvwDsPqZjEdoRovInoUVQm1KS+DxcOoj7oWOrHKE7U6MMbR8hBOO8AecvHCnc7ULlPzDGJivT99AxnwA91neawVGviNDsltM2nLoqmwStPtZnGsxGJ+Y9K+9dmVvcIqx7EkpQ/8jfJhMr/UsVuQRAvKZsTZzHfOdxOL1PHMTyNu+Ov7dbfBPrRsJZPH2gRVOxIAcBEcjq5QPOUUxLrUhksidtuZapLM/G/vleyfAgMBAAECggEAEKC+vyr6xD9CC22rGivIdYZpKRfvNxF0yeVG0Q75vwljaQJRvpVFhkPTATScXP38JzRetdWKy9gbPsA9A0VTiIYuGoRgHctCloHCBYVDz+BlPidyDqSO4SHJ8N9wuGMLvs2OND42soya5v9DScLrpa/k1hikic1ETLehsC8Yw9IEG2WzEpmTVpYw3kPyH7kxIb4a+ku0qHgvV0AUUdpD2SkOX5kQv0GN+ZeGUVP8ucCGCCOkc/PvBHOQEDZ72pVj4v/J/ZfrSXsNBufjnuasCXds/fRzfpQjoaxATjEAzEWMsIU9xutVaCyhCN4/Ui1cGPvU6zSdsedj9gDvv80gYQKBgQDY6vfDZFxL6k8N0NhwtP/kJIWt6VvInbKiPVq75Oi8FxstkHKb4VKXzJCNlFTBzGAFi7qIsfMsBdEuJ9ydI9sM2h7XxM/4aOA6hylr+q0AbhgPRROdVTGiycL8URk3O+uvnbJPOlbMXwn60PG7wfvvn69/Gp0p3Q4/6tnilfxO0wKBgQDUOZHgeIZEw2Q/VyMKZ/4F+tUKJruu1Em+G2y4olm1WnUeemDPh2smUPArRuuGZJponJ1wcwQ5ya42djrCKO1aWr4V4rL7BQRMENqkvtoW4AMZV/coVSwprKGnx9s7X49TRxVAp6LNS195pNY4rq3UkfLETGPhHKGxyhoyv0mDhQKBgDkw4jgq+satNUCgQqCcqCb/lhs/PorLQTDTWlvVw6LruKevwPfmVX9eWPJrHFmoR9zOdVTbDhEaS4eOzPTFYlimHaGn62lERXJI9pvYkMpfPIqyHLTLpHWWGomp3Csa6k34Fu4apI3ntNrjQgjN4V3RTVUGsE88UCh8BAxgnRAvAoGBAMc3g4iDmwbRpDkRQwNxuzNB0tpEocnr3Y1nkReAz1U+JNMHbflh1WOSduEpIc52gbvRyLjWPxFAERluwpmgca5voCBLPlgEzZPZ/mTIA1GV11LjEE/8JAi61MT7BwElIxW5lGms81Zjeqxl3/I1h1gT6R/71YZrqh2K6izZA9lBAoGBAM1B3ifZwF1NwKfFn1FXTAD+u1Ip/QbfHYFSS8k638K9ojaDxqejStJBihYjQIikLHBLGtLniPVKLY5nmDQyMzIyqB6+7/IytGEpsfOiGlZO6YXIBw5zh/T/a00r4/B2XeDOapLtwZ2agwmk0rhRj8EMuklcR/WJxP3HDkxBA5u5";	
		
		String data = "test123";
		String sign = sign(data, privateKey);
		System.out.println("sign:" + sign);
		
		boolean checkSign = verifySign(data, sign, publicKey);
		System.out.println(checkSign);
		
	}
}