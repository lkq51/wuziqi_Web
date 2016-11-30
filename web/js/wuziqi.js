/**
 * Created by lkq on 2016/11/28.
 */
var qipan = document.getElementById("qipan");
    grid = 14,           //棋盘大小为grid * grid
    chessSize = 20,   //棋子的半径
    chessboardSize = 700, //棋盘的边长
    interval=chessboardSize / grid; //每个格子的边长
if (qipan.getContext){
    var context = qipan.getContext("2d"),
        e = e|| window.event,
        qipanSize = {width:chessboardSize, height:chessboardSize},
        line=0;
    context.fillStyle = "rgba(0, 0, 255, 0.5)";
    context.fillRect(0, 0, qipanSize.width, qipanSize.height);
    context.beginPath();
    context.strokeStyle = "black";
    for (var i = 0;i<15;i++){
        line = i * (qipanSize.width/grid);
        context.moveTo(line, 0);
        context.lineTo(line, qipanSize.height);
        context.stroke();
    }
    for (var i = 0;i<15;i++){
        line = i * (qipanSize.height/grid);
        context.moveTo(0, line);
        context.lineTo(qipanSize.width,line);
        context.stroke();
    }
    context.closePath();
}