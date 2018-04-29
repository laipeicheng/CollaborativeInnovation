layui.use(['layedit', 'form', 'layer', 'laypage'], function(){
    var layedit = layui.layedit
	,form = layui.form
	,layer = layui.layer
	,laypage = layui.laypage;
	
    layedit.set({
      uploadImage: {
        url: '#' //接口url
        ,type: 'post' //默认post
      }
    });

   editIndex = layedit.build('reply',{
      height: 150, //设置编辑器高度
      tool: ['strong', 'italic', 'underline', 'left', 'center', 'right', '|', 'link', 'image', 'code']
    }); //建立编辑器

	//只显示上一页、下一页
	laypage.render({
		elem: 'page_reply'
		,count: 20
		//['count', 'prev', 'page', 'next', 'limit', 'skip']
		,layout: ['prev', 'page', 'next']
		,jump: function(obj, first){
		  if(!first){
			layer.msg('第 '+ obj.curr +' 页');
		  }
		}
	});
});

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



