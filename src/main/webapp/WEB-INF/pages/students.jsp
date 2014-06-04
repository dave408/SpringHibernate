<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<html>
<body>
<table border="1px"><tr>
<td width="30%">
<h3><spring:message code="label.studenttitle"/></h3>
 
<span style="float: right">
    <a href="?lang=en">en</a>|<a href="?lang=es">es</a>
</span>

<form:form method="post" action="addStudent.html" commandName="student"> 
    <table>
<%--     <tr>
        <td><form:label path="studentId"><spring:message code="label.student_id"/></form:label></td>
        <td><form:input path="studentId" /></td>
    </tr> --%>
    <tr>
        <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="age"><spring:message code="label.age"/></form:label></td>
        <td><form:input path="age" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addstudent"/>"/>
        </td>
    </tr>
	</table> 
</form:form>

<h3>Student</h3>
<c:if  test="${!empty studentList}">
<table class="data">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${studentList}" var="st">
    <tr>
        <td>${st.studentId}</td>
        <td>${st.name}</td>
        <td>${st.age}</td>
        <td><a href="deleteStudent/${st.studentId}">Delete Student</a></td>
    </tr>
</c:forEach>
</table>
</c:if>

</td>
<td width="30%">
<h3><spring:message code="label.coursetitle"/></h3>
<form:form method="post" action="addCourse.html" commandName="course"> 
    <table>
    <tr>
        <td><form:label path="courseName"><spring:message code="label.courseName"/></form:label></td>
        <td><form:input path="courseName" /></td>
    </tr>
    <tr>
        <td><form:label path="credit"><spring:message code="label.credit"/></form:label></td>
        <td><form:input path="credit" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addcourse"/>"/>
        </td>
    </tr>
	</table> 
</form:form>

<h3>Course</h3>
<c:if  test="${!empty courseList}">
<table class="data">
<tr>
    <th>Course ID</th>
    <th>Course Name</th>
    <th>Credit</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${courseList}" var="cl">
    <tr>
        <td>${cl.courseId} </td>
        <td>${cl.courseName}</td>
        <td>${cl.credit}</td>
        <td><a href="deleteCourse/${cl.courseId}">Delete Course</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
</td></tr>

<tr>
<td width="30%">
<h3><spring:message code="label.enrollmenttitle"/></h3>
<form:form id="registerForm" method="post" commandName="enrollment"> 
    <table>
    <tr>
        <td><form:label path="enrollmentSID"><spring:message code="label.student_id"/></form:label></td>
        <td><form:input id="enrollmentSID" path="enrollmentSID" /></td>
    </tr>
    <tr>
        <td><form:label path="enrollmentCID"><spring:message code="label.course_id"/></form:label></td>
        <td><form:input id="enrollmentCID" path="enrollmentCID" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input id="register" type="submit" value="<spring:message code="label.addenrollment"/>"/>            
        </td>
    </tr>
	</table>
</form:form>
</td>

<td width="30%">
<h3>Enrollment</h3>
<c:if  test="${!empty enrollmentList}">
<table class="data" border="1px">
<tr>
    <th>Enrollment ID</th>
    <th>Student ID</th>
    <th>Student Name</th>
    <th>Course ID</th>
    <th>Course Name</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${enrollmentList}" var="el">
    <tr>
        <td>${el.enrollmentId} </td>
        <td>${el.enrollmentSID}</td>
        <td>${el.enrollmentSNAME}</td>
        <td>${el.enrollmentCID}</td>
        <td>${el.enrollmentCNAME}</td>
        <td><a href="deleteEnrollment/${el.enrollmentId}">Drop Class</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
</td>
</tr></table>

<c:url value="/logout" var="logoutUrl" /><a href="${logoutUrl}">Click here to Log Out</a>
</body>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	$("#register").click(function(e) {
		e.preventDefault();//cancel the original submit, change the URI, then do the submit form
		var sid = $("#enrollmentSID").val();
		var cid = $("#enrollmentCID").val();
		$("#registerForm").get(0).setAttribute('action', "addEnrollment/" + sid + "/" + cid);
		$("#registerForm").submit();
	});
	</script>	
</html>