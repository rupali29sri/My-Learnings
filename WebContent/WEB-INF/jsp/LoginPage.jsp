 <h2>${welcomeMessage}</h2> 
<form action="/FirstSpringMVCProject/welcome/verifyUser" method="post">

<div align="center" ><B>User Login</B>
<table style ="background-color:none;border-color=black; text-align:left;width:250px;" border="1"  >

<tr bgcolor="#D1DDF1"><td>User Name</td><td><input type="text" name="userName"/></td></tr>
<tr><td>Password</td><td><input type="password" name="password"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Select Role</td>
<td><select name="selectRole">
<option></option>
<option value="Admin">Admin</option>
<option value="Teacher">Teacher</option>
<option value="Student">Student</option>
<option value="Parent">Parent</option>
</select></td></tr>
<tr bgcolor="#D1DDF1" align="center"><td colspan="2"><input type="submit" value="Login" name="loginButton"/><input type="Reset" name="resetButton"/></td></tr>

</table>
</div>
</form>