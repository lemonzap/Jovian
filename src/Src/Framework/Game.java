/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework;

import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
/**
 *
 * @author Lemonzap
 */
public class Game{
    Window window;
    
    Game(Window window){
        this.window = window;
    }
    
    public void loop(){
        
        while( glfwWindowShouldClose(window.getWindowHandle()) == GL_FALSE ) {
            // clear the framebuffer 
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
             // swap the color buffers
            glfwSwapBuffers(window.getWindowHandle());
            // Poll for window events
            glfwPollEvents();
        }
    }
    
}
