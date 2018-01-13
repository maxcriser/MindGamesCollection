package com.example.mvmax.mindgames.collection;

import java.io.Serializable;

public interface CollectionListener extends Serializable {

    void onPageSelected(final int pPoster);

    void onResume();

    void onPause();

}
