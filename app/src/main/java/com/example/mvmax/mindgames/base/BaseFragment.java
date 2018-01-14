package com.example.mvmax.mindgames.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvmax.mindgames.R;
import com.example.mvmax.mindgames.activity.GameActivity;
import com.example.mvmax.mindgames.util.UiUtils;

public class BaseFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return null;
    }

    public void setStatusBarPadding() {
        final View view = getView();

        if (view != null) {
            final View contentView = view.findViewById(R.id.fragment_base_content);

            contentView.setPadding(0, UiUtils.getStatusBarHeight(getContext()), 0, 0);
        }
    }

    public void openGameActivity(@NonNull final Fragment pGameFragment) {
//        final Intent intent = new Intent(getContext(), GameActivity.class);
//        final Bundle bundle = new Bundle();
//
//        bundle.putSerializable("ds", pGameFragment);
//
//        intent.putExtras()
//
//
//        startActivity(new Intent(getContext(), Gam));

        final FragmentActivity activity = getActivity();

        if (activity == null) {
            return;
        }

        final FragmentManager fragmentManager = activity.getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(android.R.id.content, pGameFragment)
                .addToBackStack(null)
                .commit();
    }
}