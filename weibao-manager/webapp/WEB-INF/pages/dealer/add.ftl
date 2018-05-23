<style type="text/css">
.dialog_box .w420{width:420px;}
.dialog_box .w320{width:320px;}
.dialog_box .row{font-size:0;}
.dialog_box .row textarea.input-text{padding:3px 0;text-indent:3px;}
.dialog_box.normal_form p.required_tip{text-indent:101px;}
</style>
<form class="normal_form dialog_box" onsubmit="return false;" id="myDemoDialog" style="padding-top:15px;margin-bottom:0;">
    <input type="hidden" name="id" value="${id?if_exists}" />
	<div class="row">
	    <div class="field_text">经销商名称：</div>
	    <input class="input-text w420 require" data-field="name" name="name" value="${name?if_exists}" placeholder="请输入经销商名称" />
	</div>
	<div class="row">    
	    <div class="label_select">
	        <div class="field_text">省份：</div>
	        <select class="z-select" data-field="province" name="province"></select>
	    </div>
	    <div class="label_select">
	        <div class="field_text">城市：</div>
	    	<select class="z-select" data-field="city" name="city"></select>
	    </div>
	    <input type="hidden" data-field="province_name" name="province_name" />
        <input type="hidden" data-field="city_name" name="city_name" />
	</div>
	<div class="row">
	    <label>
	        <div class="field_text">经销商地址：</div>
	        <input class="input-text w420 require" data-field="address" id="appsecret" name="address" value="${address?if_exists}" placeholder="请输入经销商地址"/>
	    </label>
	</div>
	<div class="row">
	    <div class="field_text">品牌：</div>
	    <input type="text" class="input-text w420 require" data-field="brand" value="${brand?if_exists}" name="brand" placeholder="请输入品牌"/>
	</div>
	<div class="row">
	    <label>
	        <div class="field_text">DMS账号：</div>
	        <input type="text" class="input-text require" data-field="dmsaccount" value="${dmsAccount?if_exists}" name="dmsaccount" placeholder="请输入DMS账号"/>
	    </label>
	    <label>
	        <div class="field_text">DMS密码：</div>
	        <input type="text" class="input-text require" data-field="dmspassword" name="dmspassword" value="${dmsPassword?if_exists}" placeholder="请输入DMS密码"/>
	    </label>
	</div>
	<div class="ctrl_bar">
        <button type="submit" class="btn sub_btn" id="dialogFormDemoBtn">保存</button> 
        <a href="#close" class="btn cancle">取消关闭</a>
    </div>
</form>
<script type="text/javascript">
$(function(){
	Core.InitSelect($('.dialog_box'));
	//初始化省份城市数据
    $.zSelectGroup([{
        elem: $('select[data-field="province"]'),
        setValue:'${province?if_exists}', //回填值
        valueField: 'id',
        textField: 'name',
        //url: '${request.contextPath}/static/dist/resource/jsondata/new4s_xs_province.json?level=1',
        url: '/api/district?level=1',
        dataFitler: function(result) {
            return result.rows;
        }
    }, {
        elem: $('select[data-field="city"]'),
        setValue:'${city?if_exists}', //回填值
        valueField: 'id',
        textField: 'name',
        //url: '${request.contextPath}/static/dist/resource/jsondata/new4s_xs_province.json?level=2&pid=@parentValue',
        url: '/api/district?level=2&pid=@parentValue',
        dataFitler: function(result) {
            return result.rows;
        }
    }]);
    
    $('select[data-field="province"], select[data-field="city"]').on('setZsValue', function(){
        var _this = $(this);
        if(!_this.getZsValue()){ return;}
        $('input[data-field="'+_this.attr('data-field')+'_name"]').val(_this.zsGetBox().find('.zs-value').text());
    });

    Core.Form.submit({
        form: $('#myDemoDialog'), //form
        url: '/api/dealer/save', //提交url
        successfun: function(result){
           if(result=="false"){
             Core.Dialog.msg("该经销商已存在，请勿重复提交！");
             return;
           }
           $('.cancle').click();
           //window.location.reload();
           Core.Easyui.dom.datagrid('reload');
        },errorfun: function(error){
        }
    },function(form){
        //表单验证写在此处
        //input-text.require不能为空
        //textarea.require不能为空
        //select require不能不选
        console.log(form);
        var _f = form, _ok = true;
        if($('.require').length>0){
            $('.require').each(function(_i,_t){
                Core.Form.tips.clear(_f);
                var _in = null;
                _in = ($(_t).hasClass('zs-box'))? $(_t).find('input'):(($(_t).hasClass('input-text'))? $(_t):null);
                if(_in && _in.attr('name')!='' && !Core.rule('*', $.trim(_in.val()))){
                    Core.Form.tips.set(_in);
                    _ok = false;
                    return false;
                }
            })
        }
        return _ok;
        //return false;//不能提交
        // return true;//可以提交
    });
})
</script>