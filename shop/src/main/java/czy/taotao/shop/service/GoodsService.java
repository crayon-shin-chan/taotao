package czy.taotao.shop.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import czy.taotao.shop.model.Goods;
import czy.taotao.shop.mapper.GoodsMapper;
import czy.taotao.shop.exception.HttpException;

@Service
public class GoodsService {
	
	@Autowired
	GoodsMapper goodsMapper;
	
	public List<Goods> selectAll(){
		return this.goodsMapper.selectAll();
	}
	
	public Goods selectById(int id) throws HttpException{
		Goods goods = this.goodsMapper.selectById(id);
		if(goods==null){
			throw new HttpException("id="+id+"商品不存在",HttpStatus.NOT_FOUND);
		}
		return goods;
	}
	
	public Goods selectByName(String name) throws HttpException{
		Goods goods = this.goodsMapper.selectByName(name);
		if(goods==null){
			throw new HttpException("name="+name+"商品不存在",HttpStatus.NOT_FOUND);
		}
		return goods;
	}
	
	public void insert(Goods goods){
		this.goodsMapper.insert(goods);
	}
	
	public void update(Goods goods){
		this.goodsMapper.update(goods);
	}
	
	public void delete(int id) throws HttpException{
		Goods goods = this.goodsMapper.selectById(id);
		if(goods==null){
			throw new HttpException("id="+id+"商品不存在",HttpStatus.NOT_FOUND);
		}
		this.goodsMapper.delete(id);
	}

}
