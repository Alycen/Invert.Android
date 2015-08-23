package ie.itcarlow.spritedemo;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

public class GameActivity extends BaseGameActivity {/*implements IOnSceneTouchListener, IUpdateHandler{
	private static final int CAMERA_WIDTH = 720;
	private static final int CAMERA_HEIGHT = 480;

	private BitmapTextureAtlas mTexture;
	private BitmapTextureAtlas mBearTexture;
	
	private ITextureRegion mBearTextureRegion;
	private Scene mScene;

	private Sprite mBear;
	
	private ITiledTextureRegion mCountTextureRegion;
	
	Vector velocity;
	
	private AnimatedSprite count10Sprite; */

	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, 480, 800);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(480, 860), camera);
	}

    @Override
	public void onCreateResources(
       OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws IOException {

    	 loadGfx();
		 pOnCreateResourcesCallback.onCreateResourcesFinished();
    }

    private void loadGfx() {     
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");  
        /*mTexture = new BitmapTextureAtlas(getTextureManager(), 320,32);  
        mBearTexture = new BitmapTextureAtlas(getTextureManager(), 46, 54);
        mCountTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mTexture, this, "count10.png", 0, 0, 10, 1);
        mBearTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBearTexture, this, "austrian_bear.png", 0,0);
        		
        mTexture.load();
        mBearTexture.load();*/
    }

    @Override
  	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
  			throws IOException {
/*
  		this.mScene = new Scene();
  		this.mScene.setBackground(new Background(0, 125, 58));
  		// Register this activity as a scene touch listener
  		this.mScene.setOnSceneTouchListener(this);
  	    pOnCreateSceneCallback.onCreateSceneFinished(this.mScene);  	*/	
  	}

    @Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) 
          throws IOException {

       // Setup coordinates for the sprite in order that it will
       //  be centered on the camera.
	 /* final float centerX = (CAMERA_WIDTH - this.mCountTextureRegion.getWidth()) / 2;
	   final float centerY = (CAMERA_HEIGHT - this.mCountTextureRegion.getHeight()) / 2; 
	   
	   mBear = new Sprite(centerX, centerY, mBearTextureRegion,  this.mEngine.getVertexBufferObjectManager());
	// Create a sprite and add it to the scene. mSpriteTextureRegion, this.mEngine.getVertexBufferObjectManager());
	   //mSpriteTextureRegion, this.mEngine.getVertexBufferObjectManager());

	   count10Sprite = new AnimatedSprite(centerX + 100, centerY, mCountTextureRegion, this.mEngine.getVertexBufferObjectManager()) {
	     @Override
	     public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
	        final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
	              this.setPosition(pSceneTouchEvent.getX() -  
	                     this.getWidth() / 2,   
	                     pSceneTouchEvent.getY() - this.getHeight() / 2);
	              return true;
	     }
	   };
	   this.mScene.registerTouchArea(count10Sprite);
	   
	   count10Sprite.animate(1000);
	   
	   mScene.attachChild(count10Sprite);
	   mScene.attachChild(mBear);
	   // register this activity as an update handler with the engine
	   this.mEngine.registerUpdateHandler(this);
	   pOnPopulateSceneCallback.onPopulateSceneFinished(); */
    }
     
    
	/*@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		//count10Sprite.setPosition(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
		//Get difference between count10Sprite.pos and pSceneTouchEvent.pos
		velocity = new Vector(pSceneTouchEvent.getX() - count10Sprite.getX(), pSceneTouchEvent.getY() - count10Sprite.getY());
		count10Sprite.setPosition(count10Sprite.getX() + velocity.getX(), count10Sprite.getY() + velocity.getY());
		
		
		return false;
	}
*/
	/*@Override
	public void onUpdate(float pSecondsElapsed) {
		// TODO Auto-generated method stub
		//count10Sprite.setPosition(count10Sprite.getX() + 1, count10Sprite.getY() + 1);
		if (count10Sprite.collidesWith(mBear) ) {
			count10Sprite.setColor(1.0f, 0.0f, 0.0f);
			mBear.setPosition(velocity.getX()+ mBear.getX(), velocity.getY() + mBear.getY());
		}
		else {
			count10Sprite.setColor(0.0f, 1.0f, 0.0f);
		}
		
		if (mBear.getX() > CAMERA_WIDTH || mBear.getX() < 0 || mBear.getY() > CAMERA_HEIGHT || mBear.getY() < 0) {
			mScene.detachChild(mBear);
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}*/
}
