package czy.taotao.shop.controller;

import java.util.List;
import java.util.ArrayList;
import czy.taotao.shop.model.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController("GoodsController")
public class GoodsController {

	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public List<User> goods() {
		List<User> list = new ArrayList(3);
		User user1 = new User();
		user1.setName("张三");
		user1.setAge(23);
		User user2 = new User();
		user2.setName("李四");
		user2.setAge(56);
		list.add(user1);
		list.add(user2);
		list.add(null);
		return list;
	}

}
