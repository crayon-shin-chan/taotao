package czy.taotao.shop.controller;

import java.util.List;
import java.util.ArrayList;
import java.lang.Exception;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import czy.taotao.shop.model.Goods;
import czy.taotao.shop.exception.HttpException;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	private List<Goods> goods ;
	
	public GoodsController(){
		this.goods = new ArrayList<Goods>(3);
		this.goods.add(new Goods("手机",1800));
		this.goods.add(new Goods("笔记本",5000));
		this.goods.add(new Goods("排骨",30));
	}
	
	/*所有请求方法都映射*/
	@RequestMapping("/all")
	public List<Goods> getGoodses(){
		return goods;
	}
	
	@RequestMapping("/{id}")
	public Goods getGoodsById(@PathVariable() int id) throws Exception{
		throw new HttpException("测试异常",HttpStatus.BAD_REQUEST);
		//return goods.get(id);
	}

}
