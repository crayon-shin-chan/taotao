package czy.taotao.shop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import czy.taotao.shop.model.Goods;


/* spring boot的Mapper扫描基于Mapper注解
 * decimal类型与double类型不能自由转换
 */
@Mapper
public interface GoodsMapper {
	
	@Select("select * from goods where id = #{id}")
	Goods selectById(int id);
	
	@Select("select * from goods where name = #{name}")
	Goods selectByName(String name);
	
	@Select("select * from goods")
	List<Goods> selectAll();
	
	@Insert("insert into goods (name,price) values (#{name},#{price})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void insert(Goods goods);
	
	@Update("update goods set name = #{name},price = #{price} where id = #{id}")
	void update(Goods goods);
	
	@Delete("delete from goods where id = #{id}")
	void delete(int id);

}
