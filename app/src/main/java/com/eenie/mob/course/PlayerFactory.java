package com.eenie.mob.course;

import android.os.Bundle;
import android.view.Surface;

import com.letv.controller.LetvPlayer;
import com.letv.controller.PlayContext;
import com.letv.universal.iplay.ISplayer;
import com.letv.universal.iplay.OnPlayStateListener;

public class PlayerFactory {

    /**
     * 创建一个播放器
     * 
     * @param playContext
     * @param bundle
     * @param playStateListener
     * @param surface
     * @return
     */
    public static ISplayer createOnePlayer(PlayContext playContext, Bundle bundle, OnPlayStateListener playStateListener, Surface surface) {
        ISplayer player = new LetvPlayer();
        player.setPlayContext(playContext);
        player.init();
        player.setParameter(player.getPlayerId(), bundle);
        player.setOnPlayStateListener(playStateListener);
        if (surface == null) {
            throw new RuntimeException("surface is null!");
        }
        player.setDisplay(surface);
        return player;
    }

}
