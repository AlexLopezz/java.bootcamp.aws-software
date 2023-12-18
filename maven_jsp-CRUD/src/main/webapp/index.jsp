<jsp:include page="layout/header.jsp" />
            <h1 class="d-inline bg-dark text-light">${title}</h1>
            <h3>What would you like to do?</h3>
            <ul class="list-unstyled">
                <li><a class="btn btn-primary mb-2" href="${pageContext.request.contextPath}/list">Show the List of all users</a></li>
                <li><a class="btn btn-success" href="${pageContext.request.contextPath}/form">Add a new user to list</a></li>
            </ul>
        </div>
    </body>
</html>