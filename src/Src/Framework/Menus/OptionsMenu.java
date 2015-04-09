/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework.Menus;

import Src.Framework.Game;
import Src.Framework.Menus.MainMenu;
import java.io.IOException;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER;
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
public class OptionsMenu{
    static int selection = 1;
    static private Texture menuBackground = MainMenu.menuBackground;
    static private Texture optionsTitle;
    static private Texture general;
    static private Texture generalSelected;
    static private Texture controls;
    static private Texture controlsSelected;
    static private Texture video;
    static private Texture videoSelected;
    static private Texture audio;
    static private Texture audioSelected;
    static Texture back;
    static Texture backSelected;
    
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
                //render optionsTitle
                Color.white.bind();
                optionsTitle.bind();
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
                        generalSelected.bind();
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
                        controls.bind();
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
                        video.bind();
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
                        audio.bind();
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
                        back.bind();
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
                        general.bind();
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
                        controlsSelected.bind();
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
                        video.bind();
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
                        audio.bind();
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
                        back.bind();
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
                        general.bind();
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
                        controls.bind();
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
                        videoSelected.bind();
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
                        audio.bind();
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
                        back.bind();
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
                        general.bind();
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
                        controls.bind();
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
                        video.bind();
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
                        audioSelected.bind();
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
                        back.bind();
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
                        general.bind();
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
                        controls.bind();
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
                        video.bind();
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
                        audio.bind();
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
                        backSelected.bind();
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
            optionsTitle = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/OptionsTitle.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            general = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/General.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            generalSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/GeneralSelected.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            controls = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Controls.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            controlsSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/ControlsSelected.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            video = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Video.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            videoSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/VideoSelected.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            audio = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Audio.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            audioSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/AudioSelected.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            back = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Back.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            backSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/BackSelected.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            
        } catch (IOException e){
            e.printStackTrace();
        }
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
                                MainMenu.menuChangeSelection.play(false, false, 0);
                            }
                        }
                        if ( key == GLFW_KEY_S && (action == GLFW_PRESS || action == GLFW_REPEAT)){
                            selection+=1;
                            //if selection would increment past limit then undo
                            if(selection == 6){
                                selection-=1;
                            }else{
                                MainMenu.menuChangeSelection.play(false, false, 0);
                            }
                        }
                        if ( key == GLFW_KEY_ENTER && (action == GLFW_RELEASE)){
                            MainMenu.menuSelect.play(false, false, 0);
                            switch(selection){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    MainMenu.game.setMenuState(Game.MenuState.MAIN_MENU);
                                    MainMenu.setSelection(1);
                                    break;
                                    
                            }
                        }
    }
}
