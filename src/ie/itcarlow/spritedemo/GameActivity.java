package ie.itcarlow.spritedemo;

import ie.itcarlow.spritedemo.manager.ResourceManager;
import ie.itcarlow.spritedemo.manager.SceneManager;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
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

public class GameActivity extends BaseGameActivity {
	private Camera camera;
	private ResourceManager resourceManager;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		camera = new Camera(0,0,480,860);
		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(480,860), this.camera);
	    engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
	    engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
	    return engineOptions;
	}

    @Override
	public void onCreateResources(
       OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws IOException {

        loadGfx();
        
    	ResourceManager.prepareManager(mEngine, this, camera, getVertexBufferObjectManager());
        resourceManager = ResourceManager.getInstance();
        pOnCreateResourcesCallback.onCreateResourcesFinished();
    }

    private void loadGfx() {     
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");  
        
    }

    @Override
  	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
  			throws IOException {
    	SceneManager.getInstance().createSplashScene(pOnCreateSceneCallback);
  	}

    @Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) 
          throws IOException {
    	mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback() 
        {
                public void onTimePassed(final TimerHandler pTimerHandler) 
                {
                    mEngine.unregisterUpdateHandler(pTimerHandler);
                    // load menu resources, create menu scene
                    // set menu scene using scene manager
                    // disposeSplashScene();
                    // READ NEXT ARTICLE FOR THIS PART.
                }
        }));
        pOnPopulateSceneCallback.onPopulateSceneFinished();
    }
     
    @Override 
    public Engine onCreateEngine(EngineOptions pEngineOptions) {
    	return new LimitedFPSEngine(pEngineOptions, 60);
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
