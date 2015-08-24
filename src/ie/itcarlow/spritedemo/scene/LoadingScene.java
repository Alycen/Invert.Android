package ie.itcarlow.spritedemo.scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.util.adt.color.Color;

import ie.itcarlow.spritedemo.base.BaseScene;
import ie.itcarlow.spritedemo.manager.SceneManager.SceneType;

public class LoadingScene extends BaseScene{
    @Override
    public void createScene(){
        setBackground(new Background(Color.WHITE));
        final float x = (240 - resourceManager.loading_Region.getWidth()) / 2;
        final float y = (430 - resourceManager.loading_Region.getHeight()) / 2;
        
        resourceManager.loadingSprite = new AnimatedSprite(x,y, resourceManager.loading_Region,resourceManager.engine.getVertexBufferObjectManager());
        resourceManager.loadingSprite.animate(500);
    }

    @Override
    public void onBackKeyPressed(){
        return;
    }
    
    @Override
    public SceneType getSceneType(){
        return SceneType.SCENE_LOADING;
    }

    @Override
    public void disposeScene(){

    }
}