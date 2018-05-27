package czy.taotao.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import czy.taotao.shop.exception.HttpException;
import org.springframework.stereotype.Service;
import czy.taotao.shop.mapper.UserMapper;
import czy.taotao.shop.model.User;
import java.util.List;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public List<User> findUsers() {
		return this.userMapper.selectAll();
	}

	public User findUserById(int id) throws HttpException{
		User user = this.userMapper.selectById(id);
		if (user == null) {
			throw new HttpException(400,"指定id用户不存在");
		}
		return user;
	}

	public User findUserByName(String name) throws HttpException{
		User user = this.userMapper.selectByName(name);
		if (user == null) {
			throw new HttpException(400,"指定名称用户不存在");
		}
		return user;
	}

	public void insertUser(User user) throws HttpException {
		User exist = this.userMapper.selectByName(user.getName());
		if (exist != null) {
			throw new HttpException(400,"指定名称用户已存在");
		}
		int rows = this.userMapper.insert(user);
		return;
	}

	public void updateUser(User user) throws HttpException {
		User exist = this.userMapper.selectById(user.getId());
		if (exist == null) {
			throw new HttpException(400,"指定id用户不存在");
		}
		this.userMapper.update(user);
		return;
	}

	public void deleteUser(int id) throws HttpException{
		User exist = this.userMapper.selectById(id);
		if (exist == null) {
			throw new HttpException(400,"指定id用户不存在");
		}
		this.userMapper.delete(id);
		return;
	}

}
