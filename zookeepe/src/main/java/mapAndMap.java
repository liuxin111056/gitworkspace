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

        LinkedHashMap<Object, Object> mapL=new LinkedHashMap<Object, Object>();
        Person p=new Person();
        p.setId(111);
        mapL.put(1,p);
       // mapL.put(3,4);
        String jsonStringL = JSON.toJSONString(mapL);

        JSONObject jsonObjectL=JSONObject.parseObject(jsonStringL);
        Map<String,Object> mL=(Map<String,Object>)jsonObjectL;
        String str=JSONObject.toJSONString(mL.get("1"));
        for (Map.Entry<String, Object> entry : mL.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        for(Object obj : mL.values()){
            //---------重点 即使转了Object但实际上还是JSON对象，需要再转一下
            String str1=JSON.toJSONString(obj);
            Person o=JSON.parseObject(str1,Person.class);
          //  System.out.println(o.getId()+"--------");

        }
        for (String key: mL.keySet()){
            String str1=JSON.toJSONString(mL.get(key));
            Person o=JSON.parseObject(str1,Person.class);
     //       System.out.println(o.getId()+"--------");

        }
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
