<%-- 
    Document   : NuevaVenta
    Created on : 3/05/2024, 11:11:58 p. m.
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
        <title>VENTAS</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controller?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-8 d-flex">
                                    <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrescliente" value="${c.getNom()}" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos producto </label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-8 d-flex">
                                    <input type="text" name="codigoproducto" value="${pr.getId()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreProducto" value="${pr.getNom()}" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${pr.getPrecio()}" class="form-control" placeholder="$ 0.00">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cant" placeholder="" class="form-control">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${pr.getStock()}" placeholder="stock" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>NumeroSerie</label>
                            <input type="text" name="NroSerie " value="${nSerie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="l" items="${list}">
                                    <tr>
                                        <td>${l.getItem()}</td>
                                        <td>${l.getId()}</td>
                                        <td>${l.getDescripcionP()}</td>
                                        <td>${l.getPrecio()}</td>
                                        <td>${l.getCantidad()}</td>
                                        <td>${l.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <a href="Controller?menu=NuevaVenta&accion=Delete&item=${l.getItem()}" 
                                               class="btn btn-danger" style="margin-left: 10px">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controller?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            <a href="Controller?menu=NuevaVenta&accion=Cancelar" class="btn btn-success">Cancelar</a>
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value="$ ${totalPagar}0" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

    </body>
</html>
<%
    } else {
        request.getRequestDispatcher("Error.jsp?redireccion=index.jsp").forward(request, response);
    }
%>
