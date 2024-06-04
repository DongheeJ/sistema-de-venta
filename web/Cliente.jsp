<%-- 
    Document   : Cliente
    Created on : 3/05/2024, 11:11:25 p. m.
    Author     : jodon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession val = request.getSession(true);
    if (val != null && val.getAttribute("usuario") != null) {
%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>Clientes</title>
    </head>
    <body>
        
        <div class="d-flex">
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="Controller?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${porAcutalizar.getDni()}" name="txtDni" class="form control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${porAcutalizar.getNom()}" name="txtNom" class="form control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${porAcutalizar.getAdress()}" name="txtDirec" class="form control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${porAcutalizar.getEstado()}" name="txtEstado" class="form control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-info">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>DNI</td>
                            <td>Nombres</td>
                            <td>Direccion</td>
                            <td>Estado</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${clientes}">
                            <tr>
                                <td>${em.getId()}</td>
                                <td>${em.getDni()}</td>
                                <td>${em.getNom()}</td>
                                <td>${em.getAdress()}</td>
                                <td>${em.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controller?menu=Cliente&accion=Editar&id=${em.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controller?menu=Cliente&accion=Delete&id=${em.getId()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>


        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

    </body>
</html>
<%
    } else {
        request.getRequestDispatcher("Error.jsp?redireccion=index.jsp").forward(request, response);
    }
%>