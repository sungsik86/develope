	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public HashMap<String, Object> sendPost(String url, HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		String resultStr = "";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Authorization", "Bearer " + jwtTokenUtil.createJWT());
		
		HttpEntity httpEntity = new HttpEntity(param, headers);
		
		log.info("\n[REQUEST-URL]  : " + url + "\n[HEADERS]  : " + StringUtil.objectToJson(headers)
				+ "\n[REQUEST-PARAM] : " + StringUtil.objectToJson(param));
		
		try {
			resultStr = restTemplate.postForObject(url, httpEntity, String.class);
			result.putAll(StringUtil.jsonToMap(resultStr));
			log.info("\n[RES-RESULT] : " + resultStr);
		} catch (Exception e) {
			log.error(e.getMessage());
			result.put("rslt", "9000");
			result.put("rsltDesc", "API연동실패");
		}
		
		return result;
	}
