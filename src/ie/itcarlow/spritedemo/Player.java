package ie.itcarlow.spritedemo;

import org.andengine.opengl.texture.region.ITextureRegion;

import com.badlogic.gdx.math.Vector2;

public class Player extends Block {
	private Vector2 velocity;
	
	
	public Player(float X, float Y,int type) {
		super(X, Y, type);
	}
	
	public Player(float X, float Y, float w, float h,int type) {
		super(X, Y, w, h, type);
		// TODO Auto-generated constructor stub
	}
	
	public void Move(int dir) {
		if(dir == 1) // UP
			position.x -= velocity.x;
		else if(dir == 2) // DOWN
			position.x += velocity.x;
		if(dir == 3) // LEFT
			position.y -= velocity.y;
		else if(dir == 4) // RIGHT
			position.y += velocity.y;
	}
}
