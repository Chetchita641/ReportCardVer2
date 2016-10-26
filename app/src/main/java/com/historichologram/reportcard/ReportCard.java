package com.historichologram.reportcard;

/**
 * Created by Chris Macholtz on 9/12/2016.
 */
public class ReportCard {
    /**
     * @param mClassName = The class name
     * @param mGradePercent = The percentage earned in the class
     * @param mGradeLetter = The calculated letter for the class
     * @param mCredit = The grade credit earned for the class
     */

    private String mClassName;
    private float mGradePercent;
    private String mGradeLetter;
    private float mCredit;

    public ReportCard(String className, float gradePercent) {
        mClassName = className;
        mGradePercent = gradePercent;

        // Calculate the letter grade from the percentage given
        if (mGradePercent >= 90f) {
            mGradeLetter = "A";
            mCredit = 4.0f;
        } else if (mGradePercent >= 80f && mGradePercent < 90f) {
            mGradeLetter = "B";
            mCredit = 3.0f;
        } else if (mGradePercent >= 70f && mGradePercent < 80f) {
            mGradeLetter = "C";
            mCredit = 2.0f;
        } else if (mGradePercent >= 60f && mGradePercent < 70f) {
            mGradeLetter = "D";
            mCredit = 1.0f;
        } else {
            mGradeLetter = "F";
            mCredit = 0.0f;
        }
    }

    // Returns the class name
    public String getClassName() {
        return mClassName;
    }

    // Sets a new class name
    public void setClassName(String className) {
        mClassName = className;
    }

    // Returns the grade percentage as a string
    public String getGradePercentToString() {
        return Float.toString(mGradePercent);
    }

    // Returns the grade percentage as a float
    public float getGradePercent() {
        return mGradePercent;
    }

    // Sets the grade percentage (float)
    public void setGradePercent(float gradePercent) {
        mGradePercent = gradePercent;
    }

    // Returns the grade letter
    public String getGradeLetter() {
        return mGradeLetter;
    }

    // Returns the credit earned as a String
    public String getCreditToString() {
        return Float.toString(mCredit);
    }

    // Returns the credit earned as a float
    public float getCreditToFloat() {
        return mCredit;
    }

    @Override
    public String toString() {
        return "Class Name: " + mClassName + "\nGrade Percentage: " + mGradePercent
                + "\nGrade Letter: " + mGradeLetter + "\nCredit earned: " + mCredit;
    }
}
