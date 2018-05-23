<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
  <meta charset="UTF-8">
  <title>登录</title>
  <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/dist/resource/center/css/index.css" />
  <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/jquery.min.js"></script>
  <style type="text/css">
  .c-login .my_form .img_code input[type=text]{width: 118px;float: left;}
  .c-login .my_form .img_code img{cursor:pointer;margin-left: 10px;border: 1px #bababa solid;}
  .c-login .my_form .img_code div.change_img{height:35px;line-height: 16px;border: 1px #bababa solid;border-left: 0;}
  </style>
</head>
<body class="c-login">
  <div class="header">
    <div class="w1000 clearfix">
      <div class="fl">
        <img class="hd_logo" src="${request.contextPath}/static/dist/resource/center/image/sign/header_logo.png">
      </div>
      <ul class="hd_menu menu_right fr">
        <li>
          <a href="/" attr-title="首页">
            <div class="hd_4"></div>
          </a>
        </li>
        <li>
          <a href="http://www.new4s.com" target="_blank" attr-title="官网">
            <div class="hd_5"></div>
          </a>
        </li>
        <li>
          <a href="http://bbs.new4s.com" target="_blank" attr-title="论坛">
            <div class="hd_1"></div>
          </a>
        </li>
        <li id="onlineService">
          <a href="javascript:void(0);" attr-title="客服">
            <div class="hd_2"></div>
          </a>
        </li>
      </ul>
    </div>
  </div>
  <div class="content">
    <div class='w1000'>
      <div class="clearfix">
        <div class="img_box fl" style="margin-top:120px;">
          <!-- <span>赋能数字化汽车经销商</span> -->
          <!-- <p>构建集成的全业务链一体化的数字营销管理平台 </p> -->
        </div>
        <form class="my_form fr" action="/doLogin" method="post" onsubmit="return Sys.Form(this);">
          <h1>账户登录</h1>
          <div class="row_group">
            <input type="text" name="username" value="admin" placeholder="登录帐号" maxlength="11">
          </div>
          <div class="row_group">
            <input type="password" name="password" value="123456" placeholder="登录密码" maxlength="20">
          </div>
          <div class="row_group img_code">
            <input type="text" name="code" value="" placeholder="图形验证码" maxlength="6">
            <img id="num" src="/getCode?%27+(new%20Date()).getTime()" height="27px;" width="83px" style="cursor:pointer" onclick="document.getElementById('num').src='/getCode?'+(new Date()).getTime()">
            <div class="change_img">
            <a href="#" onclick="document.getElementById('num').src='/getCode?'+(new Date()).getTime()">看不清换一张</a><br>(不区分大小写)</div>
            <div style="clear:both"></div>
          </div>
          <div class="row_group" data-key="tips">${ret?if_exists}</div>
          <div class="row_group">
            <input type="submit" class="form_button" name="" value="登录">
          </div>         
        </form>
      </div>
    </div>
  </div>
  <div class="footer">
    <div class="w1000">
      <img src="${request.contextPath}/static/dist/resource/center/image/sign/footer_img.png">
      <span>Copyright © 2012-2018 new4s.com 车巡版权所有   浙ICP备13014457号-2号</span>
    </div>
  </div>
</body>
<script charset="utf-8" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
<script type="text/javascript">
var doScript = document.createElement('script');
  doScript.innerText = "BizQQWPA.addCustom({aty: '0',nameAccount: '4006390520',selector: 'onlineService'});";
  document.body.appendChild(doScript);
</script>
<script type="text/javascript" src="${request.contextPath}/static/dist/resource/center/js/sign.in.js"></script>
<script type="text/javascript">
Sys.Form = function(form){
  var form = $(form);
  var p = {
    'username'  : form.find(':text[name="username"]').val(),
    'password': form.find(':password[name="password"]').val(),
    tips: form.find('[data-key="tips"]')
  }
//  if(!Sys.rule('mobile',p['username']) || !Sys.rule('password',p['password'])){
//    p.tips.text('请输入正确的账号和密码！');
//    return false;
//  }
  p.tips.text('');
  return Sys.submit();
}
</script>
</html>