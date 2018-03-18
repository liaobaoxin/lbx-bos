package com.lbx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbx.domain.BaseOrder;
import com.lbx.domain.BaseOrderExample;
import com.lbx.mapper.BaseOrderMapper;
import com.lbx.service.QuickService;
import com.lbx.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Create by lbx on 2018/3/17  10:14
 **/
@Service
public class QuickServiceImpl implements QuickService {

    @Autowired
    BaseOrderMapper baseOrderMapper;

    @Override
    public Integer Insert(BaseOrder baseOrder) {
        baseOrder.setAddTime(new Date());
        baseOrder.setIsDelete(false);
        baseOrder.setExportCourier(false);
        return baseOrderMapper.insert(baseOrder);
    }

    @Override
    public PageBean findList(PageBean pageBean) {
        PageHelper.startPage(pageBean.getPage(), pageBean.getRows());

        BaseOrderExample example = new BaseOrderExample();
        //按时间降序
        example.setOrderByClause("add_time desc");


        //创建查询条件
        BaseOrderExample.Criteria criteria = example.createCriteria();

        //查找前五天的记录
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -5);
        Date time = calendar.getTime();
        criteria.andAddTimeGreaterThan(time);

        criteria.andIsDeleteEqualTo(false);

        List<BaseOrder> baseOrders = baseOrderMapper.selectByExample(example);

        pageBean.setRowList(baseOrders);
        PageInfo<BaseOrder> pageInfo = new PageInfo<>(baseOrders);
        pageBean.setTotal(pageInfo.getTotal());
        return pageBean;
    }

    @Override
    public List<BaseOrder> findListByOrderNumIsZero() {
        BaseOrderExample example = new BaseOrderExample();
        BaseOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNumNotEqualTo("0");
        criteria.andIsDeleteEqualTo(false);
        List<BaseOrder> baseOrders = baseOrderMapper.selectByExample(example);
        return baseOrders;
    }

    @Override
    public Integer deleteById(String[] ids) {
        for (String id : ids) {
            BaseOrder order = new BaseOrder();
            order.setId(Integer.parseInt(id));
            order.setIsDelete(true);
            baseOrderMapper.updateByPrimaryKeySelective(order);
        }
        return null;
    }

    @Override
    public Integer updataById(BaseOrder baseOrder) {
        baseOrder.setUpdateTime(new Date());
        int i = baseOrderMapper.updateByPrimaryKeySelective(baseOrder);
        return i;
    }

    @Override
    public Integer batchInsertOrder(List<BaseOrder> baseOrderList) {
        for (BaseOrder baseOrder : baseOrderList) {
            int i = baseOrderMapper.insertSelective(baseOrder);
        }
        return null;
    }
}
