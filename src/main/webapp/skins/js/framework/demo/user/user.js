$(function () {
  //更多搜索
  $("body").on("click", "#search", function () {
    query();
  });
  $("#moresearch").popover({
    title: "",
    content: $("#searchpanel").html(),
    placement: "bottom",
    html: true,
    trigger: "click"
  });
  $("#testBtn").bind("click", function () {
    alert("ceshi");
    //$("#test1").html("测试");
  });
  //条件查询
  $("#query").bind("click", query);

  $("#userName").bind('keypress', function (event) {
    if (event.keyCode == "13") {
      query();
    }
  });

});
function query() {
  var userId = $("#userId").val();
  var userName = $("#userName").val();
  if (userId == undefined) {
    userId = "";
  }

  if (userName.length > 0 & userName.replace(/%/g, "") == "") {
    $.dialog({
      type: "alert",
      content: L.getLocaleMessage("user.tips.input", "非法输入!"),
      autofocus: true,
    });
    return;
  } else {
    if (userId.length > 0 & userId.replace(/%/g, "") == "") {
      $.dialog({
        type: "alert",
        content: L.getLocaleMessage("user.tips.input", "非法输入!"),
        autofocus: true,
      });
      return;
    } else {
      var url = context + "/service/framework/demo/user/query";
      var param = {"userId": userId, "userName": userName};
      url = encodeURI(url, "utf-8");
      grid.reload(url, param);
    }

  }


// 	匹配数值类型
//	 if((/^\d*$/).test(userId)|| userId == ""){
//		 var url = context + "/service/framework/demo/user/query";
//		 var param={"userId":userId,"userName":userName};
//		 url=encodeURI(url,"utf-8"); 
///*		 oTable.ajax.url(url).load();
//*/	     grid.reload(url,param);
//		 }else{
//		 $.dialog({
//			 type:"alert",
//			 content:L.getLocaleMessage("user.tips","用户ID应为数值型!"),
//			 autofocus: true,
//		 });
//	 }

}
//checkbox全选 
function selectAll(obj, iteName) {
  if (obj.checked) {
    $("input[name='checkList']").each(function () {
      this.checked = true;
    });
  } else {
    $("input[name='checkList']").each(function () {
      this.checked = false;
    });
  }
}


//获取选中的复选框的记录
function getCheckBoxValue(attrKey) {
  var confCheckBox = $("input:checkbox[name=" + attrKey + "]");
  var selectedValue = "";
  for (var i = 0; i < confCheckBox.length; i++) {
    if (confCheckBox[i].checked) {
      if ("" == selectedValue) {
        selectedValue = confCheckBox[i].value;
      } else {

        selectedValue = selectedValue + "," + confCheckBox[i].value;
      }
    }
  }
  return selectedValue;
}