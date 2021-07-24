package com.example.kidsdrawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_brush_size.*

class MainActivity : AppCompatActivity() {

    private var mImageButtonCurrentPaint: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawing_view.setSizeForBrush(20.toFloat())

        mImageButtonCurrentPaint = ll_paint_colors[1] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.palette_pressed)
        )

        ib_brush.setOnClickListener{
            showBrushSizeChooseDialog()
        }


    }

    private fun showBrushSizeChooseDialog()
    {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size")
        val smallBtn = brushDialog.ib_small_brush
        val mediumBtn = brushDialog.ib_medium_brush
        val largeBtn = brushDialog.ib_large_brush
        smallBtn.setOnClickListener{
            drawing_view.setSizeForBrush((10.toFloat()))
            brushDialog.dismiss()
        }
        mediumBtn.setOnClickListener{
            drawing_view.setSizeForBrush((20.toFloat()))
            brushDialog.dismiss()
        }
        largeBtn.setOnClickListener{
            drawing_view.setSizeForBrush((30.toFloat()))
            brushDialog.dismiss()
        }

        brushDialog.show()
    }

    fun paintClicked(view: View){

    }

}