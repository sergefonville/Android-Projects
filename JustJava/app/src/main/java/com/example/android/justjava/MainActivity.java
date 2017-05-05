/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava; 
 */
package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private TextView quantityTextView;
    private TextView priceSummaryTextView;
    private TextView clientNameSummaryTextView;
    private TextView quantitySummaryTextView;
    private TextView thankYouSummaryTextView;
    private LinearLayout orderSummaryLayout;
    private Button submitOrderButton;
    private Button newCustomerButton;
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        this.priceSummaryTextView  = (TextView) findViewById(R.id.price_summary_text_view);
        this.clientNameSummaryTextView = (TextView) findViewById(R.id.client_name_summary_text_view);
        this.quantitySummaryTextView = (TextView) findViewById(R.id.quantity_summary_text_view);
        this.thankYouSummaryTextView = (TextView) findViewById(R.id.thank_you_summary_text_view);
        this.orderSummaryLayout = (LinearLayout) findViewById(R.id.order_summary_layout);
        this.submitOrderButton = (Button) findViewById(R.id.submit_order_button);
        this.newCustomerButton = (Button) findViewById(R.id.new_customer_button);
        displayQuantity();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        createOrderSummary();
    }

    public void increaseQuantity(View view) {
        this.quantity++;
        if(this.quantity == 0)
            this.quantity = 2;
        this.displayQuantity();
    }

    /**
     * This method calculates the price.
     * @return the price by multiplying the quantity by 5
     */
    private int calculatePrice() {
        return this.quantity * 5;
    }

    public void decreaseQuantity(View view) {
        if(this.quantity == 1)
            return;
        this.quantity--;
        this.displayQuantity();
    }

    /**
     * This method displays the quantity value on the screen.
     */
    private void displayQuantity() {
        String displayQuantity = String.format("%d", this.quantity);
        this.quantityTextView.setText(displayQuantity);
    }

    private void createOrderSummary() {
        this.clientNameSummaryTextView.setText("Name: " + "Kaptain Kunal");
        this.quantitySummaryTextView.setText("Quantity: "+ this.quantityTextView.getText().toString());
        this.priceSummaryTextView.setText("Total: " + DecimalFormat.getCurrencyInstance().format(this.calculatePrice()));
        this.thankYouSummaryTextView.setText("Thank you!");
        this.orderSummaryLayout.setVisibility(View.VISIBLE);
        this.submitOrderButton.setVisibility(View.GONE);
        this.newCustomerButton.setVisibility(View.VISIBLE);
    }

    public void newCustomer(View view) {
        this.quantityTextView.setText("1");
        this.quantity = 1;
        this.orderSummaryLayout.setVisibility(View.GONE);
        this.submitOrderButton.setVisibility(View.VISIBLE);
        this.newCustomerButton.setVisibility(View.GONE);
    }
}