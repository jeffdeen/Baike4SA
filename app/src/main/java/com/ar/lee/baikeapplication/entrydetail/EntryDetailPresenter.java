package com.ar.lee.baikeapplication.entrydetail;

import com.ar.lee.baikeapplication.data.Entry;

/**
 * Created by Lee on 2016/12/18.
 */

public class EntryDetailPresenter implements EntryDetailContract.Presenter{

    private EntryDetailContract.View mEntryDetailView;

    public EntryDetailPresenter(EntryDetailContract.View view){
        this.mEntryDetailView = view;

        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadEntryToShow("测试ID");
    }

    @Override
    public void loadEntryToShow(String entryID) {
        //TODO: 根据词条ID从服务器加载词条信息

        mEntryDetailView.showEntryInf(new Entry(Entry.NO_ID_WHEN_CREATE,
                "测试词条名", "测试词条描述", Entry.NO_IMAGE_PATH));
    }
}
