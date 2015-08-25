package ie.itcarlow.spritedemo.scene;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

import ie.itcarlow.spritedemo.base.BaseScene;
import ie.itcarlow.spritedemo.manager.SceneManager;
import ie.itcarlow.spritedemo.manager.SceneManager.SceneType;

public class GameScene extends BaseScene {
	
	private void createHUD() {
		// Don't want a HUD In the game.
		// I know I get marks for one but right now I don't need it and it looks cluttered 
	}
	
	@Override
	public void createScene() {
		setBackground(new Background(Color.WHITE));
	}

	@Override
	public void onBackKeyPressed() {
		SceneManager.getInstance().loadMenuScene(engine);
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_GAME;
	}

	@Override
	public void disposeScene() {
		camera.setHUD(null);
		camera.setCenter(240,430);
		// TODO code responsible for disposing scene
		// removing all game objects
	}
}
