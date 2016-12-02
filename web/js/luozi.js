/**
 * Created by lkq on 2016/11/28.
 */
   var event,
       BLACK = "black",
       WHITE = "white",
       winner = "",         //胜利者
       turn = 0,            //当前进行的回合数*2
       moveFirst = BLACK, //哪种颜色先下
       color = WHITE,     //棋子当前显示的颜色
       qizis = new Array(),//存储整个棋盘棋子分布的数组
       canvasSize = 750,    //画布大小
       grid = 15,           //棋盘大小为grid * grid
       whoPlay = BLACK;     //轮到哪一方下棋了
       chessSize = 20,   //棋子的半径
       chessboardSize = 700, //棋盘的边长
       extra = (canvasSize - chessboardSize) / 2,  //棋盘与画布的空余
       interval=chessboardSize / (grid-1); //每个格子的边长
   for(var i = 0;i<grid;i++){
       qizis[i] = new Array();
   }
function getCanvasPos(canvas) {
    var rect = canvas.getBoundingClientRect();
    return{
        x: event.clientX - rect.left * (canvas.width / rect.width),
        y: event.clientY - rect.top * (canvas.height / rect.height)
    };
}
function getqiziPosition() {
    var clickPosition = getCanvasPos(qipan);
    if(clickPosition.x>(extra+chessboardSize)&&clickPosition.x<extra&&clickPosition.y<extra&&clickPosition.y>(extra+chessboardSize)){
        return null;
    }
    clickPosition.x = clickPosition.x - extra;
    clickPosition.y = clickPosition.y - extra;
    var x = parseInt(clickPosition.x / interval),
        y = parseInt(clickPosition.y / interval),
        points = [];
        points[0] = {x: x * interval, y: y * interval};
        points[1] = {x: (x + 1) * interval, y: y * interval};
        points[2] = {x: x * interval, y: (y + 1) * interval};
        points[3] = {x: (x + 1) * interval, y: (y + 1) * interval};
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
    points[lowest].x = parseInt(points[lowest].x / interval );
    points[lowest].y = parseInt(points[lowest].y / interval );
    return points[lowest];
}
//在页面上显示出落子
function draw(qiziPosition) {
    var qipan = document.getElementById("qipan"),
        context = qipan.getContext("2d");
    context.fillStyle = color;
    context.beginPath();
    context.arc(qiziPosition.x * interval +extra, qiziPosition.y * interval + extra, chessSize, 0, Math.PI * 2, true);
    context.closePath();
    context.fill();
}
//判断左下到右上是否已连成五子
function leftBottom_rightTop(qiziPosition) {
    var num_qizi = 0,
        row = qiziPosition.x,
        col = qiziPosition.y;
    while(row>-1&&row<grid&&col>-1&&col<grid){
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
    while (row>-1&&row<grid&&col>-1&&col<grid){
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
    while(row>-1&&row<grid&&col>-1&&col<grid){
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
    while(row>-1&&row<grid&&col>-1&&col<grid){
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
    while(row>-1&&row<grid&&col>-1&&col<grid){
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
    while(row>-1&&row<grid&&col>-1&&col<grid){
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
    while(row>-1&&row<grid&&col>-1&&col<grid){
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
    while(row>-1&&row<grid&&col>-1&&col<grid){
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
function checkIfinBoard(qiziPosition) {
    if (qiziPosition!=null&&qiziPosition.x<15&&qiziPosition.x>-1&&qiziPosition.y<15&&qiziPosition.y>-1){
        return true;
    }else {
        return false;
    }
}
function checkNull(qiziPosition) {
    if(qizis[qiziPosition.x][qiziPosition.y]!=BLACK&&qizis[qiziPosition.x][qiziPosition.y]!=WHITE){
        return true;
    } else{
        return false;
    }
}
function move() {
    color = whoPlay;
    var qiziPosition = getqiziPosition();
    if (checkIfinBoard(qiziPosition)&&checkNull(qiziPosition)) {
        qizis[qiziPosition.x][qiziPosition.y] = color;
        draw(qiziPosition);
        turn++;
        if(ifWin(qiziPosition)){
            winner = whoPlay;
        }
        if(whoPlay==BLACK){
            whoPlay = WHITE;
        }else {
            whoPlay =BLACK;
        }
    }else {
        warning();
    }
}
function warning() {
    document.getElementById("winner").innerHTML="此处不能落子！！";
    setTimeout(function(){
        document.getElementById("winner").innerHTML="";
    },3000);
}
function tip() {
       if (whoPlay == BLACK&&!winner){
           document.getElementById("tip").innerHTML="<h1>请黑方落子</h1>";
       }
       if (whoPlay == WHITE&&!winner){
           document.getElementById("tip").innerHTML="<h1>请白方落子</h1>";
       }
}
function gameOver() {
    document.getElementById("qipan").removeAttribute("onclick");
    var congratulationWinner = "恭喜执"+winner+"子选手获得胜利";
    document.getElementById("winner").innerHTML = congratulationWinner;
}
//游戏进行
function gameOn(e) {
        event = e;
        move();
        tip();
       if(winner){
           gameOver();
       }
}


function takeBack() {

}