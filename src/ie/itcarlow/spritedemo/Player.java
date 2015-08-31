package ie.itcarlow.spritedemo;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.physics.box2d.Body;

import ie.itcarlow.spritedemo.manager.ResourceManager;

public class Player extends AnimatedSprite
{
	private Body body;
	
    public Player(float pX, float pY, VertexBufferObjectManager vbo)
    {
        super(pX, pY, ResourceManager.getInstance().player_Region, vbo);
    }
    
    public void onDie() {
    	
    }
    
    public void anim() {
    	final long[] PLAYER_ANIMATE = new long[] {100,100,100};
    	animate(PLAYER_ANIMATE,0,9,true);
    }
    
}




/*package ie.itcarlow.spritedemo;

import ie.itcarlow.spritedemo.manager.ResourceManager;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;

import com.badlogic.gdx.math.Vector2;

public class Player {
	private Vector2 velocity;
	protected Vector2 position;
	protected float width, height;
	protected Sprite sprite;
	
	private ITextureRegion tex_Region;
	
	public Player(float X, float Y, float w, float h) {
		position.x = X;
		position.y = Y;
		width = w;
		height = h;
		makeSprite();
	}
	
	private void makeSprite() {
		tex_Region = ResourceManager.getInstance().player_Region;
		sprite = new Sprite(position.x, position.y, tex_Region, ResourceManager.getInstance().vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		};
	}
	
	public Sprite getSprite() {
		return sprite;
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
	
	public void Update() {
		
	}
}
*/