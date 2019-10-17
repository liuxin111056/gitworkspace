import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class mapAndMap {
    public static void main(String[] args) {
        Map<String, Map<String, String>> map=new HashMap<String, Map<String, String>>();
        Map<String, String> mp=new HashMap<String, String>();
        Map<String, String> mp1=new HashMap<String, String>();
        mp.put("a","b");
        mp.put("c","d");
        mp1.put("e","f");
        map.put("1",mp);
        map.put("2",mp1);
        String jsonString = JSON.toJSONString(map);

        JSONObject jsonObject=JSONObject.parseObject(jsonString);
        Map<String,Object> m=(Map<String,Object>)jsonObject;

        Map<String, Map<String, String>> mapOut=new HashMap<String, Map<String, String>>();
        for (String key : m.keySet()) {
            String str = JSON.toJSONString(m.get(key));
            JSONObject jsonObjecIn=JSONObject.parseObject(str);
            Map<String,Object> mapIn=(Map<String,Object>)jsonObjecIn;
            Map<String, String> mpIn=new HashMap<String, String>();
            for (String keyIn : mapIn.keySet()) {
                String strIn = JSON.toJSONString(mapIn.get(keyIn));
                String valueIn = JSON.parseObject(strIn, String.class);
                mpIn.put(keyIn,valueIn);
            }
            mapOut.put(key,mpIn);
        }
        System.out.println(mapOut.get("2"));
        System.out.println(mapOut.get("2").get("e"));
    }

    /**
     * 将Map转换为LinkedHashMap
     * @param dataMap
     * @return
     */
    public static LinkedHashMap getMapValueForLinkedHashMap(Map dataMap) {
        LinkedHashMap returnMap = new LinkedHashMap();
        Iterator iterator = dataMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object objKey = iterator.next();
            Object objValue = dataMap.get(objKey);
            if (objValue instanceof Map) {
                returnMap.put(objKey, getMapValueForLinkedHashMap((Map) objValue));
            } else {
                returnMap.put(objKey, objValue);
            }
        }
        return returnMap;
    }
}
