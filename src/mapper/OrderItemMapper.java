package mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    /*多对多*/
    @Select(" select * from order_item where oid = #{oid}")
    @Results({
            @Result(property="product",column="pid",one=@One(select="mapper.ProductMapper.get"))
    })
    public List<OrderItem> listByOrder(int oid);
}
