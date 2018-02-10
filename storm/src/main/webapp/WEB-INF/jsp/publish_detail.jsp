<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>公交卡详细</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
    <link id="style_color" href="assets/admin/layout/css/themes/default.css" rel="stylesheet" type="text/css"/>
    <link href="assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="images/favicon.ico"/>
</head>
<style>
    .control-label {
        margin-top: 0
    }
</style>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">





<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner">
		<div class="page-logo">
			<a href="index.do" class="logo-default">nfc查询系统</a>
			<div class="menu-toggler sidebar-toggler"></div>
		</div>
		<div class="hor-menu hor-menu-light hidden-sm hidden-xs">
			<ul class="nav navbar-nav">
				<li
					class="classic-menu-dropdown ">

					<a href="index.do"> 首页<span class="selected"></span>
				</a>
				</li>

				 <li
                        class="classic-menu-dropdown active"><a
                        href="buscard_query.do">公交卡查询 <span class="selected"></span>
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

    <div class="page-content-wrapper">
        <div class="page-content">


            <h3 class="page-title">公交卡详细</h3>
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="merchant_query.do">公交卡详细</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">公交卡详细</a>
                    </li>
                </ul>
            </div>
            <div class="portlet box blue">
                <div class="portlet-title">
                    <div class="caption">公交卡详细</div>
                </div>
                <div class="portlet-body form">
                    <form role="form" method="post" id="queryForm">
                        <div class="form-body">
                            <p class="btn green margin-bottom-10">公交卡信息</p>
                            <div class="clearfix"></div>
                            <div class="form-group col-md-4">
                                <label class="col-md-4 control-label">aid:</label>
                                <div class="col-md-8">
                                    <p class="text">535A542E57414C4C45542E454E56</p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-4 control-label">卡号:</label>
                                <div class="col-md-8">
                                    <p class="text">691003819</p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">卡ID:</label>
                                <div class="col-md-9">
                                    <p class="text">90000025</p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">城市编码:</label>
                                <div class="col-md-9">
                                    <p class="text">2</p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">用户账号:</label>
                                <div class="col-md-9">
                                    <p class="text">C7C9B43B4C24442EBD7D78E00689236D</p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">手机号:</label>
                                <div class="col-md-9">
                                    <p class="text">18680688583</p>
                                </div>
                            </div>
                             <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">卡状态:</label>
                                <div class="col-md-9">
                                    <p class="text">删除成功
</p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">卡名称:</label>
                                <div class="col-md-9">
                                    <p class="text">深圳公交</p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">客服电话:</label>
                                <div class="col-md-9">
                                    <p class="text"></p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">imei号:</label>
                                <div class="col-md-9">
                                    <p class="text"></p>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">卡图片:</label>
                                <div class="col-md-9">
                                    <img src="http://121.41.108.162:8008/wallet-pic/upload/shenzhentong.png" style="width:200px;height:100px;" />
                                </div>
                            </div>
                            
                             <div class="form-group col-md-4">
                                <label class="col-md-3 control-label">设备号:</label>
                                <div class="col-md-9">
                                    <p class="text">47900573470121980100708100503194099348100000005100000471363B464080010000000080464158</p>
                                </div>
                            </div>
                            
                            <div class="clearfix"></div>
                        </div>

                        <div class="form-actions right">
                            <input type="button" class="btn btn-lg green" id="back_btn" value="返回"></input>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <a href="javascript:;" class="page-quick-sidebar-toggler"><i class="icon-close"></i></a>
</div>



   <div class="page-footer">
    <div class="page-footer-inner">
     
    </div>
    <div class="scroll-to-top">
        <i class="icon-arrow-up"></i>
    </div>
</div>
<!--[if lt IE 9]>
<script src="assets/global/plugins/respond.min.js"></script>
<script src="assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="js/buscard/buscard.js" type="text/javascript"></script>
<script>
    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        QuickSidebar.init(); // init quick sidebar
        Demo.init(); // init demo features
    });

    $("#back_btn").click(function () {
        query();
    });

</script>
</body>
</html>