<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <h4>${empty edit?"Add new":"Edit" } category</h4>
<form:form class="form-horizontal col-sm-9" role="form" method="post" commandName="category" action="${pageContext.request.contextPath}/admin/add/category">
        <form:hidden path="id"/>
        <div class="form-group">
            <label class="control-label col-sm-2">Name:</label>

            <div class="col-sm-10">
                <form:input class="form-control" path="name" placeholder="Enter name"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Description:</label>

            <div class="col-sm-10">
                <form:input path="description" class="form-control" placeholder="Enter description"/>
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-danger" value="${empty edit?'Add new':'Edit' } category"/>
            </div>
        </div>
    </form:form>