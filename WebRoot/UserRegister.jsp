<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title>User Register</title>
		<link href="css/commons.css" rel="stylesheet" type="text/css" />
		<script src="js/My97DatePicker/WdatePicker.js" type="text/javascript"
			language="javascript"></script>

		<script type="text/javascript" language="javascript">
//check[a-z][A-Z]and[0-9]
function fucCheckSpace(str)
{       
      var strSource ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      var ch;
      var i;
      var temp;
      for(i=0;i<=(str.length-1);i++)
      {
         ch = str.charAt(i);
         temp = strSource.indexOf(ch);
         if(temp==-1) 
         {
            return 0;
         }
      }
      if(strSource.indexOf(ch)==-1)
      {
         return 0;
      }
      else
      {
         return 1;
       } 
}
//
function fucCheckLength(strTemp)
{
    var i,sum;
	sum=0;
	strTemp = strTemp.Trim();
	for(i=0;i<strTemp.length;i++)
	{
		if ((strTemp.charCodeAt(i)>=0) && (strTemp.charCodeAt(i)<=255))
			sum=sum+1;
		else
			sum=sum+2;
	}
	return sum;
}
//
function fucCheckTel(TEL)
{ 
	var i,j,strTemp;
	//strTemp="0123456789-()# ";
	strTemp="0123456789-#";
	for (i=0;i<TEL.length;i++)
	{
		j=strTemp.indexOf(TEL.charAt(i));	
		if (j==-1)
		{
		//
			return 0;
		}
	}
	//
	return 1;
}
//
function chkuser(user)
{
    if(user.length < 3 || user.length > 10)
	return 1;
	else
	return 0;
}
//
function chkpwd(pwd1,pwd2)
{
    if(pwd1 != pwd2)
	{
	   return 1;
	}
	else
	{
	   return 0;
	}
}
//
function chkemail(email)
{
    var myReg = /^[-a-zA-Z0-9_\.]+@([0-9A-Za-z][0-9A-Za-z-]+\.)+[A-Za-z]{2,5}$/;
	if(myReg.test(email))
	{
	   return 1;
	}
	else
	{
	   return 0;
	}
}
function frm_submit()
{
     if(chkuser(document.frm.userId.value)==1 || fucCheckSpace(document.frm.userId.value)==0)
	 {
	    alert('please check your name');
		document.frm.userId.focus();
		return false;
	 }
	 //if(fucCheckLength(document.frm.password1.value)<5 || fucCheckLength(document.frm.password1.value)>17)
	 if( document.frm.userPassword.value.length <6 || document.frm.userPassword.value.length >16)
	 {
	    alert('please check your password ！');
		document.frm.password.focus();
		return false;
	 }
	 if(chkpwd(document.frm.userPassword.value,document.frm.userPassword2.value) == 1)
	 {
	    alert('password not the same ！');
		document.frm.userPassword2.focus();
		return false;
	 }
	 if(document.frm.userName.value == "")
	 {
	    alert('Please Enter name ！');
		document.frm.userName.focus();
		return false;
	 }
	 if(document.frm.mobile.value == "" || fucCheckTel(document.frm.mobile.value)>30 || fucCheckTel(document.frm.mobile.value)==0)
	 {
	    alert('Please enter phone');
		document.frm.mobile.focus();
		return false;
	 }
	 if(chkemail(document.frm.email.value) == 0) 
     {
	    alert("Please enter email");
	    document.frm.email.focus();
	    return false;
	 }
	 if(document.frm.address.value == "")
	 {
	    alert('Please enter address ！');
		document.frm.address.focus();
		return false;
	 }    
}
function back()
{
   window.location.href = "./Index.jsp";
}
</script>
	</head>
	<body>
		<div id="page" style="background-image: url(image/background.jpg)">
			<div id="content">
				<div id="main">
					<form action="Register.action" method="post" name="frm"
						onsubmit="return frm_submit()">
						<table width="60%" border="0" align="center"
							style="border: 1px #ccc solid; background-color:#FFFFFF">
							<tr>
								<td colspan="3" align="center">
									<H3>User Register</H3>
								</td>
							</tr>
							<tr>
								<td valign="top">
									<br />
								</td>
								<td valign="top">
									<br />
								</td>
								<td valign="top">
									<br />
								</td>
							</tr>
							<tr>
								<td width="19%" align="right">
									User name&nbsp;
								</td>
								<td width="44%">
									&nbsp;
									<input type="text" name="userId" id="userId"
										class="inputControl" />
								</td>
								<td width="37%">
									<div id="tdtext">
										* must
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">
									Password &nbsp;
								</td>
								<td>
									&nbsp;
									<input type="password" name="userPassword" id="userPassword"
										class="inputControl" />
								</td>
								<td>
									<div id="tdtext">
										* must
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">
									Retype Password&nbsp;
								</td>
								<td>
									&nbsp;
									<input type="password" name="userPassword2" id="userPassword2"
										class="inputControl" />
								</td>
								<td>
									<div id="tdtext">
										Password should be the sanme
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">
									Name &nbsp;
								</td>
								<td>
									&nbsp;
									<input type="text" name="userName" id="userName"
										class="inputControl" />
								</td>
								<td>
									<div id="tdtext">
										* must
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">
									Sex &nbsp;
								</td>
								<td>
									&nbsp;
									<select name="sex">
										<option value="male">
											male
										</option>
										<option value="female">
											female
										</option>
									</select>
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<td align="right">
									Age&nbsp;
								</td>
								<td>
									&nbsp;
									<input type="text" name="age" id="age" class="inputControl" />
								</td>
								<td>
									<div id="tdtext">
										* number must！
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">
									Birthday &nbsp;
								</td>
								<td>
									&nbsp;
									<input class="Wdate" type="text"  id="birthday" name="birthday" onfocus="new WdatePicker(this)"/>
								</td>
								<td>
									<div id="tdtext">
										* must &nbsp;
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">
									Phone &nbsp;
								</td>
								<td>
									&nbsp;
									<input type="text" name="mobile" id="mobile"
										class="inputControl" />
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<td align="right">
									Email &nbsp;
								</td>
								<td>
									&nbsp;
									<input type="text" name="email" id="email" class="inputControl" />
								</td>
								<td>
									<div id="tdtext">
										* must
									</div>
								</td>
							</tr>
							<tr>
								<td align="right">
									Address &nbsp;
								</td>
								<td>
									&nbsp;
									<input type="text" name="address" id="address" class="inputControl" />
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<td align="right">
									Verification &nbsp;
								</td>
								<td>
									&nbsp;
									<select id="certiType" name="certiType">
										<option value="ID CARD">
											ID CARD
										</option>
										<option value="OTHERS">
											OTHERS
										</option>

									</select>
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<td align="right">
									ID NUMBER&nbsp;
								</td>
								<td>
									&nbsp;
									<input type="text" name="certiNum" id="certiNum"
										class="inputControl" />
								</td>
								<td>
									<div id="tdtext">
										* must
									</div>
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td>
									&nbsp;
									<input type="submit" value="Register" class="buttonface"/>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="reset" value="Reset" class="buttonface"/>&nbsp;&nbsp;
									<input type="button" value="Return" class="buttonface" onClick="back()"/>
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
