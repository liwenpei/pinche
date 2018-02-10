<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	HttpSession Session = request.getSession();
	String user_id = (String) Session.getAttribute("user_id");
%>
<link href="css/custom/dropdown-submenu.css" rel="stylesheet">
<!-- topbar starts -->
<div class="navbar navbar-default" role="navigation">

	<div class="navbar-inner">
		<button type="button" class="navbar-toggle pull-left animated flip">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.jsp"> <img alt="Charisma Logo"
			src="img/logo20.png" class="hidden-xs" /> <span>金立钱包</span></a>

		<!-- user dropdown starts -->

		<div class="btn-group pull-right">
			<button class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				<span class="hidden-sm hidden-xs"><%=user_id%></span> <span
					class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="user_profile.do">档案</a></li>
				<li class="divider"></li>
				<li><a href="logout.do">退出</a></li>
			</ul>
		</div>
		<!-- user dropdown ends -->

		<!-- theme selector starts -->
		<div class="btn-group pull-right theme-container animated tada">
			<button class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				<i class="glyphicon glyphicon-tint"></i><span
					class="hidden-sm hidden-xs"> 更换主题</span> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" id="themes">
				<li><a data-value="classic" href="#"><i class="whitespace"></i>
						Classic</a></li>
				<li><a data-value="cerulean" href="#"><i class="whitespace"></i>
						Cerulean</a></li>
				<li><a data-value="cyborg" href="#"><i class="whitespace"></i>
						Cyborg</a></li>
				<li><a data-value="simplex" href="#"><i class="whitespace"></i>
						Simplex</a></li>
				<li><a data-value="darkly" href="#"><i class="whitespace"></i>
						Darkly</a></li>
				<li><a data-value="lumen" href="#"><i class="whitespace"></i>
						Lumen</a></li>
				<li><a data-value="slate" href="#"><i class="whitespace"></i>
						Slate</a></li>
				<li><a data-value="spacelab" href="#"><i class="whitespace"></i>
						Spacelab</a></li>
				<li><a data-value="united" href="#"><i class="whitespace"></i>
						United</a></li>
			</ul>
		</div>
		<!-- theme selector ends -->

		<ul class="collapse navbar-collapse nav navbar-nav top-menu">
			<shiro:hasPermission name="order:r">
				<li><a href="order_query_index.do">订单查询</a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="service:r">
				<li class="dropdown"><a href="service_query.do"
					data-toggle="dropdown">服务管理<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-submenu"><a href="#">钱包服务管理</a>
							<ul class="dropdown-menu">
								<li><a href="wallet_service_query_index.do">钱包服务管理</a></li>
								<li><a href="wallet_service_query_rank_index.do">钱包服务排序</a>
								</li>
							</ul></li>
						<!-- <li class="dropdown-submenu"><a href="#">生活服务管理</a>
							<ul class="dropdown-menu">
								<li><a href="life_service_query_index.do">生活服务管理</a></li>
								<li><a href="life_service_query_rank_index.do">生活服务排序</a></li>
							</ul></li>
						<li class="dropdown-submenu"><a
							href="life_classify_service_query_index.do">生活服务分类管理</a>
							<ul class="dropdown-menu">
								<li><a href="life_classify_service_query_index.do">生活服务分类管理</a>
								</li>
								<li><a href="life_classify_service_query_rank_index.do">生活服务分类管理排序</a>
								</li>
							</ul></li> -->

						<li class="dropdown-submenu"><a href="#">支付钱包服务管理</a>
							<ul class="dropdown-menu">
								<li><a href="pay_wallet_service_query_index.do">支付钱包服务管理</a>
								</li>
								<li><a href="pay_wallet_service_query_rank_index.do">支付钱包服务排序</a>
								</li>
							</ul></li>

					</ul></li>
			</shiro:hasPermission>
			<%-- <shiro:hasPermission name="layout:r">
				<li><a href="layout_query_index.do">上架管理</a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="activity:r">
				<li class="dropdown"><a href="activity_ajax_query.do"
					data-toggle="dropdown">预算管理<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<shiro:hasPermission name="activity:audit">
							<li><a href="activity_queryReview.do">预算审核</a></li>
						</shiro:hasPermission>
						<li><a href="activity_ajax_query.do">预算列表</a></li>
						<li><a href="activity_queryDraft.do">草稿箱</a></li>
					</ul></li>
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="promotion:r">
				<li class="dropdown"><a href="promotion_query.do"
					data-toggle="dropdown">一元夺宝<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<shiro:hasPermission name="promotion:r">
							<li><a href="promotion_query.do">一元夺宝</a></li>
						</shiro:hasPermission>
						<li><a href="share_query.do">分享配置</a></li>
					</ul></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="promotion:r">
				<li class="dropdown"><a href="promotion_query.do"
					data-toggle="dropdown">优惠活动<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<shiro:hasPermission name="promotion:r">
							<li><a href="special_column_query.do">专栏</a></li>
						</shiro:hasPermission>
						<li><a href="previlege_promotion_query.do">优惠活动</a></li>
					</ul></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="blackNameList:r">
				<li><a href="blackNameList_query.do">黑名单管理</a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="product:r">
				<li class="dropdown"><a href="promotion_query.do"
					data-toggle="dropdown">产品管理<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<shiro:hasPermission name="product:r">
							<li><a href="product_ajax_query.do">产品管理</a></li>
						</shiro:hasPermission>
						<li><a href="phone_charge_up_view.do">话费上架</a></li>
					</ul></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="advertisement:r">
				<li class="dropdown"><a href="advertisement_query_index.do"
					data-toggle="dropdown">广告管理 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="advertisement_query_index.do">广告管理</a></li>
						<li><a href="advertisement_query_rank_index.do">广告管理排序</a></li>
					</ul></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="orgCode:r">
				<li><a href="orgCode_query.do">机构管理</a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="transCode:r">
				<li><a href="transCode_query.do">交易码管理</a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="orgTransCode:r">
				<li><a href="orgTransCode_query.do">接口控制</a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="user:r">
				<li class="dropdown"><a href="#" data-toggle="dropdown">用户管理<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="user_query.do">用户管理</a></li>
						<shiro:hasPermission name="role:r">
							<li><a href="role_query.do">组别管理</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="perm:r">
							<li><a href="perm_query.do">权限管理</a></li>
						</shiro:hasPermission>
					</ul></li>
			</shiro:hasPermission>
		</ul>

	</div>
</div>
<!-- topbar ends -->

<!-- left menu starts -->
<div class="col-sm-2 col-lg-2">
	<div class="sidebar-nav">
		<div class="nav-canvas">
			<div class="nav-sm nav nav-stacked"></div>
			<ul class="nav nav-pills nav-stacked main-menu">
				<li class="nav-header">导航</li>
				<li><a class="ajax-link"
					href="<%=request.getContextPath()%>/index.do"><i
						class="glyphicon glyphicon-home"></i><span> 首页</span></a></li>
				<shiro:hasPermission name="order:r">
					<li><a class="ajax-link"
						href="<%=request.getContextPath()%>/order_query_index.do"><i
							class="glyphicon glyphicon-eye-open"></i><span> 订单查询</span></a></li>
				</shiro:hasPermission>

				<shiro:hasPermission name="service:r">
					<li class="accordion"><a href="#"><i
							class="glyphicon glyphicon-plus"></i><span> 服务管理</span></a>
						<ul class="nav nav-pills nav-stacked">
							<li><a
								href="<%=request.getContextPath()%>/wallet_service_query_index.do">钱包服务管理</a></li>
							<%-- <li><a
								href="<%=request.getContextPath()%>/life_service_query_index.do">生活服务管理</a></li>
							<li><a
								href="<%=request.getContextPath()%>/life_classify_service_query_index.do">生活分类服务管理</a></li> --%>
							<li><a
								href="<%=request.getContextPath()%>/pay_wallet_service_query_index.do">支付钱包服务管理</a></li>
						</ul></li>
				</shiro:hasPermission>
			<%-- 	<shiro:hasPermission name="layout:r">
					<li><a href="layout_query_index.do"><i
							class="glyphicon glyphicon-eye-open"></i><span>上架管理</span></a></li>
				</shiro:hasPermission> --%>

				<shiro:hasPermission name="activity:r">
					<li class="accordion"><a href="#"><i
							class="glyphicon glyphicon-plus"></i><span> 预算管理</span></a>
						<ul class="nav nav-pills nav-stacked">
							<shiro:hasPermission name="activity:audit">
								<li><a
									href="<%=request.getContextPath()%>/activity_queryReview.do">预算审核</a></li>
							</shiro:hasPermission>
							<li><a
								href="<%=request.getContextPath()%>/activity_ajax_query.do">预算列表</a></li>
							<li><a
								href="<%=request.getContextPath()%>/activity_queryDraft.do">草稿箱</a></li>
						</ul></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="promotion:r">
					<li class="accordion"><a href="#"><i
							class="glyphicon glyphicon-plus"></i><span>一元抢宝</span></a>
						<ul class="nav nav-pills nav-stacked">
							<li><a
								href="<%=request.getContextPath()%>/promotion_query.do">一元抢宝</a></li>
							<li><a href="<%=request.getContextPath()%>/share_query.do">分享配置</a></li>
						</ul></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="promotion:r">
					<li class="accordion"><a href="#"><i
							class="glyphicon glyphicon-plus"></i><span>优惠活动</span></a>
						<ul class="nav nav-pills nav-stacked">
							<li><a
								href="<%=request.getContextPath()%>/special_column_query.do">专栏</a></li>
							<li><a
								href="<%=request.getContextPath()%>/previlege_promotion_query.do">优惠活动</a></li>
						</ul></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="blackNameList:r">
					<li><a class="ajax-link"
						href="<%=request.getContextPath()%>/blackNameList_query.do"><i
							class="glyphicon glyphicon-edit"></i><span> 黑名单管理</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="product:r">
					<li><a
						href="<%=request.getContextPath()%>/product_ajax_query.do"><i
							class="glyphicon glyphicon-plus"></i><span>产品管理</span></a>
						<ul class="nav nav-pills nav-stacked">
							<li><a
								href="<%=request.getContextPath()%>/product_ajax_query.do">产品管理</a></li>
							<li><a
								href="<%=request.getContextPath()%>/phone_charge_up_view.do.do">话费上架</a></li>
						</ul></li>
				</shiro:hasPermission>

				<shiro:hasPermission name="advertisement:r">
					<li><a class="ajax-link"
						href="<%=request.getContextPath()%>/advertisement_query_index.do">
							<i class="glyphicon glyphicon-font"></i><span> 广告管理</span>
					</a></li>
				</shiro:hasPermission>

				<shiro:hasPermission name="orgCode:r">
					<li><a class="ajax-link"
						href="<%=request.getContextPath()%>/orgCode_query.do"><i
							class="glyphicon glyphicon-barcode"></i><span> 机构管理</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="transCode:r">
					<li><a class="ajax-link"
						href="<%=request.getContextPath()%>/transCode_query.do"><i
							class="glyphicon glyphicon-tag"></i><span> 交易码管理</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="orgTransCode:r">
					<li><a class="ajax-link"
						href="<%=request.getContextPath()%>/orgTransCode_query.do"><i
							class="glyphicon glyphicon-picture"></i><span> 接口管理</span></a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="user:r">
					<li class="accordion"><a href="#"><i
							class="glyphicon glyphicon-plus"></i><span>用户管理</span></a>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="<%=request.getContextPath()%>/user_query.do">用户管理</a></li>
							<shiro:hasPermission name="role:r">
								<li><a href="<%=request.getContextPath()%>/role_query.do">组别管理</a></li>
							</shiro:hasPermission>
							<shiro:hasPermission name="perm:r">
								<li><a href="<%=request.getContextPath()%>/perm_query.do">权限管理</a></li>
							</shiro:hasPermission>
						</ul></li>
				</shiro:hasPermission>
				<li><a href="login.do"><i class="glyphicon glyphicon-lock"></i><span>
							登录</span></a></li>
			</ul>
		</div>
	</div>
</div>
<!--/span-->
<!-- left menu ends -->


