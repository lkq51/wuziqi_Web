/**
 * Created by lkq on 2016/11/28.
 */
var qipan = document.getElementById("qipan");

if (qipan.getContext){
    var context=qipan.getContext("2d");
    var e=e||window.event;
    var qipanSize={width:600,height:600};
    var line=0;
    context.fillStyle="rgba(0,0,255,0.5)";
    context.fillRect(0,0,qipanSize.width,qipanSize.height);
    context.beginPath();
    context.strokeStyle="black";
    for (var i=0;i<15;i++){
        line=i*(qipanSize.width/15);
        context.moveTo(line,0);
        context.lineTo(line,qipanSize.height);
        context.stroke();
    }
    for (var i=0;i<15;i++){
        line=i*(qipanSize.height/15);
        context.moveTo(0,line);
        context.lineTo(qipanSize.width,line);
        context.stroke();
    }
    context.closePath();
}