var Sys = {
	submit : function(o){
		if(typeof(o)!='object') o = $(":submit");
		o.attr('disabled','disabled');return true;
	},
	rule : function(method,a){
		switch(method){
			case 'mobile':
				var r = /^1[34578]{1}[\d]{9}$/;
			break;case 'pwd':case 'password':
			    var r = /^([a-zA-Z0-9]){5,20}$/;
			break;case '*':
				var r = /[\w\W]+/;
			break;case 'qq':
				var r = /^[1-9]{1}[\d]{4,12}$/;
			break;case 'name':
			    var r = /^[0-9a-zA-Z\u4e00-\u9fa5_-]+$/;
			break;
		}
		return r.test(a);
	},
	apps : function(id){
		$.getJSON('/apps/loader/'+id,function(data){
			try{
				window.location.href = data.link;
			}catch(e){}
		});
	}
};

$(function () {
	$(".hd_menu li a").mouseover(function(e){
		var $this = $(this);
		var link_tit = $this.attr("attr-title");
		if(link_tit&&link_tit!='undefined'){
			if($this.find(".linkTit").length==0){
				$this.append('<em class="linkTit">'+link_tit+'</em>')
				$this.find("em.linkTit").css({
					'z-index':1,
					'position':'absolute',
					'bottom':'-29px',
					'left':'40px',
					'width':'70px',
					'height':'26px',
					'font-size':'14px',
					'line-height':'26px',
					'text-align':'center',
					'border':'1px #767676 solid',
					'background':'#2b2b2b',
					'color':'#fff',
					'font-style':'normal'
				});
			}
		}
	}).mouseout(function(){
		$("em.linkTit").remove();
	})
    /*头部菜单下拉*/
    $(".menu_bar").hover(function () {
        $(this).addClass("nav-over");
    }, function () {
        $(this).removeClass("nav-over");
    });
    /*头部账号下拉*/
    $(".mycount_bar").hover(function () {
        $(this).addClass("nav-over");
    }, function () {
        $(this).removeClass("nav-over");
    })
    if($(window).height()-$(".header").height()-$(".content").height()>200){
    	$(".footer").css("position","fixed");
    }else{
    	$(".footer").css("position","relative");
    }
    $(window).resize(function(){
    	if($(window).height()-$(".header").height()-$(".content").height()>200){
	    	$(".footer").css("position","fixed");
	    }else{
	    	$(".footer").css("position","relative");
	    }
    })
	$("a.apps").click(function(){
		Sys.apps($(this).attr('data-key'));
	})
});

$(function () {//兼容ie8 的input placeholder
    var _events = ['keydown', 'keyup', 'keypress', 'change'];
    var $body = $('body');
    for (var i in _events) {
        $body.on(_events[i], '.pch-cmb .pch-inp', resetPchCmd);
    }
    function resetPchCmd() {
        var $inp = $(this);
        setTimeout(function () {//延时是为了防止事件触发了,但是value值还没有改变
            if ($inp.val()) {
                $inp.parents('.pch-cmb').addClass('has-val');
            } else {
                $inp.parents('.pch-cmb').removeClass('has-val');
            }
        }, 10);
    }
});