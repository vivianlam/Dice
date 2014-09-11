import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

//Vivian Lam, AP Computer Science, Mod 6/7, DICE
Die dice1;
Die dice2;
int totalDots;
public void setup()
{
	size(1000,768);
	noLoop();
}
public void draw()
{
	background(0);
	for (int j=0; j<1000; j+=50){
		for(int k=0; k<750; k+=50){
			dice1=new Die(j,k);
			dice1.roll();
			dice1.show();
		}
	}
	for (int j=25; j<1000; j+=50){
		for(int k=25; k<750; k+=50){
			dice2=new Die(j,k);
			dice2.roll();
			dice2.show();
		}
	}
	fill(255);
	textSize(20);
	text("T",5,750);
	text("O",55,750);
	text("T",105,750);
	text("A",155,750);
	text("L",205,750);
	text("R",305,750);
	text("O",355,750);
	text("L",405,750);
	text("L",455,750);
	text("S",505,750);
	text(":",555,750);
	text(""+totalDots,255,766);

}
public void mousePressed()
{
	totalDots=0;
	redraw();
}
class Die //models one single dice cube
{
	//variable declarations here
	int numDots, myX, myY;
	Die(int x, int y) //constructor
	{
		numDots=6;
		myX=x;
		myY=y;
	}
	public void roll()
	{
		numDots=(int)(Math.random()*6)+1;

	}
	public void show()
	{
		fill(255);
		rect(myX,myY,25,25);
		if(numDots==1){
			fill(0);
			ellipse(myX+12, myY+12, 5,5);
			totalDots++;
		}
		if(numDots==2){
			fill(0);
			ellipse(myX+20,myY+5,5,5);
			ellipse(myX+5,myY+20,5,5);
			totalDots+=2;
		}
		if(numDots==3){
			fill(0);
			ellipse(myX+20,myY+5,5,5);
			ellipse(myX+5,myY+20,5,5);
			ellipse(myX+12,myY+12,5,5);
			totalDots+=3;
		}
		if(numDots==4){
			fill(0);
			ellipse(myX+20,myY+5,5,5);
			ellipse(myX+5,myY+5,5,5);
			ellipse(myX+20,myY+20,5,5);
			ellipse(myX+5,myY+20,5,5);
			totalDots+=4;
		}
		if(numDots==5){
			fill(0);
			ellipse(myX+20,myY+5,5,5);
			ellipse(myX+5,myY+5,5,5);
			ellipse(myX+20,myY+20,5,5);
			ellipse(myX+5,myY+20,5,5);
			ellipse(myX+12, myY+12, 5,5);
			totalDots+=5;
		}
		if(numDots==6){
			fill(0);
			ellipse(myX+20,myY+5,5,5);
			ellipse(myX+5,myY+5,5,5);
			ellipse(myX+20,myY+20,5,5);
			ellipse(myX+5,myY+20,5,5);
			ellipse(myX+5,myY+12,5,5);
			ellipse(myX+20,myY+12,5,5);
			totalDots+=6;
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
