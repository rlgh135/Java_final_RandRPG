package Java_Final_RandRPG;

import java.util.*;

class Map {
  private char[][] map = new char[5][5];
  private int col, row;
  private int g_col, g_row;
  private int final_level = 5;
  public int level;
  public boolean is_there_m;
  
  public Map(){
    col = 0;
    row = 0;
    level = 1;
    exit();
    location(row, col);
  }
  public Map(int col, int row, int g_col, int g_row, int level){
    this.col = col;
    this.row = row;
    this.level = level;
    this.g_col = g_col;
    this.g_row = g_row;
    location(row, col);
  }
  public ArrayList<Integer> Info() {
	  ArrayList<Integer> l = new ArrayList<Integer>();
	  l.add(col); l.add(row); l.add(g_col); l.add(g_row); l.add(level);
	  return l;
  }
  private void monster_exists(){
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
  public boolean move(char dir){
    if(dir == 'a'){
      if(col == 0)  col = 4;
      else col--;
    }
    else if(dir == 's'){
      if(row == 4)  row = 0;
      else row++;
    }
    else if(dir == 'w'){
      if(row == 0)  row = 4;
      else row--;
    }
    else if(dir == 'd'){
      if(col == 4)  col = 0;
      else col++;
    }
    location(row, col);
    monster_exists();
    if(nextLevel()){
        level++;
        return true;
    }
    return false;
  }
  public void exit(){
    Random rand = new Random();
    g_row = 1+rand.nextInt(4);
    g_col = rand.nextInt(5);
  }
  public void displayGoal(){
      map[g_row][g_col] = 'G';
  }
  
  public boolean nextLevel(){
    if(g_col == col && g_row == row){
      col = 0; row = 0;
      exit();
      location(row, col);
      return true;
    }
    return false;
  }
  public void print_map(){
	System.out.println();
	System.out.println("\t\t MAP");
	System.out.println("--------------------------------------");
	System.out.println("\t Level of Tower : " + level);
	System.out.println();
    for(int i = 0; i < 5; i++){
    	System.out.print("\t");
      for(int j = 0; j < 5; j++)
        System.out.print("|"+map[i][j]+"| ");
      System.out.println("\n");
    }
    System.out.println("--------------------------------------\n");
    Interface.show_play();
  }
  public boolean EOG() {
	  if(level > final_level) {
		  Interface.show_ending();
		  return true;
	  }
	  return false;
  }
}