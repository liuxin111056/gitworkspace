import java.io.IOException;
import java.io.Reader;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
    public static void main(String[] args) throws IOException {
    	//两种 加载mybatis的配置文件方法
    	//1.使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        //InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        
        //2.使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader("config.xml"); 
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession(); 
        String statement = "com.lx.mapping.UserMapper.getUser";//映射sql的标识字符串
//      com.jsx.mapping.User是User.xml文件中mapper标签的namespace属性的值，
//      getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
       
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}

