package ie.itcarlow.spritedemo.manager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import ie.itcarlow.spritedemo.GameActivity;

public class ResourceManager {
    private static final ResourceManager INSTANCE = new ResourceManager();
    
    // ******************** //
    public ITextureRegion splash_Region;
    private BitmapTextureAtlas splashTextureAtlas;
    // ******************** //
    public ITextureRegion menu_background_Region;
    private BuildableBitmapTextureAtlas menuTextureAtlas;
    // ******************** //
    public BuildableBitmapTextureAtlas gameTextureAtlas;
    // ******************** //
    public ITiledTextureRegion loading_Region;
    private BitmapTextureAtlas loadingTextureAtlas;
    public AnimatedSprite loadingSprite;
    // ******************** //
    public ITiledTextureRegion player_Region;
    public AnimatedSprite playerSprite;
    // ******************** //
    public ITextureRegion block1_Region;
    public ITextureRegion block2_Region;
    public ITextureRegion finish_Region;
    private BitmapTextureAtlas blackTextureAtlas;
    // ******************** //
    
    public Engine engine;
    public GameActivity activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;
    
    public void loadMenuResources() {
        loadMenuGraphics();
        loadMenuAudio();
        loadLoadingScreen();
    }
    
    public void loadGameResources() {
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }

    public void loadPlayerGraphics(BuildableBitmapTextureAtlas bbmta) {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
    	player_Region = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbmta, activity, "playerMint.png", 10, 1);
    }
    
    public void loadBlockGraphics(BuildableBitmapTextureAtlas bbmta) {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
    	block1_Region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbmta, activity, "block1.png");
    	block2_Region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbmta, activity, "block2.png");
    	finish_Region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbmta, activity, "finish.png");
    }
    
    private void loadMenuGraphics() {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
    	menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	menu_background_Region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "bg01.png");     
    	loadPlayerGraphics(menuTextureAtlas);
    	try {
    	    this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    this.menuTextureAtlas.load();
    	} 
    	catch (final TextureAtlasBuilderException e){
    	        Debug.e(e);
    	}
    }
    
    private void loadMenuAudio() {
        
    }

    private void loadGameGraphics() {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024,1024,TextureOptions.BILINEAR);
        
        loadPlayerGraphics(gameTextureAtlas);
        loadBlockGraphics(gameTextureAtlas);
        try { 
        	this.gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,1,0));
        	this.gameTextureAtlas.load();
        }
        catch(final TextureAtlasBuilderException e) {
        	Debug.e(e);
        }
    }
    
    private void loadGameFonts() {
        
    }
    
    private void loadGameAudio() {
        
    }
    
    public void loadSplashScreen() {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
    	splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
    	splash_Region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
    	splashTextureAtlas.load();
    }
    
    public void unloadSplashScreen() {
    	splashTextureAtlas.unload();
    	splash_Region = null;
    }
    
    public void loadLoadingScreen() {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
    	loadingTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(),800,100,TextureOptions.BILINEAR);
    	loading_Region = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(loadingTextureAtlas, activity, "loading.png",0,0,8,1);
    	loadingTextureAtlas.load();
    }
    
    public void unloadMenuTextures() {
    	menuTextureAtlas.unload();
    }
    
    public void unloadGameTextures() {
    	
    }
    
    public void loadMenuTextures() {
    	menuTextureAtlas.load();
    }
    
    /**
     * @param engine
     * @param activity
     * @param camera
     * @param vbom
     * <br><br>
     * We use this method at beginning of game loading, to prepare Resources Manager properly,
     * setting all needed parameters, so we can latter access them from different classes (eg. scenes)
     */
    public static void prepareManager(Engine engine, GameActivity activity, Camera camera, VertexBufferObjectManager vbom) {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }
    
    public static ResourceManager getInstance() {
        return INSTANCE;
    }
}