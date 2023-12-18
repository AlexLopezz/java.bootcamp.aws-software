<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="layout/header.jsp" />
            <h1 class="d-inline bg-dark text-light">${title}</h1>
            <div class="d-flex justify-content-center align-items-center m-2">
                <form class="p-2 w-50 rounded" style="background-color: #DEDEDE;" action="${pageContext.request.contextPath}/form" method="POST">
                    <jstl:choose>
                        <jstl:when test="${user.dni == null}">
                            <div class="m-2">
                                <div>
                                    <label>DNI</label>
                                </div>
                                <div>
                                    <input
                                            class="text-center"
                                            type="text"
                                            name="dni"
                                            placeholder="34465765">
                                </div>
                            </div>
                        </jstl:when>
                        <jstl:otherwise>
                            <input
                                    hidden
                                    name="dni"
                                    type="text"
                                    value="${user.dni}">
                        </jstl:otherwise>
                    </jstl:choose>
                    <div class="m-2">
                        <div>
                            <label>Name</label>
                        </div>
                        <div>
                            <input
                                    class="text-center"
                                    type="text"
                                    name="name"
                                    value="${user.name}"
                                    placeholder="Bill">
                        </div>
                    </div>
    
                    <div class="m-2">
                        <div>
                            <label>Last Name</label>
                        </div>
                        <div>
                            <input
                                    class="text-center"
                                    type="text"
                                    name="lastName"
                                    value="${user.lastName}"
                                    placeholder="Gates">
                        </div>
                    </div>
    
                    <div class="m-2">
                        <label>Date of Birth</label>
                        <input
                                class="text-center"
                                name="dateBirth"
                                value="${user.dateBirth}"
                                type="date">
                    </div>
    
                    <div class="m-2">
                        <label>Profession</label>
                        <select class="text-center" name="profession">
                            <jstl:forEach items="${professions}" var="prof">
                                <option value="${prof}" ${prof == user.profession ? "selected" : ""} >${prof.getValue()}</option>
                            </jstl:forEach>
                        </select>
                    </div>
    
                    <div class="m-2">
                        <button class="btn btn-primary">Save Changes</button>
                    </div>
                </form>
            </div>
            <div>
               <a class="btn btn-success" href="${pageContext.request.contextPath}/list">Back to List of Users</a>
            </div>
               <a href="${pageContext.request.contextPath}/">Home</a>


        </div>
    </body>
</html>