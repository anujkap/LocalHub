package com.scam.localhub;

public class UserTask
{
    String HomeTutorialTitle;
    int HomeImageId;

    public UserTask(String homeTutorialTitle,int homeImageId)
    {
        HomeTutorialTitle = homeTutorialTitle;
        HomeImageId=homeImageId;
    }
    public int getItemId(){
        return HomeImageId;
    }
}
