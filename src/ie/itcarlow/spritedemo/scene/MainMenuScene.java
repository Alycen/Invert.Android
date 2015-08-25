package ie.itcarlow.spritedemo.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import ie.itcarlow.spritedemo.Player;
import ie.itcarlow.spritedemo.base.BaseScene;
import ie.itcarlow.spritedemo.manager.ResourceManager;
import ie.itcarlow.spritedemo.manager.SceneManager;
import ie.itcarlow.spritedemo.manager.SceneManager.SceneType;

public class MainMenuScene extends BaseScene {
	private final int MENU_PLAY = 0;
	private final int MENU_SETTINGS = 1;
	private final int MENU_QUIT = 2;
	
	//private Player player = new Player(0,0,40,40,0);
	
	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_MENU;
	}

	@Override
	public void createScene() {
		createBackground();
	    //attachChild(player.getSprite());
	}

	public boolean onMenuItem(MainMenuScene pMenuScene, IMenuItem pMenuItem, float X, float Y) {
		switch(pMenuItem.getID()){
		case MENU_PLAY:
			//load game
			SceneManager.getInstance().loadGameScene(engine);
			return true;
		case MENU_SETTINGS:
			// SceneManager.getInstance().loadSettingsScene(engine);
			return true;
		case MENU_QUIT:
			System.exit(0);
			return true;
		default:
			return false;
		}
	}
	
	@Override
	public void onBackKeyPressed() {
		System.exit(0);		
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
	}
	
	/*public void checkMenu() {
		if (activity.Player.top() < 0)
			MENU_QUIT;
		if (activity.Player.right() > screenWidth)
			MENU_SETTINGS;
		else if (activity.Player.left() < 0)
			MENU_PLAY;
	}*/
	
	private void createBackground(){
	    attachChild(new Sprite(240, 430, resourceManager.menu_background_Region, vbom){
	        @Override
	        protected void preDraw(GLState pGLState, Camera pCamera){
	            super.preDraw(pGLState, pCamera);
	            pGLState.enableDither();
	        }
	    });
	}
	
	
}
