package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = listOf(
            Food("Batagor", "Batagor (Bakso Tahu Goreng) adalah jajanan khas Bandung yang terbuat dari tahu dan bakso ikan, disajikan dengan saus kacang yang kental dan sambal, memberikan rasa gurih yang memikat.", R.drawable.batagor, 15000.0),
            Food("Black Salad", "Black Salad adalah kombinasi segar dari sayuran dan buah-buahan dengan dressing yang khas. Dipadukan dengan potongan keju hitam yang creamy, menciptakan rasa yang seimbang dan menyegarkan.", R.drawable.black_salad, 20000.0),
            Food("Cappucino", "Cappucino adalah sajian kopi klasik yang dibuat dari espresso yang kuat dan susu steamed yang lembut, disajikan dengan busa susu di atasnya. Rasanya yang creamy dan kaya membuatnya menjadi favorit bagi pencinta kopi.", R.drawable.cappuchino, 30000.0),
            Food("Cheese Cake", "Cheese Cake adalah kue lembut yang terbuat dari keju krim yang kaya, diletakkan di atas dasar biskuit yang renyah. Kelembutannya yang creamy dan rasa manis yang pas menjadikannya penutup yang sempurna.", R.drawable.cheesecake, 25000.0),
            Food("Cireng", "Cireng adalah jajanan khas Sunda yang terbuat dari tepung sagu dan diisi dengan berbagai bahan, seperti ayam, sayuran, atau bumbu khas. Renyah di luar dan kenyal di dalam, cocok disajikan dengan sambal rujak.", R.drawable.cireng, 10000.0),
            Food("Donut", "Donut adalah kue manis berbentuk lingkaran yang digoreng dan dilapisi dengan gula atau cokelat. Teksturnya yang lembut dan rasanya yang manis menjadikannya camilan yang sempurna untuk segala suasana.", R.drawable.donut, 12000.0),
            Food("Kopi Hitam", "Kopi Hitam adalah sajian kopi murni tanpa tambahan susu atau gula, menyajikan cita rasa pahit yang kaya. Cocok untuk para pencinta kopi sejati yang ingin merasakan keaslian kopi.", R.drawable.kopi_hitam, 15000.0),
            Food("Mie Goreng", "Mie Goreng adalah hidangan mie yang digoreng dengan bumbu khas, sayuran segar, dan pilihan protein seperti ayam atau udang. Rasa gurih dan pedasnya membuatnya menjadi pilihan yang populer.", R.drawable.mie_goreng, 20000.0),
            Food("Nasi Goreng", "Nasi Goreng adalah hidangan nasi yang digoreng dengan bumbu kecap, sayuran, dan biasanya disajikan dengan telur mata sapi di atasnya. Kombinasi rasa manis dan asin menjadikannya favorit di berbagai kalangan.", R.drawable.nasigoreng, 18000.0),
            Food("Sparkling Tea", "Sparkling Tea adalah teh yang disajikan dengan air soda bergelembung, menciptakan sensasi menyegarkan. Dapat dinikmati dengan berbagai rasa, cocok untuk menyegarkan hari Anda.", R.drawable.sparkling_tea, 22000.0)
        )



        adapter = FoodAdapter(foodList, this) { food ->
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("foodName", food.name)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        val mainView = findViewById<View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}
