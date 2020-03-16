package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Category;

import java.util.List;

public interface CategoryMapper {
    @Insert("insert into category_ (name) values(#{name})")
    public int add(Category category);

    @Delete("delete from category_ where id = #{id}")
    public void delete(int id);

    @Select("select * from category_ where id = #{id}")
    public Category get(int id);

    @Select("select * from category_ ")
    public List<Category> getAll();

    @Update("update category_ set name = #{name} where id = #{id}")
    public int update(Category category);

    /*一对多*/

    @Select("select * from category_")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "products", javaType = List.class,
                    column = "id", many = @Many(select = "mapper.ProductMapper.listByCategory"))
    })
    public List<Category> list();

}
