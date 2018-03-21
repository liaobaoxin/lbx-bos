package com.lbx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.lbx.domain.BaseOrder;
import com.lbx.domain.BaseOrderExample;
import com.lbx.mapper.BaseOrderMapper;
import com.lbx.service.QuickService;
import com.lbx.utils.DateUtil;
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
    public PageBean findList(PageBean pageBean, String preDate, String sutDate, String keyWord) {

        StringBuilder sql = new StringBuilder();
        sql.append("select * from base_order WHERE is_delete= 0 ");
        if (StringUtil.isNotEmpty(preDate) && StringUtil.isNotEmpty(sutDate)) {
            sql.append("AND DATE(add_time) BETWEEN '" + preDate + "'  AND '" + sutDate + "' ");
        }
        if (StringUtil.isNotEmpty(keyWord)) {
            sql.append("AND NAME LIKE '%" + keyWord + "%' ");
            sql.append("OR telephone LIKE '%" + keyWord + "%'");
            sql.append("OR order_num LIKE '%" + keyWord + "%'");
        }
        sql.append("ORDER BY add_time DESC LIMIT " + pageBean.getPage() + "," + pageBean.getRows() + "");


        StringBuilder countSql = new StringBuilder();
        countSql.append("select count(*) from base_order WHERE is_delete= 0 ");
        if (preDate != null) {
            countSql.append("AND add_time BETWEEN '" + preDate + "'  AND '" + sutDate + "' ");
        }
        if (keyWord != null) {
            countSql.append("AND NAME LIKE '%" + keyWord + "%' ");
            countSql.append("OR telephone LIKE '%" + keyWord + "%'");
            countSql.append("OR order_num LIKE '%" + keyWord + "%'");
        }
        countSql.append("ORDER BY add_time DESC LIMIT " + pageBean.getPage() + "," + pageBean.getRows() + "");

        List<BaseOrder> baseOrders = baseOrderMapper.conditionFind(sql.toString());
        Integer total = baseOrderMapper.conditionFindCount(countSql.toString());
        pageBean.setTotal((long) total);
        pageBean.setRowList(baseOrders);
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
