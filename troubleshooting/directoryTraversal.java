경로순회 취약점 방어코드 관련

list 출력

LogFileMgtController@RequestMapping("/ajaxLogFileListSearch") -> LogFileMgtService.getLogFileList

		String isDir = paramMap.get("selectedDir").equals("root") ? dirPath: dirPath.concat("/").concat(((String)paramMap.get("selectedDir")).replace("..", ""));
		Map<String, Object> resultMap = new HashMap<String,Object>();        
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int ListCnt =0;
		
		...
		
		...
		
		...
		
		

	public String directoryTraversal(String isDir, String ...isFileNm) throws Exception{
//		=====경로조작 및 자원삽입 취약점 방어코드 시작
		String splitDirStr = File.separator;
		String OsFilePath = isDir.replaceAll("/", Matcher.quoteReplacement(File.separator));
		String reverseSlashPath = OsFilePath.replaceAll(Matcher.quoteReplacement(File.separator), "/");
		
		if(reverseSlashPath.equals("/root") || reverseSlashPath.equals("/")) {
		//application.yml의 log경로 또는 해당변수가 조작 되었을 경우를 대비하여 고객사log경로 하드코딩
			OsFilePath = splitDirStr+"shdslog"+splitDirStr+"smmsdomain";
		}else if(reverseSlashPath.contains("..") || reverseSlashPath.contains("./")){
//			isDirStr = isDir.toString().replaceAll("[..,./]","");
			int isDirLength = reverseSlashPath.split("/").length;
			String [] strList = new String[isDirLength];
			strList = reverseSlashPath.split("/");
			isDir="";
			for(String isDirStr : strList) {
				isDirStr+="/";
				if(isDirStr.equals("")) {}else {
					if(isDirStr.contains(".")) {
						isDirStr = isDirStr.replaceAll("[..,./]", "");
						if(isDirStr.equals("")){}else{isDir += isDirStr;}
					}else {isDir += isDirStr;}
				}
			}
		};
		
		if(isFileNm.length != 0) {
			isDir += isFileNm[0].toString();
		}

//		====================================================================================
		/*
		 * isDirStr = isDirStr.replaceAll("[..,./]", "");
		 * 이것만 있어도 동작 가능
		 * */
//		====================================================================================
//		=====경로조작 및 자원삽입 취약점 방어코드 끝
		return isDir;
	}
