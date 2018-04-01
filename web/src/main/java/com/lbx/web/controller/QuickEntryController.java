package com.lbx.web.controller;

import com.lbx.domain.BaseOrder;
import com.lbx.service.QuickService;
import com.lbx.utils.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Create by lbx on 2018/3/17  9:37
 **/
@Controller
@RequestMapping("/quick")
public class QuickEntryController {

    @Autowired
    QuickService quickService;

    /**
     * 修改数据
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultData update(BaseOrder baseOrder) {
        baseOrder.setAddTime(null);
        quickService.updataById(baseOrder);
        return ResultData.ok();
    }


    /**
     * 快速录入工作单页面
     */
    @RequestMapping("/page")
    public String page() {
        return "qupai/quickEntryWorkList";
    }

    /**
     * 录入信息
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResultData entrySheet(BaseOrder baseOrder) {
        quickService.Insert(baseOrder);
        return ResultData.ok();
    }

    /**
     * 查看工作录入单信息
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultData list(PageBean pageBean, String preDate, String sutDate, String keyWord) {

        quickService.findList(pageBean, preDate, sutDate, keyWord);
        return ResultData.pageData(pageBean.getTotal(), pageBean.getRowList());
    }

    /**
     * 查看工作录入单信息
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultData delete(String ids) {
        quickService.deleteById(ids.split(","));
        return ResultData.ok();
    }


    /**
     * 分区数据导出功能
     *
     * @return
     * @throws IOException
     */
    @RequiresPermissions("quick-export")
    @RequestMapping("/export")
    public void exportXls(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //第一步：查询所有未有订单号的数据
        List<BaseOrder> orderList = quickService.findListByOrderNumIsZero();

        //第二步：使用POI将数据写到Excel文件中
        //在内存中创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建一个标签页
        HSSFSheet sheet = workbook.createSheet("订单数据");
        //设置单元格宽度
        sheet.setColumnWidth(0, (35 * 100));
        sheet.setColumnWidth(1, (35 * 150));
        sheet.setColumnWidth(2, (35 * 500));

        //设置字体样式
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 11);//字号
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//加粗

        //设置内容位置
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中

        //创建标题行
        HSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("姓名");
        headRow.createCell(1).setCellValue("电话");
        headRow.createCell(2).setCellValue("地址");


        for (BaseOrder order : orderList) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(order.getName());
            dataRow.createCell(1).setCellValue(order.getTelephone());
            dataRow.createCell(2).setCellValue(order.getAddress());

        }

        //第三步：使用输出流进行文件下载（一个流、两个头）
        String filename = DateUtil.getStringNowDate() + ".xls";
        String contentType = request.getServletContext().getMimeType(filename);
        ServletOutputStream out = response.getOutputStream();
        response.setContentType(contentType);

        //获取客户端浏览器类型
        String agent = request.getHeader("User-Agent");
        filename = FileUtils.encodeDownloadFilename(filename, agent);
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        workbook.write(out);
    }


    @RequestMapping("/import")
    public String importXls(File orderFile) throws Exception {
        List<BaseOrder> baseOrderList = new ArrayList<>();

        //使用POI解析Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(orderFile));
        //根据名称获得指定Sheet对象
        HSSFSheet hssfSheet = workbook.getSheet("订单数据");
        for (Row row : hssfSheet) {
            int rowNum = row.getRowNum();
            if (rowNum == 0) {
                continue;
            }
            String name = row.getCell(0).getStringCellValue();
            String telphone = row.getCell(1).getStringCellValue();
            String address = row.getCell(2).getStringCellValue();
            String goodsDesc = row.getCell(3).getStringCellValue();
            String orderNum = row.getCell(4).getStringCellValue();

            //包装一个订单对象
            BaseOrder baseOrder = new BaseOrder(name, telphone, address, goodsDesc, orderNum);

            baseOrderList.add(baseOrder);
        }
        //批量保存
        quickService.batchInsertOrder(baseOrderList);
        return "200";
    }


    /**
     * 快递查询
     *
     * @param modelAndView
     * @param orderNum
     * @return
     */
    @RequestMapping("/logisticsState")
    public ModelAndView logisticsState(ModelAndView modelAndView, String orderNum) {
        Map<String, Object> map = LogisticsUtil.expressInforByOrderNum(orderNum);
        List<ExpressJson.DataEntity> tracking = (List<ExpressJson.DataEntity>) map.get("tracking");
        modelAndView.addObject("tracking", tracking);
        if (tracking.size() == 0) {
            modelAndView.addObject("tracking", null);
            String message = (String) map.get("message");
            modelAndView.addObject("message", message);
        }

        modelAndView.setViewName("/qupai/track");
        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/addShortMennsage")
    @ResponseBody
    public ResultData addShortMennsage(String ids) {
        System.out.println(ids);
        return ResultData.ok();
    }


}
