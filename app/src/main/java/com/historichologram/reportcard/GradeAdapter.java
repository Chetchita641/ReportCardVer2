package com.historichologram.reportcard;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Processes the Grade class information into a ListView item
 */
public class GradeAdapter extends ArrayAdapter<ReportCard> {
    /**
     * @param context       The current context.
     * @param gradeArrayList    The ArrayList of grades
     */

    public GradeAdapter(Activity context, ArrayList<ReportCard> gradeArrayList) {
        super(context, 0, gradeArrayList);
    }

    /**
     *
     * @param position      Position in the ArrayList
     * @param convertView   Converts view into a ListView item
     * @param parent        ListView root layout
     *
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Get the grade item from the current position
        ReportCard currentGrade = getItem(position);

        // Find the TextView in the list_item.xml with ID class_name
        TextView studentNameTextView = (TextView) listItemView.findViewById(R.id.class_name);
        studentNameTextView.setText(currentGrade.getClassName());


        // Find the TextView in the list_item.xml with ID grade
        TextView gradeTextView = (TextView) listItemView.findViewById(R.id.grade);
        gradeTextView.setText(currentGrade.getGradeLetter());

        // Find the TextView in the list_item.xml with ID credit
        TextView creditTextView = (TextView) listItemView.findViewById(R.id.credit);
        creditTextView.setText("Credit: " + currentGrade.getCreditToString());

        Log.v("Values:", currentGrade.toString());
        return listItemView;
    }
}

