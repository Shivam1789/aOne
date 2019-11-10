package com.school.kotlin.activities.navigational


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.Gravity
import android.view.View
import com.school.kotlin.R
import com.school.kotlin.activities.BaseActivity
import com.school.kotlin.activities.DashboardNavigation
import com.school.kotlin.data.Status
import com.school.kotlin.ui.HomeFragment
import com.school.kotlin.utils.Constants
import com.school.kotlin.utils.Utils
import kotlinx.android.synthetic.main.activity_nevigation.*
import kotlinx.android.synthetic.main.newtool.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class NavigationalActivity : BaseActivity(), View.OnClickListener {
    private var mDrawerToggle: ActionBarDrawerToggle? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nevigation)
        init()
        initNavigationDrawer()
        EventBus.getDefault().register(this)
    }

    private fun init() {
        setListener()
        replaceFragment(HomeFragment())
    }


    /*set click event for all view*/
    private fun setListener() {
        text_home.setOnClickListener(this)
        text_help.setOnClickListener(this)
        text_transaction.setOnClickListener(this)
        text_home.setOnClickListener(this)
        text_search_school.setOnClickListener(this)
        text_add_account.setOnClickListener(this)
        text_setting.setOnClickListener(this)
        text_login.setOnClickListener(this)
        text_signup.setOnClickListener(this)
      //  text_user_names.setOnClickListener(this)
        text_home.setOnClickListener(this)
        text_logout.setOnClickListener(this)

        header.image_toggle.setOnClickListener {
            drawerLayout.openDrawer(Gravity.START)
        }
    }

    /**
     * This method will initialize navigation drawer and set toggle button and its action
     */
    private fun initNavigationDrawer() {
        //drawerLayout.setScrimColor(ContextCompat.getColor(this,android.R.color.transparent))
        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = object : ActionBarDrawerToggle(this, /* host Activity */
                drawerLayout, /* DrawerLayout object */
                R.string.navigation_drawer_open, /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */) {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                /*val width = resources.getDimension(R.dimen.navigation_view_width)
                val moveFactor = width * slideOffset
                container.translationX = moveFactor
                header.translationX = moveFactor*/
                Utils.hideKeyboard(this@NavigationalActivity)
            }
        }
        // Defer code dependent on restoration of previous instance state.
        drawerLayout.post { mDrawerToggle?.syncState() }

        drawerLayout.addDrawerListener(mDrawerToggle as ActionBarDrawerToggle)
    }


    /* when user update the profile then
    *  change the update name and image of user in nevigation drawer*/





    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.text_add_account -> {
                closeDrawer()
                moveToScreen(1)
            }
            R.id.text_search_school -> {
                closeDrawer()
                moveToScreen(2)
            }
            R.id.text_home -> {
                closeDrawer()
                moveToScreen(3)
            }
            R.id.text_transaction -> {
                closeDrawer()
                moveToScreen(4)
            }
            R.id.text_help -> {
                closeDrawer()

                moveToScreen(5)
            }
            R.id.text_setting -> {
                closeDrawer()
                moveToScreen(6)
            }
            R.id.text_login -> {
                closeDrawer()
                moveToScreen(7)
            }
            R.id.text_signup -> {
                closeDrawer()
                moveToScreen(8)
            }

            R.id.text_logout -> {
                closeDrawer()
                if (Utils.singleClick()) {
                showLogOut()
            }}
        }
    }

    /*logout the user*/
    private fun showLogOut() {

        this.let {
            val builder = AlertDialog.Builder(it).apply {
                setTitle(getString(R.string.logOut))
                setMessage(getString(R.string.logout_msg))
                setCancelable(false)
            }

            val positiveText = getString(android.R.string.ok)
            builder.setPositiveButton(positiveText) { dialog, _ ->
                // positive button logic
                dialog.dismiss()
                Utils.logout(it)
            }

            val negativeText = getString(android.R.string.cancel)
            builder.setNegativeButton(negativeText) { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            // display dialog
            dialog.show()
        }

    }

    private fun moveToScreen(type: Int) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)

        when (type) {
            Constants.TYPE.ADDSTUDENT.type -> {
                val intent = Intent(this, DashboardNavigation::class.java)
                intent.putExtra(Constants.FRAGMENT_TYPE, Constants.ADD_STUDENT)
                startActivity(intent)
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out)
            }


        }
    }

    /**
     * This method will close the Drawer
     */
    private fun closeDrawer() {
        drawerLayout.closeDrawer(Gravity.START)
    }

    /**
     **************** handle API response code and manage action accordingly *******
     */

    fun handleResponseCode(response: Status) {
        when (response.code) {
            Constants.httpcodes.STATUS_OK -> Log.e("status", "result found")
            Constants.httpcodes.STATUS_BAD_REQUEST -> Log.e("status", "api error")
            Constants.httpcodes.STATUS_SERVER_ERROR -> Log.e("status", "server error")
            Constants.httpcodes.STATUS_SESSION_EXPIRED -> {
                Handler().postDelayed({ Utils.logout(this) }, 3000)
            }
        }
    }

    /**
     ************* get the api response here from response interceptor class ***********
     */

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun responseCode(status: Status) {
        handleResponseCode(status)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.anim_in_reverse, R.anim.anim_out_reverse)
    }

}