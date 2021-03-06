
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    //导航的hover效果、二级菜单等功能，需要依赖element模块
    var element = layui.element;
    element.init()
});


//返回到顶部
layui.use('util', function(){
  var util = layui.util
  ,laydate = layui.laydate
  ,layer = layui.layer;
  //固定块
  util.fixbar({
    bar1: false
    ,bar2: false
    ,css: {right: 50, bottom: 50}
    ,bgcolor: '#393D49'
    ,click: function(type){
      if(type === 'bar1'){
        layer.msg('icon是可以随便换的')
      } else if(type === 'bar2') {
        layer.msg('两个bar都可以设定是否开启')
      }
    }
  });
});

//所有图片懒加载
layui.use('flow', function(){
  var flow = layui.flow;
  //当你执行这样一个方法时，即对页面中的全部带有lay-src的img元素开启了懒加载（当然你也可以指定相关img）
  flow.lazyimg(); 

});