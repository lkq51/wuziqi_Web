/**
 * Created by lkq on 2016/11/28.
 */
   var turn = 0,
       moveFirst = "black",
       qizis = new Array(),
       win;
   for(var i = 0;i<15;i++){
       qizis[i] = new Array();
   }
function getCanvasPos(canvas, e) {
    var rect = canvas.getBoundingClientRect();
    return{
        x: e.clientX - rect.left * (canvas.width / rect.width),
        y: e.clientY - rect.top * (canvas.height / rect.height)
    };
}
function getqiziPosition(e) {
    var clickPosition = getCanvasPos(qipan, e),
        x = parseInt(clickPosition.x / 40),
        y = parseInt(clickPosition.y / 40),
        points = [];
        points[0] = {x: x * 40, y: y * 40};
        points[1] = {x: (x + 1) * 40, y: y * 40};
        points[2] = {x: x * 40, y: (y + 1) * 40};
        points[3] = {x: (x + 1) * 40, y: (y + 1) * 40};
        var distances = [];
        distances[0] = Math.sqrt(Math.pow((clickPosition.x - points[0].x), 2) + Math.pow((clickPosition.y - points[0].y), 2));
        distances[1] = Math.sqrt(Math.pow((points[1].x - clickPosition.x), 2) + Math.pow((clickPosition.y - points[1].y), 2));
        distances[2] = Math.sqrt(Math.pow((clickPosition.x - points[2].x), 2) + Math.pow((points[2].y - clickPosition.y), 2));
        distances[3] = Math.sqrt(Math.pow((points[3].x - clickPosition.x), 2) + Math.pow((points[3].y - clickPosition.y), 2));
        lowest = 0;
    for(var i = 0;i<distances.length;i++){
        if (distances[i]<distances[lowest])
            lowest = i;
    }
    points[lowest].x=parseInt(points[lowest].x/40);
    points[lowest].y=parseInt(points[lowest].y/40)
    return points[lowest];
}
//在页面上显示出落子
function draw(e) {
    var qipan = document.getElementById("qipan"),
        context = qipan.getContext("2d"),
        qiziPosition = getqiziPosition(e);
    context.fillStyle = "yellow";
    context.beginPath();
    context.arc(qiziPosition.x * 40, qiziPosition.y * 40, 15, 0, Math.PI * 2, true);
    context.closePath();
    context.fill();
}
//判断左下到右上是否已连成五子
function leftBottom_rightTop(qiziPosition) {
    var num_qizi = 0,
        row = qiziPosition.x,
        col = qiziPosition.y;
    while(row>-1&&row<15&&col>-1&&col<15){
        if(qizis[row][col]!=qizis[qiziPosition.x][qiziPosition.y]){
            break;
        }else {
            num_qizi++;
        }
        if (row>qiziPosition.x+4||row<qiziPosition.x-4||col>qiziPosition.y+4||col<qiziPosition.y-4){
            break;
        }
        row++;
        col--;
    }
    row = qiziPosition.x - 1;
    col = qiziPosition.y + 1;
    while (row>-1&&row<15&&col>-1&&col<15){
        if (qizis[row][col]!=qizis[qiziPosition.x][qiziPosition.y]){
            break;
        }else {
            num_qizi++;
        }
        if (row>qiziPosition.x + 4||row<qiziPosition.x - 4||col>qiziPosition.y + 4||col< qiziPosition.y - 4){
            break;
        }
        row--;
        col++;
    }
    return num_qizi >= 5;
}
//判断左上到右下是否已连成五
function leftTop_rightBottom(qiziPosition) {
    var row = qiziPosition.x,
        col = qiziPosition.y,
        num_qizi = 0;
    while(row>-1&&row<15&&col>-1&&col<15){
        if(qizis[row][col]!=qizis[qiziPosition.x][qiziPosition.y]){
            break;
        }else {
            num_qizi++;
        }
        if (row>qiziPosition.x+4||row<qiziPosition.x-4||col>qiziPosition.y+4||col<qiziPosition.y-4){
            break;
        }
        row--;
        col--;
    }
    row = qiziPosition.x+1;
    col = qiziPosition.y+1;
    while(row>-1&&row<15&&col>-1&&col<15){
        if(qizis[row][col]!=qizis[qiziPosition.x][qiziPosition.y]){
            break;
        }else {
            num_qizi++;
        }
        if (row>qiziPosition.x+4||row<qiziPosition.x-4||col>qiziPosition.y+4||col<qiziPosition.y-4){
            break;
        }
        row++;
        col++;
    }
    return num_qizi >= 5;
}
//判断左到右是否已连成五子
function left_right(qiziPosition) {
    var row = qiziPosition.x,
        col = qiziPosition.y,
        num_qizi = 0;
    while(row>-1&&row<15&&col>-1&&col<15){
        if(qizis[row][col]!=qizis[qiziPosition.x][qiziPosition.y]){
            break;
        }else {
            num_qizi++;
        }
        if (row>qiziPosition.x+4||row<qiziPosition.x-4||col>qiziPosition.y+4||col<qiziPosition.y-4){
            break;
        }
        row--;
    }
    row = qiziPosition.x+1;
    while(row>-1&&row<15&&col>-1&&col<15){
        if(qizis[row][col]!=qizis[qiziPosition.x][qiziPosition.y]){
            break;
        }else {
            num_qizi++;
        }
        if (row>qiziPosition.x+4||row<qiziPosition.x-4||col>qiziPosition.y+4||col<qiziPosition.y-4){
            break;
        }
        row++;
    }
    return num_qizi >= 5;
}
//判断上到下是否已连成五子
function top_bottom(qiziPosition) {
    var row = qiziPosition.x,
        col = qiziPosition.y,
        num_qizi = 0;
    while(row>-1&&row<15&&col>-1&&col<15){
        if(qizis[row][col]!=qizis[qiziPosition.x][qiziPosition.y]){
            break;
        }else {
            num_qizi++;
        }
        if (row>qiziPosition.x+4||row<qiziPosition.x-4||col>qiziPosition.y+4||col<qiziPosition.y-4){
            break;
        }
        col--;
    }
    col = qiziPosition.y+1;
    while(row>-1&&row<15&&col>-1&&col<15){
        if(qizis[row][col]!=qizis[qiziPosition.x][qiziPosition.y]){
            break;
        }else {
            num_qizi++;
        }
        if (row>qiziPosition.x+4||row<qiziPosition.x-4||col>qiziPosition.y+4||col<qiziPosition.y-4){
            break;
        }
        col++;
    }
    return num_qizi >= 5;
}
//判断是否有人取胜
function ifWin(qiziPosition) {
    return left_right(qiziPosition) | leftBottom_rightTop(qiziPosition) | leftTop_rightBottom(qiziPosition) | top_bottom(qiziPosition);
}
//白子落子
function whiteMove(e) {
    document.getElementById("blackTip").style.visibility="hidden";
    document.getElementById("whiteTip").style.visibility="visible";
    qizis[getqiziPosition(e).x][getqiziPosition(e).y]=1;
    draw(e);
    turn++;
    return ifWin(getqiziPosition(e));

}
//黑子落子
function blackMove(e) {
    document.getElementById("blackTip").style.visibility = "visible";
    document.getElementById("whiteTip").style.visibility = "hidden";
    qizis[getqiziPosition(e).x][getqiziPosition(e).y] = 0;
    draw(e);
    turn++;
    return ifWin(getqiziPosition(e));
}
//哪方落子
function isWho(e) {
    if (moveFirst == "black"){
        if(turn % 2>0){
            win = whiteMove(e);
        }else {
            win = blackMove(e);
        }
    }else {
        if (turn % 2>0){
            win = blackMove(e);
        }else {
            win = whiteMove(e);
        }
    }
    alert(win);
}
//游戏进行
function gameOn(e) {
    isWho(e);
}