/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework;

import java.util.Arrays;
import org.lwjgl.openal.AL10;
import static org.lwjgl.openal.AL10.*;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALContext;
import org.lwjgl.openal.ALDevice;
import static org.lwjgl.openal.Util.checkALError;
import org.newdawn.slick.openal.WaveData;

/**
 *
 * @author Lemonzap
 */
public class Audio{
    
    static float musicVolume = 1.0f;
    static float effectVolume = 1.0f;
    
    static ALContext context;
    static ALDevice device;
    
    //source used for all music
    private static int musicSource;
    private static int sources[];
    //which sources should be fading in and out currently. 15 is music source
    private static boolean fadeIn[];
    private static boolean fadeOut[];
    private static float fadeTime[];
    private static float lastFadeTime = 0.0f;
    private static float timeSinceLastFade;
    private static boolean fading = false;
    //any audio not designated "music" gets its own source
    private int source;
    //the buffer stores the audio for use
    private int buffer;
    private String loc;
    private boolean isMusic = false;
    
    public Audio(String loc, boolean isMusic){
        this.loc = loc;
        this.isMusic = isMusic;
        this.load();
    }
    
    public void load(){
        //set up buffer to store loaded sound
        buffer = alGenBuffers();
        //load sound from file
        WaveData wavefile = WaveData.create(loc);
        //store sound in buffer
        alBufferData(buffer, wavefile.format, wavefile.data, wavefile.samplerate);
        wavefile.dispose();
        checkALError();
    }
    
    public void play(boolean loop, boolean fade, float fadeDuration){
        //if music then use music source
        if(isMusic){
            alSourceUnqueueBuffers(musicSource);
            alSourceQueueBuffers(musicSource, buffer);
            if(loop){
                alSourcei(musicSource, AL_LOOPING, AL_TRUE);
            }
            alSourcePlay(musicSource);
            fadeIn[15] = fade;
            fadeTime[15] = fadeDuration;
                if(!fading && fade){
                    fading = true;
                    lastFadeTime = (float)(System.nanoTime()/1000000000.0);
                    alSourcef(musicSource, AL_GAIN, 0);
                }
        }else{
            //searches for first available source to play from
            for(int i = 0; i < sources.length; i++){
                if(alGetSourcei(sources[i], AL_SOURCE_STATE) != AL_PLAYING){
                    source = i;
                    alSourceUnqueueBuffers(sources[i]);
                    alSourceQueueBuffers(sources[i], buffer);
                    
                    fadeIn[i] = fade;
                    fadeTime[i] = fadeDuration;
                    if(!fading && fade){
                        fading = true;
                        lastFadeTime = (float)(System.nanoTime()/1000000000.0);
                        alSourcef(sources[i], AL_GAIN, 0);
                    }
                    if(loop){
                        alSourcei(sources[i], AL_LOOPING, AL_TRUE);
                    }
                    break;
                }
            }
            //plays sound from found source
            //if no sources are currenly available then use the last source this sound was played from
            alSourcePlay(sources[source]);
        }
        
    }
    
    public void stop(boolean fade, float fadeDuration){
        if(isMusic){
            if(!fade){
                alSourceStop(musicSource);
            }
            fadeOut[15] = fade;
            fadeTime[15] = fadeDuration;
            if(!fading && fade){
                fading = true;
                lastFadeTime = (float)(System.nanoTime()/1000000000.0);
            }
        }else{
            if(this.isPlaying()){
                if(!fade){
                    alSourceStop(sources[source]);
                }
                fadeIn[source] = fade;
                fadeTime[source] = fadeDuration;
                if(!fading && fade){
                    fading = true;
                    lastFadeTime = (float)(System.nanoTime()/1000000000.0);
                }
            }
        }
    }
    
    public boolean isPlaying(){
        //if the source this sound uses is playing and that source is playing this sound
        if(alGetSourcei(sources[source], AL_SOURCE_STATE) == AL_PLAYING && alGetSourcei(sources[source], AL_BUFFER) == buffer){
                return true;
        }
        return false;
    }
    
    public static boolean isMusicPlaying(){
        if(alGetSourcei(musicSource, AL_SOURCE_STATE) == AL_PLAYING){
            return true;
        }else{
            return false;
        }
    }
    
    //create as many sources as designated
    public static void createSources(int num){
        sources = new int[num];
        fadeIn = new boolean[num+1];
        fadeOut = new boolean[num+1];
        fadeTime = new float[num+1];
        for(int i = 0;i < num;i++){
            sources[i] = alGenSources();
        }
    }
    
    public static void createMusicSource(){
        musicSource = alGenSources();
    }
    
    public static void loadOpenAL(){
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
    
    //called every frame to fade sources in need of fading
    public static void fade(){
        if(fading && (!Game.allFalse(fadeIn) || !Game.allFalse(fadeOut))){
            timeSinceLastFade = (float)(System.nanoTime()/1000000000.0) - lastFadeTime;
            lastFadeTime = (float)(System.nanoTime()/1000000000.0);
            if(fadeIn[15]){
                //increment volume based on elapsed time
                alSourcef(musicSource, AL_GAIN, alGetSourcef(musicSource, AL_GAIN) + musicVolume*(timeSinceLastFade/fadeTime[15]));
                //once volume exceeds or equals desired volume set it to desired volume and set fade to false
                if(alGetSourcef(musicSource, AL_GAIN) >= musicVolume){
                    alSourcef(musicSource, AL_GAIN, musicVolume);
                    fadeIn[15] = false;
                }
            }
            if(fadeOut[15]){
                //increment volume based on elapsed time
                alSourcef(musicSource, AL_GAIN, alGetSourcef(musicSource, AL_GAIN) - musicVolume*(timeSinceLastFade/fadeTime[15]));
                //once volume exceeds or equals desired volume set it to desired volume and set fade to false
                if(alGetSourcef(musicSource, AL_GAIN) <= 0.01){
                    alSourceStop(musicSource);
                    alSourcef(musicSource, AL_GAIN, musicVolume);
                    fadeOut[15] = false;
                }
            }
            for(int i = 0; i < fadeIn.length-1; i++){
                if(fadeIn[i]){
                    //increment volume based on elapsed time
                    alSourcef(sources[i], AL_GAIN, alGetSourcef(sources[i], AL_GAIN) + effectVolume*(timeSinceLastFade/fadeTime[i]));
                    //once volume exceeds or equals desired volume set it to desired volume and set fade to false
                    if(alGetSourcef(sources[i], AL_GAIN) >= effectVolume){
                        alSourcef(sources[i], AL_GAIN, effectVolume);
                        fadeIn[i] = false;
                    }
                }
                if(fadeOut[i]){
                    //increment volume based on elapsed time
                    alSourcef(sources[i], AL_GAIN, alGetSourcef(sources[i], AL_GAIN) - effectVolume*(timeSinceLastFade/fadeTime[i]));
                    //once volume exceeds or equals desired volume set it to desired volume and set fade to false
                    if(alGetSourcef(sources[i], AL_GAIN) <= 0){
                        alSourceStop(sources[i]);
                        alSourcef(sources[i], AL_GAIN, effectVolume);
                        fadeOut[i] = false;
                    }
                }
            }
        }else{
            //if all fade booleans are false then turn off fading
            fading = false;
        }
        
    }
    
    public static void setMusicVolume(float volume){
        musicVolume = volume;
        alSourcef(musicSource, AL_GAIN, musicVolume);
    }
    public static void setEffectVolume(float volume){
        effectVolume = volume;
        for(int source : sources){
            alSourcef(source, AL_GAIN, effectVolume);
        }
    }
    
    public static float getMusicVolume(){
        return musicVolume;
    }
    public static float getEffectVolume(){
        return effectVolume;
    }
    
}
