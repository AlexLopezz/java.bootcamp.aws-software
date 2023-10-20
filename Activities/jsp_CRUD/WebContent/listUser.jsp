<%@page import="java.util.List"%>
<%@page import="models.User"%>

<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="jakarta.tags.core" %>

<jsp:include page="layout/header.jsp" />
    <h1>${title}</h1>

    <jstl:choose>
        <jstl:when test="${not empty users || users.size() > 0}">
            <table class="center">
                <thead>
                    <tr class="col-header">
                        <th class="col">DNI</th>
                        <th class="col">Name</th>
                        <th class="col">LastName</th>
                        <th class="col">Date of Birth</th>
                        <th class="col">Profession</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <jstl:forEach var="user" items="${users}">
                        <tr class="rows">
                            <td class="row">${user.dni}</td>
                            <td class="row">${user.name}</td>
                            <td class="row">${user.lastName}</td>
                            <td class="row">${user.dateBirth}</td>
                            <td class="row">${user.profession}</td>
                            <td><a class="button btn-edit" href="${pageContext.request.contextPath}/form?dni=${user.dni}">Edit</a></td>
                            <td><a class="button btn-delete" href="${pageContext.request.contextPath}/deleteUser?dni=${user.dni}">Delete</a></td>
                        </tr>
                    </jstl:forEach>
                </tbody>
            </table>
        </jstl:when>
        <jstl:otherwise>
            <p>No registered users :(</p>
        </jstl:otherwise>
    </jstl:choose>
    <div style="margin: 10px;">
        <a class="button btn-new" href="${pageContext.request.contextPath}/form">Add new Person</a>
    </div>
</body>
</html>