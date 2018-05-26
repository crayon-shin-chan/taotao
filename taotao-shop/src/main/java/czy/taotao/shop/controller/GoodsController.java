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
	public List<Integer> goods() {
		List<Integer> list = new ArrayList<Integer>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		return list;
	}

}
