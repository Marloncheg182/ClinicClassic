<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Clinic Administration base</title>

<style type="text/css">
    .tg {border-collapse: collapse; border-spacing:0;border-color: lightsteelblue;}
    .tg td{font-family: Arial, sans-serif;font-size: 12px; padding: 10px 5px;border-style: solid;
        border-width:1px; overflow:hidden;word-break:normal; border-color: lightsteelblue;color:#333; background-color: #fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;
        border-width:1px;overflow:hidden;word-break:normal;border-color:lightsteelblue;color:#333;background-color:#fff;;}
    .td .tg-4eph{background-color: #f9f9f9}
</style>
</head>
<h1>
    Add Clinic
</h1>
    <form:form method="post" action="create" commandName="clinic">
        <table>
            <tr>
                <td><form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
                </td>
                <td><form:input path="ID" />
                </td>
            </tr>
            <tr>
                <td><form:label path="name">
                    <spring:message text="Name"/>
                    </form:label>
                </td>
                <td><form:input path="Name"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty clinic.name}">
                        <input type="submit"
                                value="<spring:message text="Edit Clinic"/> ">
                    </c:if>
                    <c:if test="${empty clinic.name}">
                        <input type="submit"
                                value="<spring:message text="Add Clinic"/> ">
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
<br>
<h3>Registered Clinic base</h3>
<c:if test="${!empty getAll}">
    <table class="tg">
        <tr>
            <th width="80">Clinic ID</th>
            <th width="140">Clinic Name</th>
            <th width="60">Update</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${getAll}" var="clinic">
            <tr>
                <td>${clinic.id}</td>
                <td>${clinic.name}</td>
                <td><a href="<c:url value='/edit/${clinic.id}'/> ">Edit</a></td>
                <td><a href="<c:url value='/remove/${clinic.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
