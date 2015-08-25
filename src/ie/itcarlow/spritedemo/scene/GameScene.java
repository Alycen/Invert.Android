package ie.itcarlow.spritedemo.scene;

import java.io.IOException;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.util.SAXUtils;
import org.andengine.util.adt.color.Color;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.constants.LevelConstants;
import org.andengine.util.level.simple.SimpleLevelLoader;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import ie.itcarlow.spritedemo.base.BaseScene;
import ie.itcarlow.spritedemo.manager.SceneManager;
import ie.itcarlow.spritedemo.manager.SceneManager.SceneType;

public class GameScene extends BaseScene {
	private static final String TAG_ENTITY = "entity";
	private static final String TAG_ENTITY_ATTRIBUTE_X = "x";
	private static final String TAG_ENTITY_ATTRIBUTE_Y = "y";
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE = "type";
	
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE_PLAYER = "player";
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE_BLOCK1 = "block1";
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE_BLOCK2 = "block2";
	private static final String TAG_ENTITY_ATTRIBUTE_TYPE_FINISH = "finish";
	
	private void createHUD() {
		// Don't want a HUD In the game.
		// I know I get marks for one but right now I don't need it and it looks cluttered 
	}
	
	@Override
	public void createScene() {
		setBackground(new Background(Color.WHITE));
		loadLevel(1);
	}

	private void loadLevel(int ID){
	   
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
