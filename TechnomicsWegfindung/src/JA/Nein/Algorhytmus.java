package JA.Nein;

public class Algorhytmus{

    public static void main(String[] args) {
        initialize();
    }

public static void initialize(){    
char cols = 5;
char rows = 5;
char grid = new Array(cols);

char openSet [];
char closedSet [];
char start;
char end;
char w, h;

function Spot(i,j) {
    this.x = i;
    this.y = j;
    this.f = 0;
    this.g = 0;
    this.h = 0;


    this.show = function() {
        fill(255);
        stroke(0);
      rect(this.x * w, this.y * h, w, h);
    }

}

/*function setup() {
    createCanvas(400, 400);
    console.log('A*');
}*/

w = width / cols;
h = hight / rows;

//2D Array
for (var i = 0; i < cols; i++) {
    grid[i] = new Array(rows);
} 

for (var i = 0; i < cols; i++) {
  for (var j = 0; j < rows; j ++) {
      grid[i][j] = new Spot(i,j);
    }
}

//Start und Ende Definieren
start = grid[0][0];
end = grid[cols - 1][rows - 1];

openSet.push(start);

console.log(grid);

}

function draw() {

    if (openSet.leght > 0){
      // weiter gehts  
    } else {
      // keine Lösung
    }

    background(0);

for (var i = 0; i < cols; i++){
  for (var j = 0; j < rows; i++){
    grid[i][j].show();

  }    
}





    }
}