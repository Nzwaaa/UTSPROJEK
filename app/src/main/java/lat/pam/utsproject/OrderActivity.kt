package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Toast

class OrderActivity : AppCompatActivity() {

    private lateinit var servingsEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var notesEditText: EditText
    private lateinit var foodNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Mengambil nilai dari Intent
        val foodName = intent.getStringExtra("foodName") ?: "Unknown Food"

        // Inisialisasi TextView untuk nama makanan
        foodNameTextView = findViewById(R.id.etFoodName)
        foodNameTextView.setText(foodName)

        // Menginisialisasi EditText
        servingsEditText = findViewById(R.id.etServings)
        nameEditText = findViewById(R.id.etName)
        notesEditText = findViewById(R.id.etNotes)



        // Mengatur OnClickListener untuk tombol pemesanan
        val orderButton: Button = findViewById(R.id.btnOrder)
        orderButton.setOnClickListener {
            val servings = servingsEditText.text.toString()
            val orderingName = nameEditText.text.toString()
            val additionalNotes = notesEditText.text.toString()

            // Validasi input
            if (servings.isNotBlank() && orderingName.isNotBlank()) {
                // Mengirim data ke ConfirmationActivity
                val intent = Intent(this, ConfirmationActivity::class.java).apply {
                    putExtra("foodName", foodName)
                    putExtra("servings", servings)
                    putExtra("orderingName", orderingName)
                    putExtra("additionalNotes", additionalNotes)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Mengatur padding untuk Edge to Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}

