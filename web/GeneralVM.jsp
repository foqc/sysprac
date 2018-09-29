<%@page import="practicas.modelo.entidad.cUsuario"%>
<%@page import="practicas.controlador.ControladorLogin"%>
<%
   try {
        String cedula = (String) session.getAttribute("cedula");
        
        if (!datosUsuario.equals("")) {
            session.setAttribute("cedula", cedula);
            session.setAttribute("datosUsuario", datosUsuario);
            response.sendRedirect("GeneralCN.jsp");
        }
    } catch (Exception ex) {
        // TODO handle custom exceptions here
    }

%>