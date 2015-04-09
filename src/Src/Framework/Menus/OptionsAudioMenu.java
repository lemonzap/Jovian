/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework.Menus;

import Src.Framework.Audio;
import Src.Framework.Game;
import static Src.Framework.Menus.OptionsMenu.back;
import java.io.IOException;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_REPEAT;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Lemonzap
 */
public class OptionsAudioMenu{
    static int selection = 1;
    static private Texture menuBackground = MainMenu.menuBackground;
    static private Texture audioTitle;
    static private Texture musicVolume;
    static private Texture musicVolumeSelected;
    static private Texture effectVolume;
    static private Texture effectVolumeSelected;
    static private Texture colon;
    static private Texture colonSelected;
    static private Texture sliderTrack;
    static private Texture slider;
    
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
                //render audioTitle
                Color.white.bind();
                audioTitle.bind();
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
                //musicVolume slider
                Color.white.bind();
                sliderTrack.bind();
                GL11.glBegin(GL11.GL_QUADS);
                    GL11.glTexCoord2d(0, 0);
                    GL11.glVertex2i(350, 224);

                    GL11.glTexCoord2d(1, 0);
                    GL11.glVertex2i(606, 224);

                    GL11.glTexCoord2d(1, 1);
                    GL11.glVertex2i(606, 256);

                    GL11.glTexCoord2d(0, 1);
                    GL11.glVertex2i(350, 256);
                GL11.glEnd();
                
                Color.white.bind();
                slider.bind();
                GL11.glBegin(GL11.GL_QUADS);
                    GL11.glTexCoord2d(0, 0);
                    GL11.glVertex2i(362 + (int)(220*Audio.getMusicVolume()), 224);

                    GL11.glTexCoord2d(1, 0);
                    GL11.glVertex2i(370 + (int)(220*Audio.getMusicVolume()), 224);

                    GL11.glTexCoord2d(1, 1);
                    GL11.glVertex2i(370 + (int)(220*Audio.getMusicVolume()), 256);

                    GL11.glTexCoord2d(0, 1);
                    GL11.glVertex2i(362 + (int)(220*Audio.getMusicVolume()), 256);
                GL11.glEnd();
                
                //effectVolume slider
                Color.white.bind();
                sliderTrack.bind();
                GL11.glBegin(GL11.GL_QUADS);
                    GL11.glTexCoord2d(0, 0);
                    GL11.glVertex2i(350, 288);

                    GL11.glTexCoord2d(1, 0);
                    GL11.glVertex2i(606, 288);

                    GL11.glTexCoord2d(1, 1);
                    GL11.glVertex2i(606, 320);

                    GL11.glTexCoord2d(0, 1);
                    GL11.glVertex2i(350, 320);
                GL11.glEnd();
                
                Color.white.bind();
                slider.bind();
                GL11.glBegin(GL11.GL_QUADS);
                    GL11.glTexCoord2d(0, 0);
                    GL11.glVertex2i(362 + (int)(220*Audio.getEffectVolume()), 288);

                    GL11.glTexCoord2d(1, 0);
                    GL11.glVertex2i(370 + (int)(220*Audio.getEffectVolume()), 288);

                    GL11.glTexCoord2d(1, 1);
                    GL11.glVertex2i(370 + (int)(220*Audio.getEffectVolume()), 320);

                    GL11.glTexCoord2d(0, 1);
                    GL11.glVertex2i(362 + (int)(220*Audio.getEffectVolume()), 320);
                GL11.glEnd();
                        
                
                switch(selection){
                    case 1:
                        Color.white.bind();
                        musicVolumeSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(350, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(606, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(606, 224);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(350, 224);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        colonSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(606, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(622, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(622, 224);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(606, 224);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        effectVolume.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(350, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(606, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(606, 288);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(350, 288);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        colon.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(606, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(622, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(622, 288);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(606, 288);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        OptionsMenu.back.bind();
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
                        musicVolume.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(350, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(606, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(606, 224);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(350, 224);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        colon.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(606, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(622, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(622, 224);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(606, 224);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        effectVolumeSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(350, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(606, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(606, 288);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(350, 288);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        colonSelected.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(606, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(622, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(622, 288);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(606, 288);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        OptionsMenu.back.bind();
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
                        musicVolume.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(350, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(606, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(606, 224);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(350, 224);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        colon.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(606, 192);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(622, 192);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(622, 224);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(606, 224);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        effectVolume.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(350, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(606, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(606, 288);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(350, 288);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        colon.bind();
                        GL11.glBegin(GL11.GL_QUADS);
                            GL11.glTexCoord2d(0, 0);
                            GL11.glVertex2i(606, 256);

                            GL11.glTexCoord2d(1, 0);
                            GL11.glVertex2i(622, 256);

                            GL11.glTexCoord2d(1, 1);
                            GL11.glVertex2i(622, 288);

                            GL11.glTexCoord2d(0, 1);
                            GL11.glVertex2i(606, 288);
                        GL11.glEnd();
                        
                        Color.white.bind();
                        OptionsMenu.backSelected.bind();
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
            audioTitle = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/AudioTitle.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            musicVolume = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/MusicVolume.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            musicVolumeSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/MusicVolumeSelected.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            effectVolume = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/EffectVolume.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            effectVolumeSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/EffectVolumeSelected.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            colon = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Colon.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            colonSelected = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/ColonSelected.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            sliderTrack = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/SliderTrack.png"));
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            slider = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("Src/Resources/Images/Slider.png"));
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
                            if(selection == 4){
                                selection-=1;
                            }else{
                                MainMenu.menuChangeSelection.play(false, false, 0);
                            }
                        }
                        if ( key == GLFW_KEY_A && (action == GLFW_PRESS || action == GLFW_REPEAT)){
                            switch(selection){
                                case 1:
                                    Audio.setMusicVolume(Audio.getMusicVolume()-.01f);
                                    //if selection would increment past limit then undo
                                    if(Audio.getMusicVolume() < 0){
                                       Audio.setMusicVolume(Audio.getMusicVolume()+.01f);
                                    }
                                    break;
                                case 2:
                                    Audio.setEffectVolume(Audio.getEffectVolume()-.01f);
                                    //if selection would increment past limit then undo
                                    if(Audio.getEffectVolume() < 0){
                                       Audio.setEffectVolume(Audio.getEffectVolume()+.01f);
                                    }
                                    break;
                            }
                        }
                        if ( key == GLFW_KEY_D && (action == GLFW_PRESS || action == GLFW_REPEAT)){
                            switch(selection){
                                case 1:
                                    Audio.setMusicVolume(Audio.getMusicVolume()+.01f);
                                    //if selection would increment past limit then undo
                                    if(Audio.getMusicVolume() > 1){
                                       Audio.setMusicVolume(Audio.getMusicVolume()-.01f);
                                    }
                                    break;
                                case 2:
                                    Audio.setEffectVolume(Audio.getEffectVolume()+.01f);
                                    //if selection would increment past limit then undo
                                    if(Audio.getEffectVolume() > 1){
                                       Audio.setEffectVolume(Audio.getEffectVolume()-.01f);
                                    }
                                    break;
                            }
                        }
                        if ( key == GLFW_KEY_ENTER && (action == GLFW_RELEASE)){
                            switch(selection){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    MainMenu.menuSelect.play(false, false, 0);
                                    MainMenu.game.setMenuState(Game.MenuState.OPTIONS_MENU);
                                    OptionsMenu.setSelection(1);
                                    break;
                            }
                        }
    }
}
