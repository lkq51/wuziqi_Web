<%--
  Created by IntelliJ IDEA.
  User: lkq
  Date: 2016/12/12
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<head>
    <title>设置</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0 maximum-scale=1.0, minimum-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
    <jsp:include page="include/header.jsp"/>
    <div class="am-cf admin-main">
        <jsp:include page="include/sidebar.jsp"/>

        <!-- content start -->
        <div class="admin-content">
    
            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人设置</strong> / <small>${user.username}</small></div>
            </div>
            <div class="layui-tab " lay-filter="tab">
                <ul class="layui-tab-title">
                    <li class="layui-this">基本信息</li>
                    <li>修改头像</li>
                    <li>修改密码</li>
                </ul>
    
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <c:set value="${user}" var="user"/>
                        <form class="layui-form "  action="${ctx}/${user}/update" method="post"  style="text-align: center;">
                            <div class="layui-form-item" >
                                <label class="layui-form-label" >用户名</label>
                                <div class="layui-input-inline" >
                                    <input type="text" name="username" value="${user.username}" required lay-verify="required" class="layui-input" disabled/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">昵称</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="nickname" value="${user.nickname}" required lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input"/>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="email" value="${user.email}" required lay-verify="required\email" placeholder="请输入邮箱" autocomplete="off" class="layui-input"/>
                                </div>
                                <div class="layui-form-mid layui-word-aux">tips</div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">性别</label>
                                <div class="layui-input-inline">
                                    <input type="radio" name="sex" value="1" title="男"/>
                                    <input type="radio" name="sex" value="2" title="女"/>
                                </div>
                            </div>
                            <script>
                                $(":radio[value='" + ${user.sex} + "']").prop("checked", "checked");0
                            </script>
                            <div class="layui-form-item">
                                <label class="layui-form-label">年龄</label>
                                <div class="layui-input-inline">
                                    <input id="age" name="age" value="${user.age}" required lay-verify="required\number" placeholder="请输入年龄" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">tips</div>
                            </div>

                            <div class="layui-form-item layui-form-text">
                                 <label class="layui-form-label">个性签名</label>
                                <div class="layui-input-block">
                                    <textarea name = "profile" id="profile"  placeholder="请输入内容" class="layui-textarea">${user.profile}</textarea>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="submit">保存</button>
                                    <button class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>

    
                    <div class="layui-tab-item">
                        <form class="am-form am-form-horizontal" action="${ctx}/${username}/upload" enctype="multipart/form-data" method="post" onsubmit="return checkFileType();" style="text-align: center;">
                            <div style="text-align: center;margin-bottom: 10px">
                                <img class="am-circle" src="${ctx}/${user.profilehead}" width="140" height="140" alt="lkq"/>
                            </div>
                            <div class="am-form-group am-form-file">
                                <button type="button" class="am-btn am-btn-secondary am-btn-sm">
                                    <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                                <input id="file" type="file" name="file" multiple>
                            </div>
                            <div id="file-list"></div>
                            <button type="submit" class="am-btn am-round am-btn-success"><span class="am-icon-upload"></span> 上传头像</button>
                            <script>
                                $(function() {
                                    $('#file').on('change', function() {
                                        var fileNames = '';
                                        $.each(this.files, function() {
                                            fileNames += '<span class="am-badge">' + this.name + '</span> ';
                                        });
                                        $('#file-list').html(fileNames);
                                    });
                                });
                            </script>
                        </form>
                    </div>
    
                    <div class="layui-tab-item">
                        <form class="am-form am-form-horizontal" data-am-validator action="${ctx}/${username}/pass" method="post">
                            <div class="am-form-group">
                                <label for="password1" class="am-u-sm-2 am-form-label">原密码</label>
                                <div class="am-u-sm-10">
                                    <input type="password" id="password1" name="oldpass" required placeholder="请输入原密码...">
                                </div>
                            </div>
    
                            <div class="am-form-group">
                                <label for="password2" class="am-u-sm-2 am-form-label">新密码</label>
                                <div class="am-u-sm-10">
                                    <input type="password" id="password2" name="newpass" required placeholder="请输入新密码...">
                                </div>
                            </div>
    
                            <div class="am-form-group">
                                <label for="password3" class="am-u-sm-2 am-form-label">确认新密码</label>
                                <div class="am-u-sm-10">
                                    <input type="password" id="password3" data-equal-to="#password2" required placeholder="请确认新密码...">
                                </div>
                            </div>
    
                            <div class="am-form-group">
                                <div class="am-u-sm-10 am-u-sm-offset-2">
                                    <button type="submit" class="am-btn am-round am-btn-success"><span class="am-icon-send"></span> 提交修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- content end -->
    </div>
    <a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
        <span class="am-icon-btn am-icon-th-list"></span>
    </a>
    <jsp:include page="include/footer.jsp"/>
    <script>
        //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
        layui.use(['element', 'form'], function(){
            var element = layui.element();
            var form = layui.form();
        });
        if("${message}"){
            layer.msg('${message}', {
                offset: 0,
            });
        }
        if("${error}"){
            layer.msg('${error}', {
                offset: 0,
                shift: 6
            });
        }

        function checkFileType(){
            var format = ["bmp","jpg","gif","png"];
            var filename = $("#file").val();
            var ext = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
            if(jQuery.inArray(ext, format) != -1){
                return true;
            }else{
                layer.msg('头像格式只能是bmp,jpg,gif,png!', {
                    offset: 0,
                    shift: 6
                });
                return false;
            }
}
    </script>
</body>
</html>
