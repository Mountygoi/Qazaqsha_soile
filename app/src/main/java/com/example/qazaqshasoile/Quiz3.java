package com.example.qazaqshasoile;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Quiz3 extends Fragment {

    private List<QuestionModel> questionModelList;
    TextView surak, sandar;
    Button kelesi;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3;

    int totalQuestions;
    int qCounter = 0;

    QuestionModel currentQuestion;
    ColorStateList dfRbColor;
    boolean answered;
    int score;
    TextView ball;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz1, container, false);
        surak = view.findViewById(R.id.surak);
        questionModelList = new ArrayList<>();
        sandar = view.findViewById(R.id.sandar);
        kelesi = view.findViewById(R.id.kelesi);
        ball = view.findViewById(R.id.ball);
        radioGroup = view.findViewById(R.id.radiogroup);
        rb1 = view.findViewById(R.id.rb1);
        rb2 = view.findViewById(R.id.rb2);
        rb3 = view.findViewById(R.id.rb3);
        dfRbColor = rb1.getTextColors();
        addQuestions();
        totalQuestions = questionModelList.size();
        showNextQuestion();


        kelesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answered == false) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        answered = true;
                        RadioButton rbSelected = view.findViewById(radioGroup.getCheckedRadioButtonId());
                        int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
                        if (answerNo == currentQuestion.getCorrectAnsNo()) {
                            score++;
                            ball.setText(String.valueOf(score));
                        }
                        rb1.setTextColor(Color.RED);
                        rb2.setTextColor(Color.RED);
                        rb3.setTextColor(Color.RED);
                        switch (currentQuestion.getCorrectAnsNo()) {
                            case 1:
                                rb1.setTextColor(Color.GREEN);
                                break;
                            case 2:
                                rb2.setTextColor(Color.GREEN);
                                break;
                            case 3:
                                rb3.setTextColor(Color.GREEN);
                                break;
                        }
                        if (qCounter < totalQuestions) {
                            kelesi.setText("Келесі");
                        } else {
                            kelesi.setText("Аяқтау");
                            kelesi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Fragment quiz = new TestFragment();
                                    FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.frame_container, quiz).addToBackStack(null).commit();

                                }
                            });
                        }
                    } else {
                        Toast.makeText(requireContext(), "Бір жауапты тандаңыз", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }

        });
        return view;
    }


    void showNextQuestion() {
        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);

        if (qCounter < totalQuestions) {
            currentQuestion = questionModelList.get(qCounter);
            surak.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            qCounter++;
            sandar.setText(qCounter + "/" + totalQuestions);
            answered = false;
        }
    }

    void addQuestions() {
        questionModelList.add(new QuestionModel("Әкесі екеніне неге сенбеді?", "Әкесін тірі емес деп ойлады", "Әкесінің түрі басқа", "Әкесі жоқ", 1));
        questionModelList.add(new QuestionModel("Әкесі неге жоқ болып кеткен?", "Баласын көргісі келмеді", "Солай болып қалды", "Баласының қауіпзіздігі үшін", 3));
        questionModelList.add(new QuestionModel("Баласына түсіндіре алдыма ?", "Ия", "Жоқ", "Ондай жоқ", 1));
        questionModelList.add(new QuestionModel("Баласының іс-әрекеті", "Кетіп қалды", "Әкесін құшағына алды", "Күлді", 2));
    }
}