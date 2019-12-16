package com.example.apiconnection

import android.os.AsyncTask
import android.util.JsonReader
import android.util.Log
import java.io.InputStreamReader
import java.net.URL

class TaskHelper : AsyncTask<Void, Void, String>() {
    var v = ""



    override fun doInBackground(vararg params: Void?): String {
        var endp = URL("https://api.chucknorris.io/jokes/random")
        var myConnection = endp.openConnection()
        var responseBody = myConnection.getInputStream()
        var responseBodyReader = InputStreamReader(responseBody, "UTF-8")
        var jsonReader = JsonReader(responseBodyReader)


        jsonReader.beginObject() // Start processing the JSON object
        while (jsonReader.hasNext()) { // Loop through all keys
            val key = jsonReader.nextName() // Fetch the next key
            if (key == "value") {
                this.v = jsonReader.nextString()
                //Log.d("In doInBackground", v)
                break
            } else {
                jsonReader.skipValue()
                this.v = "Przykro mi, wystąpił błąd"
            }
        }
        jsonReader.close()
        return v
    }

    fun myMethod() : String {
        return this.v
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        this.v = result!!
    }
}