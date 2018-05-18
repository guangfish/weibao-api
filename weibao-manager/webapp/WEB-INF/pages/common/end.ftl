${webEnd?if_exists}
   <script type="text/javascript" src="${request.contextPath}/static/dist/resource/js/default.js"></script>
   <script>
	$(function(){	
		// 退出
		$('#logout').on('click', function(){
			layer.confirm('您确定要退出当前账号吗？', {
				icon: 3,
				btn: ['确定','取消'] //按钮
			}, function() {
				window.location.href = "/logout";
			});
		});
	});
	</script>
  </body>
</html>