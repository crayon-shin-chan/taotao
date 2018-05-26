package czy.taotao.shop.controller;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import czy.taotao.shop.controller.GoodsController;
import czy.taotao.shop.model.User;

public class GoodsControllerTest{
	
	@Test
	public void testGoods(){
		GoodsController gc = new GoodsController();
		List<User> list = gc.goods();
		assertEquals(list.size(),3);
		assertEquals(list.get(0).getAge(),23);
		assertEquals(list.get(0).getName(),"张三");
		assertEquals(list.get(1).getAge(),56);
		assertEquals(list.get(1).getName(),"李四");
	}

}