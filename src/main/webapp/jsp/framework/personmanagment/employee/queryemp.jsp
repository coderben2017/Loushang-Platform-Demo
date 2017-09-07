<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>员工档案信息</title>
  <!-- 引入css文件 -->
  <l:link path="css/bootstrap.css,css/font-awesome.css,css/ui.css,css/form.css,css/datatables.css" />
  <l:link path="framework/personmanagment/employee/queryemp.css" />
  <!-- 引入js文件 -->
  <l:script path="jquery.js,bootstrap.js,form.js,datatables.js,loushang-framework.js,ui.js" />
  <l:script path="framework/personmanagment/employee/queryemp.js" />
</head>

<body class="container">
  <!-- 搜索功能区 -->
  <div class="input-group">
    <div class="input-group col-xs-6 col-md-6">
      <input type="text" id="searchVal" class="form-control" style="width:140px;" placeholder="请输入员工ID">
      <input type="text" id="searchNameVal" class="form-control" style="width:140px;" placeholder="请输入员工姓名">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button" id="search">搜索</button>
      </span>
    </div>
  </div>

  <!-- 主表区 -->
  <div class="emp">
    <!-- 员工档案表 -->
    <table id="personList" class="table table-bordered table-hover">
      <thead>
        <tr>
          <th width="10%" data-field="personId" data-sortable="false">员工ID</th>
          <th width="10%" data-field="personName">姓名</th>
          <th width="10%" data-field="personNum">身份证号</th>
          <th width="10%" data-field="personSex">性别</th>
          <th width="10%" data-field="personAge">年龄</th>
          <th width="10%" data-field="personBirth">出生日期</th>
          <th width="10%" data-field="personAddress">家庭住址</th>
          <th width="10%" data-field="companyId">单位号</th>
          <th width="10%" data-field="companyName">单位名</th>
          <th width="10%" data-field="option" data-render="renderoptions">操作</th>
        </tr>
      </thead>
    </table>
  </div>

  <!-- 弹出层 -->
  <div class="popup">
    <p><span class="close">关闭</span></p>
    <!-- 同事表 -->
    <table id="colleagueList" class="table table-bordered table-hover">
      <thead>
        <tr><th>员工ID</th><th>姓名</th><th>身份证号</th><th>性别</th><th>年龄</th><th>出生日期</th>
        <th>家庭住址</th><th>单位</th></tr>
      </thead>
      <tbody></tbody>
    </table>
    <!-- 单位表 -->
    <table id="companyList" class="table table-bordered table-hover">
      <thead>
        <tr><th>单位名</th><th>单位性质</th><th>单位人数</th><th>年收益</th><th>法人代表</th></tr>
      </thead>
      <tbody></tbody>
    </table>
  </div>

  <script type="text/javascript">
    var context = "<%=request.getContextPath()%>";
  </script>
</body>
</html>