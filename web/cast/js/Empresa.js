function fncAddEmpresa() {
    var idTipoEmpresa = Math.floor((Math.random() * 1000) + 1) * -1;
    var divTEmpresa = $("<div class='unidad'>");
    var div2 = $("<div class='input-group'id='" + idTipoEmpresa + "' data-tipo='dedicacion'>");
    var divtEmpresa = $("<span class='input-group-addon'>Dedicacion:</span>");
    var InputEmpresa = $("<input type='text' class='form-control'>");
    var quitarEmpresa = $("<span class='input-group-addon' data-toggle='tooltip' data-placement='bottom' title='Eliminar Dedicacion'><i class='fa fa-minus-circle'></i></span></div>");
    div2.append(divtEmpresa);
    div2.append(InputEmpresa);
    div2.append(quitarEmpresa);
    divTEmpresa.append(div2);
    quitarEmpresa.click(function () {
        divTEmpresa.remove();
    });
    $("#seccionContenido").append(divTEmpresa);
}
/*Guardar*/
//function fncBtnGuardarEmpresa() {
//    var btnGuardar = $("#btnGuardar");
//    if (btnGuardar !== undefined) {
//        btnGuardar.html('Guardar | <i class="fa fa-spinner fa-spin" ></i>');
//        /* Deshabilitar*/
//        _fncDeshabilitarContenido();
//        var empresa = getJSONEmpresa();
//        guardarDedicacion(empresa);
//    }
//}