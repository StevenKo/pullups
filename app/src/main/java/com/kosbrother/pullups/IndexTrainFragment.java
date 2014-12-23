package com.kosbrother.pullups;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;


public class IndexTrainFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextToSpeech ttobj;
    private Button startSessionButton;

    public static IndexTrainFragment newInstance(String param1, String param2) {
        IndexTrainFragment fragment = new IndexTrainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public IndexTrainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        ttobj=new TextToSpeech(getActivity(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){
                            ttobj.setLanguage(Locale.UK);
                        }
                    }
                });
    }

    public void speakText(){
        Toast.makeText(getActivity(), "1 2 3 4 5 6",
                Toast.LENGTH_SHORT).show();
        ttobj.speak("1 2 3 4 5 6", TextToSpeech.QUEUE_FLUSH, null);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_index_train, container, false);
        startSessionButton = (Button)fragment.findViewById(R.id.startSession);
        startSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakText();
            }
        });

        return fragment;
    }

    @Override
    public void onStop()
    {
        super.onStop();

        if(ttobj != null){
            ttobj.shutdown();
        }
    }

}
