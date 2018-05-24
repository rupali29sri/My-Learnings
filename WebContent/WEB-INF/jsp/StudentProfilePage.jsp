<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:errors path="studentObject.*"/>

<c:url var="addStudentProfile" value="/submitStudentProfilePage.html" ></c:url>
<form:form action="${addStudentProfile}" method="post" modelAttribute="student" >

<div align="center" ><B>CREATE STUDENT PROFILE</B>
<table style ="background-color:none;border-color=black; text-align:left;width:400px;" border="1"  >

<tr bgcolor="#D1DDF1"><td>Student Name </td><td><form:input path="studentName" /></td></tr>
<tr bgcolor="#D1DDF1"><td>Father Name </td><td><form:input type="text" path="fatherName"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Mother Name </td><td><form:input type="text" path="motherName"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Date of Birth </td><td><form:input type="text" path="dateOfBirth"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Class </td><td><form:input type="text" path="classNumber"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Count of Siblings </td><td><form:input type="text" path="countOfSibling"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Category </td><td><form:input type="text" path="category"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Permanent Address </td>
<td>
<table>
<tr bgcolor="#D1DDF1"><td>Country </td><td><form:input type="text" path="permanentAddress.country"/></td></tr>
<tr bgcolor="#D1DDF1"><td>City </td><td><form:input type="text" path="permanentAddress.city"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Street </td><td><form:input type="text" path="permanentAddress.street"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Pincode</td><td><form:input type="text" path="permanentAddress.pincode"/></td></tr>
</table>
<!-- <input type="text" name="permanentAddress"/>-->
</td></tr> 
<tr bgcolor="#D1DDF1"><td>Father's Employment </td><td><form:input type="text" path="fatherEmployment"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Mother's Employment </td><td><form:input type="text" path="motherEmployment"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Previous School Name </td><td><form:input type="text" path="previousSchoolName"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Contact Number </td><td><form:input type="text" path="contactNumber"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Identity proof </td><td><form:input type="text" path="identityProof"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Physical Disability? </td><td><form:input type="text" path="physicalDisability"/></td></tr>
<tr bgcolor="#D1DDF1"><td>Hobbies </td><td><form:select path="hobbies">
											<form:option value="Dancing">Dancing</form:option>
											<form:option value="Reading">Reading</form:option>
											<form:option value="Tv Watching">Tv Watching</form:option>
											<form:option value="Surfing">Surfing</form:option>
											<form:option value="Playing">Playing</form:option>
											<form:option value="Dancing">Dancing</form:option>
											</form:select></td></tr>
<tr bgcolor="#D1DDF1" align="center">
<td colspan="2">
<c:if test="${empty student.studentId}">
<input type="submit" value="Submit" name="loginButton"/><input type="Reset" name="resetButton" value="Cancel"/>
</c:if>
<c:if test="${!empty student.studentId}">
<input type="submit" value="Update" name="UpdateButton"/><input type="submit" name="cancelUpdateButton" value="Cancel"/>
</c:if>
</td></tr>

</table>
</div>
</form:form>