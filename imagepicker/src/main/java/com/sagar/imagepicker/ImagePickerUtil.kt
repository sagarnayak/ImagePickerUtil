package com.sagar.imagepicker

import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import com.fxn.pix.Options
import com.fxn.pix.Pix


object ImagePickerUtil {
    fun pickImage(
        context: AppCompatActivity,
        reqCode: Int,
        numberOfImage: Int = 1,
        returnList: ArrayList<String> = ArrayList(),
        orientation: Int = Options.SCREEN_ORIENTATION_PORTRAIT
    ) {
        val options = Options.init()
            .setRequestCode(reqCode) //Request code for activity results
            .setCount(numberOfImage) //Number of images to restict selection count
            .setFrontfacing(false) //Front Facing camera on start
            .setPreSelectedUrls(returnList) //Pre selected Image Urls
            .setSpanCount(4) //Span count for gallery min 1 & max 5
            .setExcludeVideos(false) //Option to exclude videos
            .setVideoDurationLimitinSeconds(30) //Duration for video recording
            .setScreenOrientation(orientation) //Orientaion
            .setPath("/remittance/images") //Custom Path For media Storage

        Pix.start(context, options)
    }

    fun rotateImage(source: Bitmap, angle: Float): Bitmap? {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(
            source,
            0,
            0,
            source.width,
            source.height,
            matrix,
            true
        )
    }
}