package czy.taotao.shop.controller;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import czy.taotao.shop.model.Goods;
import czy.taotao.shop.service.GoodsService;
import czy.taotao.shop.exception.HttpException;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private GoodsService goodsService;
	
	/*所有请求方法都映射*/
	@RequestMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Goods> getGoodses(){
		logger.info("获取所有商品");
		return this.goodsService.selectAll();
	}
	
	/*路径参数位置相同时，会导致路由路径模糊不清，如/{id}与/{name}*/
	@RequestMapping("/id/{id}")
	public Goods getGoodsById(@PathVariable() Integer id) throws HttpException{
		logger.info("获取指定id商品"+id);
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
