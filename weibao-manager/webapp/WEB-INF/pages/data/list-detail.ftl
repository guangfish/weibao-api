<!DOCTYPE html>
<html lang="zh-cmn-Hans">
 <head>
  <meta name="google" value="notranslate" /> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  <meta name="renderer" content="webkit" /> 
  <meta charset="utf-8" /> 
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" /> 
  <meta name="format-detection" content="telephone=no" />
  <title></title> 
  <script type="text/javascript">
  var _staticPath = '../resource/';
  </script>
  <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/dist/resource/css/index.css" /> 
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/jquery.min.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/jquery-easyui-1.4.5/easyloader.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/wdatepicker/wdatepicker.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/layer/layer.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/z-select/zs.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/public.core.js"></script>
  
<!--经销商列表-->
<div class="switch_links links">             
    <a data-mstate="0" href="list">数据总览</a>
    <a data-mstate="1" href="listDetail" class="active">查询明细</a>
</div>

<div class="ctrl_links links">
    <a href="" do-key="data_out" id="ctrl_export"><i class="icon data_out_ico"></i>数据导出</a>

    <span style="margin-left:30px;"><a class="tolink" href="javascript:;">查询总次数<strong>${bizObj.total?if_exists}</strong>次</a></span>
    <span><a class="tolink" href="javascript:;">成功次数：<strong>${bizObj.success?if_exists}</strong>次</a></span>
    <span><a class="tolink" href="javascript:;">失败次数：<strong>${bizObj.fail?if_exists}</strong>次</a></span>
    <span><a class="tolink" href="javascript:;">驳回次数：<strong>${bizObj.reject?if_exists}</strong>次</a></span>
</div>

<form class="search_form" onsubmit="return false;">
    <div class="sc_wrap">
        <div class="req_title">搜索条件：</div>
        <div class="req_value">
            <select class="z-select search_key" name="searchcondition">
                <option value="channelname">渠道名称</option>
                <!--<option value="ordernumber">订单号</option> -->
                <option value="vin">查询车架号(VIN)</option>
                <option value="brandname">车辆品牌</option>
                <option value="dealername">经销商</option>
                <option value="ckresult">查询结果</option>
            </select>
        </div><div class="req_value search_write_box" attr-box>
            <input class="input-text search_write" placeholder="请输入关键词" name="" />
        </div>
        <div class="req_value disn search_select_box" attr-box>
            <select class="z-select search_select" name="ckresult">
                <option value="">请选择</option>
                <option value="2">成功</option>
                <option value="3">失败</option>
                <option value="4">驳回</option>
                <option value="0">审核中</option>
                <option value="5">无记录</option>
            </select>
        </div>
        <div class="req_value disn search_select_box_1" attr-box>
            <select class="z-select search_select" name="dealername" id="dealername">
                <option value="">请选择</option>
                <#if (dealerInfoList?exists && dealerInfoList?size > 0)>
                <#list dealerInfoList as res>
                  <option value="${res.id?if_exists}">${res.name?if_exists}</option>
                </#list>
                </#if>
            </select>
        </div>
        <div class="req_value disn search_select_box_2" attr-box>
            <select class="z-select search_select" name="brandname" id="brandname">
                <option value="">请选择</option>
                <#if (brandInfoList?exists && brandInfoList?size > 0)>
                <#list brandInfoList as res>
                  <option value="${res.brand?if_exists}">${res.brand?if_exists}</option>
                </#list>
                </#if>
            </select>
        </div>
        <div class="auto-timelist">
            <hr class="border"/>
            <div class="req_title">时间范围：</div>
            <div class="req_value">
                <input class="input-text date-ico start-time" name="starttime" onclick="WdatePicker()" readonly="readonly" placeholder="开始时间" />
            </div>
            <div class="req_value date_middle">至</div>
            <div class="req_value">
                <input class="input-text date-ico end-time" name="endtime" onclick="WdatePicker()" readonly="readonly" placeholder="结束时间" />
            </div>
        </div>
        <button class="search_btn btn btn-small">搜索</button>
    </div>
</form>

<div class="table_box">
    <table class="table_main" id="datalist"></table>
</div>
<script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/default.js"></script>
</body>
</html>

<script type="text/javascript">
Core.Easyui.FieldColumn = [
    {field:'ck',checkbox:true},
    {field:'orderId',title:'订单号',width:200,align:'center'},
    {field:'vin',title:'查询车架号(VIN)',width:160,align:'center'},
     {field:'dealerName',title:'经销商',width:160,align:'center'},
    {field:'brandName',title:'品牌名称',width:160,align:'center'},  
    {field:'channelName',title:'渠道名称',width:160,align:'center'},
    {title:'查询结果',field:'status',width:160,align:'center',formatter:function(value,row,index){
        if(value=='2'){
          return '成功';
        }else if(value=='3'){
          return '成功';
        }else if(value=='4'){
          return '驳回';
        }else if(value=='5'){
          return '无记录';
        }else if(value=='0'){
          return '审核中';
        }else if(value=='1'){
          return '查询中';
        }       
    }},
    {title:'查询时间',field:'createTime',width:160,align:'center',formatter:function(value,row,index){
        return formatDateTime(value);
    }}
];

Core.Easyui.init({
    grid: $('#datalist'),
    sbar: $('.search_form'),
},Core.Easyui.FieldColumn,{
    idField: 'id',
    fitColumns: true,
    onLoadSuccess:function(data){ 
    },
    onDblClickRow : function(index,row){ 
    }
});

Core.Easyui.get('/api/order/listDetail');

$(document).ready(function(){
    function clearSearch(_f){
        //clear清空所填内容
        _f.find('.req_value[attr-box]').each(function(){
            var _this = $(this);
            if(_this.find('.input-text').length>0){
                _this.find('.input-text').val('').attr('disabled', true).removeAttr('name');
            }
            if(_this.find('select.z-select').length>0){
                _this.find('select.z-select').each(function(){
                    $(this).zsGetBox().find('.zs-input').attr('disabled', true);
                });
            }
        })
    }
    clearSearch($('.search_form'));
    var myoldkey = '';
    //搜索工具栏-下拉框选择搜索类型
    $('.search_form').on('setZsValue','.search_key',function(){
        var _f = $(this).parents('form');
        var _key = $(this).getZsValue();
        if(myoldkey == _key) {return;}
        myoldkey = _key;

        clearSearch(_f);
        _f.find('.req_value[attr-box]').addClass('disn');

        if($.inArray(_key,['ckresult'])!=-1){
            //查询结果
            _f.find('.search_select_box').removeClass('disn');
            _f.find('.search_select_box').find('.zs-input').removeAttr('disabled');
        }else if($.inArray(_key,['dealername'])!=-1){
            _f.find('.search_select_box_1').removeClass('disn');
            _f.find('.search_select_box_1').find('.zs-input').removeAttr('disabled');
        }else if($.inArray(_key,['brandname'])!=-1){
            _f.find('.search_select_box_2').removeClass('disn');
            _f.find('.search_select_box_2').find('.zs-input').removeAttr('disabled');
        }
        else{
            _f.find('.search_write_box').removeClass('disn');
            _f.find('.search_write_box').find('input.search_write').removeAttr('disabled').attr('name', _key);
        }
    })

    //默认搜索商家姓名
    $('.search_key').setZsValue('channelname');

    //导出数据
    function dataoutFun(){
        //alert($('#dealername').getZsValue());
        //alert($('#brandname').getZsValue());
        //alert($('.search_select').getZsValue());
        var conditon=$('.search_key').getZsValue();
        //return;
        //if(conditon=='ckresult'){
          //window.open('/api/orderdetail/export?searchcondition='+$('.search_key').getZsValue()+'&ckresult='+$('.search_select').getZsValue()+'&starttime='+$('.start-time').val()+'&endtime='+$('.end-time').val());
        //}else{
          //window.open('/api/orderdetail/export?searchcondition='+$('.search_key').getZsValue()+'&ckresult='+$('.search_select').getZsValue()+'&'+$('.search_write').attr('name')+'='+$('.search_write').val()+'&dealername='+$('#dealername').getZsValue()+'&brandname='+$('#brandname').getZsValue()+'&starttime='+$('.start-time').val()+'&endtime='+$('.end-time').val());
        //}
        
        window.open('/api/orderdetail/export?searchcondition='+$('.search_key').getZsValue()+'&ckresult='+$('.search_select').getZsValue()+'&'+$('.search_write').attr('name')+'='+$('.search_write').val()+'&dealername='+$('#dealername').getZsValue()+'&brandname='+$('#brandname').getZsValue()+'&starttime='+$('.start-time').val()+'&endtime='+$('.end-time').val());
    }

    //操作表格
    $(document).on('click', '.ctrl_links a',function(e){
       dataoutFun();
    })

});

function formatDateTime(inputTime) {    
    var date = new Date(inputTime);  
    var y = date.getFullYear();    
    var m = date.getMonth() + 1;    
    m = m < 10 ? ('0' + m) : m;    
    var d = date.getDate();    
    d = d < 10 ? ('0' + d) : d;    
    var h = date.getHours();  
    h = h < 10 ? ('0' + h) : h;  
    var minute = date.getMinutes();  
    var second = date.getSeconds();  
    minute = minute < 10 ? ('0' + minute) : minute;    
    second = second < 10 ? ('0' + second) : second;   
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;    
}; 
</script>