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
   
<div class="ctrl_links links">
    <a do-key="edit" id="ctrl_edit"><i class="icon edit_ico"></i>编辑</a>
    <a do-key="insert" id="ctrl_insert"><i class="icon add_ico"></i>添加</a>
</div>

<form class="search_form" onsubmit="return false;">
    <div class="sc_wrap">
        <div class="req_title">搜索条件：</div>
        <div class="req_value">
            <select class="z-select search_key" name="searchcondition">
                <option value="dealername">经销商名称</option>
                <option value="brand">品牌</option>
                <option value="province-city">省份-城市</option>
            </select>
        </div><div class="req_value search_write_box" attr-box>
            <input class="input-text search_write" placeholder="请输入关键词" name="" />
        </div>
        <div class="req_value disn search_group_box" attr-box>
            <select class="z-select" data-fname="province" name="province" data-prompt="请选择省份"></select>
            <select class="z-select" data-fname="city" name="city" data-prompt="请选择城市"></select>
        </div>
        <button class="search_btn btn btn-small">搜索</button>
    </div>
</form>

<div class="table_box">
    <table class="table_main" id="datalist" data-columnskey="index"></table>
</div>
<script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/default.js"></script>
</body>
</html>

<script type="text/javascript">
Core.Easyui.FieldColumn = [
    {field:'ck',checkbox:true},
    {field:'id',title:'经销商ID',width:100,align:'center'},
    {field:'name',title:'经销商名称',width:100,align:'center'},
    {field:'provinceName',title:'省份',width:100,align:'center'},
    {field:'cityName',title:'城市',width:100,align:'center'},
    {field:'address',title:'经销商地址',width:180,align:'center'},
    {field:'brand',title:'品牌',width:100,align:'center'},
    {field:'dmsAccount',title:'DMS账号',width:100,align:'center'},
    {field:'dmsPassword',title:'DMS密码',width:100,align:'center'},
    {field:'createTime',title:'创建时间',width:100,align:'center',sortable:false,formatter:function(value,row,index){
        return formatDateTime(value);
    }}
];
Core.Easyui.init({
    grid: $('#datalist'), //datagrid table
    sbar: $('.search_form'), //datagrid search form
},Core.Easyui.FieldColumn,{
    //idField: 'tid',
    fitColumns: true,
    onLoadSuccess:function(data){ 
    },
    onSortColumn:function (sort, order) {
        try{
            // Core.Easyui.Params.sort(sort,order);
        }catch(e){

        }
    },
    onClickRow:function(index,row){
        // $(this).datagrid('clearSelections');
        // $(this).datagrid('selectRow',index);
    },
    onDblClickRow : function(index,row){
    }
});

Core.Easyui.get('/api/dealer/list');

$(document).ready(function(){
    //初始化省份城市数据
    $.zSelectGroup([{
        elem: $('select[data-fname="province"]'),
        // setValue:'21',
        valueField: 'id',
        textField: 'name',
        //url: '${request.contextPath}/static/dist/resource/jsondata/new4s_xs_province.json?level=1',
        url: '/api/district?level=1',
        dataFitler: function(result) {
            return result.rows;
        }
    }, {
        elem: $('select[data-fname="city"]'),
        // setValue:'121',
        valueField: 'id',
        textField: 'name',
        //url: '${request.contextPath}/static/dist/resource/jsondata/new4s_xs_province.json?level=2&pid=@parentValue',
        url: '/api/district?level=2&pid=@parentValue',
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

        if($.inArray(_key,['infotype'])!=-1){
            //开通类型
            _f.find('.search_select_box').removeClass('disn');
            _f.find('.search_select_box').find('.zs-input').removeAttr('disabled');
        }else if($.inArray(_key,['province-city'])!=-1){
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

    //默认搜索商家姓名
    $('.search_key').setZsValue('dealername');


    function isCanDo(ids, cbk){
        if(ids){
            if(ids.indexOf(',')>=0){
                Core.Dialog.msg('只能选择一条数据进行操作！');
            }else{
                cbk(ids);
            }
        }else{
            Core.Dialog.msg('请选择一条数据进行操作！');
        }
    }
    function insertfun(){
        Core.Dialog.open({
            'title': '添加渠道',
            'width':'590px',
            'height':'300px',
            'url':'/dealer/addoredit'
        })
    }
    function editfun(ids){
        Core.Dialog.open({
            'title': '编辑渠道',
            'width':'590px',
            'height':'320px',
            'url':'/dealer/addoredit?id='+ids
        })
    }
    function passwdfun(){
        Core.Dialog.open({
            'title': '渠道密钥管理',
            'width':'590px',
            'height':'320px',
            'url':'dialog_passwd.html'
        })
    }

    //操作表格
    $(document).on('click', '.ctrl_links a',function(e){
        e.preventDefault();
        var _t = $(this);
        var dokey = _t.attr('do-key');
        var checkedId = Core.getCheckedRowId($('#datalist'),'id');
        var checkedRow = Core.getCheckedRow($('#datalist'));
        switch(dokey){
            case 'insert':
                insertfun();
                break;
            case 'edit': 
                isCanDo(checkedId, editfun);
                break;
            case 'passwd':
                isCanDo(checkedId, passwdfun);
                break;
            default:;
        }
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