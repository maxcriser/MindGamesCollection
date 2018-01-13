package com.example.mvmax.mindgames.gamecollection.listener;

import java.io.Serializable;

public interface GameCollectionListener extends Serializable {

    void onPageSelected(final int pPoster);

    void onResume();

    void onPause();

}
