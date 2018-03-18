package com.lbx.service;

import com.lbx.domain.BaseOrder;
import com.lbx.domain.BaseOrderExample;
import com.lbx.utils.PageBean;

import java.util.List;

/**
 * Create by lbx on 2018/3/17  10:13
 **/
public interface QuickService {
    Integer Insert(BaseOrder baseOrder);

    /**
     * 查找5天内范围的数据
     * 按日期降序
     * @return
     */
    PageBean findList(PageBean pageBean);

    /**
     * 查找没有商品描述的数据
     */
    List<BaseOrder> findListByOrderNumIsZero();

    /**
     * 删除数据
     */
    Integer deleteById(String[] ids);

    /**
     * 修改数据
     */
    Integer updataById(BaseOrder baseOrder);

    Integer batchInsertOrder(List<BaseOrder> baseOrderList);
}
