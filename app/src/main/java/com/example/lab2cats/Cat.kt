package com.example.lab2cats
import com.google.gson.annotations.SerializedName
data class Cat(
    val id: Int,
    val name: String,
    val origin: String,
    @SerializedName("image_url")val imageUrl: String,
    @SerializedName("general_health")val healthRate: Int,
    val length: String,
    @SerializedName("playfulness")val playfulnessRate: Int,
    @SerializedName("intelligence")val intelligenceRate:Int,
    @SerializedName("family_friendly")val familyFriendlyRate: Int
)
