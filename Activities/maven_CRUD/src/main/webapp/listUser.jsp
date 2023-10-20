<%@page import="java.util.List"%>
<%@page import="models.User"%>

<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="layout/header.jsp" />
            <h1>${title}</h1>
            <jstl:choose>
                <jstl:when test="${not empty users || users.size() > 0}">
                    <table class="table table-hover">
                        <thead>
                            <tr class="col-header">
                                <th>DNI</th>
                                <th>Name</th>
                                <th>LastName</th>
                                <th>Date of Birth</th>
                                <th>Profession</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <jstl:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.dni}</td>
                                    <td>${user.name}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.dateBirth}</td>
                                    <td>${user.profession}</td>
                                    <td><a class="btn btn-warning" href="${pageContext.request.contextPath}/form?dni=${user.dni}">Edit</a></td>
                                    <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteUser?dni=${user.dni}">Delete</a></td>
                                </tr>
                            </jstl:forEach>
                        </tbody>
                    </table>
                </jstl:when>
                <jstl:otherwise>
                    <h3>No registered users :(</h3>
                </jstl:otherwise>
            </jstl:choose>
            <div class="m-2">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/form">Add new Person</a>
            </div>
            <a href="${pageContext.request.contextPath}/">Home</a>
        </div>
    </body>
</html>