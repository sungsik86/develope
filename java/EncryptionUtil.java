public class EncryptionUtil {

	// 파일구분자
	static final char FILE_SEPARATOR = File.separatorChar;

	static final int BUFFER_SIZE = 1024;

	/**
	 * 비밀번호를 암호화하는 기능(복호화가 되면 안되므로 SHA-256 인코딩 방식 적용)
	 *
	 * @param password 암호화될 패스워드
	 * @param id       salt로 사용될 사용자 ID 지정
	 * @return
	 * @throws Exception
	 */
	public static String encryptPassword(String password, String id) throws Exception {

		if (password == null)
			return "";
		if (id == null)
			return "";

		byte[] hashValue = null;

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		md.reset();
		md.update(id.getBytes());

		hashValue = md.digest(password.getBytes());

		return new String(Base64.encodeBase64(hashValue));
	}

	/**
	 * 비밀번호를 암호화하는 기능(복호화가 되면 안되므로 SHA-256 인코딩 방식 적용)
	 *
	 * @param data 암호화할 비밀번호
	 * @param salt Salt
	 * @return 암호화된 비밀번호
	 * @throws Exception
	 */
	public static String encryptPassword(String data, byte[] salt) throws Exception {

		if (data == null) {
			return "";
		}

		byte[] hashValue = null; // 해쉬값

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		md.reset();
		md.update(salt);

		hashValue = md.digest(data.getBytes());

		return new String(Base64.encodeBase64(hashValue));
	}

	/**
	 * 비밀번호를 암호화된 패스워드 검증(salt가 사용된 경우만 적용).
	 *
	 * @param data    원 패스워드
	 * @param encoded 해쉬처리된 패스워드(Base64 인코딩)
	 * @return
	 * @throws Exception
	 */
	public static boolean checkPassword(String data, String encoded, byte[] salt) throws Exception {
		byte[] hashValue = null; // 해쉬값

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		md.reset();
		md.update(salt);
		hashValue = md.digest(data.getBytes());

		return MessageDigest.isEqual(hashValue, Base64.decodeBase64(encoded.getBytes()));
	}

	public static boolean checkPassword(String data, String encoded, String id) throws Exception {
		byte[] hashValue = null; // 해쉬값

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		md.reset();
		md.update(id.getBytes());
		hashValue = md.digest(data.getBytes());

		return MessageDigest.isEqual(hashValue, Base64.decodeBase64(encoded.getBytes()));
	}

	/**
	 * SHA1.
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static String getSHA1Encrypt(String message)
			throws Exception, NoSuchAlgorithmException, InvalidKeyException {
		StringBuffer hexString = new StringBuffer();

		MessageDigest md = MessageDigest.getInstance("SHA-1");

		byte[] hash = md.digest(message.getBytes("UTF-8"));

		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xFF & hash[i]);

			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}

		return hexString.toString();
	}

	/**
	 * SHA256.
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static String getSHA256Encrypt(String message)
			throws Exception, NoSuchAlgorithmException, InvalidKeyException {
		StringBuffer hexString = new StringBuffer();

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		byte[] hash = md.digest(message.getBytes("UTF-8"));

		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xFF & hash[i]);

			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}

		return hexString.toString();
	}

	/**
	 * SHA1
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static byte[] getSHA1EncryptByte(String message)
			throws Exception, NoSuchAlgorithmException, InvalidKeyException {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.update(message.getBytes());
		return digest.digest();
	}

	/**
	 * HmacSHA256 값 비교 로직.
	 *
	 * @param message
	 * @param reqHashData
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws DecoderException
	 */
	public static boolean isHashCompare(String message, String reqHashData)
			throws NoSuchAlgorithmException, InvalidKeyException, DecoderException {
		String key = System.getProperty("hmac.key");
		boolean isHashCompare = true;

		byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
		SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "HmacSHA256");

		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(secretKeySpec);
		byte[] macBytes = mac.doFinal(message.getBytes());

		byte[] ba = new byte[reqHashData.length() / 2];
		for (int i = 0; i < ba.length; i++) {
			ba[i] = ((byte) Integer.parseInt(reqHashData.substring(2 * i, 2 * i + 2), 16));
		}

		if (!MessageDigest.isEqual(macBytes, ba)) {
			isHashCompare = false;
		}

		return isHashCompare;
	}

	public byte[] aesEncryptEcb(String sKey, String sText) {
		byte[] key = null;
		byte[] text = null;
		byte[] encrypted = null;
		final int AES_KEY_SIZE_128 = 128;

		try {
			// UTF-8
			key = sKey.getBytes("UTF-8");

			// Key size (128bit, 16byte)
			key = Arrays.copyOf(key, AES_KEY_SIZE_128 / 8);

			// UTF-8
			text = sText.getBytes("UTF-8");

			// AES/EBC/PKCS5Padding
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
			encrypted = cipher.doFinal(text);
		} catch (Exception e) {
			encrypted = null;
			log.error("aesEncryptEcb exception. : {}", e.getMessage());
		}

		return encrypted;
	}

	/*
	 * AES128 Decrypt
	 */
	public byte[] aesDecryptEcb(String sKey, byte[] encrypted) throws UnsupportedEncodingException {
		byte[] key = null;
		byte[] decrypted = null;
		final int AES_KEY_SIZE_128 = 128;

		try {
			// UTF-8
			key = sKey.getBytes("UTF-8");

			// Key size 128 (128bit, 16byte)
			key = Arrays.copyOf(key, AES_KEY_SIZE_128 / 8);

			// AES/EBC/PKCS5Padding
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
			decrypted = cipher.doFinal(encrypted);
		} catch (Exception e) {
			decrypted = null;
			log.error("aesDecryptEcb exception. : {}", e.getMessage());
		}
		return decrypted;
	}

	/*
	 * AES256 Encrypt
	 */
	public byte[] aes256EncryptEcb(String sKey, String sText) {
		byte[] key = null;
		byte[] text = null;
		byte[] encrypted = null;
		final int AES_KEY_SIZE_256 = 256;

		try {
			// UTF-8
			key = sKey.getBytes("UTF-8");

			// Key size (256bit, 16byte)
			key = Arrays.copyOf(key, AES_KEY_SIZE_256 / 8);

			// UTF-8
			text = sText.getBytes("UTF-8");

			// AES/EBC/PKCS5Padding
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
			encrypted = cipher.doFinal(text);
		} catch (Exception e) {
			encrypted = null;
			log.error("aes256EncryptEcb exception. : {}", e.getMessage());
		}

		return encrypted;
	}

	/*
	 * AES256 Decrypt
	 */
	public byte[] aes256DecryptEcb(String sKey, byte[] encrypted) throws UnsupportedEncodingException {
		byte[] key = null;
		byte[] decrypted = null;
		final int AES_KEY_SIZE_256 = 256;

		try {
			// UTF-8
			key = sKey.getBytes("UTF-8");

			// Key size (256bit, 16byte)
			key = Arrays.copyOf(key, AES_KEY_SIZE_256 / 8);

			// AES/EBC/PKCS5Padding
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
			decrypted = cipher.doFinal(encrypted);
		} catch (Exception e) {
			decrypted = null;
			log.error("aes256DecryptEcb exception. : {}", e.getMessage());
		}

		return decrypted;
	}

	public String toHexString(byte[] b) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < b.length; i++) {
			sb.append(String.format("%02X", b[i]));
		}

		return sb.toString();
	}

	public byte[] toHexString2(String test) {
		int len = test.length();
		byte[] data = new byte[len / 2];

		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(test.charAt(i), 16) << 4) + Character.digit(test.charAt(i + 1), 16));
		}

		return data;

	}

//	public static void main(String[] args) throws Exception {
//		String userId = "admin";
//		String userPwd = "new1234!";
//		String encPwd = "";
//
//		encPwd = encryptPassword(userPwd, userId);
//
//		System.out.println("[Encript Password]:[" + encPwd + "]");
//		System.out.println("[Password chk Result]:[" + checkPassword(userPwd, encPwd, userId) + "]");
//	}

}
