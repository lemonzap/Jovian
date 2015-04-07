/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.*;
import org.lwjgl.glfw.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
/**
 *
 * @author Lemonzap
 */
public class Window{

    //initialize window size variables
  private int windowHeight = 512;
  private int windowWidth = 1024;
  public static final Logger LOGGER = Logger.getLogger(Window.class.getName());
  private static Window window;
  private static Game game;
 
    // The window handle
    private long windowHandle;

  static {
    try {
      LOGGER.addHandler(new FileHandler("errors.log",true));
    }
    catch(IOException ex) {
      LOGGER.log(Level.WARNING,ex.toString(),ex);
    }
  }

  public Window(int height, int width){
      windowHeight = height;
      windowWidth = width;
  }
  
  public static void main(String[] args) {
   
      //remember to place natives from NetBeansProjects/lwjgl-3/native/windows/x64 in lib folder before attempting to execute jar. not necessary fo running in IDE.
      System.setProperty("org.lwjgl.librarypath", new File("lib").getAbsolutePath());
      
      try {
        window = new Window(512, 1024);
        window.create();
        game = new Game(window);
        game.loop();
    }catch(Exception ex) {
        LOGGER.log(Level.SEVERE,ex.toString(),ex);
    }
  }

  public void create() {
      
    //Initialize GLFW. Most GLFW functions will not work before doing this.
    if ( glfwInit() != GL11.GL_TRUE ){
            throw new IllegalStateException("Unable to initialize GLFW");
    }
    //not visible after creation. Will set to visible once ready.
    glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
    //window set to be resizable
    glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
    //create window
    windowHandle = glfwCreateWindow(windowWidth, windowHeight, "Jovian", NULL, NULL);
    if ( windowHandle == NULL ){
            throw new RuntimeException("Failed to create the GLFW window");
    }
    //initialize OpenGL
    initGL();
  }
  
  public void initGL() {
    //Make the OpenGL context curent
    glfwMakeContextCurrent(windowHandle);
    // Enable v-sync
    glfwSwapInterval(1);
    // Make the window visible
    glfwShowWindow(windowHandle);
    //sets up OpenGL Bindings for use
    GLContext.createFromCurrent();
    
    GL11.glEnable(GL11.GL_TEXTURE_2D);
    //set the clear color
    glClearColor(0.0f, 1.0f, 0.0f, 0.0f);
    
    // enable alpha blending
    GL11.glEnable(GL11.GL_BLEND);
    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

    GL11.glViewport(0,0,windowWidth,windowHeight);
    GL11.glOrtho(0, windowWidth, windowHeight, 0, 1, -1);
    GL11.glMatrixMode(GL11.GL_MODELVIEW);
    
  }

    /**
     * @return the windowHandle
     */
    public long getWindowHandle(){
        return windowHandle;
    }
  
  /**
     * @return the windowHeight
     */
    public int getHeight(){
        return windowHeight;
    }

    /**
     * @param aWindowHeight the windowHeight to set
     */
    public void setHeight(int aWindowHeight){
        windowHeight = aWindowHeight;
    }

    /**
     * @return the windowWidth
     */
    public int getWidth(){
        return windowWidth;
    }

    /**
     * @param aWindowWidth the windowWidth to set
     */
    public void setWidth(int aWindowWidth){
        windowWidth = aWindowWidth;
    }
  
}
