package com.example.android.miwok;

import android.media.MediaPlayer;
import android.provider.UserDictionary;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.Activity;
import java.util.ArrayList;


/**
 * Created by Patu on 11/11/2017.
 */

public class wordAdapter extends ArrayAdapter<Word> {
    private int mBackGroundColorId;

    public wordAdapter(Activity context, ArrayList<Word> words,int backGroundColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);

        mBackGroundColorId = backGroundColor;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView Luganda_text = (TextView) listItemView.findViewById(R.id.Luganda_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        Luganda_text.setText(currentWord.getLugandaTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

            ImageView displayImage = (ImageView) listItemView.findViewById(R.id.image);
            displayImage.setImageResource(currentWord.getImageResourceId());


            // if no image is passed on then hide the view
            if(currentWord.getHasImage())
               displayImage.setVisibility(View.VISIBLE);
            else displayImage.setVisibility(View.GONE);


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mBackGroundColorId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


       // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}




