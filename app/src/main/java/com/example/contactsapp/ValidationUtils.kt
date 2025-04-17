import android.util.Patterns

object ValidationUtils {
    fun validateName(name: String): String? {
        if (name.isBlank()) {
            return "Required"
        }
        if (!name.all { it.isLetter() }) {
            return "Name should only contain letters"
        }
        return null
    }

    fun validateEmail(email: String): String? {
        if (email.isBlank()) {
            return "Required"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "Invalid Email"
        }
        return null
    }

    fun validatePhone(phone: String): String? {
        if (phone.isBlank()) {
            return "Required"
        }
        if (!phone.matches("^[0-9]{7,15}$".toRegex())) {
            return "Invalid Phone Format"
        }
        return null
    }
}
