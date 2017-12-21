package cn.mr.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
/**
 * 日期序列化实用工具类
 * @author xuejiangtao
 * 2012-8-23 上午11:22:07
 */
public class DateDeserializerUtils implements JsonDeserializer<java.util.Date>{
	public java.util.Date deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		return new java.util.Date(json.getAsJsonPrimitive().getAsLong());
	}

}
