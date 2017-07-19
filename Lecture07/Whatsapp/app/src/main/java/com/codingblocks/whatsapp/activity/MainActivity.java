package com.codingblocks.whatsapp.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.fragment.CallFragment;
import com.codingblocks.whatsapp.fragment.CameraFragment;
import com.codingblocks.whatsapp.fragment.ChatFragment;
import com.codingblocks.whatsapp.fragment.StatusFragment;
import com.codingblocks.whatsapp.model.Call;
import com.codingblocks.whatsapp.model.Chat;
import com.codingblocks.whatsapp.model.Status;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Chat> chatArrayList = new ArrayList<>();
    ArrayList<Call> callArrayList = new ArrayList<>();
    ArrayList<Status> statusArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));
        chatArrayList.add(new Chat("Harshit","Hey, there?", "6 : 30 pm"));

        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));
        callArrayList.add(new Call("Bae Ji","5 : 30 am","16 January"));

        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        statusArrayList.add(new Status("Someone Else","5 : 30 pm"));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return ChatFragment.newInstance();
                case 1:
                    return StatusFragment.newInstance();
                case 2:
                    return CallFragment.Companion.newInstance(callArrayList);
                case 3:
                    return CameraFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Chats";
                case 1:
                    return "Status";
                case 2:
                    return "Calls";
                case 3:
                    return "Camera";
                default:
                    return "";
            }
        }
    }

}
