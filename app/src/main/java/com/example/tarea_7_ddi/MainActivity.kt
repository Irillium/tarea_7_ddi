package com.example.tarea_7_ddi

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.tarea_7_ddi.databinding.ActivityMainBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainActivity : AppCompatActivity() {

    private var _binding:ActivityMainBinding?=null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)
        setubView()
        setubListCarousel()
    }
    fun setubListCarousel(){
        val imageList = mutableListOf<CarouselItem>()
        imageList.add(CarouselItem(R.drawable.zapatos_ganso_verde_01))
        imageList.add(CarouselItem(R.drawable.zapatos_ganso_verde_02))
        imageList.add(CarouselItem(R.drawable.zapatos_ganso_verde_03))
        imageList.add(CarouselItem(R.drawable.zapatos_ganso_verde_04))
        imageList.add(CarouselItem(R.drawable.zapatos_ganso_verde_05))
        imageList.add(CarouselItem(R.drawable.zapatos_ganso_verde_06))
        imageList.add(CarouselItem(R.drawable.zapatos_ganso_verde_07))

        binding.carousel.addData(imageList)
    }

    fun setubView(){
        binding.apply {
            like.setOnClickListener{
                likeCheck.visibility = View.VISIBLE
                like.visibility = View.GONE
            }
            likeCheck.setOnClickListener{
                likeCheck.visibility = View.GONE
                like.visibility = View.VISIBLE
            }
            Glide.with(this@MainActivity)
                .load(R.drawable.foto_perfil_random)
                .transform(CircleCrop())
                .into(user)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        val redItem = menu!!.findItem(R.id.denunciar)
        val spannableString = SpannableString(redItem!!.title)
        spannableString.setSpan(
            ForegroundColorSpan(Color.RED),
            0,
            spannableString.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        redItem.title = spannableString
        return true
    }
}