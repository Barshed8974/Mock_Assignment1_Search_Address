package com.example.mock_assignment1.View

import android.os.Parcelable
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Suggestions(val suggestion: String) : Parcelable, SearchSuggestion {

    override fun getBody(): String {
        return suggestion
    }

}