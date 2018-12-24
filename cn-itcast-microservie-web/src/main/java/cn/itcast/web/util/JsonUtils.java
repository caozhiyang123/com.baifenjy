package cn.itcast.web.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 统一的Json的处理工具类
 * 
 * @author zhy
 *
 */
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 把对象序列化为String
     * 
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public static String toString(Object obj) throws JsonProcessingException {
        return MAPPER.writeValueAsString(obj);
    }

    /**
     * 把Json反序列化为简单的Bean
     * 
     * @param json
     * @param clazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T toBean(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        return MAPPER.readValue(json, clazz);
    }

    /**
     * 把Json反序列化为简单的List
     * 
     * @param json
     * @param clazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> List<T> toList(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    /**
     * 把Json反序列化为简单的Map
     * 
     * @param json
     * @param clazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <K, V> Map<K, V> toMap(String json, Class<K> k, Class<V> v)
            throws JsonParseException, JsonMappingException, IOException {
        return MAPPER.readValue(json, MAPPER.getTypeFactory().constructMapType(Map.class, k, v));
    }

    /**
     * 吧json序列化为任意对象
     * 
     * @param json
     * @param type
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T toObject(String json, TypeReference<T> type)
            throws JsonParseException, JsonMappingException, IOException {
        return MAPPER.readValue(json, type);
    }
}
