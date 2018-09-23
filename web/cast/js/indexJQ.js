//Cargar contenido general
function clicContenido(id) {
    var tipo = $(id).attr('id');
    var carrera = $("#carrera").val();
    if (tipo === 'modalidad') {
        var dato = $("#cedula").val();
        var div = '#contenidoDinamico';
        var url = './Modalidades/ModalidadCN.jsp?acc=l';
        general(url, div, dato, carrera);
    } else if (tipo === 'tipoPractica') {
        var dato = $(id).attr('data-id');
        var div = '#bloqueInformacion';
        var url = './Modalidades/ModalidadProcesoCN.jsp?acc=l';
        general(url, div, dato, carrera);
    } else if (tipo === 'tutor') {
        var dato = $("#idPractica").val();
        var div = '#contenidoDinamico';
        var url = './Tutor/TutorCN.jsp?acc=l';
        general(url, div, dato, carrera);
    }
}
function general(url, div, dato, carrera) {
    $(div).html("<div style='margin-top: 30%;text-align: padding:2em;center;'><i class='fa fa-spinner fa-pulse fa-3x fa-fw'></i></div>");

    $.ajax({
        url: url,
        type: "GET",
        dataType: "text",
        data: {'dato': dato, 'carrera': carrera},
        success:
                function (data) {
                    var dataJSON = jQuery.parseJSON(data);
                    $(div).html(dataJSON.general);
                },
        error:
                function (error)
                {
                    $(div).html("Errrrrorrrrrr" + error);
                }
    });
}
//******************************** PÁGINA PRINCIPAL*****************************
//************************************Encabezado********************************
$(document).ready(function () {
    encabezado();
    //setTimeout(function () {
    //menuTutor();
    // }, 100);
});
function encabezado() {
    $.ajax({
        url: "./Principal/EncabezadoVW.jsp",
        type: "GET",
        dataType: "text",
        success:
                function (data) {
                    var dataJSON = jQuery.parseJSON(data);
                    $("#encabezado").html(dataJSON.encabezado);
                    menu();
                },
        error:
                function (error) {
//                    $("#encabezado").html("Errrrrorrrrrr: " + error); //Esto puso la moni
                    location.href = "login.jsp";
                }


    });
}
//************************************Menú Tutor********************************
function menuTutor() {
    
    $("#perfilPracticante").html("<div style='margin-top: 30%; text-align: center;'><i class='fa fa-spinner fa-pulse fa-3x fa-fw'></i></div>");
    var cedula = $("#cedula").val();
    $.ajax({
        url: "./Practicantes_Activos/PracticanteActivoCN.jsp?acc=l",
        type: "GET",
        dataType: "text",
        data: {'tipo': 'menuTutor', 'cedula': cedula},
        success:
                function (data) {
                    var dataJSON = jQuery.parseJSON(data);
                    $("#perfilPracticante").html(dataJSON.informacionPracticantes);
                },
        error:
                function (error)
                {
                    $("#perfilPracticante").html("Errrrrorrrrrr: " + error);

                }
    });
}
//************************************Menú Estudiante********************************
function menu() {
    $.ajax({
        url: "./Principal/MenuEstudianteVW.jsp",
        type: "GET",
        dataType: "text",
        success:
                function (data) {
                    var dataJSON = jQuery.parseJSON(data);
                    $("#principal").html(dataJSON.principal);
                    var tipoUsuario = $("#tipoUsuario").val();
                    if (tipoUsuario === 'DOCENTE') {
                        menuTutor();
                    }
                },
        error:
                function (error)
                {
                    $("#principal").html("Errrrrorrrrrr: " + error);

                }
    });
}

//************************************Perfil del Estudiante********************************

$(document).on('click', '.practica', function () {
    var id = $(this).attr('data-id');
    var idPractica = $(this).attr('data-idPractica');
    //alert(idPractica);
    // $("#perfilPracticante").empty();
    $.ajax({
        url: "./Principal/PerfilPracticanteVW.jsp",
        type: "GET",
        dataType: "text",
        success:
                function (data) {
                    var dataJSON = jQuery.parseJSON(data);
                    $("#perfilPracticante").html(dataJSON.perfil);
                    $("#idPracticaEstudiante").val(idPractica);
                },
        error:
                function (error)
                {
                    $("#perfilPracticante").html("Errrrrorrrrrr: " + error);
                }
    });

});
//*******************************Datos Practicante*****************************
function datosPracticante(id) {


}

//************************************Notificaciones********************************
function notificacion() {
    
    alert("Estimad@ docente usted tiene pendiente la revision de practicas de Liset Aucancela");
    
   

}
