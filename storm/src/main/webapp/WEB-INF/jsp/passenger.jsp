<!DOCTYPE html>
<%@ page import="com.project.xxx.core.models.Manager"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>乘客管理3</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">
<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/global/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/select2/select2.css" rel="stylesheet"
	type="text/css" />
<link href="assets/global/css/components.css" id="style_components"
	rel="stylesheet" type="text/css" />
<link href="assets/global/css/plugins.css" rel="stylesheet"
	type="text/css" />
<link href="assets/admin/layout/css/layout.css" rel="stylesheet"
	type="text/css" />
<link id="style_color" href="assets/admin/layout/css/themes/default.css"
	rel="stylesheet" type="text/css" />
<link href="assets/admin/layout/css/custom.css" rel="stylesheet"
	type="text/css" />
<link href="assets/artdialog/ui-dialog.css" rel="stylesheet"
	type="text/css" />
<link rel="shortcut icon" href="images/favicon.ico" />
</head>
<body
	class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
	<div class="page-header navbar navbar-fixed-top">
		<div class="page-header-inner">
			<div class="page-logo">
				<a href="index.do" class="logo-default">拼车查询系统</a>
				<div class="menu-toggler sidebar-toggler"></div>
			</div>
			<div class="hor-menu hor-menu-light hidden-sm hidden-xs">
				<ul class="nav navbar-nav">
					<li class="classic-menu-dropdown "><a href="publish_query.do"> 首页<span
							class="selected"></span>
					</a></li>
					<li class="classic-menu-dropdown "><a href="passenger_query.do">乘客管理
							<span class="selected"></span>
					</a></li>

				</ul>
			</div>

			<div class="top-menu hidden-sm hidden-xs">
				<ul class="nav navbar-nav pull-right">

					<li class="dropdown dropdown-user"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						data-hover="dropdown" data-close-others="true"> <img alt=""
							class="img-circle" src="images/logo.jpg" /> <span
							class="username username-hide-on-mobile"></span> <i
							class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li><a href="user_profile.do"> <i class="icon-user"></i>
									用户中心
							</a></li>
							<li><a href="logout.do"> <i class="icon-key"></i>退出
							</a></li>
						</ul></li>

					<li class="dropdown dropdown-quick-sidebar-toggler"></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="page-container">
		<div class="page-sidebar navbar-collapse collapse">
			<ul class="page-sidebar-menu hidden-sm hidden-xs"
				data-auto-scroll="true" data-slide-speed="200">

				<li class=""><a href="publish_query.do"> <i
						class="fa fa-tree"></i> <span class="title">班次管理</span>
				</a></li>
				<li class=""><a href="passenger_query.do"> <i
						class="fa fa-tree"></i> <span class="title">乘客管理</span>
				</a></li>
			</ul>
		</div>
		<div class="page-content-wrapper">
			<div class="page-content">
				<h3 class="page-title">乘客管理</h3>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">乘客管理</div>
								<div class="actions">
									<div class="btn-group">
										<a class="btn btn-default btn-sm" href="#"
											data-toggle="dropdown" aria-expanded="false"> <i
											class="fa fa-cogs"></i> 工具 <i class="fa fa-angle-down"></i>
										</a>
										<ul class="dropdown-menu pull-right">
											<li><a href="#" id="channelSettleExpBtn"> <i
													class="fa fa-pencil"></i> 导出
											</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="portlet-body">
								<div class="portlet-body form margin-bottom-20">
									<form role="form" method="post" id="queryForm"
										action="publish_query.do">
										<div class="form-body">
											<div class="form-group col-md-3">
												<label class="col-md-3 control-label">cplc:</label>
												<div class="col-md-7">
													<input type="text" class="form-control" placeholder="cplc"
														name="xTsmCplc" id="xTsmCplc" value="">
												</div>
											</div>

											<div class="form-group col-md-3">
												<label class="col-md-3 control-label">卡类别:</label>
												<div class="col-md-7">
													<select name="city_code" id="city_code"
														class="form-control">
														<option value="">全部</option>
														<option value="00">邻南通</option>
														<option value="2">深圳通</option>
													</select>

												</div>
											</div>

											<div class="form-group col-md-3">
												<label class="col-md-3 control-label">卡状态:</label>
												<div class="col-md-7">
													<select name="pay_type" id="pay_type" class="form-control">
														<option value="">全部</option>
														<option value="1">开卡</option>
														<option value="2">圈存</option>
														<option value="3">开卡圈存</option>
														<option value="4">迁出卡</option>
														<option value="5">迁入卡</option>
														<option value="6">迁卡充值</option>
														<option value="7">待删除</option>
														<option value="8">删除成功</option>
													</select>

												</div>
											</div>

											<div class="form-group col-md-3">
												<label class="col-md-3 control-label">创建日期:</label>
												<div class="col-md-7">
													<input type="text" class="form-control" id="datepicker"
														placeholder="创建日期" name="create_date"> <input
														type="hidden" name="hiddenDate" value=''>
												</div>
											</div>

											<input type="submit" id="query_btn" class="btn btn-lg yellow"
												value="查询">
										</div>

										<input type="hidden" name="date_init" value=''> <input
											type="hidden" name="aid" id="aid" value="">
									</form>
								</div>

								<form method="post" id="detailForm" role="form"></form>

								<table class="table table-striped table-bordered table-hover"
									style="white-space: nowrap;">
									<thead>
										<tr>
											<th>ID号</th>
											<th>姓名</th>
											<th>电话号码</th>
											<th>管理员ID</th>
											<th>创建时间</th>
											<th>更新时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="mg">
											<tr>
												<td align="center">${mg.id}</td>
												<td align="center">${mg.name}</td>
												<td align="center">${mg.telNo}</td>
												<td align="center">${mg.managerId}</td>
												<td align="center"><fmt:formatDate
														value="${mg.createTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
												<td align="center"><fmt:formatDate
														value="${mg.updateTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
												<td align="center"><a href="javascript:void:(0);"
													class="btn  blue"
													onclick="view('4790057347015A5401007209016151942608481000000051000004124623C04280010000000000545633','535A542E57414C4C45542E454E56')">详情</a>
													<a href="javascript:void(0);" class="btn  yellow"
													onclick="editView('4790057347015A5401007209016151942608481000000051000004124623C04280010000000000545633','535A542E57414C4C45542E454E56')">修改</a>
													<a href="javascript:void:(0);" class="btn  red"
													onclick="deleteCard('4790057347015A5401007209016151942608481000000051000004124623C04280010000000000545633','535A542E57414C4C45542E454E56')">删除</a></td>
												</td>
												<!-- 自定义标签 -->
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<a href="javascript:;" class="page-quick-sidebar-toggler"><i
			class="icon-close"></i></a>
	</div>



	<div class="page-footer">
		<div class="page-footer-inner"></div>
		<div class="scroll-to-top">
			<i class="icon-arrow-up"></i>
		</div>
	</div>
	<!--[if lt IE 9]>
<script src="assets/global/plugins/respond.min.js"></script>
<script src="assets/global/plugins/excanvas.min.js"></script>
<![endif]-->

	<script src="assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
		type="text/javascript"></script>
	<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
		type="text/javascript"></script>
	<script
		src="assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script
		src="assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<script
		src="assets/global/plugins/bootstrap-daterangepicker/moment.min.js"
		type="text/javascript"></script>
	<script
		src="assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js"
		type="text/javascript"></script>

	<script
		src="assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"
		type="text/javascript"></script>

	<script
		src="assets/global/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"
		type="text/javascript"></script>
	<script
		src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<script src="assets/global/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script src="assets/global/plugins/jquery.cokie.min.js"
		type="text/javascript"></script>
	<script src="assets/global/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<script
		src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<script src="assets/global/scripts/metronic.js" type="text/javascript"></script>
	<script src="assets/admin/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script src="assets/admin/layout/scripts/quick-sidebar.js"
		type="text/javascript"></script>
	<script src="assets/admin/layout/scripts/demo.js"
		type="text/javascript"></script>
	<script src="js/artdialog/dialog-min.js"></script>
	<script src="js/common.js" type="text/javascript"></script>
	<script src="js/clearing.js" type="text/javascript"></script>
	<script src="js/buscard/buscard.js" type="text/javascript"></script>

	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			QuickSidebar.init(); // init quick sidebar
			Demo.init(); // init demo features

			$('.table').dataTable()
		});

		$("#datepicker").val($("input[name='hiddenDate']").val());

		$("#datepicker").datepicker({
			language : "zh-CN",
			autoclose : true,//选中之后自动隐藏日期选择框
			clearBtn : false,//清除按钮
			todayBtn : false,//今日按钮
			format : "yyyy-mm-dd"//日期格式，详见 http://bootstrap-datepicker.readthedocs.org/en/release/options.html#format
		});
	</script>
</body>
</html>