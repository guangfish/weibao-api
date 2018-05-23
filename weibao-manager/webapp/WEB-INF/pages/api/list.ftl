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
   
<style type="text/css">
.comapi-cont{
  margin:35px 0 20px 60px;
  max-width: 1050px;
  color:#626262;
}
.comapi-cont span{
  vertical-align: middle;
}
.comapi_table .ct_table{
  border-collapse: collapse;
    width: 100%;
    text-align: center; 
}
.comapi_table .ct_table tr{
  height: 40px;
  background-color: #fff;
  font-size: 12px;
  color: #5d5d5d;
  font-weight: 100;
}
.comapi_table .ct_table tr th{
    background: #ededed;
    color: #333;
}
.comapi_table .ct_table tr td:last-child,.comapi_table .ct_table tr th:last-child{
  text-align: left;
    text-indent: 20px;
}
.comapi_table .ct_table tbody tr{
  border-bottom:1px solid #ededed;
}
.p_title{
  color:#606f7b;
  font-weight: bold;
  margin-top:36px;
}
.comapi-demo{
    max-height: 500px;
    margin: 20px 0 60px;
    background-color: #eeeeee;
    overflow-y: scroll;
    font-size: 14px;
    color: #010101;
    border: 1px #c1c1c1 solid;
    -webkit-border-radius: 3px;
    -moz-border-radius: 3px;
    -o-border-radius: 3px;
    border-radius: 3px;
}
</style>
<div class="comapi">
  <div class="comapi-cont">
    <p>接口地址：<span style="color:#23a8eb;">http://wbapi.new4s.com/api/placeAnOrder</span></p>
    <p>Content-Type：<span>application/x-www-form-urlencoded</span></p> 
    <p>请求方式：<span>HTTP POST或GET</span></p>    
    <p class="p_title"><i></i><span>请求参数说明：</span></p>
    <div class="comapi_table">
      <table class="ct_table" border="0" cellspacing="0" cellpadding="0">
        <tbody>
          <tr class="title">
              <th width="20"></th>
              <th width="110">名称</th>
              <th width="90">类型</th>
              <th width="120">必填</th>
              <th>说明</th>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>channelid</td>
            <td>string</td>
            <td>是</td>
            <td>渠道ID</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>appsecret</td>
            <td>string</td>
            <td>是</td>
            <td>密匙</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>vin</td>
            <td>string</td>
            <td>是</td>
            <td>车架号</td>
          </tr>         
        </tbody>
      </table>
    </div>
   <p class="p_title"><i></i><span>返回参数说明:</span></p>
   <div class="comapi_table">
    <table class="ct_table" border="0" cellspacing="0" cellpadding="0">
      <tbody>
        <tr class="title">
            <th width="20"></th>
            <th width="110">名称</th>
            <th width="90">类型</th>
            <th>说明</th>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>code</td>
          <td>string</td>
          <td>返回状态 100-创建成功 101-缺少渠道ID 102-缺少密匙 103-缺少vin码 104-渠道ID不正确 105-密匙不正确</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>msg</td>
          <td>string</td>
          <td>提示内容</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>result</td>
          <td>object</td>
          <td>结果对象</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;&nbsp;&nbsp;vinCode</td>
          <td>string</td>
          <td>车架号</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;&nbsp;&nbsp;orderTime</td>
          <td>string</td>
          <td>订单创建时间</td>
        </tr>
      </tbody>
    </table>
   </div>
   <div class="comapi-demo">
    <pre>
{
  "code": 100,
  "msg": "订单创建成功",
  "result": {
    "vinCode": "234",
    "orderTime": "2018-05-09 15:02:53"
  }
}
    </pre>
   </div>
</div>
<script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/default.js"></script>
</body>
</html>