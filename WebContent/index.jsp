<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SMS Modem</title>
</head>
<body>
<form action="SmsServ">
发送短信：<input type="checkbox" name="isInterrupt" value ="true" >发送失败时是否中断<br>
<br />
手机：<input type="text" name="mobile" />
<br />
内容：<input type="text" name="content" />
<input type="submit" value="发送" />
</form>
<p style="display:none">SMSModem/SmsServ?mobile=,,,&content=</p>
</body>
</html>