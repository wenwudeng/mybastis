package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Category;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*入门
* crud
* 模糊查询
* 多条件查询Tets*/
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        listAll(session,"第一次查询");

        /*指定查询*/
        Category c = session.selectOne("getCategory", 2);
        System.out.println("指定查询"+c.getName());

         /*增加*/
        Category c1 = new Category();
        c1.setName("王者荣耀");
        session.insert("addCategory", c1);
        listAll(session,"增加操作");

       /*删除*/
        Category c2 = new Category();
        c2.setId(3);
        session.delete("deleteCategory", c2);
        listAll(session,"删除操作");

      /* 修改*/
        Category c3 = new Category();
        c3.setName("QQ飞车");
        c3.setId(2);
        session.update("updateCategory", c3);
        listAll(session,"修改操作");


        /*模糊查询*/
        List<Category> cs1 = session.selectList("listSelectByName", "打野");
        System.out.println("=====模糊查询=====");
        for (Category cs2: cs1) {
            System.out.println(cs2.getId()+" "+cs2.getName());
        }


        /*多条件查询*/
        Map<String, Object> params = new HashMap<>();
        params.put("id", 3);
        params.put("name", "打野");
        List<Category> cs3 = session.selectList("listCategoryByNameAndId", params);
        System.out.println("===========多条件查询=========");
        for (Category c5 : cs3) {
            System.out.println(c5.getId()+" "+c5.getName());
        }

    }

    /*查询所有*/
    public static void listAll(SqlSession session,String oper) {

        List<Category> cs = session.selectList("listCategory");
        System.out.println("========"+oper+"=====");
        for (Category c : cs)
            System.out.println(c.getId()+" "+c.getName());
        }
}



