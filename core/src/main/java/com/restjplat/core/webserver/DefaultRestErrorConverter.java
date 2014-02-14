package com.restjplat.core.webserver;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("rawtypes")
@Component
public class DefaultRestErrorConverter implements RestErrorConverter<Map> {

	@SuppressWarnings("unchecked")
	@Override
	public Map convert(RestError re) {
		Map errorMap = new LinkedHashMap();
		errorMap.put(RestConstants.REST_SERVICE_HTTP_STATUS, re.getStatus()
				.value());
		errorMap.put(RestConstants.REST_SERVICE_ERROR_CODE, re.getErrorCode()
				.getValue());
		errorMap.put(RestConstants.REST_SERVICE_ERROR_REASON, re.getErrorCode()
				.getErrorReason());
		errorMap.put(RestConstants.REST_SERVICE_ERROR_MSG, re.getMsg());
		errorMap.put(RestConstants.REST_SERVICE_ERROR_URI, re.getFromUri());

		return errorMap;
	}

	@Override
	public String convertToJson(RestError re) {
		Map errorMap = this.convert(re);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(errorMap);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
