function notify(message){
    console.log(message)
    $('#notifyModal').modal('show');
    $('#notifyModalLabel').text('Notificación');
    $('#notifyModalBody').text(message);
};