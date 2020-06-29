//package com.secrecy.feiduichen;
//
//import java.io.FileInputStream;
//import java.io.ObjectInputStream;
//import java.math.BigInteger;
//import java.security.Key;
//import java.security.KeyFactory;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.SecureRandom;
//import java.security.spec.RSAPrivateCrtKeySpec;
//import java.security.spec.RSAPublicKeySpec;
//
//import javax.crypto.Cipher;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//// jdk版本问题
//public class Clienter {
//	public static String encrypt(String source) throws Exception {
//		/** 将文件中的公钥对象读出 */
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("publickey.keystore"));
//		Key key = (Key) ois.readObject();
//		ois.close();
//		/** 得到Cipher对象来实现对源数据的RSA加密 */
//		Cipher cipher = Cipher.getInstance("RSA");
//		cipher.init(Cipher.ENCRYPT_MODE, key);
//		byte[] b = source.getBytes();
//		/** 执行加密操作 */
//		byte[] b1 = cipher.doFinal(b);
//		BASE64Encoder encoder = new BASE64Encoder();
//		return encoder.encode(b1);
//	}
//
//	public static String decrypt(String cryptograph) throws Exception {
//		/** 将文件中的私钥对象读出 */
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("privatekey.keystore"));
//		Key key = (Key) ois.readObject();
//		/** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
//		Cipher cipher = Cipher.getInstance("RSA");
//		cipher.init(Cipher.DECRYPT_MODE, key);
//		BASE64Decoder decoder = new BASE64Decoder();
//		byte[] b1 = decoder.decodeBuffer(cryptograph);
//		/** 执行解密操作 */
//		byte[] b = cipher.doFinal(b1);
//		return new String(b);
//	}
//
//	private static void generateKeyPairString() throws Exception {
//		/** RSA算法要求有一个可信任的随机数源 */
//		SecureRandom sr = new SecureRandom();
//		/** 为RSA算法创建一个KeyPairGenerator对象 */
//		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
//		/** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
//		kpg.initialize(1024, sr);
//		/** 生成密匙对 */
//		KeyPair kp = kpg.generateKeyPair();
//		/** 得到公钥 */
//		Key publicKey = kp.getPublic();
//		/** 得到私钥 */
//		Key privateKey = kp.getPrivate();
//		/** 用字符串将生成的密钥写入文件 */
//
//		String algorithm = publicKey.getAlgorithm(); // 获取算法
//		KeyFactory keyFact = KeyFactory.getInstance(algorithm);
//		BigInteger prime = null;
//		BigInteger exponent = null;
//
//		RSAPublicKeySpec keySpec = (RSAPublicKeySpec) keyFact.getKeySpec(publicKey, RSAPublicKeySpec.class);
//
//		prime = keySpec.getModulus();
//		exponent = keySpec.getPublicExponent();
//		System.out.println("公钥模量：" + HexUtil.byte2hex(prime.toByteArray()));
//		System.out.println("公钥指数:" + HexUtil.byte2hex(exponent.toByteArray()));
//
//		System.out.println(privateKey.getAlgorithm());
//		RSAPrivateCrtKeySpec privateKeySpec = (RSAPrivateCrtKeySpec) keyFact.getKeySpec(privateKey,
//				RSAPrivateCrtKeySpec.class);
//		BigInteger privateModulus = privateKeySpec.getModulus();
//		BigInteger privateExponent = privateKeySpec.getPrivateExponent();
//
//		System.out.println("私钥模量：" + HexUtil.byte2hex(privateModulus.toByteArray()));
//		System.out.println("私钥指数:" + HexUtil.byte2hex(privateExponent.toByteArray()));
//	}
//
//	public static void main(String[] args) throws Exception {
//		String source = "chenhaiyang";
//		String encrypt = encrypt(source);
//		System.out.println(encrypt);
//		String decrypt = decrypt(encrypt);
//		System.out.println(decrypt);
//
//		// 将格式转化一下
//		String cryptograph = encrypt(source);// 生成的密文
//		String hexCrypt = HexUtil.byte2hex(cryptograph.getBytes());
//		System.out.println("生成的密文--->" + hexCrypt);
//		String target = decrypt(new String(HexUtil.hex2byte(hexCrypt)));// 解密密文
//		System.out.println("解密密文--->" + target);
//
//		// 有待研究
//		generateKeyPairString();
//	}
//}
