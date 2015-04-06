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
  private static int windowHeight = 512;
  private static int windowWidth = 1024;
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

  public static void main(String[] args) {
   
      System.setProperty("org.lwjgl.librarypath", new File("lib").getAbsolutePath());
      
      try {
        window = new Window();
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
    //set the clear color
    glClearColor(0.0f, 1.0f, 0.0f, 0.0f);
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
    public static int getHeight(){
        return windowHeight;
    }

    /**
     * @param aWindowHeight the windowHeight to set
     */
    public static void setHeight(int aWindowHeight){
        windowHeight = aWindowHeight;
    }

    /**
     * @return the windowWidth
     */
    public static int getWidth(){
        return windowWidth;
    }

    /**
     * @param aWindowWidth the windowWidth to set
     */
    public static void setWidth(int aWindowWidth){
        windowWidth = aWindowWidth;
    }
  
}
