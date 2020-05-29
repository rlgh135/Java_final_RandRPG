import java.util.Random;

class Map {
  private char[][] map = new char[5][5];
  private int col, row;
  private int g_col, g_row;
  private int level;
  private boolean is_there_m, level_up;
  
  public Map(){
    col = 0;
    row = 0;
    level = 1;
    exit();
    location(row, col);
  }
  public Map(int col, int row, int level){
    this.col = col;
    this.row = row;
    this.level = level;
    exit();
    location(row, col);
  }
  public void monster_exists(){
    Random rand = new Random();
    is_there_m = rand.nextBoolean();
  }
  public void location(int r, int c){
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++)
        map[i][j] = '_';
    }
    map[r][c] = 'P';
    displayGoal();
  }
  public void move(char dir){
    if(dir == 'h'){
      if(col == 0)  col = 4;
      else col--;
    }
    else if(dir == 'j'){
      if(row == 4)  row = 0;
      else row++;
    }
    else if(dir == 'k'){
      if(row == 0)  row = 4;
      else row--;
    }
    else if(dir == 'l'){
      if(col == 4)  col = 0;
      else col++;
    }
    location(row, col);
    monster_exists();
  }
  public void exit(){
    Random rand = new Random();
    g_row = rand.nextInt(1+5);
    g_col = rand.nextInt(1+5);
    level_up = false;
  }
  public void displayGoal(){
      map[g_row][g_col] = 'G';
  }
  public void exit(int level){
    if(!level_up) return;
    level++;
    exit();
  }
  public boolean nextLevel(){
    if(g_col == col && g_row == row){
      level_up = true;
      col = 0; row = 0;
      location(row, col);
      return true;
    }
    return false;
  }
  public void print_map(){
    System.out.println("h:left j:down k:up l:right");
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++)
        System.out.print("|"+map[i][j]+"|");
      System.out.println();
    }
    System.out.println("Level of Top: "+level);
    if(is_there_m){
      System.out.println("몬스터 출몰");
    }
    System.out.println();
    if(nextLevel()){
      exit(level);
      print_map();
    }
  }
}
