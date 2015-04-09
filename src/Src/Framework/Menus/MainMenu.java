/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework.Menus;

import Src.Framework.Audio;
import Src.Framework.Game;
import java.io.IOException;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_M;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_REPEAT;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Lemonzap
 */
public class MainMenu{
    
    static Game game;
    
    static int selection = 1;
    static Texture menuBackground;
    static Texture title;
    static private Texture singleplayer;
    static private Texture singleplayerSelected;
    static private Texture multiplayer;
    static private Texture multiplayerSelected;
    static private Texture stageCreator;
    static private Texture stageCreatorSelected;
    static private Texture options;
    static private Texture optionsSelected;
    static Texture exit;
    static Texture exitSelected;
    
    static Audio menuMusic;
    static Audio menuChangeSelection;
    static Audio menuSelect;
    
    public static void render(){
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
                //render title
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
                
                switch(selection){
                    case 1:
                        //render menu selections
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
    }
    
    public static void load(){
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
        
        //placeholder sounds
        menuMusic = new Audio("Src/Resources/Sounds/MMXTitleTheme.wav", true);
        menuChangeSelection = new Audio("Src/Resources/Sounds/Blip_Select.wav", false);
        menuSelect = new Audio("Src/Resources/Sounds/blipChoose.wav", false);
    }
    
    public static void setSelection(int aSelection){
        selection = aSelection;
    }
    
    public static void handleInputs(long window, int key, int scancode, int action, int mods){
        if ( key == GLFW_KEY_W && (action == GLFW_PRESS || action == GLFW_REPEAT)){
            selection-=1;
            //if selection would increment past limit then undo
            if(selection == 0){
                selection+=1;
            }else{
                menuChangeSelection.play(false, false, 0);
            }
        }
        if ( key == GLFW_KEY_S && (action == GLFW_PRESS || action == GLFW_REPEAT)){
            selection+=1;
            //if selection would increment past limit then undo
            if(selection == 6){
                selection-=1;
            }else{
                menuChangeSelection.play(false, false, 0);
            }
        }
        if ( key == GLFW_KEY_ENTER && (action == GLFW_RELEASE)){
            menuSelect.play(false, false, 0);
            switch(selection){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    game.setMenuState(Game.MenuState.OPTIONS_MENU);
                    OptionsMenu.setSelection(1);
                    break;
                case 5:
                    //wait for select sound to stop playing before closing
                    while(menuSelect.isPlaying()){

                    }
                    //tell main loop to exit
                    glfwSetWindowShouldClose(window, GL_TRUE);
                    break;

            }
        }
    }
    
    public static void init(Game aGame){
        menuMusic.play(true, true, 2.5f);
        game = aGame;
        game.setMenuState(Game.MenuState.MAIN_MENU);
    }
}
