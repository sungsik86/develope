	public static void main(String[] args) throws FileNotFoundException {
		//암복호화 쉘
		if("encdes".equalsIgnoreCase(System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME))) {
			JasyptShell.main(args);
			return;
		}
		
		// System.err 로그를 log4j 로 찍어준다.
		System.setErr(new PrintStream(new SystemErr()));
		
//		String path = System.getProperty("user.dir");
//		System.out.println("Working Directory = " + path);
	      
		System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "local");
		SpringApplication.run(AgentAplication.class, args);
	}

public class JasyptShell {

	public static void main(String[] args) throws FileNotFoundException {
		Properties p = EctechUtil.loadYamlIntoProperties("application.yml");
		
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		
		
		if(args == null || args.length < 2){
			System.out.println("ex) encdes.sh type text");
			System.out.println("  type : ENC - encoding, DES - decoding");
			return;
		}if("ENC".equalsIgnoreCase(args[0])  == true ){
			pbeEnc.setPassword(p.getProperty("encKey")); //암호화키
			String enc = pbeEnc.encrypt(args[1]);
			System.out.println("enc = " + enc);
			return;
		}if("DES".equalsIgnoreCase(args[0])  == true ){
			pbeEnc.setPassword(p.getProperty("encKey")); //암호화키
			String des = pbeEnc.decrypt(args[1]);
			System.out.println("des = " + des);
			return;
		}if("ENCB".equalsIgnoreCase(args[0])  == true ){
			
			String encKey = null;
			try {
				 encKey = EncryptionUtil.getSHA256Encrypt(p.getProperty("application-key"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			config.setPassword(encKey);
			config.setAlgorithm("PBEWithMD5AndDES");
			config.setKeyObtentionIterations("1000");
			config.setPoolSize("1");
			config.setProviderName("SunJCE");
			config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
			config.setStringOutputType("base64");
			encryptor.setConfig(config);
			
			StringEncryptor encryptor_str = encryptor;
			
			String enc = encryptor_str.encrypt(args[1]);
			System.out.println("enc = " + enc);
			
		}else {
			System.out.println("ex) encdes.sh type text");
			System.out.println("  type : ENC - encoding, DES - decoding");
		}
		
//		String enc = pbeEnc.encrypt("jdbc:mysql://ectech.co.kr:30406/shinhan_finance?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&RewriteBatchedStatements=true&serverTimezone=UTC"); //암호화 할 내용
//		System.out.println("enc = " + enc); //암호화 한 내용을 출력
//		
//		//테스트용 복호화
//		String des = pbeEnc.decrypt(enc);
//		System.out.println("des = " + des);
//		
//		
//		enc = pbeEnc.encrypt("shinhan_finance"); //암호화 할 내용
//		System.out.println("enc = " + enc); //암호화 한 내용을 출력
//		
//		//테스트용 복호화
//		des = pbeEnc.decrypt(enc);
//		System.out.println("des = " + des);
//		
//		
//		enc = pbeEnc.encrypt("test1234"); //암호화 할 내용
//		System.out.println("enc = " + enc); //암호화 한 내용을 출력
//		
//		//테스트용 복호화
//		des = pbeEnc.decrypt(enc);
//		System.out.println("des = " + des);
		    
	}

}
