package com.ivenree.fragmenttab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener{

    //Bottom tab
    private LinearLayout mTabChat;
    private LinearLayout mTabContact;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAccount;
    //
    private ImageButton mImageChat;
    private ImageButton mImageContact;
    private ImageButton mImageFriend;
    private ImageButton mImageAccount;

    private Fragment mChatFragment;
    private Fragment mContactFragment;
    private Fragment mFriendFragment;
    private Fragment mAccountFragment;

    private TextView mChatText;
    private TextView mContactText;
    private TextView mFriendsText;
    private TextView mAccountText;

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();
    }

    private void initEvent() {
        mTabChat.setOnClickListener(this);
        mTabContact.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAccount.setOnClickListener(this);
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mTabChat = (LinearLayout) findViewById(R.id.id_tab_chats);
        mTabContact = (LinearLayout) findViewById(R.id.id_tab_contacts);
        mTabFriend = (LinearLayout) findViewById(R.id.id_tab_friends);
        mTabAccount = (LinearLayout) findViewById(R.id.id_tab_account);

        mImageChat = (ImageButton) findViewById(R.id.id_tab_chats_img);
        mImageContact = (ImageButton) findViewById(R.id.id_tab_contacts_img);
        mImageFriend = (ImageButton) findViewById(R.id.id_tab_friends_img);
        mImageAccount = (ImageButton) findViewById(R.id.id_tab_account_img);

        mChatText = (TextView) findViewById(R.id.id_tab_chat_text);
        mContactText = (TextView) findViewById(R.id.id_tab_contact_text);
        mFriendsText = (TextView) findViewById(R.id.id_tab_friends_text);
        mAccountText = (TextView) findViewById(R.id.id_tab_account_text);

        mChatFragment = new ChatFragment();
        mContactFragment = new ContactFragment();
        mFriendFragment = new FriendFragment();
        mAccountFragment = new AccountFragment();

        mFragmentList = new ArrayList<Fragment>();
        mFragmentList.add(mChatFragment);
        mFragmentList.add(mContactFragment);
        mFragmentList.add(mFriendFragment);
        mFragmentList.add(mAccountFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragmentList.get(i);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        };

        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //
            }

            @Override
            public void onPageSelected(int position) {
                //reset images and texts
                resetImageAndText();
                switch(position){
                    case 0:
                        mImageChat.setImageResource(R.mipmap.ic_chat_press);
                        mChatText.setTextColor(Color.parseColor("#777777"));
                        break;
                    case 1:
                        mImageContact.setImageResource(R.mipmap.ic_contacts_press);
                        mContactText.setTextColor(Color.parseColor("#777777"));
                        break;
                    case 2:
                        mImageFriend.setImageResource(R.mipmap.ic_friends_press);
                        mFriendsText.setTextColor(Color.parseColor("#777777"));
                        break;
                    case 3:
                        mImageAccount.setImageResource(R.mipmap.ic_person_press);
                        mAccountText.setTextColor(Color.parseColor("#777777"));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //
            }

        });
    }

    @Override
    public void onClick(View v) {
        resetImageAndText();
        switch (v.getId()){
            case R.id.id_tab_chats:
                //set View
                mViewPager.setCurrentItem(0);
                //set Image and Text pressed status
                mImageChat.setImageResource(R.mipmap.ic_chat_press);
                mChatText.setTextColor(Color.parseColor("#777777"));
                break;
            case R.id.id_tab_contacts:
                mViewPager.setCurrentItem(1);
                mImageContact.setImageResource(R.mipmap.ic_contacts_press);
                mContactText.setTextColor(Color.parseColor("#777777"));
                break;
            case R.id.id_tab_friends:
                mViewPager.setCurrentItem(2);
                mImageFriend.setImageResource(R.mipmap.ic_friends_press);
                mFriendsText.setTextColor(Color.parseColor("#777777"));
                break;
            case R.id.id_tab_account:
                mViewPager.setCurrentItem(3);
                mImageAccount.setImageResource(R.mipmap.ic_person_press);
                mAccountText.setTextColor(Color.parseColor("#777777"));
                break;
            default:
                break;
        }
    }

    private void resetImageAndText() {
        mImageChat.setImageResource(R.mipmap.ic_chat);
        mImageContact.setImageResource(R.mipmap.ic_contact);
        mImageFriend.setImageResource(R.mipmap.ic_friends);
        mImageAccount.setImageResource(R.mipmap.ic_person);

        mChatText.setTextColor(Color.WHITE);
        mContactText.setTextColor(Color.WHITE);
        mFriendsText.setTextColor(Color.WHITE);
        mAccountText.setTextColor(Color.WHITE);
    }
}
