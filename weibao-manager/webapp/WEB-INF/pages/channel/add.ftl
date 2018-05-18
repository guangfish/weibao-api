<style type="text/css">
.dialog_box .w420{width:420px;}
.dialog_box .w320{width:320px;}
.dialog_box .row{font-size:0;}
.dialog_box .row textarea.input-text{padding:3px 0;text-indent:3px;}
.dialog_box.normal_form p.required_tip{text-indent:101px;}
</style>
<form class="normal_form dialog_box" onsubmit="return false;" id="myDemoDialog" style="padding-top:15px;margin-bottom:0;">
    <input type="hidden" name="channelid" value="${channelid?if_exists}" />
	<div class="row">
	    <div class="field_text">渠道名称：</div>
	    <input class="input-text w420 require" data-field="channelname" name="channelname" value="${channelname?if_exists}" placeholder="请输入渠道名称" />
	</div>
	<div class="row">
	    <label>
	        <div class="field_text">渠道密码：</div>
	        <input class="input-text w320 require" data-field="appsecret" id="appsecret" name="appsecret" value="${appsecret?if_exists}" placeholder="请输入渠道密码"/>
	        <div class="field_text"><a href="#" class="btn btn-mini" onclick="createAppSecret()">生成密匙</a></div>
	    </label>
	</div>
	<div class="row">
	    <label>
	        <div class="field_text">有效期：</div>
	        <input class="input-text date-ico" data-field="validtime" name="validtime" value="${validtime?if_exists}" onclick="WdatePicker()" readonly="readonly" placeholder="有效期" />
	    </label>
	</div>
	<div class="row">
	    <div class="field_text">具体地址：</div>
	    <textarea class="input-text w420" data-field="address" value="${address?if_exists}" name="address"></textarea>
	</div>
	<div class="row">
	    <label>
	        <div class="field_text">联系人：</div>
	        <input type="text" class="input-text require" data-field="people" value="${contacts?if_exists}" name="people" placeholder="请输入联系人"/>
	    </label>
	    <label>
	        <div class="field_text">联系方式：</div>
	        <input type="text" class="input-text require" data-field="mobile" name="mobile" value="${mobile?if_exists}" placeholder="请输入联系方式"/>
	    </label>
	</div>
	<div class="ctrl_bar">
        <button type="submit" class="btn sub_btn" id="dialogFormDemoBtn">保存</button> 
        <a href="#close" class="btn cancle">取消关闭</a>
    </div>
</form>
<script type="text/javascript">
function createAppSecret(){
  $.post("/channel/appsecret", function(data) {
    $("#appsecret").val(data);
  });
}
$(function(){
	Core.InitSelect($('.dialog_box'));

    Core.Form.submit({
        form: $('#myDemoDialog'), //form
        url: '/api/channel/save', //提交url
        successfun: function(result){
           $('.cancle').click();
           //$('.pagination-load').click();
           window.location.reload();
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