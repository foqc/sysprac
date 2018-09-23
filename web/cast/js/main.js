var contador = 1;
function main() {

    if (contador === 1) {
        $('#menu').animate({
            left: '0'
        });
        contador = 0;
    } else {
        contador = 1;
        $('#menu').animate({
            left: '-100%'
        });
    }
}
$(document).on('click', '.menuV', function () {
    contador = 1;
    $('#menu').animate({
        left: '-100%'
    });
});



//abrir modal observacion
$(document).ready(function () {

});

function openModal(idModal) {
    $(idModal).css('display', 'fixed');
}
function closeModal(idModal) {
    $(idModal).css('display', 'none');
}
//sesiones
let b = 1;
function session() {

    if (b === 1) {
        $('#nav-sesion').slideDown();
        $('.fatg').removeClass('fa-caret-down');
        $('.fatg').addClass('fa-caret-up');
        b = 0;
    } else {
        b = 1;
        $('.fatg').removeClass('fa-caret-up');
        $('.fatg').addClass('fa-caret-down');
        $('#nav-sesion').slideUp();
    }
}


//INTEGRACION GESTION OBSERVACIONES Y CALENDARIO

//Obtener lista de actividades con idplanificacion
function clicListActividad(id) {

    var idPractica = $("#idPracticaEstudiante").val();
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'actividades', 'idplan': idPractica}, //Aqui deberia coger el id de la planificacion, para enviar en ves del 1 estatico puesto
        success:
                function (data) {
                    var dataJSON = jQuery.parseJSON(data);
                    $("#contenidoDinamico").html(dataJSON.contenidoDinamico);
                },
        error:
                function (error)
                {
                    $("#contenidoDinamico").html("Error" + error);
                }

    });
}

//Abrir Observacion
function abrirO(id) {
    let observacion = $('#listar' + id).val();
    $('#itxa' + id).val(observacion);
    $('.' + id).removeClass('hide-modal');
}
function abriElim(id) {
    let observacion = $('#listar' + id).val();
    $('#txtEliminar' + id).val(observacion);
    $('.eliminar' + id).removeClass('hide-modal');
}
//Ingresar Observacion
function ingresarOR(id) {
    let observacionI = $('#itxa' + id).val();
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
//                data: observacionI,
        data: {'accion': 'ingresarO', 'id': id, 'txto': observacionI},
        dataType: 'text',
        success: function (response) {
            var data = jQuery.parseJSON(response);
            if (data.result === "si") {
                let observacion = $('#itxa' + id).val();
                $("#txtObservacionMovil").html("<label id='txtObservacionMovil' style='font-style: normal;'>" + observacion + "</label>");
                $("#child4" + id).html("<div id='child4" + id + "' style='float: right;' class='child4 color1'><i class='item fa fa-sticky-note fa-lg' aria-hidden='true' onclick=abrirO('" + id + "');return false;></i><input  id='listar" + id + "' type='hidden' value='" + observacion + "'><div class='iconoEliminar' style='float: right;'><i class='fa fa-trash-o' aria-hidden='true' onclick=abriElim('" + id + "');return false; ></i></div></div>");
                $("#mostrarObs" + id).html("<div id='mostrarObs'" + id + " class='itemDer'>" + observacion + "</div>");
            } else {
                alert('Observación no ingresada');
            }
        },
        error: function (error) {
            alert('Error al ingresar' + error);
        }
    });
    $('.' + id).toggleClass('hide-modal');
}
//Eliminar Observacion 
function eliminarOR(id) {
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'eliminarO', 'id': id, 'txto': '0'},
        success: function (response) {
            var data = jQuery.parseJSON(response);
            if (data.result === "si") {
                $('#itxa' + id).val("");
                $("#txtObservacionMovil").html("<label id='txtObservacionMovil' style='font-style: italic;'>No existen observaciones</label>");
                $('#txtEliminar' + id).val("");
                let observacion = $('#itxa' + id).val();
                $("#child4" + id).html("<div id='child4" + id + "' style='float: right;' class='child4 color1'><i class='item fa fa-plus fa-lg' aria-hidden='true' onclick= abrirO('" + id + "');return false;></i><input  id='listar" + id + "' type='hidden' value='" + observacion + "'></div>");
            }
            $("#txtObservacionMovil").html("<label id='txtObservacionMovil' style='font-style: italic;'>No existen observaciones</label>");
        },
        error: function (error) {
            alert('Error al ingresar' + error);
        }
    });
    $('.eliminar' + id).toggleClass('hide-modal');
}

//Construir calendario
function calendario(id, data) {

    $(id).fullCalendar({
        header: {
            left: 'prev,next',
            center: 'title',
            right: 'today,month,listYear '
        },
        //evento click de las actividades 
        eventClick: function (data) {
            var idPractica = $("#idPracticaEstudiante").val();
            var idA = data.id;
            //Fechas
            var calendar = $(id).fullCalendar('getCalendar');
            var m = calendar.moment().format();
            var n = $.fullCalendar.moment().format();

//            alert('View: ' + data.end );
            console.log((data.end)); // Forma de acceder a cada id.... por los indices 0,1,2.....n
            if (data.end === m) {
                console.log("revise");
            } else {
                console.log("no puede revisar");
            }

            $("#contenidoDinamico").html("<div style='margin-top: 30%; text-align: center;'><i class='fa fa-spinner fa-pulse fa-3x fa-fw'></i></div>");

            $.ajax({
                url: "./Actividades/ActividadesCN.jsp",
                type: "GET",
                dataType: "text",

                data: {'accion': 'actividadesR', 'idP': idPractica, 'idA': idA}, //Aqui deberia coger el id de la planificacion, para enviar en ves del 1 estatico puesto

                success:
                        function (data) {
                            var dataJSON = jQuery.parseJSON(data);
                            $("#contenidoDinamico").html(dataJSON.contenidoDinamico);
                        },

                error:
                        function (error)
                        {
                            $("#contenidoDinamico").html("Errrrrorrrrrr" + error);
                        }
            });
        },

        events: data
    });

}

//Obtener lista de actividades para Calendario
function clicActividades(id) {
    var idPractica = $("#idPracticaEstudiante").val();
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'calendario', 'idplan': idPractica}, //Aqui deberia coger el id de la planificacion, para enviar en ves del 1 estatico puesto
        success:
                function (response) {
                    console.log(response);
                    $("#contenidoDinamico").html('');
                    var cA = document.createElement("div");
                    cA.id = "calendar";
                    document.getElementById("contenidoDinamico").appendChild(cA);
                    var data = jQuery.parseJSON(response);
                    calendario("#calendar", data.events); //usando la funcion calendario
                },
        error:
                function (error)
                {
                    $("#contenidoDinamico").html("Error" + error);
                }
    });
}

//FIN INTEGRACION GOBSERVACIONES Y CALENDARIO

//Inicio de la integracion actividades revision 50 y 100
function clicActividadR(idA) {

    $("#contenidoDinamico").html("<div style='margin-top: 30%; text-align: center;'><i class='fa fa-spinner fa-pulse fa-3x fa-fw'></i></div>");
//    var tipo = $(id).attr('id');
//    var strong = $(id).html();//cpturo el id

//    $("strong").empty();
//    $(("strong")).html(strong);
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'revision', 'idA': idA},
        success:
                function (data) {
                    var dataJSON = jQuery.parseJSON(data);
                    $("#contenidoDinamico").html(dataJSON.contenidoDinamico);
                },
        error:
                function (error)
                {
                    $("#contenidoDinamico").html("Errrrrorrrrrr" + error);
                }
    });
}
// parte web
function clicRevisionWeb(idA) {
    var estado;
    if ($('#revisionWeb' + idA).prop('checked')) {
        estado = 'true';
    } else if
            ($('#revisionWeb' + idA).prop('checked', false)) {
        estado = 'false';
    }
//    var  estado = new Boolean(true);
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'actividadRevisar', 'idA': idA, 'estado': estado},
        success:
                function (response) {
                    var data = jQuery.parseJSON(response);
                    if (data.result === "si") {
                        $("#child7Web" + idA).html("<div  id='child7Web" + idA + "' class='color3'><i class='fa fa-check-circle fa-2x' aria-hidden='true'></i></div>");

                    } else if (data.result === "no") {
                        $("#child7Web" + idA).html("<div id='child7Web" + idA + "' class='color2'><i class='fa fa-times-circle fa-2x' aria-hidden='true' ></i></div>");
                    }
                },
        error:
                function (error)
                {
                    $("#contenidoDinamico").html("Errrrrorrrrrr" + error);
                }
    });
}
//parte movil
function clicRevision(idA) {
    var estado;
    if ($('#revisionMovil').prop('checked')) {
        estado = 'true';
    } else if
            ($('#revisionMovil').prop('checked', false)) {
        estado = 'false';
    }
//    var  estado = new Boolean(true);
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'actividadRevisar', 'idA': idA, 'estado': estado},
        success:
                function (response) {
                    var data = jQuery.parseJSON(response);
                    if (data.result === "si") {
                        $("#child7Web" + idA).html("<div  id='child7Web" + idA + "' class='color3'><i class='fa fa-check-circle fa-2x' aria-hidden='true' onclick=clicActividadR('" + idA + "');return false;></i></div>");

                    } else if (data.result === "no") {
                        $("#child7Web" + idA).html("<div id='child7Web" + idA + "' class='color2'><i class='fa fa-times-circle fa-2x' aria-hidden='true' onclick=clicActividadR('" + idA + "');return false;></i></div>");
                    }
                },
        error:
                function (error)
                {
                    $("#contenidoDinamico").html("Errrrrorrrrrr" + error);
                }
    });
}

function clicDesmarcar(idA) {

    var estado = new Boolean(false);

    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'actividadRevisar', 'idA': idA, 'estado': estado},
        success:
                function (response) {
                    var data = jQuery.parseJSON(response);
                    if (data.result === "si") {
                        $("#child7Web" + idA).html("<div class='child7Web'" + idA + "' color1'><i class='fa fa-times-circle fa-2x' aria-hidden='true'></i></div>");
                    }
                },
        error:
                function (error)
                {
                    $("#contenidoDinamico").html("Errrrrorrrrrr" + error);
                }
    });
}


function clicListActividadR(id) {
    var idPractica = $("#idPracticaEstudiante").val();
    $("#contenidoDinamico").html("<div style='margin-top: 30%; text-align: center;'><i class='fa fa-spinner fa-pulse fa-3x fa-fw'></i></div>");
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",

        data: {'accion': 'actividadesR', 'idP': idPractica, 'idA': id}, //Aqui deberia coger el id de la planificacion, para enviar en ves del 1 estatico puesto

        success:
                function (data) {
                    var dataJSON = jQuery.parseJSON(data);
                    $("#contenidoDinamico").html(dataJSON.contenidoDinamico);
                },
        error:
                function (error)
                {
                    $("#contenidoDinamico").html("Errrrrorrrrrr" + error);
                }
    });
}

function cancelarModal(id) {
    $('.' + id).toggleClass('hide-modal');
}

function cancelarModalIcono(id) {
    $('.' + id).toggleClass('hide-modal');
}

function cancelarModalE(id) {
    $('#' + id).toggleClass('hide-modal');
}

function cancelarModalIconoE(id) {
    $('#' + id).toggleClass('hide-modal');
}



//CODIGO JS PARA LA IMPLEMENTACION DE LA NOTIFICACION---- EF

//Notificacion 50% y 100%;

function dmy(fecha, indice) {
    var result = "";
    var fe = fecha.split("-")[indice];
    if (fe.charAt(0) === "0") {
        result = fe.charAt(1);
    } else {
        result = fe;
    }
    return result;
}


function compararHoyDB(a, adb, m, mdb, d, ddb) {
    var result = "no";
    if (a.toString() === adb.toString() && m.toString() === mdb.toString() && d.toString() === ddb.toString()) {
        result = "si";
    }
    return result;
}


function notifica(descripcion, fecha, idplan) {
    $.ajax({
        url: "./Notificacion/NotificacionesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'ingresarNo', 'descripcion': descripcion, 'fecha': fecha, 'idp': idplan},
        success:
                function (response) {
                    var data = jQuery.parseJSON(response);
                    if (data.result === "si") {
                        $("#cam").css("color", "green");
                        menuNotificacion();
                    }
                },
        error:
                function (error)
                {
                    console.log(error);
                }
    });
}

//window.onload = function () {
//    notificar50();
//};
function notificar50() {

    var accion = "cincuenta";
    var tipoAc = 2;
    var idPlan = 1;
    var hoy = new Date();
    var dd = hoy.getDate();
    var mm = hoy.getMonth() + 1;
    var yyyy = hoy.getFullYear();
    $.ajax({
        url: "./Actividades/ActividadesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': accion, 'tipoA': tipoAc}, //Aqui deberia coger el id de la planificacion, para enviar en ves del 1 estatico puesto
        success:
                function (response) {
                    var dataJSON = jQuery.parseJSON(response);
                    var verificar = compararHoyDB(dmy(dataJSON[0].FechaInicio, 0), yyyy, dmy(dataJSON[0].FechaInicio, 1), mm, dmy(dataJSON[0].FechaInicio, 2) - 2, dd);
                    var fechaNot = `${yyyy}-${mm}-${dd}`;
                    if (verificar === "si") {
                        notifica(dataJSON[0].Descripcion, fechaNot, idPlan);
                    }
                },
        error:
                function (error)
                {
                    console.log(error);
                }
    });
}

function menuNotificacion() {
    $.ajax({
        url: "./Notificacion/NotificacionesCN.jsp",
        type: "GET",
        dataType: "text",
        data: {'accion': 'menuNo', 'idp': 1}, //Aqui deberia coger el id de la planificacion, para enviar en ves del 1 estatico puesto
        success:
                function (response) {
                    var dataJSON = jQuery.parseJSON(response);
                    $("#contadorNot").html(dataJSON.contador);
                    $("#camp").append(dataJSON.result);
                    $("#camp").on('click', function () {
                        $("#navMenuNo").toggleClass("activarMenuNo");
                    });
                },
        error:
                function (error)
                {
                    console.log(error);
                }
    });
}

$(".logo").on('click', function () {
    console.log('d');
});