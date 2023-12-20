<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="jakarta.tags.core" %>

<jsp:include page="layout/header.jsp" />
    <h1>${title}</h1>
    <form class="center" action="${pageContext.request.contextPath}/form" method="POST">
        <div class="field">
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

        <div class="field">
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
        <jstl:choose>
        <jstl:when test="${user.dni == null}">
            <div class="field">
                <div>
                    <label>DNI</label>
                </div>
                <div>
                    <input
                     class="text-center"
                     type="text"
                     name="dni"
                     placeholder="11222333">
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

        <div class="field">
            <label>Date of Birth</label>
            <input
             class="text-center"
             name="dateBirth"
             value="${user.dateBirth}"
             type="date">
        </div>
        
        <div class="field">
            <label>Profession</label>
            <select class="text-center" name="profession">
                <option value="#" disabled selected>--- Select An Option ---</option>
                <jstl:forEach items="${professions}" var="prof">
                    <option value="${prof}" ${prof == user.profession ? "selected" : ""} >${prof}</option>
                </jstl:forEach>
            </select>
        </div>

        <div class="field" style="margin-top: 25px;">
            <button class="button btn-new">Save Changes</button>
        </div>
    </form>
    <a href="${pageContext.request.contextPath}/list">Back</a>
</body>
</html>