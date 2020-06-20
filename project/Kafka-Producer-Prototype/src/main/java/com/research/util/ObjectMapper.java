package com.research.util;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 
 * @author majid
 *
 */
public final class ObjectMapper {
	public static byte[] objectToBytes(Object obj) {
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		byte[] convertedBytes = null;
		try {
			convertedBytes = mapper.writeValueAsBytes(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return convertedBytes;
	}
}
