<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

        <div align="center">
            <h1>Student List</h1>
            <h3><a href="/FirstSpringMVCProject/addStudentProfilePage.html">New Student</a></h3>
            <table border="1">
                <th>No</th>
                <th>Name</th>
                <th>Date Of Birth</th>
                <th>ContactNo</th>                
                <th>Action</th> 
                 <c:if test="${!empty listStudent}">
                <c:forEach var="student" items="${listStudent}" >
                <tr>
                   <td>${student.studentId}</td>
                    <td>${student.studentName}</td>
                    <td>${student.dateOfBirth}</td>
                    <td>${student.contactNumber}</td>                   
                    <td>
                        <a href="<c:url value='/FirstSpringMVCProject/editStudentProfilePage.html?id=${student.studentId}'/>">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/FirstSpringMVCProject/editStudentProfilePage.html?id=${student.studentId}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>  
                </c:if>
                 <c:if test="${empty listStudent}">
                 <c:out value="abc"/>
                 </c:if>          
            </table>
        </div>
    