package czy.taotao.consumer.controller;



import czy.taotao.consumer.model.Goods;
import czy.taotao.consumer.remote.GoodsRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/consumer")
public class GoodsController {
	
	
	@Autowired
	private GoodsRemote goodsRemote;
		
	@GetMapping("/goods/all")
	public Goods[] getGoodses(){
		return this.goodsRemote.getGoodses();
	}


}
