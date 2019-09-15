package com.example.singlepageactivityproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.squareup.picasso.Picasso

class MainKotlinActivity : AppCompatActivity() {

    private val IMG_URL = "https://www.gstatic.com/webp/gallery/1.jpg"
    private var topBartext: TextView? = null
    private var rlImageView: ImageView? = null
    private var flImageView: ImageView? = null
    private var collapsibleDescription: TextView? = null
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topBartext = findViewById(R.id.main_s_l_r1_text)
        rlImageView = findViewById(R.id.main_s_l_r2_image)
        flImageView = findViewById(R.id.main_s_l_f_image)
        collapsibleDescription = findViewById(R.id.main_s_l_l1_desc)
        setTopBarText()
        setRelativeLayoutImageFromInternet()
        collapsibleTextViews()
        setFrameLayoutImage()
        counter = 0
        buttonCounterToast()
    }

    private fun setTopBarText() {
        val text = topBartext?.text
        topBartext?.text = "$text from kotlin"
    }

    private fun setRelativeLayoutImageFromInternet() {
        Picasso.get()
            .load(IMG_URL)
            .into(rlImageView)
    }

    private fun collapsibleTextViews() {
        val img: ImageView = findViewById(R.id.main_s_l_l1_image)
        img.setOnClickListener { view ->
            if (collapsibleDescription?.visibility == View.GONE) {
                view.setBackgroundResource(android.R.drawable.arrow_down_float)
                view.setPadding(0, 0, 20, 0)
                collapsibleDescription?.visibility = View.VISIBLE
            } else {
                view.setBackgroundResource(android.R.drawable.arrow_up_float)
                view.setPadding(0, 0, 20, 0)
                collapsibleDescription?.visibility = View.GONE
            }
        }
    }

    private fun setFrameLayoutImage() {
        Picasso.get()
            .load(IMG_URL)
            .into(flImageView)
    }

    private fun buttonCounterToast() {
        val hitMe: Button = findViewById(R.id.main_s_l_r3_hitme_btn)
        hitMe.setOnClickListener { setBtnToast(counter++) }

    }

    private fun setBtnToast(counter: Int) {
        val toast = Toast.makeText(
            this,
            "Button hit counter is: $counter", Toast.LENGTH_SHORT
        )
        toast?.show()
    }
}
