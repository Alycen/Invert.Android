package ie.itcarlow.spritedemo.manager;

import org.andengine.engine.Engine;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

import ie.itcarlow.spritedemo.base.BaseScene;
import ie.itcarlow.spritedemo.scene.LoadingScene;
import ie.itcarlow.spritedemo.scene.MainMenuScene;
import ie.itcarlow.spritedemo.scene.SplashScene;

public class SceneManager {
    private BaseScene splashScene;
    private BaseScene menuScene;
    private BaseScene gameScene;
    private BaseScene loadingScene;
    
    private static final SceneManager INSTANCE = new SceneManager();
    
    private SceneType currentSceneType = SceneType.SCENE_SPLASH;
    
    private BaseScene currentScene;
    
    private Engine engine = ResourceManager.getInstance().engine;
    
    public enum SceneType{
        SCENE_SPLASH,
        SCENE_MENU,
        SCENE_GAME,
        SCENE_LOADING,
    }
    
    public void setScene(BaseScene scene){
        engine.setScene(scene);
        currentScene = scene;
        currentSceneType = scene.getSceneType();
    }
    
    public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback){
        ResourceManager.getInstance().loadSplashScreen();
        splashScene = new SplashScene();
        currentScene = splashScene;
        pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
    }

    public void createMenuScene() {
    	ResourceManager.getInstance().loadMenuResources();
    	menuScene = new MainMenuScene();
    	loadingScene = new LoadingScene();
    	SceneManager.getInstance().setScene(menuScene);
    	disposeSplashScene();
    }
    
    public void setScene(SceneType sceneType){
        switch (sceneType){
            case SCENE_MENU:
                setScene(menuScene);
                break;
            case SCENE_GAME:
                setScene(gameScene);
                break;
            case SCENE_SPLASH:
                setScene(splashScene);
                break;
            case SCENE_LOADING:
                setScene(loadingScene);
                break;
            default:
                break;
        }
    }
    
    public static SceneManager getInstance(){
        return INSTANCE;
    }
    
    public SceneType getCurrentSceneType(){
        return currentSceneType;
    }
    
    public BaseScene getCurrentScene(){
        return currentScene;
    }
    
    private void disposeSplashScene(){
        ResourceManager.getInstance().unloadSplashScreen();
        splashScene.disposeScene();
        splashScene = null;
    }
}