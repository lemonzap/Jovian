/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Framework;

import org.lwjgl.openal.AL10;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.Util.checkALError;
import org.newdawn.slick.openal.WaveData;

/**
 *
 * @author Lemonzap
 */
public class Audio{
    
    //source used for all music
    private static int musicSource;
    private static int sources[];
    //any audio not designated "music" gets its own source
    private int source;
    //the buffer stores the audio for use
    private int buffer;
    private String loc;
    private boolean isMusic = false;
    
    Audio(String loc, boolean isMusic){
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
    
    public void play(boolean loop){
        //if music then use music source
        if(isMusic){
            alSourceUnqueueBuffers(musicSource);
            alSourceQueueBuffers(musicSource, buffer);
            if(loop){
                alSourcei(musicSource, AL_LOOPING, AL_TRUE);
            }
            alSourcePlay(musicSource);
        }else{
            //searches for first available source to play from
            for(int i = 0; i < sources.length; i++){
                if(alGetSourcei(sources[i], AL_SOURCE_STATE) != AL_PLAYING){
                    source = i;
                    alSourceUnqueueBuffers(sources[i]);
                    alSourceQueueBuffers(sources[i], buffer);
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
    
    public void stop(){
        if(isMusic){
            alSourceStop(musicSource);
        }else{
            if(this.isPlaying()){
                alSourceStop(sources[source]);
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
        for(int i = 0;i < num;i++){
            sources[i] = alGenSources();
        }
    }
    
    public static void createMusicSource(){
        musicSource = alGenSources();
    }
    
}
