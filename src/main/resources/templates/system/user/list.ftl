<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>user list</title>
</head>
<body>
<#if result.ret = 0>
<#list result.items.list as user>
    ${user.userCode!"userCode"}
    ${user.userName!"userName"}
    <br>
</#list>
<#else>
    ${result.ret}
    ${result.msg}
</#if>


</body>
</html>