/**
 * Created by lkq on 2016/11/28.
 */

var qipan = document.getElementById("qipan");
    grid = 15,           //棋盘大小为grid * grid
    canvasSize = 750,
    chessSize = 20,   //棋子的半径
    chessboardSize = 700, //棋盘的边长
    extra = (canvasSize - chessboardSize) / 2,
    interval=chessboardSize / (grid-1); //每个格子的边长
if (qipan.getContext){
    var context = qipan.getContext("2d"),
        e = e|| window.event,
        qipanSize = {width:chessboardSize, height:chessboardSize},
        x = 0,
        y = 0;

    context.fillStyle = "rgba(0,255,255, 0.5)";
    context.fillRect(0, 0, canvasSize, canvasSize);
    context.fillStyle = "rgba(0, 0, 255, 0.5)";
    context.fillRect(extra, extra, qipanSize.width, qipanSize.height);
    context.beginPath();
    context.strokeStyle = "black";
    for (var i = 0;i<15;i++){
        x = i * interval+extra;
        context.moveTo(x, extra);
        context.lineTo(x, qipanSize.height+extra);
        context.stroke();
    }
    for (var i = 0;i<15;i++){
        y = i * interval+extra;
        context.moveTo(extra, y);
        context.lineTo(qipanSize.width+extra,y);
        context.stroke();
    }
    context.closePath();
}