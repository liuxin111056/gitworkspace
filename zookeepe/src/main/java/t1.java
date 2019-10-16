import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sun.rmi.runtime.NewThreadAction;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * liuxin
 * 2019/8/30 0030
 */
public class t1 {
    public static void main(String[] args) {
        Person p=new Person();
        p.setId(1);
        Person p11=new Person();
        p11.setId(20);
        String str = JSON.toJSONString(p);
        //System.out.println(str);
        Person infoDo = JSON.parseObject(str, Person.class);
        //System.out.println(infoDo.getId());

        Map<String, Person> map11=new HashMap<String, Person>();
        map11.put("a",p);
        String jsonString1=JSON.toJSONString(map11);

        JSONObject jsonObject111 = JSONObject.parseObject(jsonString1);
        Map<String,Object> map111 = (Map<String,Object>)jsonObject111;
       System.out.println( map111.get("a")+"........................");

        String str1111 = JSON.toJSONString(map111.get("a"));
        Person infoDo11 = JSON.parseObject(str1111, Person.class);
        System.out.println( infoDo11.getId()+"........................");

        Map<String, String> map=new HashMap<String, String>();
        map.put("name","张三");
        String jsonString = JSON.toJSONString(map);
        //System.out.println(jsonString+"---");
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Map<String,Object> map1 = (Map<String,Object>)jsonObject;
        //System.out.println(map1.get("name")+"---");

        Map<String , Map<String, String>> acctNoQueryParamMap = new HashMap<String , Map<String, String>>();

        acctNoQueryParamMap.put("a",map);
        String s1 = JSON.toJSONString(acctNoQueryParamMap);
       // System.out.println(s1);

        JSONObject s2 = JSONObject.parseObject(s1);
        Map<String,Object> m1 = (Map<String,Object>)s2;

        //System.out.println(m1.get("a"));

        JSONObject s3 = JSONObject.parseObject(m1.get("a").toString());
        Map<String,Object> m2 = (Map<String,Object>)s3;
        //System.out.println(m2.get("name"));


        //System.out.println("---------------");
        Map<String, List<Person>> pageParameters=new HashMap<String,List<Person>>();
        List<Person> list=new ArrayList<Person>();
        list.add(p);
        list.add(p11);
        pageParameters.put("p",list);
        String json=JSON.toJSONString(pageParameters);
        JSONObject jsonO=JSONObject.parseObject(json);
        Map<String,Object> mapp=(Map<String,Object>)jsonO;
       // System.out.println(mapp.get("p"));

        String json1=JSON.toJSONString(mapp.get("p"));
       JSONArray jsonO1=JSONObject.parseArray(json1);
        List<Object> pp=(List<Object>)jsonO1;
        List<Person> pv=new ArrayList<Person>();
        for (Object o:pp){
            String str1 = JSON.toJSONString(o);
            Person infoDo111 = JSON.parseObject(str1, Person.class);
            pv.add(infoDo111);
        }

        for (Person pd:pv){
            //System.out.println(pd.getId()+"-======");
        }
       // List<Person> li=(List<Person>)jsonO1;
        //for (Person l:li){
           // Person ps=(Person)l;
          //  System.out.println(l.getId()+"-------");



        //System.out.println(")))))))))))))))))))))))");
        List<String> list1 =new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        String s=JSON.toJSONString(list1);
        JSONArray j1=JSONObject.parseArray(s);
        List<Object> p1=(List<Object>)j1;
       // System.out.println(p1.size()+"mmmmmmmmmmmmmmmmmmmm");
        List<String> list2 =new ArrayList<String>();
        for (Object o:p1){
            String str1 = JSON.toJSONString(o);
            String infoDo1 = JSON.parseObject(str1, String.class);
            list2.add(infoDo1);
        }
        String[] arr = list2.toArray(new String[list2.size()]);
        //System.out.println(arr[1]+"-----rrrrrrrrrrrr---");



        LinkedHashMap<Object,Object> d=getMapValueForLinkedHashMap(map11);
        Person pd=(Person)d.get("a");
        System.out.println(pd.getId()+"-======fffffffffff========");






    }
    /**
     * 将Map转换为LinkedHashMap（不带key）
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
