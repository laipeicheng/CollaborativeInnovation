function getReply(){
	layui.use(['layedit','layer','form'], function(){
		var layedit = layui.layedit
			,layer = layui.layer
			,form = layui.form;
			
		//自定义验证规则
		  form.verify({
			reply: function(value){
				var reply = layedit.getContent(editIndex);  //获取编辑器的内容
				if(reply.length <= 0){
					return '文章内容不能为空';
				}else{
					//获取添加的ui
					var ul = document.getElementById("jieda");
					//创建li
					var li = document.createElement("li");
					//设置id="newli"  data-id='14'
					li.setAttribute("id", "newli");
					li.setAttribute("data-id", "14");
					li.innerHTML = html;
　　					ul.appendChild(li);
					document.getElementById("testReply").innerHTML = reply;
					console.log(reply);
				}
			}
		  });
	});
}



