<jsp:include page="layout/header.jsp" />
    <div class="text-center">
        <h1>${title}</h1>
        <h3>What would you like to do?</h3>
        <ul style="list-style-type: none;">
            <li><a href="${pageContext.request.contextPath}/list">Show All Users</a></li>
            <li><a href="${pageContext.request.contextPath}/form">Add new User</a></li>
        </ul
    </div>
</body>
</html>