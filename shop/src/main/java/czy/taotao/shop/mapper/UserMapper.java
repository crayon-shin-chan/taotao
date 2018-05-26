package czy.taotao.shop.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Options;
import czy.taotao.shop.model.User;
import java.util.List;

public interface UserMapper {
	
	@Select("select * from user")
	public List<User> selectAll();
	
	@Select("select * from user where id = #{id}")
	public User selectById(Integer id);
	
	@Select("select * from user where name = #{name}")
	public User selectByName(String name);
	
	@Insert("insert into user( name , age) values ( #{name} , #{age} )")
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insert(User user);
	
	@Update("update user set name = #{name} ,age = #{age} where id = #{id}")
	void update(User user);
	
	@Delete("delete from user where id = #{id}")
	int delete(Integer id);

}
