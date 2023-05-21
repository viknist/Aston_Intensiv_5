package ru.viknist.aston_dz_5.ui.contact_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import ru.viknist.aston_dz_5.R
import ru.viknist.aston_dz_5.find
import ru.viknist.aston_dz_5.getTag
import ru.viknist.aston_dz_5.model.Contact
import ru.viknist.aston_dz_5.ui.contact_details.ContactDetailsFragment

class ContactListFragment : Fragment(R.layout.fragment_contact_list) {

    private var listContact = mutableListOf<Contact>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData(view)
        val bundle = Bundle()

        view.findViewById<ConstraintLayout>(R.id.firstContactLayout).setOnClickListener {
            bundle.putString("NAME", listContact[0].name)
            bundle.putString("LAST_NAME", listContact[0].lastName)
            bundle.putString("PHONE", listContact[0].phone)
            bundle.putInt("AGE", listContact[0].age)
            setFragmentResult(CONTACT_LIST_FRAGMENT_RESULT_KEY, bundle)
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    ContactDetailsFragment(),
                    ContactDetailsFragment::class.getTag())
                .addToBackStack(ContactDetailsFragment::class.getTag())
                .commit()
        }
        view.findViewById<ConstraintLayout>(R.id.secondContactLayout).setOnClickListener {
            bundle.putString("NAME", listContact[1].name)
            bundle.putString("LAST_NAME", listContact[1].lastName)
            bundle.putString("PHONE", listContact[1].phone)
            bundle.putInt("AGE", listContact[1].age)
            setFragmentResult(CONTACT_LIST_FRAGMENT_RESULT_KEY, bundle)
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    ContactDetailsFragment(),
                    ContactDetailsFragment::class.getTag())
                .addToBackStack(ContactDetailsFragment::class.getTag())
                .commit()
        }
        view.findViewById<ConstraintLayout>(R.id.thirdContactLayout).setOnClickListener {
            bundle.putString("NAME", listContact[2].name)
            bundle.putString("LAST_NAME", listContact[2].lastName)
            bundle.putString("PHONE", listContact[2].phone)
            bundle.putInt("AGE", listContact[2].age)
            setFragmentResult(CONTACT_LIST_FRAGMENT_RESULT_KEY, bundle)
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    ContactDetailsFragment(),
                    ContactDetailsFragment::class.getTag())
                .addToBackStack(ContactDetailsFragment::class.getTag())
                .commit()
        }
    }

    init {
        listContact.apply {
            add(0, Contact("+79118403133", "Alex", "Brynov",21))
            add(1, Contact("+79120092387", "Gleb", "Georgiev",30))
            add(2, Contact("+72118449030", "Oleg", "Olegov",16))
        }
    }

    fun setData(view: View){
        view.findViewById<TextView>(R.id.firstNameText).text = listContact[0].name
        view.findViewById<TextView>(R.id.firstPhoneText).text = listContact[0].phone

        view.findViewById<TextView>(R.id.secondNameText).text = listContact[1].name
        view.findViewById<TextView>(R.id.secondPhoneText).text = listContact[1].phone

        view.findViewById<TextView>(R.id.thirdNameText).text = listContact[2].name
        view.findViewById<TextView>(R.id.thirdPhoneText).text = listContact[2].phone
    }

    companion object {
        const val CONTACT_LIST_FRAGMENT_TAG = "CONTACT_LIST_FRAGMENT_TAG"
        const val CONTACT_LIST_FRAGMENT_RESULT_KEY = "CONTACT_LIST_FRAGMENT_RESULT_KEY"
    }
}