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
	protected int type;
	
	protected ITextureRegion tex_Region;
	
	public Block(float X, float Y,int type) {
		position.x = X;
		position.y = Y;
		width = 20;
		height = 20;
		makeSprite();
	}
	
	public Block(float X, float Y, float w, float h,int t) {
		position.x = X;
		position.y = Y;
		width = w;
		height = h;
		type = t;
		makeSprite();
	}
	
	protected void makeSprite() {
		if (type == 1)
			tex_Region = ResourceManager.getInstance().block1_Region;
		else if (type == 2)
			tex_Region = ResourceManager.getInstance().block2_Region;
		else if (type == 3)
		  	tex_Region = ResourceManager.getInstance().finish_Region;
	
		sprite = new Sprite(position.x, position.y, tex_Region, ResourceManager.getInstance().vbom);
	}
	
	protected void Move() {
		
	}
	
	public void Update(long time) {
		
	}
	

	public Sprite getSprite(){
		return sprite;
	}
}
