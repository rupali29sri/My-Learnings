<Center> <h2>${welcomeMessage} !!!</h2>  </Center>
 
<div align="center" ><B>DETAILS OF THE STUDENT SUBMITTED</B>
<table style ="background-color:none;border-color=black; text-align:left;width:400px;" border="1"  >

<tr bgcolor="#D1DDF1"><td>Student Name </td><td>${studentObject.studentName}</td></tr>
<tr bgcolor="#D1DDF1"><td>Father Name </td><td>${studentObject.fatherName}</td></tr>
<tr bgcolor="#D1DDF1"><td>Mother Name </td><td>${studentObject.motherName}</td></tr>
<tr bgcolor="#D1DDF1"><td>Date of Birth </td><td>${studentObject.dateOfBirth}</td></tr>
<tr bgcolor="#D1DDF1"><td>Class </td><td>${studentObject.classNumber}</td></tr>
<tr bgcolor="#D1DDF1"><td>Count of Siblings </td><td>${studentObject.countOfSibling}</td></tr>
<tr bgcolor="#D1DDF1"><td>Category </td><td>${studentObject.category}</td></tr>
<tr bgcolor="#D1DDF1"><td>Permanent Address </td>
<td>${studentObject.permanentAddress.street},${studentObject.permanentAddress.city},${studentObject.permanentAddress.country}. Pincode:${studentObject.permanentAddress.pincode}</td></tr>
<tr bgcolor="#D1DDF1"><td>Father's Employment </td><td>${studentObject.fatherEmployment}</td></tr>
<tr bgcolor="#D1DDF1"><td>Mother's Employment </td><td>${studentObject.motherEmployment}</td></tr>
<tr bgcolor="#D1DDF1"><td>Previous School Name </td><td>${studentObject.previousSchoolName}</td></tr>
<tr bgcolor="#D1DDF1"><td>Contact Number </td><td>${studentObject.contactNumber}</td></tr>
<tr bgcolor="#D1DDF1"><td>Identity proof </td><td>${studentObject.identityProof}</td></tr>
<tr bgcolor="#D1DDF1"><td>Physical Disability? </td><td>${studentObject.physicalDisability}</td></tr>
<tr bgcolor="#D1DDF1"><td>Hobbies </td><td>${studentObject.hobbies}</td></tr>
</table>
</div>