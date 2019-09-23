package com.example.signup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.signup.R;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class finalize_order extends Activity {
    DatabaseHelperorder mydb;
    TextView Items, Total_Price;
    EditText Personal_Preferances;
    Button sendButton;
    Button viewButton;

    finalize_order a=this;
    public static  Socket client;
    public static PrintWriter printwriter;
    public static BufferedReader bb;
    public static String messsage;
    public static String m1;
    static int old_all_total;
    static int all_total;

    String personal_preferances;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";

    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);
        show_Order();
        tot_v();
        oo = this;
        mydb = new DatabaseHelperorder(this);

        Items = (TextView) findViewById(R.id.order_final);
        Total_Price= (TextView) findViewById(R.id.tot_p);
        Personal_Preferances = (EditText) findViewById(R.id.personalp);
        sendButton = (Button) findViewById(R.id.button5);
        viewButton = (Button)findViewById(R.id.button14);
        AddData();
        button14();
    }
    public void AddData(){
        sendButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = mydb.insertData(Items.getText().toString(), Total_Price.getText().toString(),
                                                                Personal_Preferances.getText().toString());

                        if (isInserted = true)
                            Toast.makeText(finalize_order.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(finalize_order.this,"Do not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
    public  void button14(){
        viewButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Cursor res= mydb.getAllData();
                       if (res.getCount()==0){
                           //show msg
                           return;
                       }
                       StringBuffer buffer=new StringBuffer();
                       while(res.moveToNext()){
                           buffer.append("id:"+res.getString(0)+"\n");
                           buffer.append("Items:"+res.getString(0)+"\n");
                           buffer.append("Personal_Preferances:"+res.getString(0)+"\n");
                           buffer.append("Total_Price:"+res.getString(0)+"\n\n");
                       }

                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    public void show_Order() {
        if (Dessert.chocolate_ice_cream > 0) {
            fin_order_string = fin_order_string + "chocolate ice cream-" + String.valueOf(Dessert.chocolate_ice_cream) + ",";
        }
        if (Dessert.vanilla_ice_cream > 0) {
            fin_order_string = fin_order_string + "vannila ice cream-" + String.valueOf(Dessert.vanilla_ice_cream) + ",";
        }

        if (Dessert.strawberry_ice_cream > 0) {
            fin_order_string = fin_order_string + "strawberry ice cream-" + String.valueOf(Dessert.strawberry_ice_cream) + ",";
        }
        if (Dessert.falooda > 0) {
            fin_order_string = fin_order_string + "falooda-" + String.valueOf(Dessert.falooda) + ",";
        }
        if (Dessert.brownie_fudge > 0) {
            fin_order_string = fin_order_string + "brownie fudge-" + String.valueOf(Dessert.brownie_fudge) + ",";
        }
        if (Dessert.alpine_chocolate > 0) {
            fin_order_string = fin_order_string + "alpine chocolate-" + String.valueOf(Dessert.alpine_chocolate) + ",";
        }
        if (Dessert.devils_delight > 0) {
            fin_order_string = fin_order_string + "devils delite-" + String.valueOf(Dessert.devils_delight) + ",";
        }

        if (Dessert.black_forest > 0) {
            fin_order_string = fin_order_string + "black forest-" + String.valueOf(Dessert.black_forest) + ",";
        }
        if (Dessert.chocolate_lava > 0) {
            fin_order_string = fin_order_string + "chocolate lava-" + String.valueOf(Dessert.chocolate_lava) + ",";
        }

        if (Dessert.dutch_almond > 0) {
            fin_order_string = fin_order_string + "dutch almond-" + String.valueOf(Dessert.dutch_almond) + ",";
        }
        if (N_Veg.chicken_burger > 0) {
            fin_order_string = fin_order_string + "chicken burger-" + String.valueOf(N_Veg.chicken_burger) + ",";
        }
        if (N_Veg.chicken_bbq_pizza > 0) {
            fin_order_string = fin_order_string + "chicken bbq pizza-" + String.valueOf(N_Veg.chicken_bbq_pizza) + ",";
        }
        if (N_Veg.chicken_tikka > 0) {
            fin_order_string = fin_order_string + "chicken tikka-" + String.valueOf(N_Veg.chicken_tikka) + ",";
        }
        if (N_Veg.fried_fish_rice > 0) {
            fin_order_string = fin_order_string + "fried fish rice-" + String.valueOf(N_Veg.fried_fish_rice) + ",";
        }
        if (N_Veg.kolhapuri_chicken > 0) {
            fin_order_string = fin_order_string + "kolhapur chicken-" + String.valueOf(N_Veg.kolhapuri_chicken) + ",";
        }
        if (N_Veg.chicken_noodles > 0) {
            fin_order_string = fin_order_string + "chicken noodles-" + String.valueOf(N_Veg.chicken_noodles) + ",";
        }
        if (N_Veg.chicken_fried_rice > 0) {
            fin_order_string = fin_order_string + "chicken fried rice-" + String.valueOf(N_Veg.chicken_fried_rice) + ",";
        }

        if (N_Veg.chicken_lollipop > 0) {
            fin_order_string = fin_order_string + "chicken lollipop-" + String.valueOf(N_Veg.chicken_lollipop) + ",";
        }

        if (N_Veg.chicken_biryani> 0) {
            fin_order_string = fin_order_string + "chicken biryani-" + String.valueOf(N_Veg.chicken_biryani) + ",";
        }
        if (N_Veg.mutton_biryani> 0) {
            fin_order_string = fin_order_string + "mutton biryani-" + String.valueOf(N_Veg.mutton_biryani) + ",";
        }

        if (Veg.roti > 0) {
            fin_order_string = fin_order_string + "roti-" + String.valueOf(Veg.roti) + ",";
        }
        if (Veg.butter_roti > 0) {
            fin_order_string = fin_order_string + "butter roti-" + String.valueOf(Veg.butter_roti) + ",";
        }
        if (Veg.paneer_tikka > 0) {
            fin_order_string = fin_order_string + "paneer tikka-" + String.valueOf(Veg.paneer_tikka) + ",";
        }

        if (Veg.veg_pulao > 0) {
            fin_order_string = fin_order_string + "veg pulao-" + String.valueOf(Veg.veg_pulao) + ",";
        }
        if (Veg.mutter_paneer> 0) {
            fin_order_string = fin_order_string + "mutter paneer-" + String.valueOf(Veg.mutter_paneer) + ",";
        }
        if (Veg.veg_noodles> 0) {
            fin_order_string = fin_order_string + "veg noodles-" + String.valueOf(Veg.veg_noodles) + ",";
        }

        if (Veg.veg_fried_rice> 0) {
            fin_order_string = fin_order_string + "veg fried rice-" + String.valueOf(Veg.veg_fried_rice) + ",";
        }
        if (Veg.veg_burger> 0) {
            fin_order_string = fin_order_string + "veg burger-" + String.valueOf(Veg.veg_burger) + ",";
        }
        if (Veg.veg_biryani> 0) {
            fin_order_string = fin_order_string + "veg briyani-" + String.valueOf(Veg.veg_biryani) + ",";
        }

        if (Veg.paneer_kofta> 0) {
            fin_order_string = fin_order_string + "paneer kofta-" + String.valueOf(Veg.paneer_kofta) + ",";
        }
        if (Starters.veg_crispy > 0) {
            fin_order_string = fin_order_string + "veg crispy-" + String.valueOf(Starters.veg_crispy) + ",";
        }
        if (Starters.chicken_crispy > 0) {
            fin_order_string = fin_order_string + "chicken crispy-" + String.valueOf(Starters.chicken_crispy) + ",";
        }
        if (Starters.paneer_chilly > 0) {
            fin_order_string = fin_order_string + "paneer chilly-" + String.valueOf(Starters.paneer_chilly) + ",";
        }
        if (Starters.masala_papad > 0) {
            fin_order_string = fin_order_string + "masala papad-" + String.valueOf(Starters.masala_papad) + ",";
        }
        if (Starters.veg_soup > 0) {
            fin_order_string = fin_order_string + "veg soup-" + String.valueOf(Starters.veg_soup) + ",";
        }
        if (Starters.chicken_soup > 0) {
            fin_order_string = fin_order_string + "chicken soup-" + String.valueOf(Starters.chicken_soup) + ",";
        }
        if (Starters.tomato_soup > 0) {
            fin_order_string = fin_order_string + "tomato soup-" + String.valueOf(Starters.tomato_soup) + ",";
        }
        if (Starters.cheese_pakoda > 0) {
            fin_order_string = fin_order_string + "cheese pakoda-" + String.valueOf(Starters.cheese_pakoda) + ",";
        }
        if (Starters.paneer_pakoda > 0) {
            fin_order_string = fin_order_string + "paneer pakoda-" + String.valueOf(Starters.paneer_pakoda) + ",";
        }
        if (Starters.chicken_chilly > 0) {
            fin_order_string = fin_order_string + "chicken chilly-" + String.valueOf(Starters.chicken_chilly) + ",";
        }
        String temp_order_view=fin_order_string+old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("total price:" + "Rs:" +(finalize_order.all_total));
    }



    /*public class SendMessage extends AsyncTask<Void, Void, Void> {
        BufferedReader bb;
        Socket client;
        PrintWriter printwriter;


        @Override
        protected Void doInBackground(Void... params) {
            try {
                client = new Socket("192.168.1.105", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                bb=new BufferedReader(new InputStreamReader(client.getInputStream()));
                printwriter.println(finalize_order.messsage); // write the message to output stream
                printwriter.flush();
                m1=bb.readLine();
                //System.out.println("dd:"+m1);
                //m1="hello";
                bb.close();
                client.close(); // closing the connection
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void send_ord(View v){
        order_string=fin_order_string;

        EditText Ed= (EditText) findViewById(R.id.personalp);

        personal_preferances=Ed.getText().toString();

        final Object o = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to confirm this order?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        messsage = "Order:" +  "|" + fin_order_string + "|" + Integer.toString(all_total)+"|"+personal_preferances;
                        ; // get the text message on the text field
                        // messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total);
                        SendMessage sendMessageTask = new SendMessage();
                        sendMessageTask.execute();
                        Intent nextact = new Intent((finalize_order) o, thankyou.class);
                        startActivity(nextact);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }*/
}