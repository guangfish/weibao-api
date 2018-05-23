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
    <a data-mstate="0" href="list" class="active">数据总览</a>
    <a data-mstate="1" href="listDetail">查询明细</a>
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
                <option value="channelname">渠道简称</option>
                <!--<option value="province-city">省份-城市</option>-->
            </select>
        </div><div class="req_value search_write_box" attr-box>
            <input class="input-text search_write" placeholder="请输入关键词" name="" />
        </div>
        <div class="req_value disn search_group_box" attr-box>
            <select class="z-select" data-fname="province" name="province" data-prompt="请选择省份"></select>
            <select class="z-select" data-fname="city" name="city" data-prompt="请选择城市"></select>
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
    //{field:'ck',checkbox:true},
    {field:'channelName',title:'渠道简称',width:160,align:'center'},
    {field:'total',title:'查询总次数',width:160,align:'center'},
    {field:'success',title:'成功次数',width:160,align:'center'},
    {field:'fail',title:'失败次数',width:160,align:'center'},
    {field:'reject',title:'驳回次数',width:160,align:'center'},
    {field:'checking',title:'审核中次数',width:160,align:'center'},
    {field:'norecord',title:'无记录次数',width:160,align:'center'}
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

Core.Easyui.get('/api/order/list');

$(document).ready(function(){
    //初始化省份城市数据
    $.zSelectGroup([{
        elem: $('select[data-fname="province"]'),
        // setValue:'21',
        valueField: 'id',
        textField: 'name',
        url: '${request.contextPath}/static/dist/resource/jsondata/new4s_xs_province.json?level=1',
        dataFitler: function(result) {
            return result.rows;
        }
    }, {
        elem: $('select[data-fname="city"]'),
        // setValue:'121',
        valueField: 'id',
        textField: 'name',
        url: '${request.contextPath}/static/dist/resource/jsondata/new4s_xs_province.json?level=2&pid=@parentValue',
        dataFitler: function(result) {
            return result.rows;
        }
    }]);

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

        if($.inArray(_key,['province-city'])!=-1){
            //省份城市
            _f.find('.search_group_box').removeClass('disn');
            _f.find('.search_group_box').find('.zs-input').each(function(){
                $(this).removeAttr('disabled');
            })
        }else{
            _f.find('.search_write_box').removeClass('disn');
            _f.find('.search_write_box').find('input.search_write').removeAttr('disabled').attr('name', _key);
        }
    })

    //默认搜索渠道简称
    $('.search_key').setZsValue('channelname');

    //导出数据
    function dataoutFun(ids){
        window.open('/api/ordertotal/export?searchcondition='+$('.search_key').getZsValue()+'&'+$('.search_write').attr('name')+'='+$('.search_write').val()+'&starttime='+$('.start-time').val()+'&endtime='+$('.end-time').val());
    }

    //操作表格
    $(document).on('click', '.ctrl_links a',function(e){
        dataoutFun();
    })
});



</script>