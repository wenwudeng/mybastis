package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*多对多查询*/
public class TestMyBatis3 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        addOrderItem(session);
        //deleteOrderItem(session);
        listOrder(session);


    }

    /*建立关系*/
    private static void addOrderItem(SqlSession session) {
        Order order = session.selectOne("getOrder", 1);
        System.out.println("order"+order);
        Product product = session.selectOne("getProduct", 6);
        System.out.println("product"+product);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setNumber(200);
        session.insert("addOrderItem", orderItem);
    }

    /*删除关系*/
    public static void deleteOrderItem(SqlSession session) {
        Order order = session.selectOne("getOrder", 1);
        Product product = session.selectOne("getProduct", 6);
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        session.delete("deleteOrderItem", orderItem);
    }

    /*多对多查询操作*/
    private static void listOrder(SqlSession sqlsession) {
        List<Order> os = sqlsession.selectList("listOrder");
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            for (OrderItem oi : ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
            }
        }
    }
}
