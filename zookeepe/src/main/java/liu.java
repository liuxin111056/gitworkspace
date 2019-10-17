import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class liu {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("a","b");
        map.put("c","d");
        String jsonString= JSON.toJSONString(map);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Map<String,Object> mp = (Map<String,Object>)jsonObject;
        Map<String,String> map1=new HashMap<String, String>();
        for (String key : mp.keySet()) {
            String str1 = JSON.toJSONString(mp.get(key));
            String value = JSON.parseObject(str1, String.class);
            map1.put(key,value);
        }
        if (mp.get("a") instanceof Object){
            System.out.println(1);
        }
        if (mp.get("a") instanceof String){
            System.out.println(2);
        }
    }
}
