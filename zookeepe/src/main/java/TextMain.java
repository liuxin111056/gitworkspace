import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TextMain {
    public static void main(String[] args) throws Exception {
        TextMain2 tm= new TextMain2("zhanghao" ,"1");//对其进行初始化
        Class clazz=tm.getClass();

            //创建一个属性描述器
            PropertyDescriptor descriptor = new PropertyDescriptor("age",clazz);  //给一个属性，获取值
           // Method method = descriptor.getReadMethod();     //相当于为上面声明的字段设置get方法
           Method method2= descriptor.getWriteMethod();    //为上面声明的字段设置set方法（又称内省）
           // Object ob= method.invoke(tm);
           // System.out.println("name" +":"+ ob);
        Object ob1=method2.invoke(tm,"123");
        System.out.println("age" +":"+ ob1);

        System.out.println(  tm.getAge());
    }
}
