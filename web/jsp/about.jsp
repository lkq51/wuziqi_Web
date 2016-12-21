<%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/12/21
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>关于</title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
    <jsp:include page="include/sidebar.jsp"/>

    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf">
                <strong class="am-text-primary am-text-lg">关于</strong>
                /<small>about</small>
            </div>
        </div>
        <div class="am-tabs am-margin" data-am-tabs>
            <ul class="am-tabs-nav am-nav am-nav-tabs">
                <li class="am-active"><a href="#tab1">所用技术</a></li>
                <li><a href="#tab2">获取源码</a></li>
                <li><a href="#tab3">关于作者</a></li>
            </ul>
            <div class="am-tabs-bd">
                <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                    <hr>
                    <blockquote>
                        <p>主要使用SSM框架,即Spring + Spring MVC + Hibernate</p>
                        <p>通讯使用的是websocket</p>
                        <p>数据库使用的是mysql</p>
                        <p>端框架采用的是acle 10g express版</p>
                        <p>前端框架采用的是<a href="http://http://amazeui.org" target="_blank">Amaze UI</a>,弹窗控件和分页控件采用的是<a href="http://http://layer.layui.com/" target="_blank">Layer</a>和<a href="http://http://laypage.layui.com/" target="_blank">Laypage</a></p>
                    </blockquote>
                </div>

                <div class="am-tab-panel am-fade am-in" id="tab2">
                    <hr>
                    <blockquote>
                        <p><a href="https://github.com/lkq51/wuziqi_Web" target="_blank">点击这里</a> </p>
                    </blockquote>
                </div>

                <div class="am-tab-panel am-fade am-in" id="tab3">
                    <hr>
                    <blockquote>
                        <p>github主页<a href="https://github.com/lkq51" target="_blank">点击这里</a></p>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>
    <a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
    </a>
</body>
</html>
