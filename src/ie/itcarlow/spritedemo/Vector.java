package ie.itcarlow.spritedemo;

public class Vector {
	private float x;
	private float y;
	
	public Vector(float xNew, float yNew){
		x = xNew;
		y = yNew;
	}
	
	public float getX(){
		return x;
	}
	public void setX(float newx){
		x = newx;
	}
	public float getY(){
		return y;
	}
	public void setY(float newy){
		y = newy;
	}
}
