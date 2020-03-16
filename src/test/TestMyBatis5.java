package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Category;
import mapper.CategoryMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*注解测试CRUD*/
public class TestMyBatis5 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        CategoryMapper mapper = session.getMapper(CategoryMapper.class);

        //add(mapper);
        //delete(mapper);
        update(mapper);
        //listAll(mapper);

/*        session.commit();
        session.close();*/

    }

    public static void add(CategoryMapper mapper) {
        Category c = new Category();
        c.setName("英雄联盟");
        mapper.add(c);
        listAll(mapper);
    }

    public static void delete(CategoryMapper mapper) {
        mapper.delete(20);
        listAll(mapper);
    }

    public static void get(CategoryMapper mapper) {
        Category c = mapper.get(1);
        System.out.println(c.getName());
    }

    public static void update(CategoryMapper mapper) {
        Category c = new Category();
        c.setName("update了！");
        c.setId(12);
        mapper.update(c);
        listAll(mapper);
    }

    private static void listAll(CategoryMapper mapper) {
        List<Category> list = mapper.getAll();
        for (Category c : list) {
            System.out.println(c.getId()+" "+c.getName());
        }
    }

}
