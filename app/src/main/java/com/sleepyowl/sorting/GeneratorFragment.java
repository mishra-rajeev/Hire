package com.sleepyowl.sorting;

import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class GeneratorFragment extends Fragment {
    public TextView tv;
    Button bt1;
    Button bt2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v= inflater.inflate(R.layout.fragment_generator, container, false);
        tv = (TextView) v.findViewById(R.id.shownum);
        bt1=(Button)v.findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numgen(v);
            }
        });
         bt2=(Button)v.findViewById(R.id.button2);
         bt2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String number = tv.getText().toString();
                 Bundle bundle = new Bundle();
                 bundle.putString("Key",number);
                 android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 SortingFragment sortingFragment= new SortingFragment();
                 sortingFragment.setArguments(bundle);
                 fragmentTransaction.replace(R.id.frame_container,sortingFragment);
                 fragmentTransaction.addToBackStack(null);

                 fragmentTransaction.commit();
             }
         });



        return v;
    }
       public void numgen(View v){

      Random r = new Random();

       StringBuffer temp = new StringBuffer("");
        for (int i = 0; i < 20; i++) {
        int i1 = r.nextInt(100 - 10) + 10;
        temp.append(String.valueOf(i1));
        temp.append(String.valueOf(" "));
    }

        tv.setText(temp.toString());
}


}
