/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework;

import Src.Framework.Menus.MainMenu;
import Src.Framework.Menus.OptionsAudioMenu;
import Src.Framework.Menus.OptionsMenu;
import java.io.IOException;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.openal.*;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.AL;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.Util.checkALError;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;
import org.newdawn.slick.Color;
import org.newdawn.slick.openal.WaveData;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
/**
 *
 * @author Lemonzap
 */
public class Game{
    Window window;
    private float idealFrameRate = 60.0f;
    private float realFrameRate;
    private double lastFrameTime = 0.0;
    private double timeSinceLastFrame = 0.0;
    
    private Texture logo;
    
    //which option in a menu is currently selected from top to bottom
    int menuSelection = 1;
    private GLFWKeyCallback keyCallBack;
    
    //Possible states of the game
    private enum GameState{STARTING, MAIN_MENU, PLAYING}
    public enum MenuState{MAIN_MENU, SINGLEPLAYER_MENU, MULTIPLAYER_MENU, STAGE_CREATOR_MENU, OPTIONS_MENU, AUDIO_OPTIONS_MENU}
    
    private GameState gameState;
    private MenuState menuState;

    public MenuState getMenuState(){
        return menuState;
    }

    public void setMenuState(MenuState menuState){
        this.menuState = menuState;
    }
    
    Game(Window window){
        this.window = window;
        gameState = GameState.STARTING;
    }
    
    //main game loop
    public void loop(){
        
        while( glfwWindowShouldClose(window.getWindowHandle()) == GL_FALSE ) {
            
            //currently unused
            //updateInputs();
            updateGame();
            Audio.fade();
            
            //only render at desired fps
            timeSinceLastFrame = (System.nanoTime()/1000000000.0)- lastFrameTime;
            if(1.0/timeSinceLastFrame <= idealFrameRate){
                render();
                realFrameRate = (float)(1.0/timeSinceLastFrame);
                lastFrameTime = System.nanoTime()/1000000000.0;
            }

            // Poll for window events(including inputs)
            glfwPollEvents();
        }
        //close openAL
        Audio.device.destroy();
    }
    
    //per frame game logic
    private void updateGame(){
        switch(gameState){
            case STARTING:
                load();
                initInputPolling();
                gameState = GameState.MAIN_MENU;
                MainMenu.init(this);
                break;
            case MAIN_MENU:
                break;
            case PLAYING:
                
                break;
        }
    }
    
    //render per frame
    private void render(){
        // clear the framebuffer 
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        
        switch(gameState){
            case STARTING:
                break;
            case MAIN_MENU:
                
                switch(menuState){
                            case MAIN_MENU:
                                MainMenu.render();
                                break;
                            case SINGLEPLAYER_MENU:
                                break;
                            case MULTIPLAYER_MENU:
                                break;
                            case STAGE_CREATOR_MENU:
                                break;
                            case OPTIONS_MENU:
                                OptionsMenu.render();
                                break;
                            case AUDIO_OPTIONS_MENU:
                                OptionsAudioMenu.render();
                        }
                
                break;
            case PLAYING:
                
                break;
        }
        
         // swap the frame buffers
        glfwSwapBuffers(window.getWindowHandle());
    }
    
    private void load(){
        //load splash screen and display it before loading everything else
        try{
            logo = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/LemonzapLogo.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        } catch (IOException e){
            e.printStackTrace();
        }
        //bind white before binding any textures
        Color.white.bind();
        logo.bind();
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2d(0, 0);
            GL11.glVertex2i(0, 0);
                    
            GL11.glTexCoord2d(1, 0);
            GL11.glVertex2i(1024, 0);
                    
            GL11.glTexCoord2d(1, 1);
            GL11.glVertex2i(1024, 512);
                    
            GL11.glTexCoord2d(0, 1);
            GL11.glVertex2i(0, 512);
        GL11.glEnd();
        glfwSwapBuffers(window.getWindowHandle());
        
        //loading resources for main menu
        Audio.loadOpenAL();
        MainMenu.load();
        OptionsMenu.load();
        OptionsAudioMenu.load();
        
    }
    
    private void initInputPolling(){
        //set up input polling
        glfwSetKeyCallback(window.getWindowHandle(), keyCallBack = new GLFWKeyCallback(){
            //called whenever input has changed
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                switch(gameState){
                    case MAIN_MENU:
                        
                        switch(menuState){
                            case MAIN_MENU:
                                MainMenu.handleInputs(window, key, scancode, action, mods);
                                break;
                            case SINGLEPLAYER_MENU:
                                break;
                            case MULTIPLAYER_MENU:
                                break;
                            case STAGE_CREATOR_MENU:
                                break;
                            case OPTIONS_MENU:
                                OptionsMenu.handleInputs(window, key, scancode, action, mods);
                                break;
                            case AUDIO_OPTIONS_MENU:
                                OptionsAudioMenu.handleInputs(window, key, scancode, action, mods);
                        }
                        
                        break;
                    case PLAYING:
                        break;
                }
            }
        });
    }
    
    public static boolean allFalse(boolean[] array){
        for(boolean b : array) if(b) return false;
            return true;
    }
    
}
