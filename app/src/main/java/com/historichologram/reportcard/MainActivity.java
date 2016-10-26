package com.historichologram.reportcard;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ReportCard> gradeArrayList = new ArrayList<ReportCard>();

        // gradeArrayList inputs: Class name, Teacher name, Grade)
        gradeArrayList.add(new ReportCard("English",  91.2f));
        gradeArrayList.add(new ReportCard("Calculus AB",  76.3f));
        gradeArrayList.add(new ReportCard("History of the World",  84.3f));
        gradeArrayList.add(new ReportCard("Advanced Basketweaving",  93.2f));
        gradeArrayList.add(new ReportCard("Philsophy of Life",  71.2f));
        gradeArrayList.add(new ReportCard("Introduction to Programming",  61.3f));

        GradeAdapter gradeAdapter = new GradeAdapter(this, gradeArrayList);
        ListView listView = (ListView) findViewById(R.id.list_view_main);
        listView.setAdapter(gradeAdapter);

    }

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
}
