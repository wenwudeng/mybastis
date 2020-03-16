package pojo;


import java.util.List;

public class Order {

  private long id;
  private String code;
  private List<OrderItem> orderItems;

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", orderItems=" + orderItems +
            '}';
  }
}
