package com.nicoqueijo.cityskylinequiz.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nicoqueijo.cityskylinequiz.R;
import com.nicoqueijo.cityskylinequiz.activities.QuizGameActivity;

public class QuizScoreFragment extends Fragment {

    public static final double ATTEMPT_ONE_MULTIPLIER = 1.0;
    public static final double ATTEMPT_TWO_MULTIPLIER = 0.5;
    public static final double ATTEMPT_THREE_MULTIPLIER = 0.25;
    public static final double ATTEMPT_FOUR_MULTIPLIER = 0.0;

    private LinearLayout mNewRecordLabel;
    private TextView mAttemptOneCorrect;
    private TextView mAttemptTwoCorrect;
    private TextView mAttemptThreeCorrect;
    private TextView mAttemptFourCorrect;
    private TextView mAttemptOneScore;
    private TextView mAttemptTwoScore;
    private TextView mAttemptThreeScore;
    private TextView mAttemptFourScore;
    private TextView mTotalScore;
    private Button mGameMenuButton;
    private Button mViewReportButton;

    private int mCorrectAnswersOnAttemptOne = QuizGameActivity.correctAnswersOnAttemptOne;
    private int mCorrectAnswersOnAttemptTwo = QuizGameActivity.correctAnswersOnAttemptTwo;
    private int mCorrectAnswersOnAttemptThree = QuizGameActivity.correctAnswersOnAttemptThree;
    private int mCorrectAnswersOnAttemptFour = QuizGameActivity.correctAnswersOnAttemptFour;

    private double mScoreAttemptOne = mCorrectAnswersOnAttemptOne * ATTEMPT_ONE_MULTIPLIER;
    private double mScoreAttemptTwo = mCorrectAnswersOnAttemptTwo * ATTEMPT_TWO_MULTIPLIER;
    private double mScoreAttemptThree = mCorrectAnswersOnAttemptThree * ATTEMPT_THREE_MULTIPLIER;
    private double mScoreAttemptFour = mCorrectAnswersOnAttemptFour * ATTEMPT_FOUR_MULTIPLIER;
    private double mFinalScore = (mScoreAttemptOne + mScoreAttemptTwo + mScoreAttemptThree +
            mScoreAttemptFour);

    /**
     * Required empty public constructor
     */
    public QuizScoreFragment() {
    }

    /**
     * Called to do initial creation of a fragment.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_quiz_score, container, false);
        mNewRecordLabel = (LinearLayout) view.findViewById(R.id.new_record_label);
        mAttemptOneCorrect = (TextView) view.findViewById(R.id.attempt_one_correct);
        mAttemptTwoCorrect = (TextView) view.findViewById(R.id.attempt_two_correct);
        mAttemptThreeCorrect = (TextView) view.findViewById(R.id.attempt_three_correct);
        mAttemptFourCorrect = (TextView) view.findViewById(R.id.attempt_four_correct);
        mAttemptOneScore = (TextView) view.findViewById(R.id.attempt_one_score);
        mAttemptTwoScore = (TextView) view.findViewById(R.id.attempt_two_score);
        mAttemptThreeScore = (TextView) view.findViewById(R.id.attempt_three_score);
        mAttemptFourScore = (TextView) view.findViewById(R.id.attempt_four_score);
        mTotalScore = (TextView) view.findViewById(R.id.total_score);
        mGameMenuButton = (Button) view.findViewById(R.id.game_menu_button);
        mViewReportButton = (Button) view.findViewById(R.id.view_report_button);


        if (true) {
            mNewRecordLabel.setVisibility(View.VISIBLE);
        }

        mAttemptOneCorrect.setText(String.valueOf(mCorrectAnswersOnAttemptOne));
        mAttemptOneCorrect.setText(String.valueOf(mCorrectAnswersOnAttemptOne));
        mAttemptTwoCorrect.setText(String.valueOf(mCorrectAnswersOnAttemptTwo));
        mAttemptThreeCorrect.setText(String.valueOf(mCorrectAnswersOnAttemptThree));
        mAttemptFourCorrect.setText(String.valueOf(mCorrectAnswersOnAttemptFour));

        mAttemptOneScore.setText(String.format("%.2f", mScoreAttemptOne));
        mAttemptTwoScore.setText(String.format("%.2f", mScoreAttemptTwo));
        mAttemptThreeScore.setText(String.format("%.2f", mScoreAttemptThree));
        mAttemptFourScore.setText(String.format("%.2f", mScoreAttemptFour));
        mTotalScore.setText(String.format("%.2f", mFinalScore));

        mGameMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        mViewReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack
                        ("quizScoreFragment").replace(R.id.quiz_fragment_container,
                        new QuizReportFragment()).commit();
            }
        });
        return view;
    }
}
