package mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pojo.Product;

import java.util.List;

public interface ProductMapper {
    @Select("select * from product_ where cid=#{cid}")
    public List<Product> listByCategory(int cid);

    /*多对一*/
    @Select("select * from product_")
    @Results({
           @Result(property = "category",column = "cid",
                   one = @One(select = "mapper.CategoryMapper.get"))
    })
    public List<Product> list();

    @Select("select * from product_ where id =#{id}")
    public Product get(int id);

}
