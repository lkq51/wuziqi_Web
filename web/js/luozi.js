/**
 * Created by lkq on 2016/11/28.
 */
function getCanvasPos(canvas,e) {
    var rect=canvas.getBoundingClientRect();
    return{
        x:e.clientX-rect.left*(canvas.width/rect.width),
        y:e.clientY-rect.top*(canvas.height/rect.height)
    };
}
function getqiziPosition(clickPosition) {
    var x;
    var y;
    x=clickPosition.x/40;
    y=clickPosition.y/40;
    var x1=x*40;
    var x2=(x+1)*40;
    var y1=y*40;
    var y2=(y+1)*40;

    var distances={distance1:0,distance2:0,distance3:0,distance4:0};
    var distance.distance1=Math.sqrt(Math.pow((clickPosition.x-x1),2)+Math.pow((clickPosition.y-y1),2));
    var distance2=Math.sqrt(Math.pow((x2-clickPosition.x),2)+Math.pow((clickPosition.y-y1),2));
    var distance3=Math.sqrt(Math.pow((clickPosition.x-x1),2)+Math.pow((y2-clickPosition.y),2));
    var distance4=Math.sqrt(Math.pow((x2-clickPosition.x),2)+Math.pow((y2-clickPosition.y),2));

}

function draw(e) {
    var qipan = document.getElementById("qipan");
    var context=qipan.getContext("2d");
    var clickPosition=getCanvasPos(qipan,e);
    var qiziPosition=
    context.fillStyle="yellow";
    context.beginPath();
    context.arc(qizi.x,qizi.y,15,0,Math.PI*2,true);
    context.closePath();
    context.fill();
}