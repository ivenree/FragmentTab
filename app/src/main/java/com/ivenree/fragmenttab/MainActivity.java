package com.ivenree.fragmenttab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends FragmentActivity implements View.OnClickListener{

    //Bottom tab
    private LinearLayout mTabChat;
    private LinearLayout mTabContact;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAccount;

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

    private FragmentManager manager;
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
        mTabChat = (LinearLayout) findViewById(R.id.id_tab_chats);
        mTabContact = (LinearLayout) findViewById(R.id.id_tab_contacts);
        mTabFriend = (LinearLayout) findViewById(R.id.id_tab_friends);
        mTabAccount = (LinearLayout) findViewById(R.id.id_tab_account);

        mImageChat = (ImageButton) findViewById(R.id.id_tab_chats_img);
        mImageContact = (ImageButton) findViewById(R.id.id_tab_contacts_img);
        mImageFriend = (ImageButton) findViewById(R.id.id_tab_friends_img);
        mImageAccount = (ImageButton) findViewById(R.id.id_tab_account_img);

        mChatFragment = new ChatFragment();
        mContactFragment = new ContactFragment();
        mFriendFragment = new FriendFragment();
        mAccountFragment = new AccountFragment();


        mChatText = (TextView) findViewById(R.id.id_tab_chat_text);
        mContactText = (TextView) findViewById(R.id.id_tab_contact_text);
        mFriendsText = (TextView) findViewById(R.id.id_tab_friends_text);
        mAccountText = (TextView) findViewById(R.id.id_tab_account_text);

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //add fragment to fragmentlayout
        transaction.add(R.id.id_tab_content, mChatFragment);
        transaction.add(R.id.id_tab_content, mContactFragment);
        transaction.add(R.id.id_tab_content, mFriendFragment);
        transaction.add(R.id.id_tab_content, mAccountFragment);
        //show Chat view when opening
        if(mContactFragment != null){
            transaction.hide(mContactFragment);
        }
        if(mFriendFragment != null){
            transaction.hide(mFriendFragment);
        }
        if(mAccountFragment != null){
            transaction.hide(mAccountFragment);
        }
        transaction.commit();

    }

    /*
     *
     */
    private void setSelect(int index){

        FragmentTransaction transaction = manager.beginTransaction();
        //hide fragment before showing next
        hideFragmentView(transaction);

        switch(index){
            case 0:
                //show fragment
                if(mChatFragment == null){
                    mChatFragment = new ChatFragment();
                }
                else{
                    transaction.show(mChatFragment);
                }
                //show image pressed status
                mImageChat.setImageResource(R.mipmap.ic_chat_press);
                //show text pressed status
                mChatText.setTextColor(Color.parseColor("#777777"));
                break;
            case 1:
                if(mContactFragment == null){
                    mContactFragment = new ContactFragment();
                }
                else{

                    transaction.show(mContactFragment);
                }
                mImageContact.setImageResource(R.mipmap.ic_contacts_press);
                mContactText.setTextColor(Color.parseColor("#777777"));
                break;
            case 2:
                if(mFriendFragment == null){
                    mFriendFragment = new FriendFragment();
                }
                else{

                    transaction.show(mFriendFragment);
                }
                mImageFriend.setImageResource(R.mipmap.ic_friends_press);
                mFriendsText.setTextColor(Color.parseColor("#777777"));
                break;
            case 3:
                if(mAccountFragment == null){
                    mAccountFragment = new AccountFragment();
                }
                else{

                    transaction.show(mAccountFragment);
                }
                mImageAccount.setImageResource(R.mipmap.ic_person_press);
                mAccountText.setTextColor(Color.parseColor("#777777"));
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragmentView(FragmentTransaction transaction) {
        if(mChatFragment != null){
            transaction.hide(mChatFragment);
        }
        if(mContactFragment != null){
            transaction.hide(mContactFragment);
        }
        if(mFriendFragment != null){
            transaction.hide(mFriendFragment);
        }
        if(mAccountFragment != null){
            transaction.hide(mAccountFragment);
        }

    }


    @Override
    public void onClick(View v) {
        resetImageAndText();
        switch (v.getId()){
            case R.id.id_tab_chats:
                setSelect(0);
                break;
            case R.id.id_tab_contacts:
                setSelect(1);
                break;
            case R.id.id_tab_friends:
                setSelect(2);
                break;
            case R.id.id_tab_account:
                setSelect(3);
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
