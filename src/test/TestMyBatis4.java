package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*动态SQL*/
public class TestMyBatis4 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

/*
        */
/*动态SQL-if测试*//*

        System.out.println("查询所有");
        List<Product> products = session.selectList("ifListProduct");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("模糊查询");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "a");
        List<Product> products1 = session.selectList("ifListProduct",map);
        for (Product p : products1) {
            System.out.println(p);
        }

        */
/*动态SQL-where测试*//*

        System.out.println("多条件查询");
        Map<String, Object> map1 = new HashMap<>();
        //map1.put("name", "a");
        map1.put("price", "10");
        List<Product> products12 = session.selectList("whereListProduct",map1);
        for (Product p : products12) {
            System.out.println(p);
        }
*/
/*        *//*动态SQL-set*//*
        Product product = new Product();
        product.setId(5);
        product.setName("王者荣耀");
        product.setPrice(99.99f);
        session.update("setUpdateProduct", product);

        List<Product> products2 = session.selectList("ifListProduct");
        for (Product p : products2) {
            System.out.println(p);
        }*/

/*        *//*动态SQL-when-otherwise*//*
        Map<String,Object> params = new HashMap<>();
        //params.put("name","a");
        //params.put("price","10");
        List<Product> ps = session.selectList("whenListProduct",params);
        for (Product p : ps) {
            System.out.println(p);
        }*/

  /*      *//*动态SQL-foreach*//*
        List<Integer> ids = new ArrayList();
        ids.add(1);
        ids.add(3);
        ids.add(5);

        List<Product> ps6 = session.selectList("foreachListProduct",ids);
        for (Product p : ps6) {
            System.out.println(p);
        }*/

        /*动态SQL-bind*/
        Map<String, String> params =new HashMap();
        params.put("name", "product");

        List<Product> ps = session.selectList("bindListProduct",params);
        for (Product p : ps) {
            System.out.println(p);
        }



    }



}
