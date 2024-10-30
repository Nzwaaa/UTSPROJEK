package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var tvFoodNameValue: TextView
    private lateinit var tvServingsValue: TextView
    private lateinit var tvOrderingNameValue: TextView
    private lateinit var tvAdditionalNotesValue: TextView
    private lateinit var backToMenuButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Inisialisasi TextView
        tvFoodNameValue = findViewById(R.id.tvFoodNameValue)
        tvServingsValue = findViewById(R.id.tvServingsValue)
        tvOrderingNameValue = findViewById(R.id.tvOrderingNameValue)
        tvAdditionalNotesValue = findViewById(R.id.tvAdditionalNotesValue)
        backToMenuButton = findViewById(R.id.backtoMenu)

        // Mengambil data dari Intent
        val foodName = intent.getStringExtra("foodName") ?: "Unknown Food"
        val servings = intent.getStringExtra("servings") ?: "0"
        val orderingName = intent.getStringExtra("orderingName") ?: "Unknown"
        val additionalNotes = intent.getStringExtra("additionalNotes") ?: "None"

        // Mengisi nilai ke TextView
        tvFoodNameValue.text = foodName
        tvServingsValue.text = servings
        tvOrderingNameValue.text = orderingName
        tvAdditionalNotesValue.text = additionalNotes

        // Mengatur OnClickListener untuk tombol "Selesai"
        backToMenuButton.setOnClickListener {
            // Pindah ke ListFoodActivity
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish() // Menutup ConfirmationActivity agar tidak kembali ke halaman ini
        }
    }
}
