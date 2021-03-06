package com.example.due

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File


class HomePageNew : AppCompatActivity() {

    private val CHANNEL_ID = "channel_id_exmample_01"
    private val notificationId = 101

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_new)

        createNotificationChannel()

        val db = Firebase.firestore
        val storageRef = FirebaseStorage.getInstance().reference;

        val currentUsername = "Jack"
        val currentUserId = "ZQZEsGUBpxxFvU026MeW"
        val seenUsers: ArrayList<UserInfo> = arrayListOf()


        db.collection("test_users").whereNotEqualTo("username", currentUsername)
            .get()
            .addOnSuccessListener { result ->

                val userAgeTextView: TextView = findViewById(R.id.user_age_textview)

                // Get all nearby users
                val users = ArrayList<UserInfo>()
                for (document in result) {
                    Log.d("test_users", "${document.id} => ${document.data}")
                    val userInfo = document.toObject(UserInfo::class.java) ?: UserInfo()
                    userInfo.id = document.id
                    users.add(userInfo)
                }


                val notSeenUsers = users.filter { s -> s !in seenUsers }
                var displayedUser = notSeenUsers.shuffled().take(1)[0]

                // Display the first user
                seenUsers.add(displayedUser)
                userAgeTextView.text = "${displayedUser.username}, ${displayedUser.age}"
                val startUserImagesRef: StorageReference = storageRef.child("${displayedUser.username}.jpg")
                val startLocalFile = File.createTempFile("images", "jpg")
                startUserImagesRef.getFile(startLocalFile)
                        .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                            Log.d("photo", "success")

                            // Display user image
                            val userImage: ImageView = findViewById<View>(R.id.user_image) as ImageView
                            val myBitmap = BitmapFactory.decodeFile(startLocalFile.absolutePath)
                            userImage.setImageBitmap(myBitmap)

                            Log.d("photo", "display")

                        }).addOnFailureListener(OnFailureListener {
                            Log.d("photo", "fail")
                        })


                // Like button pressed
                val likeButton: Button = findViewById(R.id.like_button)
                likeButton.setOnClickListener {

                    // Check if it's a match
                    if(currentUsername in displayedUser.my_likes) {
                        sendNotification("${displayedUser.username} also likes you")
                    }

                    // Update the database about the like reaction
                    displayedUser.got_likes.add(currentUsername)
                    val data = hashMapOf("got_likes" to displayedUser.got_likes)
                    db.collection("test_users").document(displayedUser.id)
                            .set(data, SetOptions.merge())
                            .addOnSuccessListener {}
                            .addOnFailureListener {
                                Toast.makeText(applicationContext, "egine malakia", Toast.LENGTH_SHORT).show()
                            }

                    val notSeenUsers = users.filter { s -> s !in seenUsers }

                    // Display next user
                    if(notSeenUsers.isNotEmpty()) {

                        // Get the new one
                        displayedUser = notSeenUsers.shuffled().take(1)[0]
                        seenUsers.add(displayedUser)

                        // Download User Image
                        val userImagesRef: StorageReference = storageRef.child("${displayedUser.username}.jpg")
                        val localFile = File.createTempFile("images", "jpg")
                        userImagesRef.getFile(localFile)
                                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                                    Log.d("photo", "success")

                                    // Display user image
                                    val userImage: ImageView = findViewById<View>(R.id.user_image) as ImageView
                                    val myBitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                    userImage.setImageBitmap(myBitmap)

                                    // Display Username
                                    userAgeTextView.text = "${displayedUser.username}, ${displayedUser.age}"

                                }).addOnFailureListener(OnFailureListener {
                                    Log.d("photo", "fail")
                                })

                    }
                    else{
                        userAgeTextView.text = "den exei alla mounakia bro"
                    }

                }

                // Dislike button pressed
                val dislikeButton: Button = findViewById(R.id.dislike_button)
                dislikeButton.setOnClickListener {

                    // Update the database about the like reaction
                    displayedUser.got_dislikes.add(currentUsername)
                    val data = hashMapOf("got_dislikes" to displayedUser.got_dislikes)
                    db.collection("test_users").document(displayedUser.id)
                            .set(data, SetOptions.merge())
                            .addOnSuccessListener {}
                            .addOnFailureListener {
                                Toast.makeText(applicationContext, "egine malakia", Toast.LENGTH_SHORT).show()
                            }

                    val notSeenUsers = users.filter { s -> s !in seenUsers }

                    // Display next user
                    if(notSeenUsers.isNotEmpty()) {

                        // Get the new one
                        displayedUser = notSeenUsers.shuffled().take(1)[0]
                        seenUsers.add(displayedUser)


                        // Download User Image
                        val userImagesRef: StorageReference = storageRef.child("${displayedUser.username}.jpg")
                        val localFile = File.createTempFile("images", "jpg")
                        userImagesRef.getFile(localFile)
                                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                                    Log.d("photo", "success")

                                    // Display user image
                                    val userImage: ImageView = findViewById<View>(R.id.user_image) as ImageView
                                    val myBitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                    userImage.setImageBitmap(myBitmap)

                                    // Display Username
                                    userAgeTextView.text = "${displayedUser.username}, ${displayedUser.age}"

                                }).addOnFailureListener(OnFailureListener {
                                    Log.d("photo", "fail")
                                })

                    }
                    else{
                        userAgeTextView.text = "den exei alla mounakia bro"
                    }

                }

                // Drink button pressed
                val drinkButton: Button = findViewById(R.id.drink_button)
                drinkButton.setOnClickListener {

                    // Check if it's a match
                    if(currentUsername in displayedUser.my_likes) {
                        sendNotification("Buy ${displayedUser.username} a drink")
                    }

                    // Update the database about the like reaction
                    displayedUser.got_drinks.add(currentUsername)
                    val data = hashMapOf("got_drinks" to displayedUser.got_drinks)
                    db.collection("test_users").document(displayedUser.id)
                            .set(data, SetOptions.merge())
                            .addOnSuccessListener {}
                            .addOnFailureListener {
                                Toast.makeText(applicationContext, "egine malakia", Toast.LENGTH_SHORT).show()
                            }

                    val notSeenUsers = users.filter { s -> s !in seenUsers }

                    // Display next user
                    if(notSeenUsers.isNotEmpty()) {

                        // Get the new one
                        displayedUser = notSeenUsers.shuffled().take(1)[0]
                        seenUsers.add(displayedUser)

                        // Download User Image
                        val userImagesRef: StorageReference = storageRef.child("${displayedUser.username}.jpg")
                        val localFile = File.createTempFile("images", "jpg")
                        userImagesRef.getFile(localFile)
                                .addOnSuccessListener(OnSuccessListener<FileDownloadTask.TaskSnapshot?> {
                                    Log.d("photo", "success")

                                    // Display user image
                                    val userImage: ImageView = findViewById<View>(R.id.user_image) as ImageView
                                    val myBitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                                    userImage.setImageBitmap(myBitmap)

                                    // Display Username
                                    userAgeTextView.text = "${displayedUser.username}, ${displayedUser.age}"

                                }).addOnFailureListener(OnFailureListener {
                                    Log.d("photo", "fail")
                                })

                    }
                    else{
                        userAgeTextView.text = "den exei alla mounakia bro"
                    }

                }

            }
            .addOnFailureListener { exception ->
                Log.d("test_users", "Error getting documents: ", exception)
            }


    }

    private fun createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
                enableVibration(true)
                enableLights(true)
                lightColor = Color.MAGENTA
            }

            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(message: String){

        val intent = Intent(this, Messages::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.duemylogo1)
        val bitmapLargeIcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.duemylogo1)

        val unicode = 0x1F60A
        val emoji = String(Character.toChars(unicode));

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("You have a match!")
                .setContentText("$message and ... $emoji")
                .setSmallIcon(R.drawable.ic_launcher_mylogo_foreground)
                //.setLargeIcon(bitmapLargeIcon)
                //.setStyle(NotificationCompat.BigPictureStyle().bigPicture(userBitmap))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(notificationId, builder.build())
        }

    }
}

data class UserInfo(
        var id: String = "",
        var username: String = "",
        var age: Int = 0,
        var my_likes: ArrayList<String> = arrayListOf(),
        var got_likes: ArrayList<String> = arrayListOf(),
        var got_drinks: ArrayList<String> = arrayListOf(),
        var got_dislikes: ArrayList<String> = arrayListOf()
)