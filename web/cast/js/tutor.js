/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(main);
var contador = 1;
function main() {
    $('#toggle').click(function () {
        if (contador === 1) {
            $('#nav').slideDown(300);
            $('.fatg').removeClass('fa-caret-down');
            $('.fatg').addClass('fa-caret-up');
            contador = 0;
        } else {
            contador = 1;
            $('.fatg').removeClass('fa-caret-up');
            $('.fatg').addClass('fa-caret-down');
            $('#nav').slideUp(300);
        }
    });
}