package ie.itcarlow.spritedemo;

import ie.itcarlow.spritedemo.manager.ResourceManager;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;

import com.badlogic.gdx.math.Vector2;

public class Block {
	protected Vector2 position;
	protected Vector2 velocity;
	
	protected Sprite sprite;
	
	protected float width;
	protected float height;
	public float[] top,bottom,left,right;
	
	protected ITextureRegion tex_Region;
	
	public Block(float X, float Y,int type) {
		position.x = X;
		position.y = Y;
		width = 20;
		height = 20;
		if(type==1)
			sprite = new Sprite(position.x,position.y,ResourceManager.getInstance().block1_Region,ResourceManager.getInstance().vbom);
		else if(type==2)
			sprite = new Sprite(position.x,position.y,ResourceManager.getInstance().block2_Region,ResourceManager.getInstance().vbom);
		else
			sprite = new Sprite(position.x,position.y,ResourceManager.getInstance().player_Region,ResourceManager.getInstance().vbom);
	}
	
	public Block(float X, float Y, float w, float h,int type) {
		position.x = X;
		position.y = Y;
		width = w;
		height = h;
		if(type==1)
			sprite = new Sprite(position.x,position.y,ResourceManager.getInstance().block1_Region,ResourceManager.getInstance().vbom);
		else if(type==2)
			sprite = new Sprite(position.x,position.y,ResourceManager.getInstance().block2_Region,ResourceManager.getInstance().vbom);
		else
			sprite = new Sprite(position.x,position.y,ResourceManager.getInstance().player_Region,ResourceManager.getInstance().vbom);
	}
	
	public float[] top() {
		return top;
	}
	
	public float[] bottom() {
		return bottom;
	}
	
	public float[] left() {
		return left;
	}
	
	public float[] right() {
		return right;
	}
	
	protected void Move() {
		
	}
	
	public void Update(long time) {
		top[0] = position.x;
		top[1] = position.y;
		top[2] = position.x + width;
		top[3] = position.y;
		
		bottom[0] = position.x;
		bottom[1] = position.y + height;
		bottom[2] = position.x + width;
		bottom[3] = position.y + height;
		
		left[0] = position.x;
		left[1] = position.y;
		left[2] = position.x;
		left[3] = position.y + height;
		
		right[0] = position.x + width;
		right[1] = position.y;
		right[2] = position.x + width;
		right[3] = position.y + height;
	}
	
	public boolean isColliding(Block b) {
		if(b.bottom[1] > top[1] && b.left[0] > right[0] || b.right[0] < left[0]) // colliding at the bottom of b
			return true;
		else if (b.top[1] < bottom[1] && b.left[0] > right[0] || b.right[0] < left[0]) // colliding at the top of b
			return true;
		if(b.left[0] > right[0] && b.bottom[1] > top[1] || b.top[1] < bottom[1]) // colliding at the left of b
			return true;
		else if (b.right[0] < left[0] && b.bottom[11] > top[1] || b.top[1] < bottom[1]) // colliding at the right of b
			return true;
		else 
			return false;
	}
	
	public Sprite getSprite(){
		return sprite;
	}
}
