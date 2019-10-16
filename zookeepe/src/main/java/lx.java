import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lx {
    public static void main(String[] args) {
        Map<String, List<Person>> hp = new HashMap<String, List<Person>>();
        Person p = new Person();
        Person p1 = new Person();
        p.setId(1);
        p1.setId(12);
        List<Person> list = new ArrayList<Person>();
        list.add(p);
        list.add(p1);
        hp.put("map", list);
        HashMap<String, List<Person>> pf=getPointRuleAttachDetailDtoMap(hp);
        List<Person> li=pf.get("map");
        for (Person pp:li){
            System.out.println(pp.getId());
        }

    }
    public static HashMap<String, List<Person>> getPointRuleAttachDetailDtoMap(Map<String, List<Person>> hp) {
        String s= JSON.toJSONString(hp);
        JSONObject jsonObject = JSONObject.parseObject(s);
        Map<String,Object> map = (Map<String,Object>)jsonObject;
        HashMap<String, List<Person>> mp=null;
        for (String key : map.keySet()) {
            String json=JSON.toJSONString(map.get(key));
            JSONArray jsonO1=JSONObject.parseArray(json);
            List<Object> pp=(List<Object>)jsonO1;
            List<Person> pv=new ArrayList<Person>();
            for (Object o:pp){
                String str1 = JSON.toJSONString(o);
                Person infoDo111 = JSON.parseObject(str1, Person.class);
                pv.add(infoDo111);
            }
            mp =new HashMap<String, List<Person>>();

            mp.put(key,pv);
        }
        return mp;
    }
}




