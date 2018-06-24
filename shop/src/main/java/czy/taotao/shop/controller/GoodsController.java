package czy.taotao.shop.controller;


import java.util.List;
import java.util.ArrayList;
import java.lang.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import czy.taotao.shop.model.Goods;
import czy.taotao.shop.exception.HttpException;
import czy.taotao.shop.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	
	@Autowired
	GoodsService goodsService;
		
	public GoodsController(){}
	
	/*所有请求方法都映射*/
	@RequestMapping("/all")
	public List<Goods> getGoodses(){
		return this.goodsService.selectAll();
	}
	
	/*路径参数位置相同时，会导致路由路径模糊不清，如/{id}与/{name}*/
	@RequestMapping("/id/{id}")
	public Goods getGoodsById(@PathVariable() int id) throws HttpException{
		return this.goodsService.selectById(id);
	}
	
	@RequestMapping("/name/{name}")
	public Goods getGoodsByName(@PathVariable() String name) throws HttpException{
		return this.goodsService.selectByName(name);
	}
	
	@RequestMapping(path="/insert",method=RequestMethod.POST)
	public void insert(@RequestBody Goods goods) throws HttpException{
		this.goodsService.insert(goods);
	}
	
	@RequestMapping(path="/update",method=RequestMethod.POST)
	public void update(@RequestBody Goods goods) throws HttpException{
		this.goodsService.update(goods);
	}

	/*RequestParam参数不能获取json请求参数*/
	@RequestMapping(path="/delete",method=RequestMethod.POST)
	public void delete(@RequestBody Goods goods) throws HttpException{
		this.goodsService.delete(goods.getId());
	}
}
