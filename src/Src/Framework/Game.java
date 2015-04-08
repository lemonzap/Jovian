/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework;

import Src.Framework.Menus.MainMenu;
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
    
    private Texture logo;
    
    ALContext context;
    ALDevice device;

    Audio menuMusic;
    Audio menuChangeSelection;
    Audio menuSelect;
    
    //which option in a menu is currently selected from top to bottom
    int menuSelection = 1;
    private GLFWKeyCallback keyCallBack;
    
    //Possible states of the game
    private enum GameState{STARTING, MAIN_MENU, PLAYING}
    
    private GameState gameState;
    
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
            render();

            // Poll for window events(including inputs)
            glfwPollEvents();
        }
        
    }
    
    //per frame game logic
    private void updateGame(){
        switch(gameState){
            case STARTING:
                load();
                initInputPolling();
                gameState = GameState.MAIN_MENU;
                menuMusic.play(true);
                break;
            case MAIN_MENU:
                break;
            case PLAYING:
                
                break;
        }
    }
    
    //per frame what inputs have changed
    private void updateInputs(){
        
    }
    
    //render per frame
    private void render(){
        // clear the framebuffer 
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        
        switch(gameState){
            case STARTING:
                break;
            case MAIN_MENU:
                
                MainMenu.render();
                
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
        loadOpenAL();
        MainMenu.load();  
        //placeholder sounds
        menuMusic = new Audio("Src/Resources/Sounds/MMXTitleTheme.wav", true);
        menuChangeSelection = new Audio("Src/Resources/Sounds/Blip_Select.wav", false);
        menuSelect = new Audio("Src/Resources/Sounds/blipChoose.wav", false);
        
    }
    
    private void initInputPolling(){
        //set up input polling
        glfwSetKeyCallback(window.getWindowHandle(), keyCallBack = new GLFWKeyCallback(){
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                switch(gameState){
                    case MAIN_MENU:
                        if ( key == GLFW_KEY_W && (action == GLFW_PRESS || action == GLFW_REPEAT)){
                            menuSelection-=1;
                            //if selection would increment past limit then undo
                            if(menuSelection == 0){
                                menuSelection+=1;
                            }else{
                                MainMenu.setSelection(menuSelection);
                                menuChangeSelection.play(false);
                            }
                        }
                        if ( key == GLFW_KEY_S && (action == GLFW_PRESS || action == GLFW_REPEAT)){
                            menuSelection+=1;
                            //if selection would increment past limit then undo
                            if(menuSelection == 6){
                                menuSelection-=1;
                            }else{
                                MainMenu.setSelection(menuSelection);
                                menuChangeSelection.play(false);
                            }
                        }
                        if ( key == GLFW_KEY_ENTER && (action == GLFW_RELEASE)){
                            menuSelect.play(false);
                            switch(menuSelection){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    //wait for select sound to stop playing before closing
                                    while(menuSelect.isPlaying()){
                                        
                                    }
                                    //tell main loop to exit
                                    glfwSetWindowShouldClose(window, GL_TRUE);
                                    //close openAL
                                    device.destroy();
                                    break;
                                    
                            }
                        }
                        break;
                    case PLAYING:
                        break;
                }
            }
        });
    }
    
    private void loadOpenAL(){
        //ready openAL for use
        context = ALContext.create();
        device = context.getDevice();
        context.makeCurrent();
        ALCCapabilities capabilities = device.getCapabilities();
 
        if (!capabilities.OpenALC10){
            throw new RuntimeException("OpenAL Context Creation failed");
        }
        
        //setup source and buffer ints according to openAL standards
        Audio.createMusicSource();
        Audio.createSources(15);
    }
    
}
