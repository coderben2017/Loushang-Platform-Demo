/**
 * @file the JavaScript file of queryemp.jsp
 * @author Jin Ben(jinben@inspur.com)
 *         Song Xiaoyu(songxiaoyu@inspur.com)
 */

$(document).ready(function(){
  initDOM();
  initEvent();
});

function initDOM(){
  // 初始化表格
  var options = {};
  var url = context + "/service/framework/personmanagment/query";
  grid = new L.FlexGrid("personList",url);
  grid.init(options);
}

function initEvent(){
  // 绑定“查询”按钮事件
  $(document).on("click", "#search", function (){
    var personId = $("#searchVal").val();
    var personName = $("#searchNameVal").val();
    query(personId, personName);
  });

  // 绑定“同事”按钮点击事件
  $(document).on("click", ".colleague", function (){
    if($("#companyList").css("display") !== "none"){
      $("#companyList tbody tr").remove();
      $("#companyList").hide();
    }

    var $table = $("#colleagueList");
    var empId = $(this).parent().siblings(":first").text();
    $.ajax({
      type: "get",
      url: context + "/service/framework/personmanagment/queryColleague/" + empId,
      dataType: "json",
      success: function (response){
        var $tbody = $("#colleagueList tbody");
        if($tbody.children()){
          $tbody.children().remove();
        }
        $.each(response, function (index){
          var $tr = $("<tr>" +
                        "<td>" + response[index].personId + "</td>" +
                        "<td>" + response[index].personName + "</td>" +
                        "<td>" + response[index].personNum + "</td>" +
                        "<td>" + response[index].personSex + "</td>" +
                        "<td>" + response[index].personAge + "</td>" +
                        "<td>" + response[index].personBirth + "</td>" +
                        "<td>" + response[index].personAddress + "</td>" +
                        "<td>" + response[index].companyName + "</td>" +
                      "</tr>");
          $tbody.append($tr);
        });
        $(".popup").show();
        $table.show();
      }
    });
  });

  // 绑定“单位”按钮点击事件
  $(document).on("click", ".company", function (){
    if($("#colleagueList").css("display") !== "none"){
      $("#colleagueList tbody tr").remove();
      $("#colleagueList").hide();
    }

    var $table = $("#companyList");
    var empId = $(this).parent().siblings(":nth-child(8)").text();
    $.ajax({
      type: "get",
      url: context + "/service/framework/personmanagment/queryCompany/" + empId,
      dataType: "json",
      success: function (response){
        var $tbody = $("#companyList tbody");
        if($tbody.children()){
          $tbody.children().remove();
        }
        var $tr = $("<tr>" +
                      "<td>" + response.companyName + "</td>" +
                      "<td>" + response.companyProperty + "</td>" +
                      "<td>" + response.companyNum + "</td>" +
                      "<td>" + response.income + "</td>" +
                      "<td>" + response.legalRepresentative + "</td>" +
                   "</tr>");
        $tbody.append($tr);
        $(".popup").show();
        $table.show();
      }
    });
  });

  // 绑定关闭弹窗事件
  $(document).on("click", ".close", function (){
    if($("#colleagueList").css("display") !== "none"){
      $("#colleagueList tbody tr").remove();
      $("#colleagueList").hide();
      $(".popup").hide();
    }else if($("#companyList").css("display") !== "none"){
      $("#companyList tbody tr").remove();
      $("#companyList").hide();
      $(".popup").hide();
    }
  });
}

/**
 * 渲染表格中的“操作”列
 *
 * @param {Object} option 参数描述
 * @param {string} option.url option项描述
 * @param {string=} option.method option项描述，可选参数
 */
function renderoptions(data, type, full) {
  var colleagueBtn = "<a class=\"colleague\" >同事</a>";
  var companyBtn = "<a class=\"company\">单位</a>";
  return colleagueBtn + "&emsp;" + companyBtn;
}

/**
 * 查询函数
 * 可通过“员工ID”、“姓名”进行混合查询
 *
 * @param {Number} personId 员工ID
 * @param {String} personName 员工姓名
 */
function query(personId, personName) {
  if(!personId){
    personId = "";
  }
  if(!personName){
    personName = "";
  }
  var url = context + "/service/framework/personmanagment/query";
  var param = {"personId": personId.trim(), "personName": personName.trim()};
  url = encodeURI(url, "utf-8");
  grid.reload(url, param);
}