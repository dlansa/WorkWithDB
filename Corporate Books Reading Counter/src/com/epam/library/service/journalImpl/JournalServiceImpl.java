package com.epam.library.service.journalImpl;

import com.epam.library.domain.DBconnector;
import com.epam.library.service.JournalService;

public class JournalServiceImpl implements JournalService{

    private DBconnector connector;
    private String query;

    public JournalServiceImpl(){
        connector = new DBconnector();
    }

    @Override
    public void readMoreOne() {

    }

    @Override
    public void readLessTwo() {

    }

    @Override
    public void renameBook(String oldName, String newName){
        query = "update books set name = '"+newName+"' where name = '"+oldName+"'";
        //connector.execute(query);
    }
}
