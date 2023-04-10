<%@ page import="com.brightpattern.webcfg.tenantmgmt.server.utils.TenantJspInjector" %>
<%@ page import="com.brightpattern.webcfg.server.branding.BrandingConfig" %>
<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><%=StringEscapeUtils.escapeHtml(BrandingConfig.get().getPageTitle(request))%></title>
    <style type="text/css">
        .header {
            font: 1.6em "Trebuchet MS",Verdana,sans-serif;
        }

        .descr {
            font: 1.3em "Trebuchet MS",Verdana,sans-serif;
        }
    </style>
</head>
<body>
<h1 class="header">HTTP Error 404</h1>
<h1 class="descr">Not Found: The page or file you are looking for is not found.</h1>
</body>
</html>