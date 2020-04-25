package com.lec.android.mydd;

import android.app.Activity;
import android.content.Intent;

public class ItemListActivity extends Activity {

    pubic void startActivityByItem(ItemDB item) {
        Intent intent = new Intent(this, ItemInfoActivity.class);
        intent.putExtra(ITEM_KEY, item);
        startActivity(intent);
    }
}