package com.lec.android.mydd;

import android.app.Activity;

public class ItemInfoActivity extends Activity {

    ItemDB item = (ItemDB) getIntent().getParcelableExtra(ITEM_KEY);
    Log.e("[ITEM] 이름 :", getResources().getString(item.getName()));
}