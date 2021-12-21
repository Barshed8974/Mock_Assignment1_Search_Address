package com.example.mock_assignment1.DataClasses

import com.google.gson.annotations.SerializedName

data class ResponseModel(

	@field:SerializedName("data")
	val data: Data1? = null,

	@field:SerializedName("requestId")
	val requestId: String? = null
)

data class AddressListItem(

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("pinCode")
	val pinCode: String? = null,

	@field:SerializedName("addressString")
	val addressString: String? = null,

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("priority")
	val priority: Int? = null
)

data class Data1(

	@field:SerializedName("focusWord")
	val focusWord: String? = null,

	@field:SerializedName("addressList")
	val addressList: List<AddressListItem?>? = null,

	@field:SerializedName("totalNoRSUReturned")
	val totalNoRSUReturned: Int? = null,

	@field:SerializedName("totalFindByRSUHits")
	val totalFindByRSUHits: Int? = null,

	@field:SerializedName("autoCompleteRequestString")
	val autoCompleteRequestString: String? = null
)
