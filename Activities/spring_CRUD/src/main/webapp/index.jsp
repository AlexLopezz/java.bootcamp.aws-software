<jsp:include page="layout/header.jsp" />
            <h1 class="d-inline bg-dark text-light">Welcome to my CRUD-App!</h1>
            <h3>What would you like to do?</h3>
            <ul class="list-unstyled">
                <li><a href="${pageContext.request.contextPath}/list">Show the List of all users</a></li>
                <li><a href="${pageContext.request.contextPath}/form">Add a new user to list</a></li>
            </ul>
<jsp:include page="layout/footer.jsp" />