
import android.content.Context
import android.content.SharedPreferences
import com.besttyme.kotlin.utils.security.EncryptedPreferences
import com.school.kotlin.R

/**
 * Created by android on 27/2/18.
 */
 class Preferences {
    companion object {

        var prefs: SharedPreferences? = null
        fun initPreferences(context: Context) {
            prefs = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE)
        }
    }
}