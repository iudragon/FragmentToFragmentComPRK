package dragon.bakuman.iu.fragmenttofragmentcom;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private Button mButton;
    private EditText mEditText;

    OnMessageSendListener mMessageSendListener;

    public interface OnMessageSendListener {

        void onMessageSend(String message);
    }


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        mButton = view.findViewById(R.id.bn);
        mEditText = view.findViewById(R.id.text_message);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = mEditText.getText().toString();
                mMessageSendListener.onMessageSend(message);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {


        } catch (ClassCastException e) {

            throw new ClassCastException(activity.toString() + "Must implement onMessageSend");


        }

        mMessageSendListener = (OnMessageSendListener) activity;
    }

    @Override
    public void onResume() {
        super.onResume();
        mEditText.setText("");
    }
}
