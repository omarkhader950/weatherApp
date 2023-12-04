package com.wetherapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wetherapp.Model.Contact;
import com.wetherapp.Model.Main;
import com.wetherapp.Model.Model;
import com.wetherapp.Model.Weather;
import com.wetherapp.R;
import com.wetherapp.ViewModel.ContactViewModel;
import com.wetherapp.ViewModel.MainViewModel;
import com.wetherapp.adapter.RecyclerViewAdapter;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnContactClickListener {

    private static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = 1;
    private static final String TAG = "Clicked";
    public static final String CONTACT_ID = "contact_id";
    private ContactViewModel contactViewModel;

    private TextView weather ,temp , feelslike ,humidity;

    private EditText editText;

    ImageButton  imageButton;




    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LiveData<List<Contact>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        temp = findViewById(R.id.main_tv_temp);
        feelslike = findViewById(R.id.main_tv_feelsLike);
        weather = findViewById(R.id.main_tv_weather);
        humidity = findViewById(R.id.main_tv_humidity);
        editText = findViewById(R.id.main_ed_city);
        imageButton = findViewById(R.id.main_btn_serching);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this
                .getApplication())
                .create(ContactViewModel.class);

        contactViewModel.getAllContacts().observe(this, contacts -> {

            recyclerViewAdapter = new RecyclerViewAdapter(contacts, MainActivity.this, this);
            recyclerView.setAdapter(recyclerViewAdapter);


        });

        FloatingActionButton fab = findViewById(R.id.add_contact_fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewContact.class);
            startActivityForResult(intent, NEW_CONTACT_ACTIVITY_REQUEST_CODE);
        });

         MainViewModel mainViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this
            .getApplication())
            .create(MainViewModel.class);

         mainViewModel.getdata();

         mainViewModel.dataMutableLiveData.observe(MainActivity.this, new Observer<Model>() {
             @Override
             public void onChanged(Model model) {

                 //Model model = model.body();
                 Main main = model.getMain();
                 double t = main.getTemp();
                 double f = main.getFeelsLike();
                 int h =main.getHumidity();

                 List<Weather> weathers = model.getWeathers();
                 String s = weathers.get(0).getMain();

                 weather.setText(s+"");

                 temp.setText(t+"");
                 feelslike.setText(f+"");
                 humidity.setText(h+"");

             }
         });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q = editText.getText().toString();
                mainViewModel.getCitydata(q);

                mainViewModel.dataCityMutableLiveData.observe(MainActivity.this, new Observer<Model>() {
                    @Override
                    public void onChanged(Model model) {
                        Main main = model.getMain();
                        double t = main.getTemp();
                        double f = main.getFeelsLike();
                        int h =main.getHumidity();

                        List<Weather> weathers = model.getWeathers();
                        String s = weathers.get(0).getMain();

                        weather.setText(s+"");

                        temp.setText(t+"");
                        feelslike.setText(f+"");
                        humidity.setText(h+"");
                    }
                });

            }
        });


         //* mainViewModel.dataCityMutableLiveData.observe(this, new Observer<Main>() {
           //  @Override
           //  public void onChanged(Main main) {

           //      temp.setText((int) main.getTemp());
//                  tempMin.setText((int)main.getTempMin());
            //      tempMax.setText((int) main.getTempMax());


          //   }
      //   });*/










    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_CONTACT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            assert data != null;
            String name = data.getStringExtra(NewContact.NAME_REPLY);
            String occupation = data.getStringExtra(NewContact.OCCUPATION);

            assert name != null;
            Contact contact = new Contact(name, occupation);

            ContactViewModel.insert(contact);
        }
    }

    @Override
    public void onContactClick(int position) {
        Contact contact = Objects.requireNonNull(contactViewModel.allContacts.getValue()).get(position);
        Log.d(TAG, "onContactClick: " + contact.getId());

        Intent intent = new Intent(MainActivity.this, NewContact.class);
        intent.putExtra(CONTACT_ID, contact.getId());
        startActivity(intent);

    }


















}
