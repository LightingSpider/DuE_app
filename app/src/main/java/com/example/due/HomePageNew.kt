package com.example.due

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File


class HomePageNew : AppCompatActivity() {

    private val mStorageRef: StorageReference? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_new)

        val db = Firebase.firestore
        val storageRef = FirebaseStorage.getInstance().reference;
        //val storageRef: StorageReference = FirebaseStorage.getReference()

        db.collection("test_users")
            .get()
            .addOnSuccessListener { result ->

                val users = ArrayList<UserInfo>()

                // Get all nearby users
                for (document in result) {
                    Log.d("test_users", "${document.id} => ${document.data}")
                    val userInfo = document.toObject(UserInfo::class.java) ?: UserInfo()
                    users.add(userInfo)
                }

                val userAgeTextView: TextView = findViewById(R.id.user_age_textview)

                // Display the first user
                userAgeTextView.text = "${users[0].username}, ${users[0].age}"
                val riversRef: StorageReference = storageRef.child("${users[0].username}.jpg")
                val localFile = File.createTempFile("images", "jpg")
                riversRef.getFile(localFile)
                        .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                            Log.d("photo", "success")

                            // Display user image
                            val userImage: ImageView = findViewById<View>(R.id.user_image) as ImageView
                            val myBitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                            userImage.setImageBitmap(myBitmap)

                            Log.d("photo", "display")

                        }).addOnFailureListener(OnFailureListener {
                            Log.d("photo", "fail")
                        })

                // Like button pressed
                val likeButton: Button = findViewById(R.id.like_button)
                likeButton.setOnClickListener {

                    // Display users
                    if(users.size > 1) {
                        val userRange = 1 until users.size
                        val userIndex = userRange.random()
                        Log.d("index", userIndex.toString())
                        userAgeTextView.text = "${users[userIndex].username}, ${users[userIndex].age}"


                        // Download user photo
                        val riversRef: StorageReference = storageRef.child("${users[userIndex].username}.jpg")
                        val localFile = File.createTempFile("images", "jpg")
                        riversRef.getFile(localFile)
                                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                                    Log.d("photo", "success")

                                    // Display user image
                                    val userImage: ImageView = findViewById<View>(R.id.user_image) as ImageView
                                    val myBitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                    userImage.setImageBitmap(myBitmap)

                                    Log.d("photo", "display")

                                }).addOnFailureListener(OnFailureListener {
                                    Log.d("photo", "fail")
                                })


                        users.removeAt(userIndex)
                    }
                    else{
                        userAgeTextView.text = "den exei alla mounakia bro"
                    }
                }

            }
            .addOnFailureListener { exception ->
                Log.d("test_users", "Error getting documents: ", exception)
            }



        /*
        val rollButton: Button = findViewById(R.id.like_button)
        rollButton.setOnClickListener {

            db.collection("test_users").document("4EkcTGIqP5WYIJvmwXIz")
                    .get()
                    .addOnSuccessListener { document ->
                        val userInfo = document.toObject(UserInfo::class.java) ?: UserInfo()
                        user_age.text = "${userInfo.username}, ${userInfo.age}"
                    }
                    .addOnFailureListener { exception ->
                        Log.w("test_users", "Error getting documents.", exception)
                    }

        }
        */
    }
}

data class UserInfo(
        var username: String = "",
        var age: Int = 0,
        var my_likes: ArrayList<String> = arrayListOf(),
        var got_likes: ArrayList<String> = arrayListOf(),
        var got_drinks: ArrayList<String> = arrayListOf(),
        var got_dislikes: ArrayList<String> = arrayListOf()
)