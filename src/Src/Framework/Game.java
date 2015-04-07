/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework;

import java.io.IOException;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.Color;
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
    private Texture menuBackground;
    private Texture title;
    private Texture singleplayer;
    private Texture multiplayer;
    private Texture stageCreator;
    private Texture options;
    private Texture exit;
    private Texture singleplayerSelected;
    private Texture multiplayerSelected;
    private Texture stageCreatorSelected;
    private Texture optionsSelected;
    private Texture exitSelected;
    
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
            
            updateInputs();
            updateGame();
            render();

            // Poll for window events
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
                //bind white before binding any textures
                Color.white.bind();
                menuBackground.bind();
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
                
                Color.white.bind();
                title.bind();
                GL11.glBegin(GL11.GL_QUADS);
                    GL11.glTexCoord2d(0, 0);
                    GL11.glVertex2i(256, 0);
                    
                    GL11.glTexCoord2d(1, 0);
                    GL11.glVertex2i(768, 0);
                    
                    GL11.glTexCoord2d(1, 1);
                    GL11.glVertex2i(768, 167);
                    
                    GL11.glTexCoord2d(0, 1);
                    GL11.glVertex2i(256, 167);
                GL11.glEnd();
                
                switch(menuSelection){
                    case 1:
                        Color.white.bind();
                        singleplayerSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 256);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        multiplayer.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 320);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        stageCreator.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 320);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 384);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        options.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 384);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 448);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        exit.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 448);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 512);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 512);
                        GL11.glEnd();
                        break;
                    case 2:
                        Color.white.bind();
                        singleplayer.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 256);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        multiplayerSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 320);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        stageCreator.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 320);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 384);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        options.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 384);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 448);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        exit.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 448);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 512);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 512);
                        GL11.glEnd();
                        break;
                    case 3:
                        Color.white.bind();
                        singleplayer.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 256);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        multiplayer.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 320);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        stageCreatorSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 320);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 384);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        options.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 384);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 448);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        exit.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 448);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 512);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 512);
                        GL11.glEnd();
                        break;
                    case 4:
                        Color.white.bind();
                        singleplayer.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 256);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        multiplayer.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 320);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        stageCreator.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 320);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 384);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        optionsSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 384);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 448);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        exit.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 448);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 512);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 512);
                        GL11.glEnd();
                        break;
                    case 5:
                        Color.white.bind();
                        singleplayer.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 256);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        multiplayer.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 320);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        stageCreator.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 320);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 320);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 384);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        options.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 384);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 384);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 448);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        exitSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(256, 448);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(768, 448);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(768, 512);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(256, 512);
                        GL11.glEnd();
                        break;
                        
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
        try{
                        menuBackground = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/MainMenu.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        title = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Title.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        singleplayer = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Singleplayer.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        singleplayerSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/SingleplayerSelected.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        multiplayer = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Multiplayer.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        multiplayerSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/MultiplayerSelected.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        stageCreator = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/StageCreator.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        stageCreatorSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/StageCreatorSelected.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        options = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Options.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        optionsSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/OptionsSelected.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        exit = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Exit.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                        exitSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/ExitSelected.png"));
                        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
        
        
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
                            if(menuSelection == 0){
                                menuSelection+=1;
                            }
                        }
                        if ( key == GLFW_KEY_S && (action == GLFW_PRESS || action == GLFW_REPEAT)){
                            menuSelection+=1;
                            if(menuSelection == 6){
                                menuSelection-=1;
                            }
                        }
                        if ( key == GLFW_KEY_ENTER && (action == GLFW_RELEASE)){
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
                                    glfwSetWindowShouldClose(window, GL_TRUE);
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
    
}
