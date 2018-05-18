package com.new4s.weibao.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.new4s.weibao.common.DateUtil;
import com.new4s.weibao.common.web.PageConst;
import com.new4s.weibao.entity.BrandInfo;
import com.new4s.weibao.entity.DealerInfo;
import com.new4s.weibao.entity.YqOrderVo;
import com.new4s.weibao.service.IBrandInfoService;
import com.new4s.weibao.service.IDealerInfoService;
import com.new4s.weibao.service.IYqOrderService;
import com.new4s.weibao.vo.web.SearchDataVo;
import com.new4s.weibao.web.BasicController;
import com.new4s.weibao.web.controller.vo.DataStatsVo;
import com.new4s.weibao.web.controller.vo.JsonResult;
import com.new4s.weibao.web.util.SearchUtil;

/**
 * 数据查询Controller
 */
@Controller
public class DataController extends BasicController {
	@Autowired
	IYqOrderService yqOrderService;
	@Autowired
	IDealerInfoService dealerInfoService;
	@Autowired
	IBrandInfoService brandInfoService;

	@RequestMapping(value = "/data/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {				
		String statsRecordStr = yqOrderService.getStatsRecord();
		String[] statsRecordStrs = statsRecordStr.split(",");
		DataStatsVo dataStatsVo = new DataStatsVo();
		dataStatsVo.setTotal(statsRecordStrs[0]);
		dataStatsVo.setChecking(statsRecordStrs[1]);
		dataStatsVo.setQuerying(statsRecordStrs[2]);
		dataStatsVo.setSuccess(statsRecordStrs[3]);
		dataStatsVo.setFail(statsRecordStrs[4]);
		dataStatsVo.setReject(statsRecordStrs[5]);
		dataStatsVo.setNorecord(statsRecordStrs[6]);
		model.addAttribute("bizObj", dataStatsVo);
		
		return PageConst.DATA_LIST;
	}

	@RequestMapping(value = "/data/listDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String listDetail(Model model, HttpServletRequest request) {
		List<DealerInfo> dealerInfoList = dealerInfoService.selectAll();
		List<BrandInfo> brandInfoList = brandInfoService.selectAll();
		String statsRecordStr = yqOrderService.getStatsRecord();
		String[] statsRecordStrs = statsRecordStr.split(",");
		DataStatsVo dataStatsVo = new DataStatsVo();
		dataStatsVo.setTotal(statsRecordStrs[0]);
		dataStatsVo.setChecking(statsRecordStrs[1]);
		dataStatsVo.setQuerying(statsRecordStrs[2]);
		dataStatsVo.setSuccess(statsRecordStrs[3]);
		dataStatsVo.setFail(statsRecordStrs[4]);
		dataStatsVo.setReject(statsRecordStrs[5]);
		dataStatsVo.setNorecord(statsRecordStrs[6]);
		model.addAttribute("bizObj", dataStatsVo);
		model.addAttribute("dealerInfoList", dealerInfoList);
		model.addAttribute("brandInfoList", brandInfoList);

		return PageConst.DATA_LIST_DETAIL;
	}

	@ResponseBody
	@RequestMapping(value = "/api/order/listDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getDatalListDetail(
			@RequestParam(value = "searchcondition", required = false) String searchCondition,
			@RequestParam(value = "channelname", required = false) String channelName,
			@RequestParam(value = "dealername", required = false) Integer dealerId,
			@RequestParam(value = "brandname", required = false) String brandName,
			@RequestParam(value = "vin", required = false) String vin,
			@RequestParam(value = "ckresult", required = false) String status,
			@RequestParam(value = "starttime", required = false) String fromTime,
			@RequestParam(value = "endtime", required = false) String toTime) {
		SearchDataVo vo = SearchUtil.getVo();
		JsonResult result = new JsonResult();
		if (searchCondition != null) {
			if ("channelname".equals(searchCondition)) {
				if (channelName != null) {
					vo.putSearchParam("channelName", channelName, channelName);
				}
			} else if ("vin".equals(searchCondition)) {
				if (vin != null) {
					vo.putSearchParam("vin", vin, vin);
				}
			} else if ("ckresult".equals(searchCondition)) {
				if (status != null) {
					vo.putSearchParam("status", status, status);
				}
			}else if ("dealername".equals(searchCondition)) {
				if (dealerId != null) {
					vo.putSearchParam("dealerId", dealerId+"", dealerId);
				}
			}else if ("brandname".equals(searchCondition)) {
				if (brandName != null) {
					vo.putSearchParam("brandName", brandName, brandName);
				}
			}
		}
		if (fromTime != null) {
			vo.putSearchParam("fromTime", fromTime, fromTime);
		}
		if (toTime != null) {
			vo.putSearchParam("toTime", toTime, toTime);
		}
		yqOrderService.getYqOrderList(vo);
		result.setTotal(vo.getCount()+"");
		result.setRows(vo.getList());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/api/order/list", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getDatalList(
			@RequestParam(value = "searchcondition", required = false) String searchCondition,
			@RequestParam(value = "channelname", required = false) String channelName,
			@RequestParam(value = "starttime", required = false) String fromTime,
			@RequestParam(value = "endtime", required = false) String toTime) {

		SearchDataVo vo = SearchUtil.getVo();
		JsonResult result = new JsonResult();
		if (searchCondition != null) {
			if ("channelname".equals(searchCondition)) {
				if (channelName != null) {
					vo.putSearchParam("channelName", channelName, channelName);
				}
			}
		}
		if (fromTime != null) {
			vo.putSearchParam("fromTime", fromTime, fromTime);
		}
		if (toTime != null) {
			vo.putSearchParam("toTime", toTime, toTime);
		}
		yqOrderService.getStatsRecordList(vo);
		result.setTotal(vo.getCount() + "");
		result.setRows(vo.getList());
		return result;
	}
	
	@RequestMapping(value = "/api/ordertotal/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportTotal(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "searchcondition", required = false) String searchCondition,
			@RequestParam(value = "channelname", required = false) String channelName,
			@RequestParam(value = "starttime", required = false) String fromTime,
			@RequestParam(value = "endtime", required = false) String toTime) {

		Map<String, Object> searchMap = new HashMap<String, Object>();
		if (searchCondition != null) {
			if ("channelname".equals(searchCondition)) {
				if (channelName != null) {
					searchMap.put("channelName", channelName);
				}
			}
		}
		if (fromTime != null) {
			searchMap.put("fromTime", fromTime);
		}
		if (toTime != null) {
			searchMap.put("toTime", toTime);
		}
		List<YqOrderVo> statsRecordList = yqOrderService.getStatsRecordList(searchMap);
		HSSFWorkbook workbook = createOrderTotalExcel(statsRecordList); 
		try {
			// 定义excle名称 UTF-8防止名称乱码
			String msg = new String(("order-total-" + DateUtil.dateFormate(new Date(), "yyyy-MM-dd") + ".xls").getBytes(),
					"UTF-8");
			// 以导出时间作为文件名
			response.setContentType("application/vnd.ms-excel");
			response.addHeader("Content-Disposition", "attachment;filename=" + msg);
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/api/orderdetail/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportDetail(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "searchcondition", required = false) String searchCondition,
			@RequestParam(value = "channelname", required = false) String channelName,
			@RequestParam(value = "dealername", required = false) Integer dealerId,
			@RequestParam(value = "brandname", required = false) String brandName,
			@RequestParam(value = "vin", required = false) String vin,
			@RequestParam(value = "ckresult", required = false) String status,
			@RequestParam(value = "starttime", required = false) String fromTime,
			@RequestParam(value = "endtime", required = false) String toTime) {

		Map<String, Object> searchMap = new HashMap<String, Object>();
		if (searchCondition != null) {
			if ("channelname".equals(searchCondition)) {
				if (channelName != null) {
					searchMap.put("channelName", channelName);
				}
			} else if ("vin".equals(searchCondition)) {
				if (vin != null) {
					searchMap.put("vin", vin);
				}
			} else if ("ckresult".equals(searchCondition)) {
				if (status != null) {
					searchMap.put("status", status);
				}
			}else if ("dealername".equals(searchCondition)) {
				if (dealerId != null) {
					searchMap.put("dealerId", dealerId);
				}
			}else if ("brandname".equals(searchCondition)) {
				if (brandName != null) {
					searchMap.put("brandName", brandName);
				}
			}
		}
		if (fromTime != null) {
			searchMap.put("fromTime", fromTime);
		}
		if (toTime != null) {
			searchMap.put("toTime", toTime);
		}
		List<YqOrderVo> yqOrderVoList = yqOrderService.getYqOrderList(searchMap);
		HSSFWorkbook workbook = createOrderDetailExcel(yqOrderVoList); 
		try {
			// 定义excle名称 UTF-8防止名称乱码
			String msg = new String(("order-detail-" + DateUtil.dateFormate(new Date(), "yyyy-MM-dd") + ".xls").getBytes(),
					"UTF-8");
			// 以导出时间作为文件名
			response.setContentType("application/vnd.ms-excel");
			response.addHeader("Content-Disposition", "attachment;filename=" + msg);
			workbook.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static HSSFWorkbook createOrderTotalExcel(List<YqOrderVo> yqOrderVoList) {
		// 创建一个webbook，对应一个excel文件  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        // 在webbook中添加一个sheet,对应excel文件中的sheet  
        HSSFSheet sheet = workbook.createSheet("数据总览");  
        sheet.setColumnWidth(0, 40 * 100);  
        sheet.setColumnWidth(1, 40 * 100);  
        sheet.setColumnWidth(2, 40 * 100);  
        sheet.setColumnWidth(3, 40 * 100);  
        sheet.setColumnWidth(4, 40 * 100);  
        sheet.setColumnWidth(5, 40 * 100);
        sheet.setColumnWidth(6, 40 * 100);
        
        // 在sheet中添加表头第0行  
        HSSFRow row = sheet.createRow(0);  
        HSSFCell cell = row.createCell(0);  
        cell.setCellValue("渠道名称");
        cell = row.createCell(1);
        cell.setCellValue("查询总次数");
        cell = row.createCell(2);
        cell.setCellValue("成功次数");
        cell = row.createCell(3);  
        cell.setCellValue("失败次数");  
        cell = row.createCell(4);  
        cell.setCellValue("驳回次数");   
        cell = row.createCell(5);  
        cell.setCellValue("审核中次数"); 
        cell = row.createCell(6);  
        cell.setCellValue("无记录次数");
        for (int i = 0; i < yqOrderVoList.size(); i++) {
        	row = sheet.createRow(i + 1);
        	YqOrderVo yqOrderVo=yqOrderVoList.get(i);
        	HSSFCell c1 = row.createCell(0);  
            c1.setCellValue(yqOrderVo.getChannelName());  
            HSSFCell c2 = row.createCell(1);  
            c2.setCellValue(yqOrderVo.getTotal());
            HSSFCell c3 = row.createCell(2);  
            c3.setCellValue(yqOrderVo.getSuccess());
            HSSFCell c4 = row.createCell(3);  
            c4.setCellValue(yqOrderVo.getFail());
            HSSFCell c5 = row.createCell(4);  
            c5.setCellValue(yqOrderVo.getReject());
            HSSFCell c6 = row.createCell(5);  
            c6.setCellValue(yqOrderVo.getChecking());
            HSSFCell c7 = row.createCell(6);  
            c7.setCellValue(yqOrderVo.getNorecord());
        }
        
        return workbook;
	}
	
	public static HSSFWorkbook createOrderDetailExcel(List<YqOrderVo> yqOrderVoList) {
		// 创建一个webbook，对应一个excel文件  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        // 在webbook中添加一个sheet,对应excel文件中的sheet  
        HSSFSheet sheet = workbook.createSheet("订单报表");  
        // 设置列宽  
        sheet.setColumnWidth(0, 40 * 100);  
        sheet.setColumnWidth(1, 40 * 100);  
        sheet.setColumnWidth(2, 40 * 100);  
        sheet.setColumnWidth(3, 40 * 100);  
        sheet.setColumnWidth(4, 40 * 100);  
        sheet.setColumnWidth(5, 40 * 100);
        sheet.setColumnWidth(6, 40 * 100);
        
        // 在sheet中添加表头第0行  
        HSSFRow row = sheet.createRow(0);  
        HSSFCell cell = row.createCell(0);  
        cell.setCellValue("订单号");   
        cell = row.createCell(1);  
        cell.setCellValue("查询车架号(VIN)");  
        cell = row.createCell(2);  
        cell.setCellValue("经销商");  
        cell = row.createCell(3);  
        cell.setCellValue("品牌名称");  
        cell = row.createCell(4);  
        cell.setCellValue("渠道名称");  
        cell = row.createCell(5);  
        cell.setCellValue("查询结果");   
        cell = row.createCell(6);  
        cell.setCellValue("查询时间"); 
        for (int i = 0; i < yqOrderVoList.size(); i++) {
        	row = sheet.createRow(i + 1);
        	YqOrderVo yqOrderVo=yqOrderVoList.get(i);
        	HSSFCell c1 = row.createCell(0);  
            c1.setCellValue(yqOrderVo.getOrderId());  
            HSSFCell c2 = row.createCell(1);  
            c2.setCellValue(yqOrderVo.getVin());
            HSSFCell c3 = row.createCell(2);  
            c3.setCellValue(yqOrderVo.getDealerName());
            HSSFCell c4 = row.createCell(3);  
            c4.setCellValue(yqOrderVo.getBrandName());
            HSSFCell c5 = row.createCell(4);  
            c5.setCellValue(yqOrderVo.getChannelName());
            HSSFCell c6 = row.createCell(5);  
            String status="";
            if(yqOrderVo.getStatus()==0){
            	status="审核中";
            }else if(yqOrderVo.getStatus()==1){
            	status="查询中";
            }else if(yqOrderVo.getStatus()==2){
            	status="查询成功";
            }else if(yqOrderVo.getStatus()==3){
            	status="失败";
            }else if(yqOrderVo.getStatus()==4){
            	status="驳回";
            }else if(yqOrderVo.getStatus()==5){
            	status="无记录";
            }
            c6.setCellValue(status);
            HSSFCell c7 = row.createCell(6);  
            c7.setCellValue(DateUtil.dateFormate(yqOrderVo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        }
		return workbook;
	}

}
