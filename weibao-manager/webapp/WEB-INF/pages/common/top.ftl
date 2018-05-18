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
  <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/dist/resource/css/index.css" /> 
  
  ${webHead?if_exists}
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/jquery.min.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/jquery-easyui-1.4.5/easyloader.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/wdatepicker/wdatepicker.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/layer/layer.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/z-select/zs.js"></script>
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/public.core.js"></script>
 </head>
 <body>
 
 <!--顶部导航-->
  <div class="topnav">
    <i class="switch_left icon"></i>
    <a href="/"><img class="logo" src="${request.contextPath}/static/dist/resource/image/logo.png"/></a>
    <div class="fl_right" style="padding-left: 16px;">
        <div class="links">
            <a href="" target="mainIframe" class="top_note" title="消息">
                <i class="icon message"></i>
                <em>2</em>
            </a>
            <a href="" target="mainIframe" class="top_note" title="设置">
                <i class="icon setting"></i>
            </a>
            <div class="users-center">
                <a href="" target="mainIframe" title="用户中心"><i class="icon user"></i></a>
                <div class="lks">
                    <p style="color:#ca1627;font-size:12px;margin:0;"><@shiro.principal />&nbsp;欢迎您！</p>
                    <a href="javascript:;" id="logout" title="退出">退出登录</a>
                </div>
            </div>
        </div> 
    </div>
</div>
