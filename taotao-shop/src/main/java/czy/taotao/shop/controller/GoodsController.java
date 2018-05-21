package czy.taotao.shop.controller;

import czy.taotao.shop.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller("GoodsController")
public class GoodsController {
	
	@RequestMapping(
			value="/goods",
			method=RequestMethod.GET
	)
	public @ResponseBody User goods(){
		User user = new User();
		user.setName("张三");
		user.setAge(23);
		return user;
	}

}
