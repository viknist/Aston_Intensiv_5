package ru.viknist.aston_dz_5.ui.contact_details

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.fragment.app.setFragmentResultListener
import ru.viknist.aston_dz_5.R
import ru.viknist.aston_dz_5.ui.contact_list.ContactListFragment.Companion.CONTACT_LIST_FRAGMENT_RESULT_KEY

class ContactDetailsFragment : Fragment(R.layout.fragment_contact_details) {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText = view.findViewById<EditText>(R.id.nameEditText).apply { keyListener = null }
        val phoneEditText = view.findViewById<EditText>(R.id.phoneEditText).apply { keyListener = null }
        val ageEditText = view.findViewById<EditText>(R.id.ageEditText).apply { keyListener = null }
        val lastNameEditText = view.findViewById<EditText>(R.id.lastNameEditText).apply { keyListener = null }

        setFragmentResultListener(CONTACT_LIST_FRAGMENT_RESULT_KEY) { requestKey, bundle ->
                nameEditText.setText(bundle.getString("NAME").orEmpty())
                lastNameEditText.setText(bundle.getString("LAST_NAME").orEmpty())
                phoneEditText.setText(bundle.getString("PHONE").orEmpty())
                ageEditText.setText(bundle.getInt("AGE").toString())
        }
    }
}