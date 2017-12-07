<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%response.setStatus(HttpServletResponse.SC_OK);%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>页面500错误</title>
    <link href="${ctx}/epp/css/error.css" type="text/css" rel="stylesheet"/>
    <script language="JavaScript" type="text/javascript">
        if(top != self){
            top.location.replace(location);
        }
    </script>
</head>

<body>
<div class="piece">
    <div class="fl"><img src="${ctx}/images/error/icon_error.jpg" width="210" height="213"/></div>
    <div class="fr">
        <h1>糟糕！网页无法访问。</h1>

        <h3>（<%=request.getAttribute("javax.servlet.error.status_code")%>：<%=request.getAttribute("javax.servlet.error.message")%>）</h3>
        <input name="" type="button" class="btn_refresh" onmouseover="this.className='btn_refresh_hover'"
               onmouseout="this.className='btn_refresh'"  onclick="window.reload();"/>
    </div>
</div>
</body>
</html>