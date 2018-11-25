package com.fh.shop.api.list.biz;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.list.mapper.IGoodsMapper;
import com.fh.shop.api.list.po.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class IGoodsServiceImpl implements IGoodsService {
    @Resource
    private IGoodsMapper goodsMapper;


    @Override
    public ServerResponse queryList() {
        List<Goods> goods = goodsMapper.queryList();
        return ServerResponse.success(goods);
    }
}
